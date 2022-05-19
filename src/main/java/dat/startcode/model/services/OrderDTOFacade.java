package dat.startcode.model.services;

import dat.startcode.model.DTO.OrderDTO;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderDTOMapper;

public class OrderDTOFacade {

    public static OrderDTO getOrderWithAllInfo(int orderId, ConnectionPool connectionPool) {
        OrderDTOMapper orderDTOMapper = new OrderDTOMapper(connectionPool);

        return orderDTOMapper.getOrderWithFulloverview(orderId);
    }
}
