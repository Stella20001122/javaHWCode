package exception;

import java.util.Scanner;

public class ArrayIndex {
	
	public static void f() {
		// 尝试捕捉数组下标溢出的异常
		int[] a=new int[10];
		int idx;
		Scanner in=new Scanner(System.in);
		idx=in.nextInt();
		a[idx]=10;
		System.out.println("无异常");
	}
	public static void g() {
		f();
	}
	public static void h() {
		int i=10;
		if(i<100) {
			g();
		}
	}
	public static void k() {
		try {
			h();
		}catch(NullPointerException e2) {
			System.out.println("k()异常");
		}
		catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("k()异常-arrayindex");
//			throw e1;//抛出异常后，则该异常还能被后面的catch捕捉到
		}
	}
	public static void main(String[] args) {
		try {
			k();
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("main-catch");
			System.out.println(e.getMessage());
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
