package week3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//先读入城市名
		Scanner in=new Scanner(System.in);
		ArrayList<String> city=new ArrayList<String>();
		String s=in.nextLine();
		while(!s.equals("###")) {
			city.add(s);
			s=in.nextLine();
		}
		int n=city.size();
		int[][] distance=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				distance[i][j]=in.nextInt();
			}
		}
		String startcity=in.nextLine();
		String endcity=in.nextLine();
		int startind=city.indexOf(startcity);
		int endind=city.indexOf(endcity);
		int ans=distance[startind][endind];
		System.out.println(ans);
		in.close();

	}

}
