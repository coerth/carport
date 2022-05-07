package dat.startcode.model.persistence;

import dat.startcode.model.entities.Carport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomCarportMapper implements ICustomCarportMapper {

    ConnectionPool connectionPool;


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

                        Carport newCarport = new Carport(width,9,"high",true,99,99);

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




