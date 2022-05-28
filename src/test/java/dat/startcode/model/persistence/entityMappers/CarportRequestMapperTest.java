package dat.startcode.model.persistence.entityMappers;

import dat.startcode.model.persistence.ConnectionPool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class CarportRequestMapperTest {

    private final static String USER = "carport_test";
    private final static String PASSWORD = "nemt";
    private final static String URL = "jdbc:mysql://localhost:3306/carport_test";
    private static ConnectionPool connectionPool;

    @BeforeAll
    public static void setUpClass() {
        connectionPool = new ConnectionPool(USER, PASSWORD, URL);
    }

    @BeforeEach
    void setUp() {
        try (Connection testConnection = connectionPool.getConnection()) {
            try (Statement statement = testConnection.createStatement()) {
                //Remove all rows from table
                statement.execute("delete from `carport_request`");

                //Inserting data into table
                statement.execute("INSERT INTO `carport_request` (1,600,780,'Plasttrapez',null,false,280,600,2);");
            }

        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            fail("Database connection failed");
        }
    }

    @Test
    void testConnection() throws SQLException {
        Connection connection = connectionPool.getConnection();
        assertNotNull(connection);
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    void createCarportRequest() {

    }

    @Test
    void getSpecificRequest() {

    }

    @Test
    void approveSpecificRequest() {
    }

    @Test
    void getAllRequests() {
    }

    @Test
    void getAllRequestFromCustomer() {
    }

    @Test
    void getAllOpenRequests() {
    }

    @Test
    void deleteCarportRequest() {
    }
}