package hello;

public class ThreadPrac01 {
	
	
	public static void main(String[] args) throws InterruptedException {
		Cat cat=new Cat();
		cat.start();//启动线程
		//当main线程启动一个子线程，主线程不会阻塞，会继续执行
		//jconsle可以查看进程线程运行情况
		//主线程/子线程执行完就退出了（具体顺序看各自执行多长时间）
		Cat cat1=new Cat();
		cat1.start();//启动线程--直接调用run方法属于时普通方法，没有启动线程，会阻塞
		System.out.println("主线程："+Thread.currentThread().getName());
		for(int i=0;i<60;i++) {
			System.out.println("主线程i="+i);
			Thread.sleep(1000);
		}
	}

}

class Cat extends Thread{
//当一个类继承了Thread，这个类就可以当成线程去使用
	int times=0;
	@Override
	public void run() {
		while(true) {
			System.out.println("喵喵喵"+(++times)+"-线程名"+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(times==60) {
				break;
			}
		}
		
	}
	
	
}