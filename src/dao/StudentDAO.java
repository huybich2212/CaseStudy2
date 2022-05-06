package dao;

import dao.MysqlConnection;
import domain.Student;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAll() {
        String sql = "select * from student";
        List<Student> result = new LinkedList<>();
        try (
                Connection connection = MysqlConnection.getConnection();
        Statement statement = connection.createStatement();
        ){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getLong("class id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("gender")
                );
                result.add(student);
            }
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Student insert(Student student)  {
        String sql = "insert into student(`id class`, name ,age,gender) value (?,?,?,?)";
        try (
                Connection conn = MysqlConnection.getConnection();
                PreparedStatement pre = conn.prepareStatement(sql);
        ){
            pre.setString(1,student.getName());
            pre.setString(2,student.getClassId());
            pre.setInt(3,student.getAge());
            pre.setInt(4,student.isGender());
            int result = pre.executeUpdate();
            if (result < 1) {
                throw new RuntimeException("khong insert duoc");
            }
            return student;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 }
