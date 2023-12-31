package Template;

import java.util.Scanner;

import Controller.CreateAccountController;
import Model.Account;
import Model.Custumer;
import Model.Employee;

public class CreateAccountUI {
    // attributes
    public static Scanner scanner = new Scanner(System.in);
    private CreateAccountController createAccountController; // communicate with controller
    private int action;

    // constructor
    public CreateAccountUI(CreateAccountController createAccountController) {
        this.createAccountController = createAccountController;
        this.action = 2;
    }

    // xủ lý lệnh của user
    public String handleCommands(int rep) {
        if (rep == 2) {
            return "Enter a username, a password, a telephone number and an address";
        } else {
            return "Unkown command.";
        }
    }

    // user input
    private static Account creatAccountInputs() {
        System.out.print("Username: ");
        String userName = scanner.nextLine();

        System.out.print("Password: ");
        Integer password = scanner.nextInt();

        Integer confirmPassword;
        do {
            System.out.print("Confirm password: ");
            confirmPassword = scanner.nextInt();
            if (confirmPassword.equals(password)) {
                break;
            } else {
                System.out.println("Passwords don't match!");
            }
        } while (!confirmPassword.equals(password));
        scanner.nextLine();

        System.out.print("Telephone: ");
        String tel = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        return new Custumer(userName, password, tel, "KH", address);
    }

    // xử lý input của user
    public void handleCAInputs() {
        if (this.action == 2) {
            Account account = creatAccountInputs();
            // đưa cho controller xử lí và tạo account
            if (account.getRole().equalsIgnoreCase("KH")) {
                Custumer customer = (Custumer) account;
                this.createAccountController.creatAccount(customer.getUserName(),
                        customer.getPassword(), customer.getTel(),
                        customer.getRole(), customer.getAddress());
            } else {
                Employee employee = (Employee) account;
                this.createAccountController.creatAccount(employee.getUserName(),
                        employee.getPassword(), employee.getTel(),
                        employee.getRole(), "n/a");
            }
        }
    }
}
