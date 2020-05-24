package jredis;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class jedistest {

	@Test
	public  void ma() {
		Jedis jedis=new Jedis("localhost",6379);
		jedis.set("username", "zhangs");
		jedis.close();
		
		
	}

}
