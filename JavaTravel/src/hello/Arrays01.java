package hello;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Arrays01 {

	public static void main(String[] args) {
		Integer[] integer= {1,200,999};
		System.out.println(integer.toString());
		
		//排序sort
		Integer arr[]= {1,-1,7,89,8};
		//可以用冒泡排序，也可以直接用sort方法
		//数组时引用类型，所以sort排序后，会直接影响到实参arr
		//Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		//可以通过传入参数控制比较规则（可以自己写实现Comparator接口的匿名内部类）
		Arrays.sort(arr, new Comparator() {
			@Override
			public int compare(Object o1,Object o2) {
				Integer i1=(Integer)o1;
				Integer i2=(Integer)o2;
				return i2-i1;//降序
				//return i1-i2;//升序
			}
		});
		System.out.println(Arrays.toString(arr));
		
		//冒泡排序
		int[] arr1= {1,-1,8,9,20};
		bubble(arr1);
		System.out.println(Arrays.toString(arr1));
		
		//二分查找--必须对排序后的数组
		int ind=Arrays.binarySearch(arr1, 1);//不存在这个元素则返回-（low+1),low为应该在的位置；
		System.out.println(ind);
		
		//拷贝
		Integer[] newarr=Arrays.copyOf(arr, 10);
		System.out.println(Arrays.toString(newarr));//超出补空
		
		//填充
		Integer[] num=new Integer[] {9,3,2};
		Arrays.fill(num,99);
		System.out.println(Arrays.toString(num));//
		
		//转换成list
		List<Integer> asList=Arrays.asList(2,3,4,5,6,7);
		System.out.println(asList);//
		System.out.println(asList.getClass());
		//asList编译类型是List(接口)；运行类型是java.util.Arrays$ArrayList
		
		//练习
		Book[] books=new Book[4];
		books[0]=new Book("红楼梦",100);
		books[1]=new Book("三国演义",90);
		books[2]=new Book("青年文摘2020",5);
		books[3]=new Book("java从入门到入土",1024);
		//按价格大到小
		Arrays.sort(books, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Book b1=(Book)o1;
				Book b2=(Book)o2;
				double cmp=b2.getPrice()-b1.getPrice();
				//因为重写compare函数，输出类型是int，所以需要强制转换
				if(cmp>0) {
					return 1;
				}
				else if(cmp<0) {
					return -1;
				}
				else {
					return 0;
				}
			}
		});
//		for(Book b:books) {
//			System.out.println(b.toString());
//		}
		System.out.println(Arrays.toString(books));
		
		System.out.println("=========");
		//按名字长度
		Arrays.sort(books, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Book b1=(Book)o1;
				Book b2=(Book)o2;
				int l1=b1.getName().length();
				int l2=b2.getName().length();
				return l2-l1;
			}
		});
		for(Book b:books) {
			System.out.println(b.toString());
		}
	}
	
	
	//冒泡排序
	public static void bubble(int[] arr) {
		int temp=0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				//从小到大
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}

}
//BOOK
	class Book{
		private double price;
		private String name;
		public Book(String name,int price) {
			super();
			this.price = price;
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public double getPrice() {
			return price;
		}
		public void setName(String name) {
			this.name=name;
		}
		@Override
		public String toString() {
			String ans="["+name+" "+price+"]";
			return ans;
		}
		
	}
