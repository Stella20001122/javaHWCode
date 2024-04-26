package hello;

import java.util.Scanner;

public class ThreadPrac06 {

	public static void main(String[] args) {
		A aa=new A();
		aa.start();
		B bb=new B(aa);
		bb.start();
	}

}
class A extends Thread{
	private boolean loop=true;
	@Override
	public void run() {
		while(loop) {
			System.out.println((int)(100*Math.random()+1));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean isLoop() {
		return loop;
	}
	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	

}

//B线程必须持有A线程的对象才能控制它
class B extends Thread{
	private A a;
	private Scanner scanner=new Scanner(System.in);
	public B(A a) {
		super();
		this.a = a;
	}
	@Override
	public void run() {
		while(true) {
			System.out.println("输入指令Q退出");
			char c=scanner.next().toUpperCase().charAt(0);
			if(c=='Q') {
				a.setLoop(false);
				break;
			}
		}
	}
	

}