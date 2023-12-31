package Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import Model.Account;
import Model.Custumer;
import Model.Employee;

public class LogginAccountController {
    // attributes
    private Custumer customer;
    private Employee employee;

    private String accountRole;

    // getter
    public Custumer getCustomer() {
        return customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getAccountRole() {
        return accountRole;
    }

    // constructor
    public LogginAccountController() {
        this.customer = new Custumer();
        this.employee = new Employee();
    }

    // methods
    public void login(String username, Integer password) {
        // get all accounts from database
        JsonArray listAccount = Account.getAccount().getAll();
        int index = -1;

        index = Account.getAccount().search("un", username);
        // founded
        if (index != -1) {
            JsonObject jsonObjectAccount = listAccount.get(index).getAsJsonObject(); // get account at index
            int pass = jsonObjectAccount.get("ps").getAsInt(); // get value of key ps

            String role = jsonObjectAccount.get("role").getAsString();
            // login as customer
            if (role.equals("KH")) {
                this.accountRole = role;
                if (pass == password) {
                   String tel = jsonObjectAccount.get("tel").getAsString();
                    String address = jsonObjectAccount.get("address").getAsString();

                    this.customer.setAccountCustomer(username, password, tel, role, address);
                    System.out.println("[LOGGED  IN] You are logged in.\n");
                } else {
                    System.out.println("[WRONG PASSWORD] The password you enterd is incorrect!!!");
                }
            }
            // login as employee
            else {
                this.accountRole = role;
                if (pass == password) {
                    String tel = jsonObjectAccount.get("tel").getAsString();

                    this.employee.setAccountEmployee(username, password, tel, role);
                    System.out.println("[LOGGED IN] You are logged in.\n");
                } else {
                    System.out.println("[WRONG PASSWORD] The password you enterd is incorrect!!!");
                }
            }
        } else {
            System.out.println("[ERROR] The username you enterd is incorrect!!!");
        }
    }

    public void logout() {
        if (this.getAccountRole().equalsIgnoreCase("KH")) {
            this.customer.logout();
        } else {
            this.employee.logout();
        }
    }

}
