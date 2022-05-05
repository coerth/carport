package dat.startcode.model.persistence;

import dat.startcode.model.entities.Customer;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerMapper implements ICustomerMapper
{
    ConnectionPool connectionPool;

    public CustomerMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }

    @Override
    public Customer createCustomer(String name, String address, String city, int zip, int mobile, int accountId) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        Customer customer;
        String sql = "insert into customer (name, address, city, zip, mobile, account_id) values (?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, name);
                ps.setString(2, address);
                ps.setString(3, city);
                ps.setInt(4, zip);
                ps.setInt(5, mobile);
                ps.setInt(6, accountId);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    customer = new Customer(name, address, city, zip, mobile, accountId);
                } else
                {
                    throw new DatabaseException("The customer with name = " + name + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return customer;
    }

    @Override
    public int getCustomerId(int mobile) throws DatabaseException{

        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "SELECT * FROM customer WHERE mobile = ?";
        int customerId = 0;

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, mobile);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    customerId = rs.getInt("customer_id");
                }
                if(customerId==0){
                    throw new DatabaseException("Kunne ikke finde customer_id");
                }
            }
        } catch (SQLException ex){
            throw new DatabaseException(ex, "Kunne ikke finde customer:id");
        }

        return customerId;
    }


}
