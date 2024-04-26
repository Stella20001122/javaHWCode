package hello;

public class ThreadPrac02 {

	public static void main(String[] args) {
		Dog dog=new Dog();
		//没有dog.start();
		//构建一个Thread放进去用
		Thread thread = new Thread(dog);
		thread.start();

	}

}
class ThreadProxy implements Runnable{
	//模拟一个简单版的Thread
	private Runnable target =null;
	@Override
	public void run() {
		if(target!=null) {
			target.run();
		}
		
	}
	public ThreadProxy(Runnable target) {
		super();
		this.target = target;
	}
	public void start() {
		start0();
	}
	public void start0(){
		run();
	}
}
class Dog implements Runnable{
	int count=0;
	@Override
	public void run() {
		while(true) {
			System.out.println("汪汪汪"+(++count)+Thread.currentThread().getName());
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
