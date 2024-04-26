package hello;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetPrac01 {

	public static void main(String[] args) {
		//当name和age相同时，认为是相同员工
		//需要重写哈希值方法&equals方法，
		//使name和age相同时返回相同的哈希值（自动重写）
		Set hashset=new HashSet();
		hashset.add(new Employee("Tom",25));
		hashset.add(new Employee("jack",36));
		hashset.add(new Employee("Tom",25));
		System.out.println(hashset.toString());

	}

}
class Employee{
	private String name;
	private int age;
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
}