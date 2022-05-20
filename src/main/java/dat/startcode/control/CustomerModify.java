package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.Customer;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.CustomerFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerModify extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DatabaseException {

        HttpSession session = request.getSession();

        Customer customer = (Customer) session.getAttribute("customer");

        int accountId = customer.getAccountId();
        String email = customer.getEmail();
        String password = customer.getPassword();
        int role = customer.getRole();
        int customerId = customer.getCustomerId();
        String name = customer.getName();
        String address = customer.getAddress();
        String city = customer.getCity();
        int zip = customer.getZip();
        int mobile = customer.getMobile();

        CustomerFacade.updateCustomerProfile(new Customer(email, password, role, customerId, name, address, city, zip, mobile, accountId), ApplicationStart.getConnectionPool());

        return "customerprofile";
    }

}
