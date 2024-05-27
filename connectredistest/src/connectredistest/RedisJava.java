package connectredistest;

import counter.RedisCounter;
import message.RedisPublisher;
import message.RedisSubscriber;
import redis.clients.jedis.Jedis;

public class RedisJava {
    public static void main(String[] args) {
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("localhost");
//        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
//        // jedis.auth("123456"); 
//        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());
    	
    	// 连接到Redis服务器，默认端口是6379
//    	Jedis jedis = new Jedis("localhost");
        Jedis jedis = new Jedis("redis://127.0.0.1:6379/0");
        
        
        try {
            // 验证Redis服务器是否运行正常
            System.out.println("Server is running: " + jedis.ping());

            // 设置缓存数据
            String key = "popular_product_info";
            String value = "{\"id\":123,\"name\":\"Popular Product\",\"price\":99.99}";
            jedis.set(key, value);
            System.out.println("Cached data: " + jedis.get(key));
            
            // 设置缓存数据
            String key12 = "popular_product_info2";
            String value11 = "{\"id\":456,\"name\":\"Popular Product\",\"price\":66.66}";
            jedis.set(key12, value11);
            System.out.println("Cached data: " + jedis.get(key12));
            
            
            // 获取缓存数据
            String cachedData = jedis.get(key);
            if (cachedData != null) {
                System.out.println("Retrieved data from cache: " + cachedData);
            } else {
                System.out.println("No data found in cache for key: " + key);
            }
            
            //计数器
            RedisCounter ccounter= new RedisCounter(jedis);
            String key1="1"; //要求是数字
            ccounter.increment(key1);
            System.out.println("计数器: " + ccounter.get(key1));
            ccounter.increment(key1);
            System.out.println("计数器: " + ccounter.get(key1));
            
            //消息订阅
//            RedisSubscriber sub=new RedisSubscriber();
//            sub.listening(jedis,"my-channel");
            
            //消息发送
            RedisPublisher pub=new RedisPublisher();
            pub.publishmessage(jedis, "my-channel", "Hello, Redis Publish/Subscribe!");
            

        } finally {
            // 关闭连接
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
