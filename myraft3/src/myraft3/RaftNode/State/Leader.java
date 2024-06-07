package myraft3.RaftNode.State;

import java.net.Socket;

import myraft3.RaftNode.HeartBeatTask;
import myraft3.RaftNode.RaftNode;

public class Leader implements State{

    private HeartBeatTask heartBeatTask;

    public Leader(RaftNode raftNode) {
    	heartBeatTask = new HeartBeatTask(raftNode);
        heartBeatTask.start();
    }

    @Override
    public void dealMessage(String[] strings) {

    }

    @Override
    public void dealMessage(String[] strings, Socket socket) {

    }

    @Override
    public String currentState() {
        return "leader";
    }
}
