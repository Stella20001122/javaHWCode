package innerclass_prac;

public class LocalInnerClass {

	public static void main(String[] args) {
		//test
		Outer02 out2=new Outer02();
		out2.m1();
	}
}
/*
* 1.是定义在外部类的局部位置，通常在方法内
* 2.可以直接访问外部类的所有成员，包括私有成员
* 3.不能添加访问修饰符（相当于是一个局部变量（类型为类）），但是可以用final
* 4.作用域仅仅在定义它的方法或代码块中
* 5.可以直接访问外部类的成员
* 6.外部类在方法中可以创建局部内部类的对象，然后调用方法即可
* 7.外部其他类不能直接访问局部内部类（因为局部内部类的地位就是一个局部变量
* 8.如果外部类和局部内部类的成员重名，默认遵循就近原则；如果想访问外部类的成员，
*   可以使用“外部类名.this.成员”去访问--外部类名.this本质是外部类的对象
*/
class Outer02{
	private int n1=100;//私有属性
	private void m2() {
		System.out.println("outer02 m2()");
	}//私有方法
	public void m1() {
		//方法
		final class Inner02{
			private int n1=900;
			public void f() {
				System.out.println("n1="+n1+" 外部类的n1:"+Outer02.this.n1);
				m2();
			}
		}
		Inner02 inn=new Inner02();
		inn.f();
	}
}
