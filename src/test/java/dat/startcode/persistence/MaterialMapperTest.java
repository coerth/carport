package dat.startcode.persistence;

import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class MaterialMapperTest
{
    private final static String USER = "root";
    private final static String PASSWORD = System.getenv("dbpassword");
    private final static String URL = "jdbc:mysql://localhost:3306/carport_test?serverTimezone=CET&allowPublicKeyRetrieval=true&useSSL=false";

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
                stmt.execute("delete from material");
                // Indsæt et par brugere
                stmt.execute("INSERT INTO `material` (`name`,`price`,`unit`,`max_length`,`type_id`)" +
                        "VALUES ('25x200 mm. trykimp. Brædt', 50, 'Stk', 720, 1),('45x95 mm. Reglar ub.', 25, 'Stk', 720, 1)");
                stmt.execute("INSERT INTO `material` (`name`,`price`,`unit`,`type_id`)" +
                        "VALUES('plastmo bundskruer 200 stk.', 10, 'Pakke', 2),('universal 190 mm højre', 5, 'Stk', 2);");

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
