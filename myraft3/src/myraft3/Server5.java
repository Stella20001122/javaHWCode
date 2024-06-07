package myraft3;

import myraft3.RaftNode.RaftNode;

public class Server5 {
    public static void main(String[] args) {
        new RaftNode("localhost", 8888, "5").start();
    }
}
