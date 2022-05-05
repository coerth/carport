package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.AccountFacade;
import dat.startcode.model.services.CustomerFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command{

 private ConnectionPool connectionPool;

    public Register() {
        this.connectionPool = ApplicationStart.getConnectionPool();
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

        CustomerFacade.createCustomer(name,address,city,zip,mobile,email,password,connectionPool);

        return "index";

    }

}
