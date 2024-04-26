package hello;

import java.util.*;
//import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

public class ListSort01 {

	public static void main(String[] args) {
//		List lsb=new ArrayList();
//		List lsb=new LinkedList();
		List lsb=new Vector();
		
		lsb.add(new Book1("红楼梦","曹雪芹",100));
		lsb.add(new Book1("西游记","吴承恩",20));
		lsb.add(new Book1("水浒传","施耐庵",10));
		lsb.add(new Book1("三国演义","罗贯中",66));
		System.out.println(lsb.toString());
		
		//排序 
		sort(lsb);//价格大到小，冒泡
		System.out.println(lsb.toString());
		
	}
	
	public static void sort(List list) {
		//冒泡
		int s=list.size();
		for(int i=0;i<s-1;i++) {
			for(int j=0;j<s-1-i;j++) {
				//取出Book1对象
				Book1 b1=(Book1)(list.get(j));
				Book1 b2=(Book1)list.get(j+1);
				if(b1.getPrice()<b2.getPrice()) {
					//交换
					list.set(j+1,b1);
					list.set(j, b2);
				}
			}
		}
	}

}

class Book1{
	private String name;
	private String writer;
	private double price;
	public Book1(String name, String writer, double price) {
		super();
		this.name = name;
		this.writer = writer;
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" "+writer+" -- "+price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}