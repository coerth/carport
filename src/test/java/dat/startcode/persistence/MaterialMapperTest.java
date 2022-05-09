package dat.startcode.persistence;

import dat.startcode.model.entities.Material;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.MaterialFacade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class MaterialMapperTest
{
    private final static String USER = "SQLUser";
    //private final static String PASSWORD = System.getenv("dbpassword");
    private final static String PASSWORD = "Bananflue";

    private final static String URL = "jdbc:mysql://localhost:3306/carport_test";

    private static ConnectionPool connectionPool;

    @BeforeAll
    public static void setUpClass() {
        connectionPool = new ConnectionPool(USER, PASSWORD, URL);
    }

    @BeforeEach
    void setUp()
    {
        try (Connection testConnection = connectionPool.getConnection())
        {
            try (Statement stmt = testConnection.createStatement() )
            {
                // Remove all rows from all tables
                stmt.execute("delete from `material`");
                stmt.execute("delete from `material_type`");
                // Indsæt et par brugere

                stmt.execute("INSERT INTO `material_type` (`name`) VALUES ('Træ & Tagplader'), ('Beslag & Skruer')");
                stmt.execute("INSERT INTO `material` (`name`,`price`,`unit`,`length`,`width`,`height`,`type_id`)" +
                        "VALUES ('25x200 mm. trykimp. Brædt', 50, 'Stk', 720,25, 200, 1),('45x95 mm. Reglar ub.', 25, 'Stk', 720,45, 95, 1)");
                stmt.execute("INSERT INTO `material` (`name`,`price`,`unit`,`type_id`)" +
                        "VALUES('plastmo bundskruer 200 stk.', 10, 'Pakke', 2),('universal 190 mm højre', 5, 'Stk', 2)");

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
    void getAllMaterialsTest() throws SQLException
    {
        ArrayList<Material> materialArrayList = MaterialFacade.getAllMaterials(connectionPool);

        assertEquals(4, materialArrayList.size());
        assertEquals(25, materialArrayList.get(1).getPrice());
        assertEquals("universal 190 mm højre", materialArrayList.get(3).getName());
    }

    @Test
    void getSpecificMaterialTest() throws SQLException
    {
        Material material = MaterialFacade.getSpecificMaterial(2, connectionPool);

        assertEquals(25, material.getPrice());

       material = MaterialFacade.getSpecificMaterial(4, connectionPool);
       assertEquals(2, material.getTypeId());


    }

}
