package dat.startcode.model.persistence;

import dat.startcode.model.entities.Material;

import java.util.ArrayList;
import java.util.HashMap;

public interface IMaterialMapper
{


    public ArrayList<Material> getAllMaterials();
    public Material getSpecificMaterial(int materialId);
    public boolean createNewMaterial(String name, int price, String unit, int length, int typeId, int width, int height, int quantity);
    public boolean updateMaterial(Material material);
    public boolean deleteMaterial(int materialId);
    public HashMap<String, ArrayList<Material>> getMaterialHashmaps();





}
