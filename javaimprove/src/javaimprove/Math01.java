package javaimprove;

public class Math01 {

	public static void main(String[] args) {
		// 随机数-random()是[0,1)
		// 获取从[2,7]的随机数
		for(int i=0;i<20;i++) {
			System.out.println((int)(2+Math.random()*(7-2+1)));
		}

	}

}
