package Model;

public class Employee extends Account {
    // attribute

    // constructor
    public Employee() {

    }

    public Employee(String username, Integer password, String tel, String role) {
        super(username, password, tel, role);
    }

    // methods
    public void setAccountEmployee(String username, int password, String tel, String role) {
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.role = role;
        this.loggedIn = true;
    }
}
