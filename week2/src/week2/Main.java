package week2;

class Clock{
	//Clock将两个Display对象连接起来
	private Display hour=new Display(24);
	private Display minute=new Display(60);
	private Display second=new Display(60);
	public void start() {
		while(true) {
			minute.increase();
			if(minute.getValue()==0) {
				hour.increase();
			}
			System.out.printf("%02d:%02d\n", hour.getValue(),minute.getValue());
		}
	}
	public Clock(int hour1,int minute1,int second1) {
		hour.setValue(hour1);
		minute.setValue(minute1);
		second.setValue(second1);
	}
	public void tick() {
		second.increase();
		if(second.getValue()==0) {
			minute.increase();
			if(minute.getValue()==0) {
				hour.increase();
			}
		}
	}
	public String toString() {
		return String.format("%02d:%02d:02d",hour.getValue(),minute.getValue(),second.getValue());
	}
	
	
}

class Display{

	private int value=0;
	private int limit=0;
	
	//构造函数（接受limit参数
	public Display(int limit){ //public一定要写吗？
		this.limit=limit;
	}
	public void increase() {
		value++;
		if(value==limit) {
			value=0;
		}
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value=value;
	}
}


public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner in=new java.util.Scanner(System.in);
		Clock clock = new Clock(in.nextInt(),in.nextInt(),in.nextInt());
		clock.tick();
		System.out.println(clock);
		in.close();
	}

}
