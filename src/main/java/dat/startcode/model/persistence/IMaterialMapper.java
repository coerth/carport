package dat.startcode.model.persistence;

import dat.startcode.model.entities.Material;

import java.util.ArrayList;

public interface IMaterialMapper
{

    public ArrayList<Material> getAllMaterials();
    public Material getSpecificMaterial(int materialId);
    public Material createNewMaterial(String name, int price, String unit, int length, int typeId, int width, int height);
    public boolean updateMaterial(Material material);
    public boolean deleteMaterial(int materialId);




}
