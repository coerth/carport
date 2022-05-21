package dat.startcode.model.persistence;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.Customer;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomCarportMapper {

    ConnectionPool connectionPool;

    public CustomCarportMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public CarportRequest createCarportRequest(int width, int length, String roofType, int shedWidth, int shedLength, int customerId ) throws DatabaseException, SQLException {

        CarportRequest carportRequest;

        String sql  =  "INSERT INTO carport_request (width, length, roof, shed_length, shed_width, customer_id) values (?,?, ?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1,width);
                ps.setInt(2,length);
                ps.setString(3, roofType);
                ps.setInt(5,shedLength);
                ps.setInt(4,shedWidth);
                ps.setInt(6, customerId);


                int rowsAffected = ps.executeUpdate();

                if (rowsAffected == 1)
                {
                    carportRequest = new CarportRequest(width,length,roofType,shedLength,shedWidth, customerId);
                } else
                {
                    throw new DatabaseException("Fejl ved indsættelse af forespørgsel i databasen");
                }
            }
        }return carportRequest;
    }


    public CarportRequest getSpecificRequest(int carportRequestId) {

        String sql = "SELECT * FROM carport_request WHERE carport_request_id = ?";
        CarportRequest carportRequest = null;

        try( Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, carportRequestId);

                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    String roof = rs.getString("roof");
                    int customerId = rs.getInt("customer_id");

                    carportRequest = new CarportRequest(width, length, roof, customerId);
                    return carportRequest;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carportRequest;
    }

    public ArrayList<CarportRequest> getAllRequest() {

        ArrayList<CarportRequest> carportRequestList = new ArrayList<>();

        String sql = "SELECT * FROM carport_request";

        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    String roof = rs.getString("roof");
                    int roofIncline = rs.getInt("roof_incline");
                    int shedLength = rs.getInt("shed_length");
                    int shedWidth = rs.getInt("shed_width");
                    int customerId = rs.getInt("customer_id");

                    CarportRequest newCarportRequest = new CarportRequest(width, length, roof, roofIncline, shedLength, shedWidth, customerId);
                    carportRequestList.add(newCarportRequest);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carportRequestList;
    }


}




