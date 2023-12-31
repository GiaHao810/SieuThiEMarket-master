package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Account;
import Model.Custumer;
import Model.Employee;

public class CreateAccountController {
    // attribute
    private Custumer customer;
    private Employee employee;

    private CustumerController custumerController = new CustumerController(customer);

    // getter setter
    public Custumer getCustomer() {
        return customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    // constructor
    public CreateAccountController() {
        this.employee = new Employee();
        this.customer = new Custumer();
    }

    // methods

    public void creatAccount(String username, Integer password, String tel, String role, String address) {
        List<Object> listCheck = this.accountValid(username, tel); // check valid
        if (!(boolean) listCheck.get(0)) {
            System.out.println(listCheck.get(1)); // print message
        } else {
            custumerController.createNewCustumer(username, address);
            Account.getAccount().update(username, password, tel, role, address);
            Account.getAccount().write();
            System.out.println(listCheck.get(1));
        }
    }

    public List<Object> accountValid(String username, String tel) {
        List<Object> listValidate = new ArrayList<>();
        int index = 0;
        index = Account.getAccount().search("un", username);
        // if index != -1, account is already exists
        if (index != -1) {
            listValidate.add(false);
            listValidate.add("[USERNAME EXISTS]!");
        }
        index = Account.getAccount().search("tel", tel);
        if (index != -1) {
            listValidate.add(false);
            listValidate.add("[TELEPHONE EXISTS]!");
        }

        if (index == -1) {
            listValidate.add(true);
            listValidate.add("[ACCOUNT_CREATED]!");
        }

        return listValidate;
    }

}
