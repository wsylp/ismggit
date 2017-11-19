package study.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;
import wsylp.util.redis.JedisUtil;

/**
 * Created by wsylp on 2017/9/17.
 */
public class RedisAction {

//    private static final String ipAddr = "192.168.2.249";
//    private static final int port = 6379;
//    private static Jedis jedis = null;
//
//    @BeforeClass
//    public static void init() {
//        jedis = JedisUtil.getInstance().getJedis(ipAddr, port);
//    }
//
//    @AfterClass
//    public static void close() {
//        JedisUtil.getInstance().closeJedis(jedis, ipAddr, port);
//    }
//
//    @Test
//    public void testKey() throws InterruptedException {
//        System.out.println("清空数据:" + jedis.flushDB());
//        System.out.println("判断某个键是否存在:" + jedis.exists("userName"));
//        System.out.println("新增<username,wsylp>键值对" + jedis.set("username", "wsylp"));
//        System.out.println(jedis.exists("username"));
//        System.out.println("新增<passwo,psaaword>键值对" + jedis.set("password", "password"));
//        System.out.println("系统所有的键值对如下");
//        Set<String> keys = jedis.keys("*");
//        System.out.println(keys);
//        System.out.println("删除password键值对" + jedis.del("password"));
//        System.out.println("判断password是否存在" + jedis.exists("password"));
//        System.out.println("设置键username的过期时间为5s" + jedis.expire("username", 5));
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println("查看键username的剩余生存时间:" + jedis.ttl("username"));
//        System.out.println("移除键usename的生存时间" + jedis.persist("username"));
//        System.out.println("查看username的剩余生存时间" + jedis.ttl("username"));
//        System.out.println("查看键username所储存的值的类型" + jedis.type("username"));
//    }
//
//    @Test
//    public void testString() throws InterruptedException {
//        jedis.flushDB();
//        System.out.println("==========增加数据=========");
//        System.out.println(jedis.set("key1", "value1"));
//        System.out.println(jedis.set("key2", "value2"));
//        System.out.println(jedis.set("key3", "value3"));
//        System.out.println("删除键2:" + jedis.del("key2"));
//        System.out.println("获取键值对2" + jedis.get("key2"));
//        System.out.println("修改key1" + jedis.set("key1", "valueKey1changed"));
//        System.out.println("获取key1的值" + jedis.get("key1"));
//        System.out.println("在key3后加入值" + jedis.append("key3", "End"));
//        System.out.println("获取key3的值" + jedis.get("key3"));
//        System.out.println("增加多个键值对" + jedis.mset("key01", "value01", "key02", "vlaue02"));
//        System.out.println("获取多个键值对" + jedis.mget("key01", "key02"));
//        System.out.println("删除多个键值对" + jedis.del(new String[]{"key01", "key02"}));
//        System.out.println("获取多个键值对" + jedis.mget("key01", "key02"));
//
//        jedis.flushDB();
//        System.out.println("清空后获取键值对" + jedis.get("key1"));
//
//        System.out.println("==========新增键值对防止覆盖原先值============");
//        System.out.println(jedis.setnx("key1", "value1"));
//        System.out.println(jedis.setnx("key2", "value2"));
//        System.out.println(jedis.setnx("key2", "value2-new"));
//        System.out.println(jedis.get("key1"));
//        System.out.println(jedis.get("key2"));
//
//        System.out.println("================新增键值对对并设置有效时间");
//        System.out.println(jedis.setex("key3", 2, "value3"));
//        System.out.println(jedis.get("key3"));
//        TimeUnit.SECONDS.sleep(3);
//        System.out.println(jedis.get("key3"));
//
//        System.out.println("设置为原值,更新为新值");
//        System.out.println(jedis.get("key2"));
//        System.out.println("返回的为原值,设置新值:" + jedis.getSet("key2", "key2GetSet"));//
//        System.out.println(jedis.get("key2"));
//
//        //截取
//        System.out.println("获取key2值的字符串" + jedis.getrange("key2", 2, 4));
//
//    }
//
//    @Test
//    public void testNumber() {
//        jedis.flushDB();
//        jedis.set("key1", "1");
//        jedis.set("key2", "2");
//        jedis.set("key3", "2.3");
//        System.out.println("key1的值：" + jedis.get("key1"));
//        System.out.println("key2的值：" + jedis.get("key2"));
//        System.out.println("key1的值加1：" + jedis.incr("key1"));
//        System.out.println("获取key1的值：" + jedis.get("key1"));
//        System.out.println("key2的值减1：" + jedis.decr("key2"));
//        System.out.println("获取key2的值：" + jedis.get("key2"));
//        System.out.println("将key1的值加上整数5：" + jedis.incrBy("key1", 5));
//        System.out.println("获取key1的值：" + jedis.get("key1"));
//        System.out.println("将key2的值减去整数5：" + jedis.decrBy("key2", 5));
//        System.out.println("获取key2的值：" + jedis.get("key2"));
//
//        //incrbyfloat，即将键存储的值加上浮点数
//        System.out.println("获取key3的值:" + jedis.get("key3"));
//        System.out.println("key3的值加1：" + jedis.incrByFloat("key3", 2.5));
//        System.out.println("获取key3的值" + jedis.get("key3"));
//    }
//
//    /**
//     * 集合类的使用
//     */
//    @Test
//    public void testSet() {
//        jedis.flushDB();
//        System.out.println("============向集合中添加元素============");
//        System.out.println(jedis.sadd("eleSet", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
//        System.out.println(jedis.sadd("eleSet", "e6"));
//        System.out.println(jedis.sadd("eleSet", "e6"));
//        System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));
//        System.out.println("删除一个元素e0：" + jedis.srem("eleSet", "e0"));
//        System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));
//        System.out.println("删除两个元素e7和e6：" + jedis.srem("eleSet", "e7", "e6"));
//        System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));
//        System.out.println("随机的移除集合中的一个元素：" + jedis.spop("eleSet"));
//        System.out.println("随机的移除集合中的一个元素：" + jedis.spop("eleSet"));
//        System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));
//        System.out.println("eleSet中包含元素的个数：" + jedis.scard("eleSet"));
//        System.out.println("e3是否在eleSet中：" + jedis.sismember("eleSet", "e3"));
//        System.out.println("e1是否在eleSet中：" + jedis.sismember("eleSet", "e1"));
//        System.out.println("e1是否在eleSet中：" + jedis.sismember("eleSet", "e5"));
//        System.out.println("=================================");
//        System.out.println(jedis.sadd("eleSet1", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
//        System.out.println(jedis.sadd("eleSet2", "e1", "e2", "e4", "e3", "e0", "e8"));
//        System.out.println("将eleSet1中删除e1并存入eleSet3中：" + jedis.smove("eleSet1", "eleSet3", "e1"));
//        System.out.println("将eleSet1中删除e2并存入eleSet3中：" + jedis.smove("eleSet1", "eleSet3", "e2"));
//        System.out.println("eleSet1中的元素：" + jedis.smembers("eleSet1"));
//        System.out.println("eleSet3中的元素：" + jedis.smembers("eleSet3"));
//        System.out.println("============集合运算=================");
//        System.out.println("eleSet1中的元素：" + jedis.smembers("eleSet1"));
//        System.out.println("eleSet2中的元素：" + jedis.smembers("eleSet2"));
//        System.out.println("eleSet1和eleSet2的交集:" + jedis.sinter("eleSet1", "eleSet2"));
//        System.out.println("eleSet1和eleSet2的并集:" + jedis.sunion("eleSet1", "eleSet2"));
//        //eleSet1中有，eleSet2中没有
//        System.out.println("eleSet1和eleSet2的差集:" + jedis.sdiff("eleSet1", "eleSet2"));
//
//
//    }
//
//    @Test
//    public void testHash() {
//        jedis.flushDB();
//        Map<String, String> map = new HashMap<>();
//        map.put("key1", "value1");
//        map.put("key2", "value2");
//        map.put("key3", "value3");
//        map.put("key4", "value4");
//        jedis.hmset("hash", map);
//        jedis.hset("hash", "key5", "value5");
//        System.out.println("散列hash的所有键值对为：" + jedis.hgetAll("hash"));//return Map<String,String>
//        System.out.println("散列hash的所有键为：" + jedis.hkeys("hash"));//return Set<String>
//        System.out.println("散列hash的所有值为：" + jedis.hvals("hash"));//return List<String>
//        System.out.println("将key6保存的值加上一个整数，如果key6不存在则添加key6：" + jedis.hincrBy("hash", "key6", 6));
//        System.out.println("散列hash的所有键值对为：" + jedis.hgetAll("hash"));
//        System.out.println("将key6保存的值加上一个整数，如果key6不存在则添加key6：" + jedis.hincrBy("hash", "key6", 3));
//        System.out.println("散列hash的所有键值对为：" + jedis.hgetAll("hash"));
//        System.out.println("删除一个或者多个键值对：" + jedis.hdel("hash", "key2"));
//        System.out.println("散列hash的所有键值对为：" + jedis.hgetAll("hash"));
//        System.out.println("散列hash中键值对的个数：" + jedis.hlen("hash"));
//        System.out.println("判断hash中是否存在key2：" + jedis.hexists("hash", "key2"));
//        System.out.println("判断hash中是否存在key3：" + jedis.hexists("hash", "key3"));
//        System.out.println("获取hash中的值：" + jedis.hmget("hash", "key3"));
//        System.out.println("获取hash中的值：" + jedis.hmget("hash", "key3", "key4"));
//    }
//
//    @Test
//    public void testSortedSet() {
//        jedis.flushDB();
//        Map<Double, String> map = new HashMap<>();
//        map.put(1.2, "key2");
//        map.put(4.0, "key3");
//        map.put(5.0, "key4");
//        map.put(0.2, "key5");
//        System.out.println(jedis.zadd("zset", 3, "key1"));
//      //  System.out.println(jedis.zadd("zset",map));
//
//        System.out.println("zset中的所有元素：" + jedis.zrange("zset", 0, -1));
//        System.out.println("zset中的所有元素：" + jedis.zrangeWithScores("zset", 0, -1));
//        System.out.println("zset中的所有元素：" + jedis.zrangeByScore("zset", 0, 100));
//        System.out.println("zset中的所有元素：" + jedis.zrangeByScoreWithScores("zset", 0, 100));
//        System.out.println("zset中key2的分值：" + jedis.zscore("zset", "key2"));
//        System.out.println("zset中key2的排名：" + jedis.zrank("zset", "key2"));
//        System.out.println("删除zset中的元素key3：" + jedis.zrem("zset", "key3"));
//        System.out.println("zset中的所有元素：" + jedis.zrange("zset", 0, -1));
//        System.out.println("zset中元素的个数：" + jedis.zcard("zset"));
//        System.out.println("zset中分值在1-4之间的元素的个数：" + jedis.zcount("zset", 1, 4));
//        System.out.println("key2的分值加上5：" + jedis.zincrby("zset", 5, "key2"));
//        System.out.println("key3的分值加上4：" + jedis.zincrby("zset", 4, "key3"));
//        System.out.println("zset中的所有元素：" + jedis.zrange("zset", 0, -1));
//        //有序集合还有诸如zinterstore, zunionstore, zremrangebyscore,
//        // zremrangebyrank, zrevrank, zrevrange, zrangebyscore等命令。
//    }
//
//    @Test
//    public void testSort() {
//        jedis.flushDB();
//        jedis.lpush("collections", "ArrayList", "Vector", "Stack", "HashMap", "WeakHashMap",
//            "LinkedHashMap");
//        System.out.println("collections的内容：" + jedis.lrange("collections", 0, -1));
//        SortingParams sortingParameters = new SortingParams();
//        System.out.println(jedis.sort("collections", sortingParameters.alpha()));
//        System.out.println("===============================");
//        jedis.lpush("sortedList", "3", "6", "2", "0", "7", "4");
//        System.out.println("sortedList排序前：" + jedis.lrange("sortedList", 0, -1));
//        System.out.println("升序：" + jedis.sort("sortedList", sortingParameters.asc()));
//        System.out.println("升序：" + jedis.sort("sortedList", sortingParameters.desc()));
//        System.out.println("===============================");
//        jedis.lpush("userlist", "33");
//        jedis.lpush("userlist", "22");
//        jedis.lpush("userlist", "55");
//        jedis.lpush("userlist", "11");
//        jedis.hset("user:66", "name", "66");
//        jedis.hset("user:55", "name", "55");
//        jedis.hset("user:33", "name", "33");
//        jedis.hset("user:22", "name", "79");
//        jedis.hset("user:11", "name", "24");
//        jedis.hset("user:11", "add", "beijing");
//        jedis.hset("user:22", "add", "shanghai");
//        jedis.hset("user:33", "add", "guangzhou");
//        jedis.hset("user:55", "add", "chongqing");
//        jedis.hset("user:66", "add", "xi'an");
//        sortingParameters = new SortingParams();
//        sortingParameters.get("user:*->name");
//        sortingParameters.get("user:*->add");
//        System.out.println(jedis.sort("userlist", sortingParameters));
//    }
}
