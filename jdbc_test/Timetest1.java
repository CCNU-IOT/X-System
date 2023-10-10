package jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//向数据库中插入数据
public class Timetest1 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test1";
        String user = "root";
        String password = "123456";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            /*System.out.println("成功连接到数据库！");*/
            String insertQuery = "INSERT INTO time_test1 (`current_time`) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            System.out.println(formattedDateTime);

            preparedStatement.setString(1, formattedDateTime);

            preparedStatement.executeUpdate();

            System.out.println("数据插入成功！");

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据插入失败！");

        }

    }
}

