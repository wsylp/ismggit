package study.redis;

import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;

/**
 * Created by wsylp on 2017/9/17.
 */
public class SimpleConnect {
    private static Logger logger = LogManager.getLogger(SimpleConnect.class.getName());
    static Jedis jedis;

    static void init() {
        jedis = new Jedis("192.168.2.249");
        System.out.println(jedis.ping());
    }

    public static void main(String[] args) {
        init();
        logger.info("hahahahaa");
        //操作字符串
        jedis.set("name", "wsylp");
        System.out.println(jedis.get("name"));

        //操作列表
        jedis.lpush("nblist", "哈哈", "妞妞");
        List<String> list = jedis.lrange("nblist", 0, -1);
        for (String o : list) {
            System.out.println(o);
        }

        //输出所有的键
        Set<String> set = jedis.keys("*");
        for(String key :set){
            System.out.println(key);
        }

    }

}
