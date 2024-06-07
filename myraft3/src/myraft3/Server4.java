package myraft3;

import myraft3.RaftNode.RaftNode;

public class Server4 {
    public static void main(String[] args) {
        new RaftNode("localhost", 7777, "4").start();
    }
}
