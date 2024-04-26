package hello;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.print("Hello World!\n");
		Scanner in = new Scanner(System.in);
		System.out.print("输入数字：");
//		System.out.println("echo:"+in.nextLine());
//		System.out.println(5+"=2+3="+(2+3));
		final int amount=100;//final说明是常量
		int price = 0; //整型
		price=in.nextInt();//声明变量并赋值
		System.out.println(amount+"-"+price+"="+(amount-price));
		
		//单位换算--浮点数
		//当整数和浮点数放在一起计算，java会自动把整数换成浮点数
		int foot;
		double inch;
		System.out.println("输入foot：");
		foot=in.nextInt();
		System.out.println("输入inch：");
		inch=in.nextDouble();
		System.out.println((foot+inch/12)*0.3048);
		System.out.println((int)((foot+inch/12)*0.3048*100)+"cm");//强制类型转换
		
		//浮点数精度缺失
		System.out.println(1.2-1.1);//结果是0.09999999999999987
		
		
		
	}

}
