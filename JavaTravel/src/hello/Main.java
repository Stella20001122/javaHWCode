package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String s=in.nextLine();
		String timeChina=null;
		while(!s.equals("END")) {
			if(s.startsWith("$GPRMC")) {
				//计算异或值，找到$和*之间的
				int start=s.indexOf('$');
				int end=s.indexOf('*');
				int value=s.charAt(start+1);
				for(int i=start+1;i<end-1;i++) {
					value=value^s.charAt(i+1);
				}
				int valuemo=value%65536;
				String s1=Integer.toHexString(valuemo);
				String s2=s.substring(end+1);
				if(s1.equals(s2)) {
					String[] fields=s.split(",");//分割得到字符串数组
					if(fields[2].equals("A")) {
						//判断为已定位状态
						String timeUTC=fields[1];
						String hh=timeUTC.substring(0,2);
						String mm=timeUTC.substring(2,4);
						String ss=timeUTC.substring(4,6);
						int h=(Integer.parseInt(hh)+8)%24;
						if(h<10) {
							hh="0"+Integer.toString(h);
						}
						else {
							hh=Integer.toString(h);
						}
						timeChina=hh+":"+mm+":"+ss;
					}
					
				}
			}
			s=in.nextLine();
		}
		if(timeChina!=null) {
			System.out.println(timeChina);
		}
		in.close();
	}

}
