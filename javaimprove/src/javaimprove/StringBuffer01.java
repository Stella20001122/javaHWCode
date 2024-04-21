package javaimprove;

public class StringBuffer01 {

	public static void main(String[] args) {
		//构造一个大小为16的char[]，用于存放字符内容（默认容量16）
		StringBuffer sbf=new StringBuffer();
		
		//构造指定大小的char[]，用于存放字符内容
		StringBuffer sbf1=new StringBuffer(100);
				
		//构造当前已有的字符串大小再加16的char[]，用于存放字符内容（默认剩余容量16
		StringBuffer sbf2=new StringBuffer("hello");
	
		//StringBuffer和String互换
		String str="hello tom";
		// 方法1：返回的才是StringBuffer对象，对str本身没有影响
		StringBuffer sbf3=new StringBuffer(str);
		// 方法2：使用append方法
		StringBuffer sbf4=new StringBuffer();
		sbf4=sbf4.append(str);
		
		StringBuffer sbf5=new StringBuffer("你好世界");
		//方法1：使用StringBuffer的toString
		String ss=sbf5.toString();
		//方法2：使用构造器
		String ss1=new String(sbf5);
		
		//方法使用
		StringBuffer sb=new StringBuffer("hello");
		//增加
		sb.append('.');
		sb.append("张三丰");
		sb.append("赵敏").append(100).append(true).append(3.1415);
		System.out.println(sb);
		
		//删除 索引大于等于左，小于右（左闭右开）
		sb.delete(11,14);
		System.out.println(sb);
		
		//改
		sb.replace(9,11,"周芷若");
		System.out.println(sb);
		
		//查找(子串第一次出现的索引
		int ind=sb.indexOf("张三丰");
		System.out.println(ind);
		
		//插入
		sb.insert(9,"赵敏");
		System.out.println(sb);
		
		//长度
		System.out.println(sb.length());
		
		//将123456.59变成价格的常规表示123,456.59
		String price="12345679.59";
		StringBuffer sb1=new StringBuffer(price);
		//找到小数点的位置
//		int i= sb1.indexOf(".");
//		while(i>3) {
//			i-=3;
//			sb1=sb1.insert(i, ",");//如果i-3<0?
//		}
//		System.out.println(sb1);
		//或者for循环
		for(int i=sb1.lastIndexOf(".")-3;i>0;i-=3) {
			sb1=sb1.insert(i, ",");//如果i-3<0?
		}
		System.out.println(sb1);
		
	}

}
