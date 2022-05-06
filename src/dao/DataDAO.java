package dao;

import domain.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DataDAO {

    public UserAccount getAccount(String username) {
        String sql = "select * from account where username = ?";
        try (
                Connection con = MysqlConnection.getConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setString(1, username.trim());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserAccount account = new UserAccount(username, null, resultSet.getString("password"), null);
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public UserAccount createAccount(UserAccount account) {
        String sql = "insert into account(username, password) value (?, ?)";
        try (
                Connection con = MysqlConnection.getConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());
            int result = statement.executeUpdate();
            if (result == 0) {
                throw new RuntimeException("Not inserted");
            }
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
