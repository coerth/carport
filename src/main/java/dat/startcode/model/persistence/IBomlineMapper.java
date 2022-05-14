package dat.startcode.model.persistence;

import dat.startcode.model.entities.Bomline;
import dat.startcode.model.entities.Material;

import java.util.ArrayList;

public interface IBomlineMapper {

    ArrayList<Bomline> getAllBomlines();
    Bomline getSpecificBomline(int bomlineId);
    boolean createBomline(int bomId, int quantity, int descriptionId, int materialId);

}
