package week4;

public class Item {
	private String title;
	private int playingTine;
	private boolean gotIt=false;
	private String comment;
	
	public Item(String title, int playingTine,boolean gotIt,String comment) {
		super();
		this.title = title;
		this.playingTine = playingTine;
		this.gotIt = gotIt;
		this.comment = comment;
	}
	public void print() {
		System.out.print(title);
	}
	
	public void setTitle(String title) {
		this.title=title;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
