package task;

import redis.clients.jedis.Jedis;

public class TaskConsumer implements Runnable {
    private Jedis jedis;
    private final String queueKey = "task-queue";

    public TaskConsumer(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public void run() {
        while (true) { // 无限循环，直到程序被外部终止
            String task = jedis.brpop(0, queueKey).get(1); // 从队列右侧（尾部）取出并移除任务，阻塞直到有任务可用
            if (task != null) {
                System.out.println("Consumed task: " + task);
                // 在这里处理任务...
                // ...
            }
        }
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://127.0.0.1:6379/0"); // 假设 Redis 服务器运行在本地
        TaskConsumer consumer = new TaskConsumer(jedis);

        // 在新的线程中运行消费者，以便它可以持续地从队列中取出任务
        new Thread(consumer).start();
    }
}