package hello;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod01 {

	public static void main(String[] args) {
		List ls=new ArrayList();
		ls.add("JACK");
		ls.add(10);
		ls.add(true);
		System.out.println("List:"+ls);
		
		ls.remove(true);
		System.out.println("List:"+ls);
		
		System.out.println(ls.contains("jack"));
		System.out.println(ls.contains("JACK"));
		
		System.out.println(ls.size());
		System.out.println(ls.isEmpty());
		
		List ls1=new ArrayList();
		ls1.add("Amy");
		ls1.add(100);
		ls1.add("JACK");
		System.out.println("List1:"+ls1);
		
		//查看多个元素是否都存在
		System.out.println(ls.containsAll(ls1));
		//删除多个元素
		ls.removeAll(ls1);
		System.out.println("List:"+ls);
		
		ls.add("11");
		ls.add(22);
		System.out.println("List:"+ls);
		List ls2=ls.subList(0, 2);
		System.out.println("List2:"+ls2);
		
	}

}
