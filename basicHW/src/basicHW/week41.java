package basicHW;

import java.util.Scanner;

public class week41 {

	public static void main(String[] args) {
		//输入样例：-30
		//输出样例：fu san ling
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		//判断是否为0
		if(num==0) {
			System.out.print("ling");
		}
		//判断是否为负
		boolean isfu=false;
		if(num<0) {
			isfu=true;
			num*=-1;//变为正
			System.out.print("fu ");
		}
		int tmp=num;
		int cnt=0;
		while(tmp>0) {
			tmp/=10;
			cnt++;
		}
		//从高位开始取
		tmp=num;
		while(cnt>0) {
			tmp=(int)(num/Math.pow(10,cnt-1));
			num-=tmp*Math.pow(10,cnt-1);
			switch(tmp) {
			    case 0:
			    	System.out.print("ling");
					break;
				case 1:
					System.out.print("yi");
					break;
				case 2:
					System.out.print("er");
					break;
				case 3:
					System.out.print("san");
					break;
				case 4:
					System.out.print("si");
					break;
				case 5:
					System.out.print("wu");
					break;
				case 6:
					System.out.print("liu");
					break;
				case 7:
					System.out.print("qi");
					break;
				case 8:
					System.out.print("ba");
					break;
				case 9:
					System.out.print("jiu");
					break;
				default:
			}
			cnt--;
			if(cnt!=0) {System.out.print(" ");}
		}
		
	}

}