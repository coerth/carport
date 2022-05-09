package dat.startcode.model.services;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.Customer;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CustomCarportMapper;
import dat.startcode.model.persistence.CustomerMapper;

import java.sql.SQLException;

public class CarportRequestFacade {

    public static CarportRequest createCarportRequest(int width, int length, String roofType, int shedWidth, int shedLength, int customerId, ConnectionPool connectionPool ) throws DatabaseException, SQLException {

        CustomCarportMapper customCarportMapper = new CustomCarportMapper(connectionPool);
        return customCarportMapper.createCarportRequest(width,length,roofType,shedWidth,shedLength, customerId);


    }

}
