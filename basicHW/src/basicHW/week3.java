package basicHW;

import java.util.Scanner;

public class week3 {

	public static void main(String[] args) {
		//输入样例：9 3 4 2 5 7 －1 
		//输出样例：4 2
		Scanner in=new Scanner(System.in);
		int num=1;
		int count_odd=0;
		int count_even=0;
		while(num>0&&num<100000) {
			num=in.nextInt();
			if(num==-1) {
				break;
			}
			if(num%2==0) {
				count_even++;
			}
			else{
				count_odd++;
			}
			
		}
		System.out.println(count_odd+" "+count_even);
	}

}