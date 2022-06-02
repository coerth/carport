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

        String message = "";

        int materialId = Integer.parseInt(request.getParameter("materialId"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String unit = request.getParameter("unit");
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String typeName = request.getParameter("typeName");
        int typeId = 0;

        boolean error = false;

        switch (typeName){
            case "Træ":
                typeId = 1;
                break;
            case "Tagplader":
                typeId = 2;
                break;
            case "Beslag, Hulbånd & Diverse":
                typeId = 3;
                break;
            case "Skruer, Skiver & Bolte":
                typeId = 4;
                break;
            case "Vælg type":
                message = "Ændring mislykkedes";
                break;
        }



         if(MaterialFacade.updateMaterial(new Material(materialId, name, price, unit, length, width, height, quantity, typeId), ApplicationStart.getConnectionPool()))
         {
             message = "Succesfyld ændring";
         }



        ArrayList<Material> materialArrayList = new ArrayList<>();

        materialArrayList = MaterialFacade.getAllMaterials(ApplicationStart.getConnectionPool());
        request.setAttribute("materialArrayList", materialArrayList);

        request.setAttribute("message", message);

        return "materialoverview";
    }
}
