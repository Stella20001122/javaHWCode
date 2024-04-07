package basicHW;

import java.util.Scanner;

public class week6 {

	public static void main(String[] args) {
		//输入样例：It's great to see you here.
		//输出样例：4 5 2 3 3 4
		Scanner in=new Scanner(System.in);
		String s=in.nextLine();
		String s1=s.trim();
		int cnt=0;
		if(s1.length()>1) {
			for(int i=0;i<s1.length();i++) {
				if(s1.charAt(i)==' ') {
					if(cnt!=0) {System.out.print(cnt+" ");}
					cnt=0;
				}
				else if(s1.charAt(i)=='.') {
					System.out.print(cnt);
					break;
				}
				else{
					cnt++;
				}
			}
		}
		
		
		in.close();
	}

}
