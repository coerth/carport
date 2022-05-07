package dat.startcode.model.services;

import dat.startcode.model.entities.Material;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.MaterialMapper;

import java.util.ArrayList;

public class MaterialFacade {

    public static ArrayList<Material> getAllMaterials(ConnectionPool connectionPool){
        MaterialMapper materialMapper = new MaterialMapper(connectionPool);
        return materialMapper.getAllMaterials();
    }

    public static Material getSpecificMaterial(int materialID, ConnectionPool connectionPool){
        MaterialMapper materialMapper = new MaterialMapper(connectionPool);
        return materialMapper.getSpecificMaterial(materialID);
    }

    public static Material updateMaterial(Material material, ConnectionPool connectionPool){
        MaterialMapper materialMapper = new MaterialMapper(connectionPool);
        return materialMapper.updateMaterial(material);
    }

    public static boolean deleteMaterial(int materialId, ConnectionPool connectionPool){
        MaterialMapper materialMapper = new MaterialMapper(connectionPool);
        return materialMapper.deleteMaterial(materialId);
    }
}
