package dat.startcode.model.persistence;

import dat.startcode.model.entities.Bomline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BomlineMapper implements IBomlineMapper{

    ConnectionPool connectionPool;

    public BomlineMapper(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }

    @Override
    public ArrayList<Bomline> getAllBomlines() {

        ArrayList<Bomline> bomlineArrayList = new ArrayList<>();

        String sql = "SELECT * FROM bomline";

        try (Connection connection = connectionPool.getConnection()){
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int bomlineId = rs.getInt("bomline_id");
                    int bomId = rs.getInt("bom_id");
                    int quantity = rs.getInt("quantity");
                    int descriptionId = rs.getInt("description_id");
                    int materialId = rs.getInt("material_id");
                    Bomline newBomline = new Bomline(bomlineId, bomId, quantity, descriptionId, materialId);
                    bomlineArrayList.add(newBomline);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bomlineArrayList;
    }

    @Override
    public Bomline getSpecificBomline(int bomlineId) {

        String sql = "SELECT * FROM bomline WHERE bomline_id = ?";
        Bomline bomline = null;

        try (Connection connection = connectionPool.getConnection()){
            try ( PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, bomlineId);

                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    int bomId = rs.getInt("bom_id");
                    int quantity = rs.getInt("quantity");
                    int descriptionId = rs.getInt("description_id");
                    int materialId = rs.getInt("material_id");

                    bomline = new Bomline(bomlineId, bomId, quantity, descriptionId, materialId);
                    return  bomline;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bomline;
    }

    @Override
    public boolean createBomline(int bomId, int quantity, int descriptionId, int materialId) {

        String sql = "INSERT INTO bomline (bom_id, quantity, description_id, material_id) VALUES (?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, bomId);
                ps.setInt(2, quantity);
                ps.setInt(3, descriptionId);
                ps.setInt(4, materialId);
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected == 1) {
                    return true;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
