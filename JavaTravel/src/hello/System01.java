package hello;

import java.util.Arrays;

public class System01 {

	public static void main(String[] args) {
		//退出当前程序
		System.out.print("1111");
//		System.exit(0);//exit(0)表示退出程序，0表示正常状态
		System.out.print("22222");
		
		//arraycopy:复制数组元素，比较适合底层调用；
		//一般还是用Arrays.copyOf
		int[] src= {1,2,3};
		int[] dest=new int[3];//当前是0,0,0
		System.arraycopy(src, 0, dest, 1, 2);
		//五个参数：源数组/起始拷贝索引/目标数组/起始被拷贝索引/拷贝元素个数
		System.out.print(Arrays.toString(dest));
	
		//currentTimeMilens:返回当前时间距离1970-1-1的毫秒数
		System.out.print(System.currentTimeMillis());
		
		//gc：运行垃圾回收机制System.gc();
		
	}

}
