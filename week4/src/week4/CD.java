package week4;

public class CD extends Item{
//	private String title;
	private String artist;
	private int numofTracks;
//	private int playingTine;
//	private boolean gotIt=false;
//	private String comment;
	public CD(String title, String artist, int numofTracks, int playingTine, String comment) {
		super(title,playingTine,false,comment);
		//this.title = title;
		this.artist = artist;
		this.numofTracks = numofTracks;
//		this.playingTine = playingTine;
//		this.comment = comment;
	}
	public void print() {
		System.out.print("CD:《");
		super.print();
		System.out.print("》by "+artist+"\n");
	}
	public static void main(String[] args) {
		CD cd1=new CD("aa","bb",1,1,"...");
		cd1.print();
	}
}
