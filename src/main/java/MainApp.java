
import java.sql.*;

public class MainApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://92.53.96.36/cn91564_sendoc";
        String userName = "cn91564_sendoc";
        String password = "sendoc";
        String driverMySql = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driverMySql);
            System.out.println("Драйвер подключен успешно");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            System.out.println("Соединение успешно!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from orders");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("order_number"));
            }
        } catch (SQLException e) {

        }
    }
}
