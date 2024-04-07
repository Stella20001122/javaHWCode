package week1;
//java进阶课程-第一周作业

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		//测试数据：2 4 1 3
		Fraction a=new Fraction(in.nextInt(),in.nextInt());
		Fraction b=new Fraction(in.nextInt(),in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5,6)).print();
		a.print();
		b.print();
		in.close();
	}

}

class Fraction{
	int son;
	int mon;
	
	Fraction(int son,int mon){
		this.son=son;
		this.mon=mon;
	}
	
	double toDouble() {
		return (double)son/mon;
	}
	
	Fraction plus(Fraction r) {//交叉乘上分母，分子相加
		int fenzi=r.son*mon+son*r.mon;
		int fenmu=mon*r.mon;
		return new Fraction(fenzi,fenmu);
	}
	
	Fraction multiply(Fraction r) {
		int s=r.son*this.son;
		int m=r.mon*this.mon;
		return new Fraction(s,m);
	}
	
	void print() {
		int tmp;
		int m1=mon;
		int s1=son;
		while(m1!=0) {//化为最简分式
			tmp=s1%m1;
			s1=m1;
			m1=tmp;
		}//s1为最大公约数
		son/=s1;
		mon/=s1;
		if(son%mon==0) {
			System.out.println(son/mon);
		}
		else {
			System.out.println(son+"/"+mon);
		}
	}
}