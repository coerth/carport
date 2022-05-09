package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CustomCarportMapper;
import dat.startcode.model.services.CarportRequestFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class Quickbuild extends Command{

    private ConnectionPool connectionPool;

    public Quickbuild() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        HttpSession session = request.getSession();
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        String roofType = request.getParameter("roof");
        int shedLength;
        int shedWidth;

        if(request.getParameter("shedLength").equals("") ) {
            shedLength = 0;
        } else {

            shedLength = Integer.parseInt(request.getParameter("shedLength"));
        }
        if(request.getParameter("shedWidth").equals("")) {
            shedWidth = 0;
        } else {

            shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        }

        try {
            CarportRequestFacade.createCarportRequest(width,length,roofType,shedLength,shedWidth,connectionPool);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "requestsent";

    }

}

