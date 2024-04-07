package basicHW;

import java.util.Scanner;

public class week2 {

	public static void main(String[] args) {
		//输入样例：933
		//输出样例：133
		Scanner in=new Scanner(System.in);
		int BJT;
		BJT=in.nextInt();
		int one,two,three,four;
		one=BJT%10;
		two=(BJT/10)%10;
		three=(BJT/100)%10;
		four=(BJT/1000)%10;
		
		//System.out.println(four+"+"+three+"+"+two+"+"+one);
		if(four==0) {
			//没有千位
			if(three>=8) {
				three-=8;
			}
			else {//跨天了
				int hour=24-(8-three);
				four=hour%10;
				three=(hour-four*10);
			}
		}
		else {
			//有千位
			if(three>=8) {
				three-=8;
			}
			else {
				four-=1;
				three=10+three-8;
			}
		}
		int ans=four*1000+three*100+two*10+one;
		System.out.println(ans);
	}

}