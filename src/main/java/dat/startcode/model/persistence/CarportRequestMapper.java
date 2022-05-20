package dat.startcode.model.persistence;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarportRequestMapper implements ICarportRequestMapper {

    ConnectionPool connectionPool;

    public CarportRequestMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public CarportRequest createCarportRequest(int width, int length, String roofType, int roofIncline, int shedWidth, int shedLength, int customerId) throws DatabaseException, SQLException {

        CarportRequest carportRequest;

        String sql = "INSERT INTO carport_request (width, length, roof, roof_incline, shed_length, shed_width, customer_id) values (?,?, ?, ?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, width);
                ps.setInt(2, length);
                ps.setString(3, roofType);
                ps.setInt(4, roofIncline);
                ps.setInt(5, shedLength);
                ps.setInt(6, shedWidth);
                ps.setInt(7, customerId);


                int rowsAffected = ps.executeUpdate();

                if (rowsAffected == 1) {
                    carportRequest = new CarportRequest(width, length, roofType, shedLength, shedWidth, customerId);
                } else {
                    throw new DatabaseException("Fejl ved indsættelse af forespørgsel i databasen");
                }
            }
        }
        return carportRequest;
    }

    @Override
    public CarportRequest getSpecificRequest(int carportRequestId) {

        String sql = "SELECT * FROM carport_request WHERE carport_request_id = ?";
        CarportRequest carportRequest = null;

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, carportRequestId);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    String roof = rs.getString("roof");
                    int roofIncline = rs.getInt("roof_incline");
                    boolean isApproved = rs.getBoolean("is_approved");
                    int shedLength = rs.getInt("shed_length");
                    int shedWidth = rs.getInt("shed_width");
                    int customerId = rs.getInt("customer_id");

                    carportRequest = new CarportRequest(carportRequestId, width, length, roof, roofIncline, isApproved, shedLength, shedWidth, customerId);
                    return carportRequest;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carportRequest;
    }

    @Override
    public ArrayList<CarportRequest> getAllRequests() {
        ArrayList<CarportRequest> requestArrayList = new ArrayList<>();
        String sql = "SELECT * FROM carport_request";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int carportRequestId = rs.getInt("carport_request_id");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    String roof = rs.getString("roof");
                    int roofIncline = rs.getInt("roof_incline");
                    boolean isApproved = rs.getBoolean("is_approved");
                    int shedLength = rs.getInt("shed_length");
                    int shedWidth = rs.getInt("shed_width");
                    int customerId = rs.getInt("customer_id");

                    CarportRequest newCarportRequest = new CarportRequest(carportRequestId, width, length, roof, roofIncline, isApproved, shedLength, shedWidth, customerId);
                    requestArrayList.add(newCarportRequest);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }            return requestArrayList;

    }

    @Override
    public ArrayList<CarportRequest> getAllOpenRequests() {
        ArrayList<CarportRequest> requestArrayList = new ArrayList<>();
        String sql = "SELECT * FROM carport_request WHERE is_approved = 0";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int carportRequestId = rs.getInt("carport_request_id");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    String roof = rs.getString("roof");
                    int roofIncline = rs.getInt("roof_incline");
                    boolean isApproved = rs.getBoolean("is_approved");
                    int shedLength = rs.getInt("shed_length");
                    int shedWidth = rs.getInt("shed_width");
                    int customerId = rs.getInt("customer_id");

                    CarportRequest newCarportRequest = new CarportRequest(carportRequestId, width, length, roof, roofIncline, isApproved, shedLength, shedWidth, customerId);
                    requestArrayList.add(newCarportRequest);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }            return requestArrayList;

    }

    @Override
    public boolean deleteCarportRequest(int carportRequestId) {
        String sql = "DELETE FROM `carport_request` WHERE `carport_request_id` = ?";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, carportRequestId);

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




