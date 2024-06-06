package my2pcCode;

public class Main {
    public static void main(String[] args) {
        TransactionManager tm = new TransactionManager();

        // 银行数据库的JDBC URL可能需要根据实际情况调整
        String urlBank1 = "jdbc:mysql://localhost:3306/testdb";
        String urlBank2 = "jdbc:mysql://localhost:3306/testdb2";
        String user = "root";
        String password = "123456";

        // 定义SQL命令，代表事务操作
        String sqlBank1 = "UPDATE accounts SET balance = balance - 200 WHERE name = 'Alice'";
        String sqlBank2 = "UPDATE accounts SET balance = balance + 200 WHERE name = 'Bob'";

        // 添加数据库参与者
        tm.addParticipant(new DBParticipant(urlBank1, user, password, sqlBank1));
        tm.addParticipant(new DBParticipant(urlBank2, user, password, sqlBank2));

        // 执行事务
        tm.executeTransaction();
    }
}
