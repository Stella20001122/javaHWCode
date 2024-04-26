package hello;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetPrac02 {

	public static void main(String[] args) {
		//当birthday和name相同时判断为同一个
		//所以MyDate的hashcode和equals也需要重写
		Set hashset=new HashSet();
		hashset.add(new Employee1("Tom",2000,new MyDate(1999,1,1)));
		hashset.add(new Employee1("jack",3000,new MyDate(1999,5,1)));
		hashset.add(new Employee1("Tom",4000,new MyDate(1999,1,1)));
		System.out.println(hashset.toString());
	}

}

class Employee1{
	private String name;
	private double sal;
	private MyDate birthday;
	public Employee1(String name, double sal, MyDate birthday) {
		super();
		this.name = name;
		this.sal = sal;
		this.birthday = birthday;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(birthday, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee1 other = (Employee1) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Employee1 [name=" + name + ", sal=" + sal + ", birthday=" + birthday + "]";
	}
	
	
}
class MyDate{
	private int year;
	private int month;
	private int day;
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		return day == other.day && month == other.month && year == other.year;
	}
	
}