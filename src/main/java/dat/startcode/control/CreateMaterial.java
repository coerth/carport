package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.Material;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.MaterialFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class CreateMaterial extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String unit = request.getParameter("unit");
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));

        if(MaterialFacade.createNewMaterial(name, price, unit, length, typeId, width, height, quantity, ApplicationStart.getConnectionPool()))
        {
            ArrayList<Material> materialArrayList = new ArrayList<>();

            materialArrayList = MaterialFacade.getAllMaterials(ApplicationStart.getConnectionPool());
            request.getServletContext().setAttribute("materialArrayList", materialArrayList);
        }


        return "materialoverview";
    }
}
