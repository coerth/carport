package dat.startcode.model.persistence;

import dat.startcode.model.entities.Carport;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomCarportMapper implements ICustomCarportMapper {

    ConnectionPool connectionPool;


    public ArrayList<Carport> getAll() throws DatabaseException, SQLException {

        ArrayList<Carport> carportArrayList = new ArrayList<>();

        Carport carport = null;

        try {

            Connection connection = connectionPool.getConnection();

            {
                String sql = "select * from custom_carport";
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        int width = rs.getInt("width");
                        int length = rs.getInt("length");
                        String roofType = rs.getString("roof");
                        int shedWidth = rs.getInt("shed_width");


                        carportArrayList.add(new Carport(width, length, roofType, false, 100, 200));
                    }
                }
            }
        } catch(
                SQLException throwables)

        {
            throwables.printStackTrace();
        }
        return carportArrayList;
    }
}




