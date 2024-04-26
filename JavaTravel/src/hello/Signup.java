package hello;

class MyException extends Exception {
    //异常信息
    private String message;

    //构造函数
    public MyException(String message){
        super(message);
        this.message = message;
    }

    //获取异常信息,由于构造函数调用了super(message),不用重写此方法
    //public String getMessage(){
    //    return message;
    //}
}

public class Signup {
	static void isSuccess(String name,String password,String email) throws MyException{
		if(name.isEmpty()||password.isEmpty()||email.isEmpty()) {
			throw new MyException("empty false!");
		}
		int namelen=name.length();
		if(namelen<2||namelen>4) {
			throw new MyException("name length false!");
		}
		int passlen=password.length();
		if(passlen!=6) {
			throw new MyException("password length false!");
		}
		//判断每个字符是否为数字
		for(char c:password.toCharArray()) {
			if(!Character.isDigit(c)) {
				throw new MyException("password digit false!");
			}
		}
		int ind1=email.indexOf('@');
		int ind2=email.indexOf('.');
		if(!(ind1>0&&ind2>ind1)) {
			throw new MyException("email false!");
		}
	}


	public static void main(String[] args) {
		// 注册信息
		// 用户名长度2-4；
		// 密码长度6，全为数字
		// 邮箱中包含@和，并且@在.前
		String name="Tom";
		String password="123456";
		String email="156423@qq.com";
		try {
			isSuccess(name,password,email);
			System.out.print("注册成功");
		} catch (MyException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
