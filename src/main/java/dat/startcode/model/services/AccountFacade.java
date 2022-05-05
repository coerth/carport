package dat.startcode.model.services;

import dat.startcode.model.entities.Account;
import dat.startcode.model.entities.Customer;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.AccountMapper;
import dat.startcode.model.persistence.ConnectionPool;


public class AccountFacade {

    public static Account login(String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        AccountMapper accountMapper = new AccountMapper(connectionPool);
        return accountMapper.login(email, password);
    }

    public static Account createAccount(String email, String password, int role, ConnectionPool connectionPool) throws DatabaseException
    {
        AccountMapper accountMapper = new AccountMapper(connectionPool);
        return accountMapper.createAccount(email, password, role);
    }

    public static int getAccountId(String email, String password, ConnectionPool connectionPool) throws DatabaseException{
        AccountMapper accountMapper = new AccountMapper(connectionPool);
        return accountMapper.getAccountId(email, password);
    }
}
