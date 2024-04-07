package basicHW;

import java.util.Scanner;

public class week21 {

	public static void main(String[] args) {
		//输入样例：33
		//输出样例：Weak signals, readable with considerable difficulty.
		Scanner in=new Scanner(System.in);
		int RS;
		RS=in.nextInt();
		int S=RS%10;
		int R=(RS/10)%10;
		//System.out.println(four+"+"+three+"+"+two+"+"+one);
		String Rstr = null;
		String Sstr = null;
		switch(R) {
		case 1:
			Rstr="unreadable";
			break;
		case 2:
			Rstr="barely readable, occasional words distinguishable";
			break;
		case 3:
			Rstr="readable with considerable difficulty";
			break;
		case 4:
			Rstr="readable with practically no difficulty";
			break;
		case 5:
			Rstr="perfectly readable";
			break;
		default:
		}
		
		switch(S) {
		case 1:
			Sstr="Faint signals, barely perceptible";
			break;
		case 2:
			Sstr="Very weak signals";
			break;
		case 3:
			Sstr="Weak signals";
			break;
		case 4:
			Sstr="Fair signals";
			break;
		case 5:
			Sstr="Fairly good signals";
			break;
		case 6:
			Sstr="Good signals";
			break;
		case 7:
			Sstr="Moderately strong signals";
			break;
		case 8:
			Sstr="Strong signals";
			break;
		case 9:
			Sstr="Extremely strong signals";
			break;
		default:
		}
		
		System.out.println(Sstr+", "+Rstr+".");
	}

}