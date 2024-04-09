package castle;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String,Room> exits=new HashMap<String,Room>();
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    public Room(String description) 
    {
        this.description = description;
    }
    public void setExit(String dir,Room room) {
    	exits.put(dir, room);
    }
//    public void setExits(Room north, Room east, Room south, Room west) 
//    {
//        if(north != null)
//            northExit = north;
//        if(east != null)
//            eastExit = east;
//        if(south != null)
//            southExit = south;
//        if(west != null)
//            westExit = west;
//    }

    @Override
    public String toString()
    {
        return description;
    }
    
  //**********改动***********
    public String getExitDesc() {
    	StringBuffer s=new StringBuffer();
    	//直接用String会开销很大,因为String不可修改，
    	//每次增加都会新建一个String，因此用可以修改的StringBuffer
    	for(String dir:exits.keySet()) {
    		s.append(dir);
    		s.append(' ');
    	}
//    	if(northExit!=null) {
//    		s.append("north ");
//    	}
//    	if(eastExit!=null) {
//    		s.append("east ");
//    	}
//    	if(southExit!=null) {
//    		s.append("south ");
//    	}
//    	if(westExit!=null) {
//    		s.append("west ");
//    	}
    	return s.toString();
    }
    
    
    public Room getExit(String direction) {
    	Room nextRoom = null;
    	nextRoom = exits.get(direction);
//    	if(direction.equals("north")) {
//            nextRoom = northExit;
//        }
//        if(direction.equals("east")) {
//            nextRoom = eastExit;
//        }
//        if(direction.equals("south")) {
//            nextRoom = southExit;
//        }
//        if(direction.equals("west")) {
//            nextRoom = westExit;
//        }
        return nextRoom;
    }
    
    //************************
}
