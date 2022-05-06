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
        Material material = null;


        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, materialID);

                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String name = rs.getString("material_name");
                    int price = rs.getInt("price");
                    String unit = rs.getString("unit");
                    int maxLength = rs.getInt("max_length");
                    String mtName = rs.getString("mt_name");
                    int typeID = rs.getInt("type_id");

                    material = new Material(materialID, name, price, unit, maxLength, typeID, mtName);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return material;
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
