package week4;

import java.util.ArrayList;

public class Database {
	//private ArrayList<CD> listCD=new ArrayList<CD>();
	//private ArrayList<DVD> listDVD=new ArrayList<DVD>();
	private ArrayList<Item> listItem=new ArrayList<Item>();
	
//	public void add(CD cd) {
//		listCD.add(cd);
//	}
//	public void add(DVD dvd) {
//		listDVD.add(dvd);
//	}
	public void add(Item item) {
		listItem.add(item);
	}
	public void list() {
//		for(CD cd:listCD) {
//			cd.print();
//		}
//		for(DVD dvd:listDVD) {
//			dvd.print();
//		}
		for (Item item:listItem) {
			item.print();
		}
	}
	
	public static void main(String[] args) {
		Database db=new Database();
		db.add(new CD("flower sea","jaychou", 4, 60, "...."));
		db.add(new CD("baby","justin", 2, 60, "...."));
		db.add(new DVD("harry potter","JK", 60, "...."));
		db.add(new DVD("flipped","unknow", 60, "...."));
		db.add(new Videogame("it takes two friends to pass", 55, "....",2));
		db.add(new MP3("last dance","wubai", 55, "...."));
		db.list();
		
		
	}
}
