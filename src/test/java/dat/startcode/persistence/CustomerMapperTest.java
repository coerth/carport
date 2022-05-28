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
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CuatomerMapperTest
{
    private final static String USER = "test";
    private final static String PASSWORD = "nemt";
    private final static String URL = "jdbc:mysql://localhost:3306/carport_test";

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
                stmt.execute("delete from account");
                stmt.execute("ALTER TABLE account AUTO_INCREMENT = 0");
                stmt.execute("delete from customer");
                stmt.execute("ALTER TABLE customer AUTO_INCREMENT = 0");



                // Indsæt et par brugere
                stmt.execute("insert into account (email, password, role) " +
                        "values ('user@fog.dk','1234',2),('admin@fog.dk','1234',1), ('ben@ben.dk','1234',2)");
                stmt.execute("INSERT INTO `carport_test`.`customer` (`name`,`address`,`city`,`zip`,`mobile`,`account_id`)VALUES('Test Testington', 'Adresse', 'By', 1234, 12345678, 3), ()");
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




}