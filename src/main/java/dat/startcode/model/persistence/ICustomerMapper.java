package dat.startcode.model.persistence;

import dat.startcode.model.entities.Customer;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

public interface ICustomerMapper
{
    public User login(String email, String kodeord) throws DatabaseException;
    public Customer createCustomer(String name, String address, String city, int zip, int mobile, int accountId) throws DatabaseException;
    public int getCustomerId(int mobile) throws DatabaseException;
}
