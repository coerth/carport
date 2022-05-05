package dat.startcode.control;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command{

 private ConnectionPool connectionPool;

    public Register() {
        this.connectionPool = connectionPool;
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String address = request.getParameter("adr");
        String city = request.getParameter("city");
        int zip = Integer.parseInt(request.getParameter("zip"));
        int mobile = Integer.parseInt(request.getParameter("mobile"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        /*UserFacade.createAccount();*/

        return "index.jsp";

    }




}
