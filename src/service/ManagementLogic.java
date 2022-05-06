package service;

import dao.DataDAO;
import dao.StudentDAO;
import domain.Class;
import dao.ClassDAO;
import domain.Student;
import domain.UserAccount;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ManagementLogic {

    private Scanner sc;

    public ManagementLogic() {
        sc =  new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("============ choose option ============");
        System.out.println("1) show all class");
        System.out.println("2) show info class");
        System.out.println("3) add class");
        System.out.println("4) add student");
        System.out.println("5) update student");
        System.out.println("6) delete student");
        System.out.println("7) register account");
    }

    public void showAllClass() {
        ClassDAO classDAO = new ClassDAO();
        List<Class> classes = classDAO.getAll();
        for (Class clazz : classes) {
            System.out.println(clazz);
        }
    }

    public void addClass() {
        System.out.println("input class name:");
        String name = sc.nextLine();
        System.out.println("input teacher name:");
        String teacher = sc.nextLine();
        Class clazz = new Class(null, name, teacher);
        ClassDAO classDAO = new ClassDAO();
        classDAO.insert(clazz);
    }
    public void addStudent() {
        System.out.println("input student name :");
        String name = sc.nextLine();
        System.out.println("input age student");
        int age = sc.nextInt();
        System.out.println("input gender student");
        int gender = sc.nextInt();
        System.out.println("input id class");
        String classId = sc.nextLine();
        Student student = new Student(null,name,age,gender);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.insert(student);
    }
    public void showAllStudent() {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getAll();
        for (Student student: students) {
            System.out.println(student);
        }
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
        if (!account.getPassword().equals(password))
            throw new RuntimeException("Password invalid");

    }

}
