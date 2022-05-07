package dat.startcode.model.persistence;

import dat.startcode.model.entities.Material;

import java.util.ArrayList;

public interface IMaterialMapper
{

    public ArrayList<Material> getAllMaterials();
    public Material getSpecificMaterial(int materialId);
    public Material updateMaterial(Material material);
    public boolean deleteMaterial(int materialId);




}
