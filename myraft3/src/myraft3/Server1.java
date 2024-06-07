package myraft3;

import myraft3.RaftNode.RaftNode;

public class Server1 {
    public static void main(String[] args) {
        new RaftNode("localhost", 4444, "1").start();
    }
}
