package jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//连接数据库
public class TestDatabaseConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test1";
        String user = "root";
        String password = "123456";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("成功连接到数据库！");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接失败！");
        }
    }
}

