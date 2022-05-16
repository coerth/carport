package dat.startcode.model.persistence;

import dat.startcode.model.entities.Material;

import java.util.ArrayList;

public interface IMaterialMapper
{

    ArrayList<Material> getAllMaterials();
    Material getSpecificMaterial(int materialId);
    boolean createNewMaterial(String name, int price, String unit, int length, int typeId, int width, int height);
    boolean updateMaterial(Material material);
    boolean deleteMaterial(int materialId);




}
