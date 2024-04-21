package javaimprove;

public class Integer01 {

	public static void main(String[] args) {
		//int<-->Integer装箱和拆箱
		//jdk5前是手动，后面是自动
		//-----手动装箱---
		int n1=100;
		Integer integer=new Integer(n1);
		Integer integer1=Integer.valueOf(n1);
		//----手动拆箱--
		int i=integer.intValue();
		
		//jdk5之后自动装拆
		//----自动装箱
		int n2=200;
		Integer integer2=n2;//底层还是使用Integer.valueOf(n2);
		//----自动拆箱
		int i2=integer2;//底层也是使用integer2.intValue();
		
		String s1="15695";
		Integer integer3=Integer.parseInt(s1);
	}	

}
