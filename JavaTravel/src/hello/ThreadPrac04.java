package hello;

public class ThreadPrac04 {

	public static void main(String[] args) throws InterruptedException {
		Thread th4=new Thread(new T4());
		
		for(int i=1;i<=10;i++) {
			System.out.println("hi"+i);
			if(i==5) {
				th4.start();
				th4.join();
			}
			Thread.sleep(1000);
		}

	}

}
class T4 implements Runnable{

	private int count=0;
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
			if(count==10) {
				break;
			}
		}
		
	}
	
	
}