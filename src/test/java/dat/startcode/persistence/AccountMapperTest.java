package dat.startcode.persistence;

import dat.startcode.model.entities.Account;

import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.AccountFacade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class AccountMapperTest
{
    private final static String USER = "root";
    private final static String PASSWORD = System.getenv("dbpassword");
    private final static String URL = "jdbc:mysql://localhost:3306/startcode_test?serverTimezone=CET&allowPublicKeyRetrieval=true&useSSL=false";

    private static ConnectionPool connectionPool;

    @BeforeAll
    public static void setUpClass() {
            connectionPool = new ConnectionPool(USER, PASSWORD, URL);
    }

    @BeforeEach
    void setUp()
    {
        try (Connection testConnection = connectionPool.getConnection()) {
            try (Statement stmt = testConnection.createStatement() ) {
                // Remove all rows from all tables
                stmt.execute("delete from user");
                // Indsæt et par brugere
                stmt.execute("insert into user (username, password, role) " +
                        "values ('user','1234','user'),('admin','1234','admin'), ('ben','1234','user')");
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            fail("Database connection failed");
        }
    }

    @Test
    void testConnection() throws SQLException
    {
        Connection connection = connectionPool.getConnection();
        assertNotNull(connection);
        if (connection != null)
        {
            connection.close();
        }
    }

    @Test
    void login() throws DatabaseException
    {
        Account expectedAccount = new Account("a@a.dk","1234",2);
        Account actualAccount = AccountFacade.login("a@a.dk","1234", connectionPool);
        assertEquals(expectedAccount, actualAccount);
    }

    @Test
    void invalidPasswordLogin() throws DatabaseException
    {
        assertThrows(DatabaseException.class, () -> AccountFacade.login("a@a.dk","123", connectionPool));
    }

    @Test
    void invalidAccountNameLogin() throws DatabaseException
    {
        assertThrows(DatabaseException.class, () -> AccountFacade.login("bob","1234", connectionPool));
    }

    @Test
    void createAccount() throws DatabaseException
    {
        int newAccount = AccountFacade.createAccount("jill", "1234", 2, connectionPool);
        Account logInAccount = AccountFacade.login("jill","1234", connectionPool);
        Account expectedAccount = new Account("jill", "1234", 2);
        assertEquals(expectedAccount, newAccount);
        assertEquals(expectedAccount, logInAccount);

    }
}