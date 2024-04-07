package basicHW;

import java.util.Scanner;

public class week5 {

	public static void main(String[] args) {
//		输入样例：
//		6 2
//		5 3
//		3 12
//		1 6
//		0 20
//		6 2
//		5 3
//		2 12
//		1 6
//		0 20
	//输出样例：4x6+6x5+12x3+12x2+12x+40
		Scanner in=new Scanner(System.in);
		int[] a=new int[101];
		int[] b=new int[101];
		int[] s=new int[101];
		int mi,num;
		do {
			mi=in.nextInt();
			num=in.nextInt();
			a[mi]=num;
		}while(mi!=0);
		do {
			mi=in.nextInt();
			num=in.nextInt();
			b[mi]+=num;
		}while(mi!=0);
		for(int i=0;i<=100;i++) {
			s[i]=a[i]+b[i];
		}
		int count=0;//记录输出的项数
		for(int i=100;i>1;i--) {
			if(s[i]==0) {
				continue;
			}
			if(count==0) {
				System.out.print(s[i]+"x"+i);
			}
			else {
				if(s[i]>1) {
					System.out.print("+"+s[i]+"x"+i);
				}
				else if(s[i]<-1){
					System.out.print(s[i]+"x"+i);
				}
				else if(s[i]==1) {
					System.out.print("+x"+i);
				}
				else {
					System.out.print("-x"+i);
				}
			}
			count++;
		}
		if(s[1]!=0) {
			if(count==0) {
				System.out.print(s[1]+"x");
			}
			else {
				if(s[1]>1) {
					System.out.print("+"+s[1]+"x");
				}
				else if(s[1]<-1){
					System.out.print(s[1]+"x");
				}
				else if(s[1]==1) {
					System.out.print("+x");
				}
				else {
					System.out.print("-x");
				}
			}
			count++;
		}
		if(s[0]!=0) {
			if(count==0) {
				System.out.print(s[0]);
			}
			else {
				if(s[0]>1) {
					System.out.print("+"+s[0]);
				}
				else if(s[0]<-1){
					System.out.print(s[0]);
				}
				else if(s[0]==1) {
					System.out.print("+1");
				}
				else {
					System.out.print("-1");
				}
			}
			count++;
		}
		if(count==0) {
			System.out.print("0");//一个项也没有输出的时候，输出0！
		}
		in.close();
	}

}