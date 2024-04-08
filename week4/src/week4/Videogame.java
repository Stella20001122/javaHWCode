package week4;

public class Videogame extends Item {
	private int numberofplayer;
	
	public Videogame(String title, int playingTine, String comment, int numberofplayer) {
		super(title, playingTine,false, comment);
		this.numberofplayer = numberofplayer;
	}


	public void print() {
		System.out.print("Videogame:《");
		super.print();
		System.out.print("》 -need "+numberofplayer+" person\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
