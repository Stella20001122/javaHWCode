package basicHW;

import java.util.ArrayList;
import java.util.Scanner;

public class Week71 {

	public static boolean isWan(int num) {
		//判断是否为完数
		int sum=0;
		boolean iswan=false;
		for(int i=1;i<num;i++) {
			if(num%i==0) {
				sum+=i;
			}
		}
		if(sum==num) {
			iswan=true;
		}
		return iswan;
	}
	
	public static void main(String[] args) {
		//输入样例：1 10
		//输出样例：6
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(int i=n;i<=m;i++) {
			if(isWan(i)) {
				arr.add(i);
			}
		}
		if(arr.size()!=0) {
			for(int i=0;i<arr.size()-1;i++) {
				System.out.print(arr.get(i));
				System.out.print(" ");
			}
			System.out.print(arr.get(arr.size()-1));
		}
		else {
			System.out.println("");
		}
		
	}

}
