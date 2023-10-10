package jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timetest2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test1";
        String user = "root";
        String password = "123456";

        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            String insertQuery = "INSERT INTO time_test1 (`current_time`) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            while (true){
                LocalDateTime currentDatetime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattdDatetime = currentDatetime.format(formatter);

                preparedStatement.setString(1,formattdDatetime);

                preparedStatement.executeUpdate();

                System.out.println(formattdDatetime);

                Thread.sleep(2000);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}