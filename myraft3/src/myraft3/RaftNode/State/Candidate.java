package myraft3.RaftNode.State;

import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import myraft3.RaftNode.RaftNode;

public class Candidate implements State{

    private RaftNode raftNode;
    private AtomicInteger votes = new AtomicInteger();
    private Thread electionThread;
    private volatile Boolean run;
    private AtomicInteger electionLimit;
    private Map<String, Integer> map;
    private volatile boolean electionSuccess;

    public Candidate(RaftNode raftNode) {
        this.votes.set(0);
        this.raftNode = raftNode;
        map = new ConcurrentHashMap<>();
        electionLimit = new AtomicInteger(3);
        electionSuccess = false;
        electionThread = new Thread(()->{
            run = true;
            while (run && electionLimit.get() > 0) {
                synchronized (run) {
                    raftNode.election();
                    electionLimit.getAndDecrement();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if(electionLimit.get() == 0 && !electionSuccess) {
                //System.out.println("CandidateToFollower by timeLimit");
                System.out.println("超时未完成选举，从Candidate转变为Follower");
                raftNode.CandidateToFollower();
            }
        });
        electionThread.start();
    }

    private void electionReply(String[] strings) {
        int index = Integer.parseInt(strings[2]);
        if(raftNode.getIndex() <= index) {
            System.out.println("CandidateToFollower by election");
            toFollower();
        } else {
            raftNode.refuse(strings[3]);
        }
    }

    private void getVote(String[] strings) {

        synchronized (votes){
            if (!map.containsKey(strings[2])) {
                votes.getAndIncrement();
                map.put(strings[2], 1);
            }
            //System.out.println("get a vote, current vote is " + votes.get());
            System.out.println("获得选票，当前选票来自 " + votes.get());
            if (votes.get() > 2) {
                electionSuccess = true;
                System.out.println("election***************success!!!");
                toLeader();
            }
        }
    }

    private void toFollower() {
        run = false;
        raftNode.CandidateToFollower();
    }

    private void toLeader() {
        run = false;
        raftNode.CandidateToLeader();
    }

    @Override
    public void dealMessage(String[] strings) {
        switch (strings[1]) {
            case "heartBeat":
            case "refuse":
                System.out.println("获得反对票，从Candidate转变为Follower");
                toFollower();
                break;
            case "election":
                electionReply(strings);
                break;
            case "vote":
                getVote(strings);
                break;
            default:
                break;
        }
    }

    @Override
    public void dealMessage(String[] strings, Socket socket) {

    }

    @Override
    public String currentState() {
        return "candidate";
    }
}