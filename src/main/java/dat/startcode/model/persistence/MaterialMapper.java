package dat.startcode.model.persistence;

import dat.startcode.model.entities.Material;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;



public class MaterialMapper implements IMaterialMapper
{
    ConnectionPool connectionPool;

    public MaterialMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public ArrayList<Material> getAllMaterials()
    {
        return null;
    }

    @Override
    public Material getSpecificMaterial(int materialID)
    {
        String sql = "Select * FROM `material_view` WHERE material_id = ?";


        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, customerID);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("order_id");
                    Timestamp time = rs.getTimestamp("date");
                    LocalDateTime localDateTime = time.toLocalDateTime();
                    String customerName = rs.getString("name");
                    ArrayList<Orderline> orderlineArrayList = getAllOrderlines(orderID);
                    Order newOrder = new Order(orderID, customerName, localDateTime, orderlineArrayList);
                    orderArrayList.add(newOrder);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderArrayList;
        return null;
    }

    @Override
    public boolean updatePrice(int materialId) {
        return false;
    }

    @Override
    public boolean updateName(int materialId) {
        return false;
    }

    @Override
    public boolean updateLength(int materialId) {
        return false;
    }

    @Override
    public boolean updateUnit(int materialId) {
        return false;
    }

    @Override
    public boolean deleteMaterial(int material) {
        return false;
    }
}
