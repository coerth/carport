package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartUp extends Command
{

    private ConnectionPool connectionPool;

    public StartUp()
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException
    {

        /*HttpSession session = request.getSession();
        ArrayList<Material> materialArrayList;

        materialArrayList = MaterialFacade.getAllMaterials(connectionPool);

        System.out.println(materialArrayList);

        session.getServletContext().setAttribute("materialArrayList", materialArrayList);*/

        return "index";
    }
}
