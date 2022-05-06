package dat.startcode.model.services;

import dat.startcode.model.entities.Customer;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CustomerMapper;

public class CustomerFacade
{

    public static Customer createCustomer(String name, String address, String city, int zip, int mobile, String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        CustomerMapper customerMapper = new CustomerMapper(connectionPool);
        return customerMapper.createCustomer(name, address, city, zip, mobile, email, password);
    }

    public static int getCustomerId(int mobile, ConnectionPool connectionPool) throws DatabaseException{
        CustomerMapper customerMapper = new CustomerMapper(connectionPool);
        return customerMapper.getCustomerId(mobile);
    }
}
