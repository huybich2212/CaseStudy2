import service.ManagementLogic;

import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws SQLException {
        ManagementLogic logic = new ManagementLogic();
        Scanner sc = new Scanner(System.in);
        boolean login = false;
        while (login == false) {
            try {
                logic.login();
                login = true;
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        boolean run = true;
        while (run) {
            logic.showMenu();
            System.out.println("your option: ");
            Integer option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1: {
                    logic.showAllClass();
                    break;
                }

                case 3: {
                    logic.addClass();
                    break;
                }
                case 4: {
                    logic.addStudent();
                    break;
                }
                case 5:{
                    logic.showAllStudent();
                }
                case 7: {
                    logic.registerNewAccount();
                    break;
                }
                case -1: {
                    run = false;
                    break;
                }
            }
        }
    }
}
