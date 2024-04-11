package exception;

class OpenException extends Exception{
	
}
class CloseException extends Throwable{
	
}
public class Open {
	// 文件打开异常
	public static int open() {
		return -1;
	}
	public static void readFile() throws OpenException,CloseException{
		if(open()==-1) {
			throw new OpenException();
		}
	}
	public static void main(String[] args) {
		try {
			readFile();
		} catch (OpenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CloseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
