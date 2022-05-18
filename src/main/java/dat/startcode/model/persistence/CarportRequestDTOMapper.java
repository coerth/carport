package dat.startcode.model.persistence;

import dat.startcode.model.DTO.CarportRequestDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarportRequestDTOMapper implements ICarportRequestDTOMapper{

    ConnectionPool connectionPool;

    public CarportRequestDTOMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public CarportRequestDTO getSpecificCarportRequestDTO(int carportRequestId) {
        String sql = "SELECT * FROM carport.carport_request_with_customer_info";

        CarportRequestDTO carportRequestDTO = null;

        try(Connection connection = connectionPool.getConnection()) {
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, carportRequestId);

                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    int customerId = rs.getInt("customer_id");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    String roof = rs.getString("roof");
                    int roofIncline = rs.getInt("roof_incline");
                    boolean isApproved = rs.getBoolean("is_approved");
                    int shedLength = rs.getInt("shed_length");
                    int shedWidth = rs.getInt("shed_width");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String city = rs.getString("city");
                    int zip = rs.getInt("zip");
                    int mobile = rs.getInt("mobile");
                    int accountId = rs.getInt("account_id");

                    carportRequestDTO = new CarportRequestDTO(customerId,carportRequestId,width,length,roof,roofIncline,isApproved,shedLength,shedWidth,name,address,city,zip,mobile,accountId);
                    return carportRequestDTO;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carportRequestDTO;
    }
}
