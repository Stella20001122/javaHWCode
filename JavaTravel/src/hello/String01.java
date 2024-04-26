package hello;

public class String01 {
	//实现reverse
	private static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuffer(str).reverse().toString();
    }//使用StringBuffer或StringBuilder自带reverse方法
	
    private static String reverse4(String str) {
        if (str == null) {
            return null;
        }
        //char数组的内容是可变的，长度是固定的
        char[] chars = str.toCharArray();
        int n = chars.length - 1;
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - i];
            chars[n - i] = temp;
        }
        return new String(chars);
    }//二分法逆序字符串数组
    
    
	public static void main(String[] args) {
		String str=new String("哈喽单车");
		System.out.println("原始："+str);
		System.out.println("reverse："+reverse(str));
		

	}
	

}
