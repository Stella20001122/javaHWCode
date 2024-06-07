package myraft3.RaftNode;

public class ServeStart {
    public static void main(String[] args) {
        new RaftNode("localhost", 7777, "server").start();

    }
}
