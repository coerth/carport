package dat.startcode.model.persistence;

import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.Material;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICustomCarportMapper {
    ArrayList<CarportRequest> getAll = new ArrayList<>();
    CarportRequest createCarportRequest(int width, int length, String roofType, int shedWidth, int shedLength, int customerId ) throws DatabaseException, SQLException;
    CarportRequest getSpecificRequest(int carportRequestId);


}
