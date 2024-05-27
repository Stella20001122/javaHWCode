package task;

import redis.clients.jedis.Jedis;

public class TaskProducer {
    private Jedis jedis;
    private final String queueKey = "task-queue";

    public TaskProducer(Jedis jedis) {
        this.jedis = jedis;
    }

    public void produceTask(String task) {
        jedis.lpush(queueKey, task); // 将任务推入队列左侧（头部）
        System.out.println("Produced task: " + task);
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://127.0.0.1:6379/0"); // 假设 Redis 服务器运行在本地
        TaskProducer producer = new TaskProducer(jedis);

        // 生产一些任务
        producer.produceTask("Task 1");
        producer.produceTask("Task 2");
        producer.produceTask("Task 3");
        producer.produceTask("Task 4");

        // 关闭连接（在实际应用中，你可能希望在应用程序结束时关闭连接）
        jedis.close();
    }
}