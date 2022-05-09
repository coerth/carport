package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.Material;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.MaterialFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class RequestModify extends Command
{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        HttpSession session = request.getSession();
        int materialId = Integer.parseInt(request.getParameter("modify"));

        ArrayList<Material> materialArrayList = (ArrayList<Material>) session.getServletContext().getAttribute("materialArrayList");

        Material material = null;

        for (Material m : materialArrayList)
        {
            if(m.getMaterialId() == materialId)
            {
                material = m;
            }
        }

        request.setAttribute("material", material);

        return "modify";
    }
}
