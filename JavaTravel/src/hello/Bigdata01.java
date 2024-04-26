package hello;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Bigdata01 {

	public static void main(String[] args) {
		// BigInteger类--适合保存比较大的整型
		// 注意也是不可变的
		long l1= 237888888;
		System.out.println(l1);
		/*当需要处理很大的数据时，long不够用*/
		/* 构造的时候用字符串写入（否则还是提示溢出）
		 * 加减乘除要用方法
		 * */
		BigInteger b1=new BigInteger("1266415668165161561");
		System.out.println(b1);
		BigInteger b2=new BigInteger("100");
		BigInteger b3=b1.add(b2);
		System.out.println(b3);
		BigInteger b4=b1.subtract(b2);
		System.out.println(b4);
		BigInteger b5=b1.multiply(b2);
		System.out.println(b5);
		BigInteger b6=b1.divide(b2);
		System.out.println(b6);
		
		// BigDecimal类--适合保存精度更高的浮点型（小数）
		double d=1999.11454522537453376785467863549999d;
		System.out.println(d);//精度被缩减
		
		BigDecimal bd1=new BigDecimal("1999.11454522537453376785467863549999");
		BigDecimal bd2=new BigDecimal("1.1");
		System.out.println(bd1);//精度完整保留
		/* 加减乘除也是要用方法
		 * 不可变，所以创建新的BigDecimal再用方法
		 * */
		System.out.println(bd1.add(bd2));//
		System.out.println(bd1.subtract(bd2));//
		
		//除法要小心，如果结果是无限循环的小数会抛出异常Non-terminating decimal expansion
//		System.out.println(bd1.divide(bd2));//
		System.out.println(bd1.divide(bd2,BigDecimal.ROUND_CEILING));//需要指定精度避免除不尽
		
		
		
	}

}
