package dat.startcode.model.services;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CustomerMapper;

public class UserFacade
{
    public static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        CustomerMapper userMapper = new CustomerMapper(connectionPool);
        return userMapper.login(username, password);
    }

    public static User createUser(String username, String password, String role, ConnectionPool connectionPool) throws DatabaseException
    {
        CustomerMapper userMapper = new CustomerMapper(connectionPool);
        return userMapper.createUser(username, password, role);
    }
}
