package javaimprove;

public class StringBulider01 {

	public static void main(String[] args) {
		//对比性能
		String text="";
		long starttime=0L;
		long endtime=0L;
		StringBuffer buffer=new StringBuffer("");
		StringBuilder builder=new StringBuilder("");
		starttime=System.currentTimeMillis();
		for(int i=0;i<80000;i++) {
			buffer.append(String.valueOf(i));
		}
		endtime=System.currentTimeMillis();
		System.out.println("StringBuffer的执行时间："+(endtime-starttime));
	
		starttime=System.currentTimeMillis();
		for(int i=0;i<80000;i++) {
			builder.append(String.valueOf(i));
		}
		endtime=System.currentTimeMillis();
		System.out.println("StringBuilder的执行时间："+(endtime-starttime));
	
	}

}
