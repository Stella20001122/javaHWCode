package message;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisPublisher {
	
	public void publishmessage(Jedis jedis, String channel,String message) {
		// 发布消息到 "my-channel"
        jedis.publish(channel, message);
        System.out.println("Message published to my-channel");
        
//        System.out.println("Message published to my-channel");
	}
    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://127.0.0.1:6379/0"); // 假设 Redis 服务器运行在本地
        System.out.println("Connected to Redis server!");

        // 发布消息到 "my-channel"
        jedis.publish("my-channel", "Hello, Redis Publish/Subscribe!");
        System.out.println("Message published to my-channel");

        jedis.close();
    }
}