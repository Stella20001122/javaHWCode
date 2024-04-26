package hello;

public class ThreadMethod01 {

	public static void main(String[] args) throws InterruptedException {
		test02 t2=new test02();
		
		t2.setName("吃晚饭");
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t2.start();
		for(int i=0;i<5;i++) {
			Thread.sleep(1000);
			System.out.println(i+"hi1");
		}
		System.out.println("优先级"+t2.getPriority());
		t2.interrupt();//t2处于休眠中，提前中断休眠
		
		

	}

}
class test02 extends Thread{
	
	@Override
	public void run() {
		while(true) {
			for(int i=0;i<20;i++) {
				System.out.println(Thread.currentThread().getName()+"吃饭~~~"+i);
			}
			try {
				System.out.println(Thread.currentThread().getName()+"线程休眠中");
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				//当休眠被interrupt，会catch一个异常，可以加入自己的代码
				System.out.println(Thread.currentThread().getName()+"被中断");
				
			}
			
			
		}
		
	}
	
}