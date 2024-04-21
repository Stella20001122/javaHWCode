package javaimprove;

public class StringPrac {

	public static void main(String[] args) {
		//String 方法
		String poem="锄禾日当午,汗滴禾下土,谁知盘中餐,粒粒皆辛苦";
		String[] splitpoem=poem.split(",");
		for(int i=0;i<splitpoem.length;i++) {
			System.out.println(splitpoem[i]);
		}
		
		String address="E:\\aaa\\bbb";
		String[] splitaddress=address.split("\\\\");//每个斜杠前面要带转义符\
		for(int i=0;i<splitaddress.length;i++) {
			System.out.println(splitaddress[i]);
		}
		// 转成字符数组
		String s="happy";
		char[] chs=s.toCharArray();
		for(int i=0;i<chs.length;i++) {
			System.out.println(chs[i]);
		}
		//格式
		String name="amy";
		int age=10;
		double score=98.3/3;
		char gender='女';
		String info=
				"姓名是"+name+"，年龄是"+age+"，成绩是"+score+"，性别是"+gender+",希望大家喜欢我";
		System.out.println(info);
		
		String info2=String.format("姓名是%s，年龄是%d，成绩是%.2f，性别是%c,希望大家喜欢我",name,age,score,gender);
		System.out.println(info2);
		
		String formatStr="姓名是%s，年龄是%d，成绩是%.2f，性别是%c,希望大家喜欢我";
		String info3=String.format(formatStr,name,age,score,gender);
		System.out.println(info3);

	}

}
