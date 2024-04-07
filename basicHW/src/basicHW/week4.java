package basicHW;

import java.util.Scanner;

public class week4 {

	public static void main(String[] args) {
		//输入样例：2 4
		//输出样例：15
		Scanner in=new Scanner(System.in);
		int n,m;
		n=in.nextInt();
		m=in.nextInt();
		int cnt=1;
		int num=2;
		
		while(cnt<n) {
			boolean flag=true;
			num++;
			for(int i=2;i<num;i++){
				if(num%i==0) {
					flag=false;
					break;
				}
			}
			if(flag) {cnt++;}
			
		}
		//此时计数到达第n个素数
		int sum=num;
		//System.out.println(num);
		while(cnt<m) {
			num++;
			//System.out.println(num);
			boolean flag=true;
			for(int i=2;i<num;i++){
				if(num%i==0) {
					flag=false;
					break;
				}
			}
			if(flag) {
				cnt++;
				sum+=num;
			}
			
		}
		System.out.println(sum);
	}

}