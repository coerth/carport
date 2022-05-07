package dat.startcode.model.entities;

public class Customer extends Account {

    private int customerId;
    private String name;
    private String address;
    private String city;
    private int zip;
    private int mobile;
    private int accountId;

    public Customer(String email, String password, int role, int customerId, String name, String address, String city, int zip, int mobile, int accountId) {
        super(email, password, role);
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.mobile = mobile;
        this.accountId = accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
