package innerclass_prac;

public class AnonymousInnerClassDetails {
	//匿名内部类的细节
	
	public static void main(String[] args) {
		Outer05 out05 = new Outer05();
		out05.f1();
	}

}
class Outer05{
	private int n1=99;
	public void f1() {
		//创建一个基于类的匿名内部类
		Person per = new Person() {
			private int n1=999;
			@Override
			public void hi() {
				System.out.println("匿名内部类重写了hi()");
				System.out.println("n1="+n1);
				System.out.println("外部类Outer05的n1="+Outer05.this.n1);
			}
			
		};
		per.hi();//动态绑定，真实运行类型是Outer05$1
		
		//也可以直接调用(连对象都不去命名）
		new Person() {

			@Override
			public void hi() {
				System.out.println("匿名内部类重写了hi()--hhh");
			}

		}.hi();//不带参数
		
		new Person() {

			@Override
			public void hi() {
				System.out.println("匿名内部类重写了hi()--hhh");
			}
			@Override
			public void ok(String str) {
				// TODO Auto-generated method stub
				super.ok(str);
			}
			
		}.ok("bye"); //带参数的函数
	}
}
class Person{
	public void hi() {
		System.out.println("person hi()");
	}
	public void ok(String str) {
		System.out.println("person ok()"+str);
	}
}