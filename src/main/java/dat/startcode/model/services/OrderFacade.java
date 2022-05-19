package dat.startcode.model.services;

import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;

import java.time.LocalDateTime;

public class OrderFacade {

    public static int createOrder (int customerId, LocalDateTime date, int carportType, int carportRequestId, ConnectionPool connectionPool) {
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        return orderMapper.createOrder(customerId,date, carportType, carportRequestId);
    }

}
