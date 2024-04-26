package hello;

public class SellTicket01 {

	public static void main(String[] args) {
		//用继承的方式，总是需要创建新的线程，
		//因此每个窗口的票都是20，没有共享余票
		//所以要把tickets改成private static int
//		Sell01 s1=new Sell01();//窗口1
//		s1.start();
//		Sell01 s2=new Sell01();//窗口2
//		s2.start();
//		Sell01 s3=new Sell01();//窗口3
//		s3.start();
		//会有超卖现象!因为判断票数和减少票数之间有延时，
		//比如三个线程同时访问余票=1的情况，都成功运行，但票已经不够了
		
		//**需要通过线程同步解决！
		
		//使用接口实现
//		Sell02 s21=new Sell02();
//		Thread th1=new Thread(s21);//窗口1
//		th1.start();
//		Thread th2=new Thread(s21);//窗口2
//		th2.start();
//		Thread th3=new Thread(s21);//窗口3
//		th3.start();
		
		//同步
		Sell03 s31=new Sell03();
		Thread th1=new Thread(s31);//窗口1
		th1.start();
		Thread th2=new Thread(s31);//窗口2
		th2.start();
		Thread th3=new Thread(s31);//窗口3
		th3.start();
	}

}
class Sell01  extends Thread{
	private static int tickets=20;//余票

	@Override
	public void run() {
		while(true) {
			if(tickets<=0) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"卖了一张票，剩余票数："+(--tickets));
		}
		
	}
	
}

class Sell02  implements Runnable{
	private int tickets=20;//余票

	@Override
	public void run() {
		while(true) {
			if(tickets<=0) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"卖了一张票，剩余票数："+(--tickets));
		}
		
	}
	
}

class Sell03  implements Runnable{
	private int tickets=20;//余票
	private boolean loop=true;
	public synchronized void m() {//同步方法，同一时刻只能有一个线程操作此方法
		if(tickets<=0) {
			System.out.println("卖完了");
			loop=false;
			return;
			
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"卖了一张票，剩余票数："+(--tickets));
	}
	@Override
	public void run() {
		while(loop) {
			m();
		}
		
	}
	
}