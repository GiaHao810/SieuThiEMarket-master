package Model;

public class Custumer extends Account {

    private static StoredFiles custumers = new StoredFiles("custumer.json");
    // attributes
    private String address;
    private String type;
    private String pHistory;

    // getter setter
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // constructor
    public Custumer() {
        super();
        this.address = null;
    }

    public Custumer(String userName, Integer password, String tel, String role, String address) {
        super(userName, password, tel, role);
        this.address = address;
        this.type = "Custumer";
        this.pHistory = null;
    }
    // methods

    @Override
    public void logout() {
        super.logout();
        this.address = null;
    }

    public void setAccountCustomer(String username, Integer password, String tel, String role, String address) {
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.role = role;
        this.address = address;
        this.loggedIn = true;
    }

    public static StoredFiles getCustumers() {
        return custumers;
    }
}
