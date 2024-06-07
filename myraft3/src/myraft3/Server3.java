package myraft3;

import myraft3.RaftNode.RaftNode;

public class Server3 {
    public static void main(String[] args) {
        new RaftNode("localhost", 6666, "3").start();
    }
}