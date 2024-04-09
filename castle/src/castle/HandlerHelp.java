package castle;

public class HandlerHelp extends Handler {

	public HandlerHelp(Game game) {
		super(game);
	}

	@Override
	public void doCmd(String word) {
		//修改了help的提示，可以显示新增的操作；把Game中的成员handlers改成protected了
		System.out.print("迷路了吗？你可以做的命令有：");
		for(String key:game.handlers.keySet()) {
			System.out.print(key+" ");
		}
		System.out.print("\n");
        System.out.println("如：\tgo east");
	}
	
}
