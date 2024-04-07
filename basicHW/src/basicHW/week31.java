package basicHW;

import java.util.Scanner;

public class week31 {

	public static void main(String[] args) {
		//输入样例：342315
		//输出样例：13
		Scanner in=new Scanner(System.in);
		int shuwei=1;
		int num=in.nextInt();
		int ans=0;
		while(num>0) {
			int tmp=num%10;
			if(tmp%2==shuwei%2) {
				ans+=(int)Math.pow(2, shuwei-1);
			}
			shuwei++;
			num=num/10;
		}
		System.out.println(ans);
	}

}