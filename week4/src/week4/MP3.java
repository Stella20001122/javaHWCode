package week4;

public class MP3 extends Item {
	private String singer;
	
	public MP3(String title, String singer, int playingTine, String comment) {
		super(title, playingTine, false, comment);
		this.singer = singer;
	}

	public void print() {
		System.out.print("MP3:《");
		super.print();
		System.out.print("》 by "+singer+"\n");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
