package dat.startcode.model.persistence;

import dat.startcode.model.entities.Material;

import java.util.ArrayList;

public class MaterialMapper implements IMaterialMapper{
    @Override
    public ArrayList<Material> getAllMaterials() {

        ArrayList<Material> materialList = new ArrayList<>();

        String sql = "SELECT * FROM carport.material_view";

        try(ConnectionPool connectionPool = conn)
        return null;
    }

    @Override
    public Material getSpecificMaterial(int materialID) {
        return null;
    }

    @Override
    public boolean updatePrice(int materialId) {
        return false;
    }

    @Override
    public boolean updateName(int materialId) {
        return false;
    }

    @Override
    public boolean updateLength(int materialId) {
        return false;
    }

    @Override
    public boolean updateUnit(int materialId) {
        return false;
    }

    @Override
    public boolean deleteMaterial(int material) {
        return false;
    }
}
