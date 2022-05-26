/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.Bomline;
import dat.startcode.model.entities.CarportCalculator;
import dat.startcode.model.entities.Material;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.MaterialFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet( name = "FrontController", urlPatterns = { "/fc/*" } )
public class  FrontController extends HttpServlet {


    public void init()
    {

        /*ArrayList<Material> materialArrayList;
        materialArrayList = MaterialFacade.getAllMaterials(ApplicationStart.getConnectionPool());
        System.out.println(materialArrayList);

        CarportCalculator carportCalculator = new CarportCalculator(materialArrayList);

        ArrayList<Bomline> bomlineArrayList = carportCalculator.createCarportWithFullShed(780, 600, 210, 600);

        System.out.println(bomlineArrayList);

        getServletContext().setAttribute("materialArrayList", materialArrayList);*/
    }

    protected void processRequest( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        try
        {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            Locale.setDefault(new Locale("US"));

            Command action = Command.from( request );
            String view = action.execute( request, response );
            if (view.equals("index"))
            {
                response.sendRedirect(request.getServletContext().getContextPath() + "/index.jsp");
            } else
            {
                request.getRequestDispatcher("/WEB-INF/" + view + ".jsp").forward(request, response);
            }
        } catch ( UnsupportedEncodingException | DatabaseException e )
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher(request.getServletContext().getContextPath() + "/error.jsp").forward(request, response);        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        processRequest( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        processRequest( request, response );
    }

    @Override
    public String getServletInfo() {
        return "FrontController Servlet";
    }

}
