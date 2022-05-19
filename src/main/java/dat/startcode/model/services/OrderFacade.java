package dat.startcode.model.services;

import dat.startcode.model.entities.Order;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderFacade {

    public static int createOrder (int customerId, String date, int carportType, int carportRequestId, ConnectionPool connectionPool) {
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        return orderMapper.createOrder(customerId,date, carportType, carportRequestId);
    }

    public static ArrayList<Order> getAllOrders(ConnectionPool connectionPool) {
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        return orderMapper.getAllOrders();
    }

    public static Order getSpecificOrder (int orderId, ConnectionPool connectionPool) {
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        return orderMapper.getSpecificOrder(orderId);
    }

}
