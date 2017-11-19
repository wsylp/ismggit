package wsylp.util.redis;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis工具类
 *
 *
 *
 * Created by wsylp on 2017/9/17.
 */
public class JedisUtil {

    private static Logger logger = LogManager.getLogger(JedisUtil.class.getName());

    private JedisUtil() {

    }

    ;

    private static class RedisUtilHolder {

        private static final JedisUtil instance = new JedisUtil();
    }

    public static JedisUtil getInstance() {
        return RedisUtilHolder.instance;
    }

    private static Map<String, JedisPool> maps = new HashMap<String, JedisPool>();

    private static JedisPool getPool(String ip, int port) {
        String key = ip + ":" + port;
        JedisPool pool = null;

        if (!maps.containsKey(key)) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(RedisConfig.MAX_TOTAL);
            config.setMaxIdle(RedisConfig.MAX_IDLE);
            //config.setMaxWait();
            config.setMaxWaitMillis(RedisConfig.MAX_WAIT);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);

            pool = new JedisPool(config, ip, port, RedisConfig.TIMEOUT);
            maps.put(key, pool);
        } else {
            pool = maps.get(key);
        }
        return pool;
    }
    public Jedis getJedis(String ip, int port)
    {
        Jedis jedis = null;
        int count = 0;
        do
        {
            try
            {
                jedis = getPool(ip,port).getResource();
            }
            catch (Exception e)
            {
                logger.error("get redis master1 failed!",e);
                getPool(ip,port).close();
                //  jedisPool.returnBrokenResource(jedis);废弃了
            }
        }
        while(jedis == null && count<RedisConfig.RETRY_NUM);
        return jedis;
    }

    public void closeJedis(Jedis jedis, String ip, int port){
        if(jedis != null)
        {
            getPool(ip,port).close();
        }
    }
}
