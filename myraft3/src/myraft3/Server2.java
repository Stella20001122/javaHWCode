package myraft3;

import myraft3.RaftNode.RaftNode;

public class Server2 {
    public static void main(String[] args) {
        new RaftNode("localhost", 5555, "2").start();
    }
}
