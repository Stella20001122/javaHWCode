package hello;

public class ThreadExit01 {

	public static void main(String[] args) throws InterruptedException {
		test01 t1=new test01();
		t1.start();
		
		Thread.sleep(10000);
		t1.setLoop(false);//通知线程
	}

}
class test01 extends Thread{
	//设置一个控制变量
	private boolean loop=true;
	//希望main线程去控制线程的退出
	//即可以修改loop
	public void setLoop(boolean loop) {
		this.loop=loop;
	}
	@Override
	public void run() {
		while(loop) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程还在运行");
			
		}
		
	}
	
}