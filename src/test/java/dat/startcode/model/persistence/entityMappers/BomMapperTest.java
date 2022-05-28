package dat.startcode.model.persistence.entityMappers;

import dat.startcode.model.persistence.ConnectionPool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class BomMapperTest {

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
                stmt.execute("delete from `bomline`");
                stmt.execute("delete from `bill_of_materials`");

                // Indsæt et par brugere

                stmt.execute("INSERT INTO `bill_of_materials` (`bom_id`,`order_id`) VALUES (1,1) ");
                stmt.execute("INSERT INTO `bomline` (`bomline_id`,`bom_id`,`quantity`,`description_id`,`material_id`) VALUES ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAllBomlines() {
    }

    @Test
    void getAllBomlinesWithSpecificBOMId() {
    }

    @Test
    void getSpecificBomline() {
    }

    @Test
    void getBomIdFromOrderId() {
    }

    @Test
    void createBomline() {
    }

    @Test
    void createBom() {
    }

    @Test
    void createCompleteBillOfMaterials() {
    }
}