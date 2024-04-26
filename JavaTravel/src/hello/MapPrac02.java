package hello;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapPrac02 {

	public static void main(String[] args) {
		Map hashmap=new HashMap();
		hashmap.put(1, new Employee2("jack",2000,1));
		hashmap.put(2, new Employee2("tom",33000,2));
		hashmap.put(3, new Employee2("amy",5000,3));

		//迭代：取出所有的Key
		Set keyset=hashmap.keySet();
		//1.增强for循环
		for(Object key:keyset) {
			Employee2 o1=(Employee2)hashmap.get(key);
			if(o1.getSal()>18000) {
				System.out.println(o1.getName());
			}
		}	
		
		hashmap.put(3, new Employee2("john",500000,3));
		//迭代：通过EntrySet获取
		Set entryset=hashmap.entrySet();
		//2.迭代器
		Iterator it2=entryset.iterator();
		while(it2.hasNext()) {
			Object next=it2.next();
			Map.Entry ne=(Map.Entry)next;
			Employee2 o2=(Employee2)ne.getValue();
			if(o2.getSal()>18000) {
				System.out.println(o2.getName());
			}
		}				
	}

}
class Employee2{
	private String name;
	private double sal;
	private int id;
	public Employee2(String name, double sal, int id) {
		super();
		this.name = name;
		this.sal = sal;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", sal=" + sal + ", id=" + id + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}