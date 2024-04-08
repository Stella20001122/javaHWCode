package week4;

public class DVD extends Item {
//	private String title;
	private String director;
//	private int playingTine;
//	private boolean gotIt=false;
//	private String comment;
	
	public DVD(String title, String director, int playingTine, String comment) {
		super(title,playingTine,false,comment);
//		this.title = title;
		this.director = director;
//		this.playingTine = playingTine;
//		this.comment = comment;
	}

	public void print() {
		System.out.print("DVD:《");
		super.print();
		System.out.print("》by "+director+"\n");
	}
}
