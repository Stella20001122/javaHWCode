package my2pcCode;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.*;

public class DBParticipant implements Participant {
    private final String url;
    private final String username;
    private final String password;
    private Connection connection;
    private PreparedStatement statement;

    public DBParticipant(String url, String username, String password, String sql) {
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);//取消自动提交事务
            this.statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean prepare() {
        try {
        	//用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句，
            //例如 CREATE TABLE 和 DROP TABLE。INSERT、UPDATE 或 DELETE 语句的效果是修改表中零行或多行中的一列或多列。
            //executeUpdate  的返回值是一个整数（int），指示受影响的行数（即更新计数）。 
            //对于 CREATE TABLE 或 DROP TABLE 等不操作行的语句，executeUpdate 的返回值总为零。 
            int result = statement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // JDBC程序中当一个Connection对象创建时，默认情况下是自动提交事务：
    // 每次执行一个SQL语句时，如果执行成功，就会向数据库自动提交，而不能回滚。
    // JDBC程序中为了让多个SQL语句作为一个整体执行，需要使用事务
    // 调用Connection的setAutoCommit(false)可以取消自动提交事务
    //在所有的SQL语句都成功执行后，调用Connection的commit()；方法提交事务
    //在其中某个操作失败或出现异常时，调用Connection的rollback)；方法回滚事务

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
