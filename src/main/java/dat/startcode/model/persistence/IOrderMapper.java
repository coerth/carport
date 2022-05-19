package dat.startcode.model.persistence;

import dat.startcode.model.entities.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IOrderMapper {

    ArrayList<Order> getAllOrders();
    Order getSpecificOrder(int orderId);
    int createOrder(int customerId, String dateTime, int carportType, int carportRequestId);

}
