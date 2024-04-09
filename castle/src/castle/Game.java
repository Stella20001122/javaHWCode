package castle;
//***新增****
// 加入挖宝藏功能--每个房间都有藏有宝藏（金币），金额随机（0~20随机数）
// 玩家一共有三次挖宝藏的机会，口袋会记录目前有多少个金币
// Game类中新增：goldnum; res_dignum; digForTreasure() ;
// Handler类新增子类：HandlerDig
//**********
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    //handler负责管理命令与对应的操作
    protected HashMap<String,Handler> handlers=new HashMap<String,Handler>();
    private int goldnum=0;//记录累计获得的金币数
    private int res_dignum=3;//记录剩余的挖宝藏次数
    
    public Game() 
    {
    	handlers.put("go", new HandlerGo(this));
    	handlers.put("help",new HandlerHelp(this));
    	handlers.put("bye",new HandlerBye(this));
    	handlers.put("dig",new HandlerDig(this));//挖宝藏功能
        
    	createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        
        //	初始化房间的出口
//        outside.setExits(null, lobby, study, pub);
//        lobby.setExits(null, null, null, outside);
//        pub.setExits(null, outside, null, null);
//        study.setExits(outside, bedroom, null, null);
//        bedroom.setExits(null, null, null, study);
        outside.setExit("east", lobby);
        outside.setExit("south", study);
        outside.setExit("west", pub);
        lobby.setExit("west", outside);
        pub.setExit("east", outside);
        study.setExit("north", outside);
        study.setExit("east", bedroom);
        bedroom.setExit("east", study);
        //加入up down
        lobby.setExit("up", pub);
        pub.setExit("down", lobby);
        
        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showPrompt();
    }
    
    private void showPrompt() {
    	System.out.println("现在你在" + currentRoom);
        System.out.print("出口有：");
        System.out.print(currentRoom.getExitDesc());
        System.out.println();
    }
    
    private void play() {
    	Scanner in = new Scanner(System.in);
    	while ( true ) {
    		String line = in.nextLine();
    		String[] words = line.split(" ");
    		Handler handler = handlers.get(words[0]);
    		String value="";
    		if(words.length>1) {
    			value=words[1];//针对不是bye的情况
    		}
    		if(handler!=null) {
    			handler.doCmd(value);
    			if(handler.isBye()) {
    				break;
    			}
    		}
//    		if ( words[0].equals("help") ) {
//    			printHelp();
//    		} else if (words[0].equals("go") ) {
//    			goRoom(words[1]);
//    		} else if ( words[0].equals("bye") ) {
//    			break;
//    		}
    	}
    	in.close();
    }
    //************************
    
    // 以下为用户命令
    public void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }
    //**********新增：挖宝藏***********
    public void digForTreasure() 
    {
    	if(res_dignum>0) {
    		int gold = (int)(Math.random()*20)+1;
    		goldnum+=gold;
    		res_dignum--;
    		System.out.println("恭喜你挖到"+gold+"个金币！你目前拥有："+goldnum+"个金币！剩余次数："+res_dignum);
    	}
    	else {
    		System.out.println("挖不动了...");
    	}
    }
  //*************************
	
	public static void main(String[] args) {
		Game game = new Game();
		game.printWelcome();
		
		game.play();
        
        System.out.println("感谢您的光临。");
        System.out.println("此次旅程中，您一共获得了"+game.goldnum+"个金币~");
        System.out.println("再见！");
	}

}
