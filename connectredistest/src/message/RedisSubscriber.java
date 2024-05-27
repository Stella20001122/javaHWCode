package message;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisSubscriber extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("Received message: " + message + " on channel: " + channel);
    }
    
    public void listening(Jedis jedis,String channel) {
    	//Jedis jedis = new Jedis("redis://127.0.0.1:6379/0"); // 假设 Redis 服务器运行在本地
        System.out.println("Connected to Redis server!");

        // 订阅 "my-channel"
        new Thread(new Runnable() {
            @Override
            public void run() {
                jedis.subscribe(new RedisSubscriber(), channel);
            }
        }).start();
        
        System.out.println("listening: my-channel");
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://127.0.0.1:6379/0"); // 假设 Redis 服务器运行在本地
        System.out.println("Connected to Redis server!");

        // 订阅 "my-channel"
        new Thread(new Runnable() {
            @Override
            public void run() {
                jedis.subscribe(new RedisSubscriber(), "my-channel");
            }
        }).start();
    }
}