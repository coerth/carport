package dat.startcode.model.services;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.Customer;
import dat.startcode.model.entities.Material;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CustomCarportMapper;
import dat.startcode.model.persistence.CustomerMapper;
import dat.startcode.model.persistence.MaterialMapper;

import java.sql.SQLException;
import java.util.ArrayList;

public class CarportRequestFacade {

    public static CarportRequest createCarportRequest(int width, int length, String roofType, int roofIncline, int shedWidth, int shedLength, int customerId, ConnectionPool connectionPool ) throws DatabaseException, SQLException {

        CustomCarportMapper customCarportMapper = new CustomCarportMapper(connectionPool);
        return customCarportMapper.createCarportRequest(width,length,roofType,roofIncline, shedWidth,shedLength, customerId);

    }

    public static ArrayList<CarportRequest> getAllCarportRequests(ConnectionPool connectionPool){
        CustomCarportMapper customCarportMapper = new CustomCarportMapper(connectionPool);
        return customCarportMapper.getAllRequests();
    }

    public static CarportRequest getSpecificCarportRequest(int requestId, ConnectionPool connectionPool){
        CustomCarportMapper customCarportMapper = new CustomCarportMapper(connectionPool);

        return customCarportMapper.getSpecificRequest(requestId);
    }



}
