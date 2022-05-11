package dao;

import com.sun.tools.javac.Main;
import dao.MysqlConnection;
import domain.Student;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO {


    public List<Student> getAll(boolean sort) {
        String sql = "select * from student";
        if (sort) {
            sql = sql + " order by point ";
        }
        List<Student> result = new LinkedList<>();
        try (
                Connection connection = MysqlConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("year_birth"),
                        resultSet.getFloat("point")
                );
                result.add(student);
            }
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Student insert(Student student) {
        String sql = "insert into student(id, name, year_birth, point) value (?,?,?,?)";
        try (
                Connection conn = MysqlConnection.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
        ) {
            pre.setString(1, student.getId());
            pre.setNString(2, student.getName());
            pre.setInt(3, student.getYearBirth());
            pre.setFloat(4, student.getPoint());
            int result = pre.executeUpdate();
            if (result < 1) {
                throw new RuntimeException("khong insert duoc");
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> seach(String name) {
        String sql = "select * from student where name like ?";
        List<Student> result = new LinkedList<>();
        try (
                Connection connection = MysqlConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("year_birth"),
                        resultSet.getFloat("point")
                );
                result.add(student);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void edit(Student student) {
        String sql = "update student set name=?,year_birth=?,point=? Where id = ?";
        try (
                Connection connection = MysqlConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getYearBirth());
            statement.setFloat(3, student.getPoint());
            statement.setString(4, student.getId());
            int result = statement.executeUpdate();
            if (result == 0) {
                throw new RuntimeException("Not found student");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        String sql = "delete from student Where id = ?";
        try (
                Connection connection = MysqlConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, id);
            int result = statement.executeUpdate();
            if (result == 0) {
                throw new RuntimeException("Not found student");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
