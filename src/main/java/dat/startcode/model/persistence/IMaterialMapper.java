package dat.startcode.model.persistence;

import dat.startcode.model.entities.Material;

import java.util.ArrayList;

public interface IMaterialMapper
{

    public ArrayList<Material> getAllMaterials();
    public Material getSpecificMaterial(int materialId);
    public Material updateMaterial(int materialId, String name, int price, String unit, int length, int type_id, int width, int height);
    public boolean deleteMaterial(int materialId);




}
