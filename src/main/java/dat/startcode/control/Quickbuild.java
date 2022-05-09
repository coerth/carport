package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.Carport;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CustomCarportMapper;
import dat.startcode.model.services.AccountFacade;
import dat.startcode.model.services.CustomerFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.rmi.server.LogStream.log;

public class Quickbuild extends Command{

    private ConnectionPool connectionPool;

    public Quickbuild() {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        HttpSession session = request.getSession();

       CustomCarportMapper customCarportMapper = new CustomCarportMapper();
       ArrayList<Integer> carportArrayList;

        try {
            carportArrayList = customCarportMapper.getWidths();
            session.setAttribute("carportArrayList", carportArrayList);
            System.out.println(carportArrayList.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "index";

    }

}

