package Template;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.LogginAccountController;

public class LoggedInAccountUI {
    // attributes
    private static Scanner scanner = new Scanner(System.in);
    private LogginAccountController logginAccountController;
    private int commands;

    // constructor
    public LoggedInAccountUI(LogginAccountController logginAccountController) {
        this.logginAccountController = logginAccountController;
        this.commands = 1;
    }

    // handle commands
    public String handleCommands(int key) {
        this.commands = key;
        if (this.commands == 1) {
            return "Enter username and password";
        } else if (this.commands == 5 &&
                (this.logginAccountController.getCustomer().checkLoggedIn()
                        || this.logginAccountController.getEmployee().checkLoggedIn())) {
            return "LOG OUT ...";
        } else
            return "Unknown command";

    }

    // inputs
    public List<Object> inputLogin() {
        List<Object> list = new ArrayList<>();

        System.out.print("User Name: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        Integer password = scanner.nextInt();
        scanner.nextLine();

        list.add(username);
        list.add(password);
        return list;
    }

    // handle inputs(controller)
    public void handleInputLI(int key) {
        this.commands = key;
        if (this.commands == 1) {
            // login
            List<Object> list = this.inputLogin();
            this.logginAccountController.login(list.get(0).toString(), (int) list.get(1));
        } else if (this.commands == 5 &&
                (this.logginAccountController.getCustomer().checkLoggedIn()
                        || this.logginAccountController.getEmployee().checkLoggedIn())) {
            // logout
            this.logginAccountController.logout();
        } else {
            System.out.println("Unknown command");
        }
    }
}
