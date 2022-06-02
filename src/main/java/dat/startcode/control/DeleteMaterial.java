package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.Material;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.MaterialFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class DeleteMaterial extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        HttpSession session = request.getSession();
        int materialId = Integer.parseInt(request.getParameter("delete"));


        System.out.println(MaterialFacade.deleteMaterial(materialId, ApplicationStart.getConnectionPool()));

        ArrayList<Material> materialArrayList = new ArrayList<>();

        materialArrayList = MaterialFacade.getAllMaterials(ApplicationStart.getConnectionPool());
        request.setAttribute("materialArrayList", materialArrayList);

        System.out.println(materialId);

        return "materialoverview";
    }
}
