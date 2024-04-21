package innerclass_prac;

import java.util.Timer;
import java.util.TimerTask;

public class TimerHolder {
    private Timer timer;

    public TimerHolder() {
        this.timer = new Timer();
    }

    public void startTimer(int seconds, final Runnable task) {
        timer.schedule(new SimpleTimer(seconds, task), 0, seconds * 1000);
    }

    public void stopTimer() {
        timer.cancel();
    }

    // 内部类实现计时器功能
    class SimpleTimer extends TimerTask {
        private int seconds;
        private Runnable task;
        
        public SimpleTimer(int seconds, Runnable task) {
            this.seconds = seconds;
            this.task = task;
        }

        @Override
        public void run() {
            System.out.println("Timer ticked: " + seconds + " seconds have passed.");
            task.run(); // 执行传入的任务
        }
    }

    public static void main(String[] args) {
        TimerHolder holder = new TimerHolder();
        holder.startTimer(5, () -> System.out.println("Performing a task every 5 seconds."));
        
        // 让主线程休眠一段时间以便观察计时器效果
        try {
            Thread.sleep(20000); // 休眠20秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        holder.stopTimer(); // 停止计时器
    }
}
