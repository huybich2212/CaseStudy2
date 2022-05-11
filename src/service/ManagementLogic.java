package service;

import com.sun.tools.javac.Main;
import dao.DataDAO;
import dao.StudentDAO;
import domain.Student;
import domain.UserAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ManagementLogic {

    private static Object level;
    private Scanner sc;

    private StudentDAO studentDAO;

    public List<Student> studentList;

    public ManagementLogic() {
        sc = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("============ choose option ============");
        System.out.println("[1.] add student");
        System.out.println("[2.] update student");
        System.out.println("[3.] delete student");
        System.out.println("[4.] get all student");
        System.out.println("[5.] seach Student");
        System.out.println("[7.] register account");
    }

    public void addStudent() {
        System.out.println("input student id");
        String id = sc.nextLine();
        System.out.println("input student name :");
        String name = sc.nextLine();
        System.out.println("input age student");
        int birthday = Integer.parseInt(sc.nextLine());
        System.out.println("input student point");
        float point = Float.parseFloat(sc.nextLine());
        System.out.println("input id class");
        Student student = new Student(id, name, birthday, point);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.insert(student);
    }

    public void seach() {
        System.out.println("input student name");
        String name = sc.nextLine();
        List<Student> students = new StudentDAO().seach(name);
        System.out.println(students);
    }

    public void showAllStudent() {
        StudentDAO studentDAO = new StudentDAO();
        System.out.println("do you want sort by point ?");
        String answer = sc.nextLine();
        boolean sort = false;
        if ("YES".equalsIgnoreCase(answer)) {
            sort = true;
        }
        List<Student> students = studentDAO.getAll(sort);
        for (Student student : students) {
            System.out.println(student);

        }
    }

    public void edit() {
        System.out.println("input student id");
        String id = sc.nextLine();
        System.out.println("input student name :");
        String name = sc.nextLine();
        System.out.println("input age student");
        int birthday = Integer.parseInt(sc.nextLine());
        System.out.println("input student point");
        float point = Float.parseFloat(sc.nextLine());
        System.out.println("input id class");
        Student student = new Student(id, name, birthday, point);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.edit(student);

    }

    public void delete() {
        System.out.println("input student id");
        String id = sc.nextLine();
        new StudentDAO().delete(id);
    }


    public UserAccount registerNewAccount() {
        System.out.println("input username: ");
        String username = sc.nextLine();
        System.out.println("input password: ");
        String password = sc.nextLine();

        UserAccount userAccount = new UserAccount(username, null, password, null);
        DataDAO dataDAO = new DataDAO();
        return dataDAO.createAccount(userAccount);
    }

    public void login() {
        System.out.println("input username: ");
        String username = sc.nextLine();
        System.out.println("input password: ");
        String password = sc.nextLine();

        DataDAO dataDAO = new DataDAO();
        System.out.print(username);
        UserAccount account = dataDAO.getAccount(username);
        if (account == null) {
            throw new RuntimeException("Account not found");
        }
        if (!account.getPassword().equals(password)) throw new RuntimeException("Password invalid");

    }

}
