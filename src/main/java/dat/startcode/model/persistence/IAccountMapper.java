package dat.startcode.model.persistence;

import dat.startcode.model.entities.Account;
import dat.startcode.model.exceptions.DatabaseException;

public interface IAccountMapper {

    public Account createAccount(String email, String password, int role) throws DatabaseException;
    public int getAccountId(String email, String password) throws DatabaseException;
}
