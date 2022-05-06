package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bichdb";
        Connection connection = DriverManager.getConnection(url, "root", "bich2001");
        return connection;
    }

}
