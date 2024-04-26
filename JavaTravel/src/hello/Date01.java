package hello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Date01 {

	public static void main(String[] args) throws ParseException {
		// 默认输出的是国外的日期格式
		Date d1=new Date();
		System.out.println(d1);
		// 转换成国内的
		// 使用的字母是规定好的
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
		String format=sdf.format(d1);
		System.out.println(format);
		
		//字符串再转成date
		//string必须要跟使用的SimpleDateFormat对象格式一样，否则会有 ParseException  
		String s="2024年4月20日 11:17:04 星期六";
		Date parse=sdf.parse(s);//需要抛出异常
		System.out.println(sdf.format(parse));
		
		//二代：calendar,是抽象类，不能实例化，只能获取相应的字段
		Calendar c=Calendar.getInstance();//c是管理器
		System.out.println(c);
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.MONTH)+1);//月从0开始变化，要+1
		//需要自己组合格式，没有专门的格式化的类
		System.out.println((c.get(Calendar.MONTH)+1)+"月"+(c.get(Calendar.DAY_OF_MONTH))+"日");//月从0开始变化，要+1
		
		//第三代：LocalDate LocalTime  LocalDateTime
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ldt);//年月日时分秒
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getDayOfYear());
		System.out.println(ldt.getHour());
		System.out.println(ldt.getYear());
		//格式日期类DateTimeFormatter
		DateTimeFormatter dft=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		String fs=dft.format(ldt);
		System.out.println(fs);//年月日时分秒
		
		//时间加减
		System.out.println(dft.format(ldt));//年月日时分秒
		LocalDateTime ldt1=ldt.minusDays(890);
		System.out.println(dft.format(ldt1));//年月日时分秒
		LocalDateTime ldt2=ldt.plusHours(485);
		System.out.println(dft.format(ldt2));//年月日时分秒
		
		
		//Instant与Date互换
		Instant ins=Instant.now();
		System.out.println(ins);
		Date dt=Date.from(ins);
		Instant ins1=dt.toInstant();
		System.out.println(ins1);
	}

}
