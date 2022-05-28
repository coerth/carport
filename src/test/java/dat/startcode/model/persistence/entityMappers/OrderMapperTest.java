package dat.startcode.model.persistence.entityMappers;

import dat.startcode.model.entities.Order;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.OrderFacade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    private final static String USER = "test";
    private final static String PASSWORD = "nemt";
    private final static String URL = "jdbc:mysql://localhost:3306/carport_test";

    private static ConnectionPool connectionPool;

    @BeforeAll
    public static void setUpClass() {
        connectionPool = new ConnectionPool(USER, PASSWORD, URL);
    }

    @BeforeEach
    void setUp() {
        try(Connection testConnection = connectionPool.getConnection()){
            try(Statement stmt = testConnection.createStatement()){
                // Remove all rows from all tables
                stmt.execute("delete from `order`");
                stmt.execute("ALTER TABLE `order` AUTO_INCREMENT = 0");
                stmt.execute("delete from `carport_request`");
                stmt.execute("ALTER TABLE `carport_request` AUTO_INCREMENT = 0");
                stmt.execute("delete from `customer`");
                stmt.execute("ALTER TABLE `customer` AUTO_INCREMENT = 0");
                stmt.execute("delete from `account`");
                stmt.execute("ALTER TABLE `account` AUTO_INCREMENT = 0");


                // Indsæt et par brugere

                stmt.execute("INSERT INTO `account` (email, password, role) values ('a@a.dk','1234',2)");
                stmt.execute("INSERT INTO `customer` (name, address, city, zip, mobile, account_id) values ('Allan Allanson','Allansvej 1', 'Allanrød', 1111, 12121212, 1)");
                stmt.execute("INSERT INTO `carport_request` (width, length, roof, roof_incline, shed_length, shed_width, customer_id) values (10, 10, 'ja', 2, 5, 5, 1)");
                stmt.execute("INSERT INTO `order` (customer_id, date, carport_type, carport_request_id) VALUES (1, 2022.10.02, 1, 1)");

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
    void getAllOrders() {

        ArrayList<Order> orderList = OrderFacade.getAllOrders(connectionPool);

        assertEquals(1, orderList.size());
    }

    @Test
    void getAllOrdersFromSpecificCustomer() {
    }

    @Test
    void getSpecificOrder() {
    }

    @Test
    void createOrder() {
    }
}