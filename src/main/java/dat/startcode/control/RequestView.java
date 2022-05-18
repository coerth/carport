package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.Customer;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.CarportRequestFacade;
import dat.startcode.model.services.CustomerFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RequestView extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));

        CarportRequest carportRequest = CarportRequestFacade.getSpecificCarportRequest(requestId, ApplicationStart.getConnectionPool());
        Customer customer = CustomerFacade.getSpecificCustomer(carportRequest.getCustomerId(), ApplicationStart.getConnectionPool());

        request.setAttribute("carportRequest", carportRequest);
        request.setAttribute("customer", customer);

        return "requestview";
    }

}
