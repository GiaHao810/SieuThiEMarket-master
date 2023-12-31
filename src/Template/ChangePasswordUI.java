package Template;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.ChangePasswordController;
import Controller.LogginAccountController;

public class ChangePasswordUI {
    // attributes
    public static Scanner scanner = new Scanner(System.in);
    private ChangePasswordController changePasswordController;
    private int command;

    // construction
    public ChangePasswordUI(LogginAccountController logginAccountController) {
        this.changePasswordController = new ChangePasswordController();
        this.command = 6;
    }

    // methods
    public String handleCommands(int rep) {
        if (rep == 6) {
            return "Enter current password and new password";
        }
        return "Unknown command.";
    }

    public List<Integer> inputPassword() {
        List<Integer> list = new ArrayList<>();
        System.out.print("Current password: ");
        int currentPass = scanner.nextInt();

        System.out.print("New password: ");
        int newPass = scanner.nextInt();

        list.add(currentPass);
        list.add(newPass);

        return list;
    }

    public void handleCPInputs(LogginAccountController logginAccountController, int key) {
        List<Integer> list = this.inputPassword();
        this.command = key;

        if (this.command == 6 && logginAccountController.getCustomer().checkLoggedIn()) {
            this.changePasswordController.changePassword(logginAccountController,
                    list.get(0), list.get(1));
        } else {
            System.out.println("[ERROR]: You have to login first!");
        }
    }
}
