package hello;

public class ThreadPrac05 {

	public static void main(String[] args) throws InterruptedException {
		MyDaemonThread md=new MyDaemonThread();
		md.setDaemon(true);//设置为守护线程
		md.start();//先设置再启动
		for(int i=1;i<=10;i++) {
			System.out.println("呜呜呜");
			Thread.sleep(2000);
			
		}

	}

}

//设置线程为守护线程
class MyDaemonThread extends Thread{

	@Override
	public void run() {
		for( ; ; ) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("哈哈哈");
		}
	}
	
	
}