package dat.startcode.control;

import com.mysql.cj.protocol.AuthenticationPlugin;
import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.Material;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.MaterialFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class MaterialModify extends Command
{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException
    {


        int materialId = Integer.parseInt(request.getParameter("materialId"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String unit = request.getParameter("unit");
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));

         if(MaterialFacade.updateMaterial(new Material(materialId, name, price, unit, length, width, height, quantity, typeId), ApplicationStart.getConnectionPool()))
         {
            ArrayList<Material> materialArrayList = new ArrayList<>();

            materialArrayList = MaterialFacade.getAllMaterials(ApplicationStart.getConnectionPool());
            request.setAttribute("materialArrayList", materialArrayList);
         }


        return "materialoverview";
    }
}
