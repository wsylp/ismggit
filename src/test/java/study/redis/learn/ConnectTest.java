package study.redis.learn;

import redis.clients.jedis.Jedis;

public class ConnectTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.2.219");
		System.out.println(jedis.ping());
	}
}
