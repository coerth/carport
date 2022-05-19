package dat.startcode.control;

import dat.startcode.model.DTO.CarportRequestDTO;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;
import dat.startcode.model.services.CarportRequestFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestApprove extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        int requestId = Integer.parseInt(request.getParameter("requestId"));

        String requestApproved = "Forespørgsel med id-nummer " + requestId + " er accepteret";
        request.setAttribute("requestApproved", requestApproved);

        return "orderView";
    }
}
