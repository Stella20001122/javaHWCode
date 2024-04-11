package basicHW;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class week7 {
		//week7(1)
	public static boolean isSU(int num) {
		//判断是否为素数
		boolean ans=true;
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				ans=false;
				break;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		//输入样例：18
		//输出样例：18=2x3x3
		Scanner in = new Scanner(System.in);
		int number=in.nextInt();
		if(isSU(number)) {
			System.out.print(number);
		}
		else {
			//拆分因子
			System.out.print(number+"=");
			ArrayList<Integer> factors=new ArrayList<Integer>();
			int cell=2;
			while(number!=1) {
				if(isSU(cell)) {
					while(number%cell==0) {
						number/=cell;
						factors.add(cell);
					}
				}
				cell++;
			}
			for(int i=0;i<factors.size();i++) {
				System.out.print(factors.get(i));
				if(i!=factors.size()-1) {
					System.out.print("x");
				}
			}
		}
		in.close();
	}

}
