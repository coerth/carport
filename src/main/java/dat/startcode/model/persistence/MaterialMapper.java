package dat.startcode.model.persistence;

import dat.startcode.model.entities.Material;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;



public class MaterialMapper implements IMaterialMapper {
    ConnectionPool connectionPool;

    public MaterialMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override

    public ArrayList<Material> getAllMaterials() {

        ArrayList<Material> materialList = new ArrayList<>();

        String sql = "SELECT * FROM carport.material_view";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int materialId = rs.getInt("material_id");
                    int typeId = rs.getInt("type_id");
                    String materialName = rs.getString("material_name");
                    int price = rs.getInt("price");
                    String unit = rs.getString("unit");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int height = rs.getInt("height");
                    String typeName = rs.getString("mt_name");
                    Material newMaterial = new Material(materialId, materialName, price, unit, length, width, height, typeId, typeName);
                    materialList.add(newMaterial);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materialList;
    }


    @Override
    public Material getSpecificMaterial(int materialID)
    {
        String sql = "Select * FROM `material_view` WHERE material_id = ?";
        Material material = null;


        try (Connection connection = connectionPool.getConnection())
        {

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, materialID);

                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String name = rs.getString("material_name");
                    int price = rs.getInt("price");
                    String unit = rs.getString("unit");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    int height = rs.getInt("height");
                    String mtName = rs.getString("mt_name");
                    int typeID = rs.getInt("type_id");

                    material = new Material(materialID, name, price, unit, length, width, height, typeID, mtName);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return material;
    }

//    @Override
//    public Material createNewMaterial(Material material) {
//
//        boolean result = false;
//        int newId = 0;
//
//        String sql = "INSERT INTO `material` (`material_id`, `name`, `price`, `unit`, `length`, `type_id`, `width`, `height`) VALUES (?,?,?,?,?,?,?,?)";
//
//        try (Connection connection = connectionPool.getConnection()) {
//            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//            }
//        }
//
//        return null;
//    }

    @Override
    public Material updateMaterial(Material material)
    {
        Material newMaterial = null;

        String sql = "UPDATE `material` SET `material_id` = ?, `name` = ?, `price` = ?, `unit` = ?, `length` = ?, `type_id` = ?, `width` = ?, `height` = ? WHERE `material_id` = ?";


        try (Connection connection = connectionPool.getConnection())
        {

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, material.getMaterialId());
                ps.setString(2, material.getName());
                ps.setInt(3, material.getPrice());
                ps.setString(4, material.getUnit());
                ps.setInt(5, material.getLength());
                ps.setInt(6, material.getTypeId());
                ps.setInt(7, material.getWidth());
                ps.setInt(8, material.getHeight());

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected == 1)
                {
                    newMaterial = new Material(material.getMaterialId(), material.getName(), material.getPrice(), material.getUnit(), material.getLength(), material.getLength(), material.getWidth(), material.getHeight());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newMaterial;
    }

    @Override
    public boolean deleteMaterial(int materialId)
    {

        String sql = "DELETE FROM `material` WHERE `material_id` = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, materialId);

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected == 1)
                {
                    return true;
                }
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
