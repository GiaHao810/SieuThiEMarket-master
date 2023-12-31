package Template;

import java.util.Scanner;

import com.google.gson.JsonArray;

import Controller.CreateAccountController;
import Controller.LogginAccountController;

public class BootStrap {

    static JsonArray list = new JsonArray();
    
    public static void main(String[] args) {
        chooseOptions();
    }

    public static void chooseOptions() {
        Scanner scanner = new Scanner(System.in);

        CreateAccountController createAccountController = new CreateAccountController();
        CreateAccountUI createAccountUI = new CreateAccountUI(createAccountController);

        LogginAccountController logginAccountController = new LogginAccountController();
        LoggedInAccountUI loggedInAccountUI = new LoggedInAccountUI(logginAccountController);

        System.out.println("Welcome to the eMarket System!!");

        int key = -1;
        do {
            System.out.println(getPrompt(logginAccountController)); // show loggin account name
            displayOptions(logginAccountController, scanner, key); // show menu options

            menuCustomer menuCustomer = new menuCustomer();
            menuEmployee menuEmployee = new menuEmployee();
    
            // check login
            if (!logginAccountController.getCustomer().checkLoggedIn()
                    && !logginAccountController.getEmployee().checkLoggedIn()) {
                System.out.println("=========================MENU============================");
                System.out.println(">>0. Kết thúc                                            ");
                System.out.println(">>1. Đăng nhập                                           ");
                System.out.println(">>2. Đăng kí                                             ");
                System.out.println(">>3. Tra cứu hàng hóa                                    ");
                System.out.println("=========================================================");
                System.out.print("Chọn chức năng: ");
                key = scanner.nextInt();
            } else if (logginAccountController.getCustomer().checkLoggedIn()
                    && logginAccountController.getAccountRole().equals("KH")) {
                menuCustomer.renderUI(logginAccountController, scanner);
                key = -1;
            } else {
                menuEmployee.renderUI(logginAccountController, scanner);
                key = -1;
            }
            // scanner.nextLine();

            String requireMsg; // user guide

            switch (key) {
                case 1: {// login or logout
                    requireMsg = loggedInAccountUI.handleCommands(key);
                    System.out.println(requireMsg);
                    loggedInAccountUI.handleInputLI(key);
                    break;
                }
                case 2: {// create account
                    requireMsg = createAccountUI.handleCommands(key);
                    System.out.println(requireMsg);
                    createAccountUI.handleCAInputs();
                    break;
                }
                case 3: {
                    
                }
            }

        } while (key != 0);
    }

    public static void displayOptions(LogginAccountController logginAccountController, Scanner scanner,int key) {
        

    }

    public static String getPrompt(LogginAccountController logginAccountController) {
        if (logginAccountController.getAccountRole() == null) {
            return "";
        }
        if (logginAccountController.getAccountRole().equals("KH")) {
            if (!logginAccountController.getCustomer().checkLoggedIn()) {
                return "";
            }
            return "WELCOME #" + logginAccountController.getCustomer().getUserName();

        } else {
            if (!logginAccountController.getEmployee().checkLoggedIn()) {
                return "";
            }
            return "WELCOME #" + logginAccountController.getEmployee().getUserName();
        }
    }

}
