package dat.startcode.model.persistence;

import dat.startcode.model.entities.Material;

import java.util.ArrayList;

public interface IMaterialMapper
{

    public ArrayList<Material> getAllMaterials();
    public Material getSpecificMaterial(int materialID);
    public boolean updatePrice(Material material);
    public boolean updateName(int materialId);
    public boolean updateLength(Material material);
    public boolean updateUnit(int materialId);
    public boolean deleteMaterial(int material);




}
