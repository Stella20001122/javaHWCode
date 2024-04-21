package innerclass_prac;

public class AnonymousInnerClass {

	public static void main(String[] args) {
		Outer04 out04=new Outer04();
		out04.method();
	}

}

class Outer04{//外部类
	private int n1=10;
	public void method() {
		//基于接口的匿名内部类
		//需求：使用接口IA并创建对象；
		//传统方法：写一个类，实现该接口，再创建对象
		//如果新写的这个类，只用一次，之后不再使用，则新写一个类有点浪费
		//可以使用匿名内部类来简化开发
		//tiger的编译类型是：等号的左边（IA接口）
		//tiger的运行类型是：匿名内部类 xxx=Outer04$1(系统自己分配的类名
		/*
		 * 匿名内部类的底层：
		 * class xxx implements IA{
		       @Override
			   public void cry() {
			       System.out.println("老虎叫...");
			   }
		   }
		 */
		//jdk在底层创建匿名内部类Outer04$1，而后立即创建Outer04$1实例
		//并且把地址返回给了tiger
		//匿名内部类使用一次，就不能再使用（但是对象tiger还是可以继续使用
		IA tiger = new IA(){
			@Override
			public void cry() {
				System.out.println("老虎叫...");
			}
		};
		System.out.println("tiger的运行类型="+tiger.getClass());
		tiger.cry();
		tiger.cry();
		//new Outer04$1();是无效的
		
		//基于类的匿名内部类
		//如果是Father father = new Father("Tom");--单纯的new了一个对象
		//匿名内部类需要后面加大括号{};
		//father的编译类型：Father
		//father的运行类型：Outer04$2
		/*
		 * 匿名内部类的底层：
		 * class xxx extends Father{
		      @Override
			  public void test() {
				  System.out.println("匿名内部类重写了test()");
			  }
		   }
		 */
		//而后立即创建Outer04$2对象，并且把地址返回给了father
		//("Tom")参数列表会自动传给Father构造器
		Father father = new Father("Tom") {

			@Override
			public void test() {
				System.out.println("匿名内部类重写了test()");
			}
			
		};
		Father father1 = new Father("Tom1");
		System.out.println("father的运行类型="+father.getClass());
		System.out.println("father1的运行类型="+father1.getClass());
		father.test();
		
		//基于抽象类的匿名内部类
		Animal animal = new Animal(){
			@Override
			void eat() {
				System.out.println("小狗吃东西...");
			}
			
		};
		animal.eat();
	}
}
interface IA{//接口
	public void cry();
}
class Father{//类
	public Father(String name) {
		System.out.println("name="+name);
	}
	public void test() {
		
	}
}
abstract class Animal{//抽象类
	abstract void eat();
}