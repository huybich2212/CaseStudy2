package dao;

import dao.MysqlConnection;
import domain.Class;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClassDAO {

    public List<Class> getAll() {
        String sql = "select * from class";
        List<Class> result = new LinkedList<>();
        try (
                Connection connection = MysqlConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Class clazz = new Class(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("teacher_name")
                );
                result.add(clazz);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Class insert(Class clazz) {
        String sql = "insert into class (`name`, teacher_name) value (?, ?)";
        try (
                Connection conn = MysqlConnection.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
        ) {
            pre.setString(1, clazz.getName());
            pre.setString(2, clazz.getTeacherName());
            int result = pre.executeUpdate();
            if (result < 1) {
                throw new RuntimeException("Khong insert duoc");
            }
            return clazz;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
