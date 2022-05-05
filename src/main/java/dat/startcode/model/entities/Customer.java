package dat.startcode.model.entities;

public class Customer {

    String name;
    String address;
    String city;
    int zip;
    int mobile;
    int accountId;

    public Customer(String name, String address, String city, int zip, int mobile, int accountId) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.mobile = mobile;
        this.accountId = accountId;
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
