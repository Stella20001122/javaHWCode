package exception;

class NewException extends Exception{}

public class Jicheng {
	public void f() throws OpenException{
		
	}
	
	public Jicheng() throws NewException{
	}

	public static void main(String[] args) {
		
	}

}
class Newclass extends Jicheng{
	public void f() throws OpenException{
		
	}
	
	public Newclass() throws OpenException,NewException {
		
	}

	public static void main(String[] args) {
		try {
			Jicheng a=new Newclass();
			a.f();
		} catch (OpenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NewException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
