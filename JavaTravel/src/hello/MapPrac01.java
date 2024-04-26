package hello;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapPrac01 {

	public static void main(String[] args) {
		Map map=new HashMap();
		map.put("111","222");
		map.put("333", "444");
		map.put("555", "666");
		
		//迭代：取出所有的Key
		Set keyset=map.keySet();
		//1.增强for循环
		for(Object key:keyset) {
			System.out.println(key+"-"+map.get(key));
		}
		//2.迭代器
		Iterator it=keyset.iterator();
		while(it.hasNext()) {
			Object key=it.next();
			System.out.println(key+"-"+map.get(key));
		}
		
		//迭代：取出所有的values
		Collection valueset=map.values();
		//1.增强for循环
		for(Object val:valueset) {
			System.out.println(val);
		}
		//2.迭代器
		Iterator it1=keyset.iterator();
		while(it1.hasNext()) {
			Object val=it1.next();
			System.out.println(val);
		}
		
		//迭代：通过EntrySet获取
		Set entryset=map.entrySet();
		//1.增强for循环
		for(Object entry:entryset) {
			//把entry转成Map.Entry(具有获得key和value的方法
			Map.Entry m=(Map.Entry)entry;
			System.out.println(m.getKey()+"=="+m.getValue());
		}		
		//2.迭代器
		Iterator it2=entryset.iterator();
		while(it2.hasNext()) {
			Object next=it2.next();
			Map.Entry ne=(Map.Entry)next;
			System.out.println(ne.getKey()+"**"+ne.getValue());
		}		
		
	}

}
