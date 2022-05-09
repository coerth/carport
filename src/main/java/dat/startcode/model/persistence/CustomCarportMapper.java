package dat.startcode.model.persistence;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.Customer;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomCarportMapper implements ICustomCarportMapper {

    ConnectionPool connectionPool;

    public CustomCarportMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public CarportRequest createCarportRequest(int width, int length, String roofType, int shedWidth, int shedLength ) throws DatabaseException, SQLException {

        CarportRequest carportRequest = null;

        String sql  =  "INSERT INTO carport_request (width, length, roof, shed_length, shed_width) values (?,?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1,width);
                ps.setInt(2,length);
                ps.setString(3, roofType);
                ps.setInt(5,shedLength);
                ps.setInt(4,shedWidth);


                int rowsAffected = ps.executeUpdate();

                if (rowsAffected == 1)
                {
                    carportRequest = new CarportRequest(width,length,roofType,shedLength,shedWidth);
                } else
                {
                    throw new DatabaseException("Fejl ved indsættelse af forespørgsel i databasen");
                }
            }
        }return carportRequest;
    }



    public ArrayList<Integer> getWidths() throws SQLException {

        ArrayList<Integer> widthArrayList = new ArrayList<>();


        try {

            Connection connection = connectionPool.getConnection();

            {
                String sql = "SELECT width FROM carport.carport_request;";
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {

                        int width = rs.getInt("width");
                        int length = rs.getInt("length");
                        String roofType = rs.getString("roof");
                        int shedWidth = rs.getInt("shed_width");
                        int shedLength = rs.getInt("shed_length");

                        CarportRequest newCarportRequest = new CarportRequest(width,9,"high",99,99);

                        widthArrayList.add(width);
                    }
                }
            }
        } catch(
                SQLException e)

        {
            e.printStackTrace();
        }
        return widthArrayList;
    }
}




