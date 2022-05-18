package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.CarportRequestDTOFacade;
import dat.startcode.model.services.CarportRequestFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RequestDeny extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));

        CarportRequestFacade.deleteRequest(requestId, ApplicationStart.getConnectionPool());

        if (CarportRequestFacade.deleteRequest(requestId, ApplicationStart.getConnectionPool()))
        {
          String requestDeleted = "Din forespørgsel med id nummer " + requestId + " blev slettet";
          request.setAttribute("requestDeleted", requestDeleted);
        }


        ArrayList<CarportRequest> carportRequestArraylist = CarportRequestFacade.getAllCarportRequests(ApplicationStart.getConnectionPool());

        request.setAttribute("carportRequestArraylist", carportRequestArraylist);
        return "requestoverview";
    }
}
