package hello;

public class ThreadPrac03 {

	public static void main(String[] args) {
		//main中多个子线程
//		T1 t1=new T1();
//		T2 t2=new T2();
//		Thread th1=new Thread(t1);
//		Thread th2=new Thread(t2);
//		th1.start();
//		th2.start();
		
		//
		T2 t3=new T2();
		Thread th31=new Thread(t3);
		Thread th32=new Thread(t3);
		th31.start();
		th32.start();
	}

}
class T1 implements Runnable{
	int count=0;
	@Override
	public void run() {
		while(true) {
			System.out.println("helloword"+(++count));
			count++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count==10) {
				break;
			}
		}
		
	}
	
}
class T2 implements Runnable{
	int count=0;
	@Override
	public void run() {
		while(true) {
			System.out.println("hi"+(++count));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count==5) {
				break;
			}
		}
		
	}
	
}