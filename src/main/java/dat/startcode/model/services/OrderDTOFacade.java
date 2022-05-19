package dat.startcode.model.services;

import dat.startcode.model.DTO.BomDTO;
import dat.startcode.model.DTO.CarportRequestDTO;
import dat.startcode.model.DTO.OrderDTO;
import dat.startcode.model.entities.Bomline;
import dat.startcode.model.entities.CarportRequest;
import dat.startcode.model.entities.Material;
import dat.startcode.model.entities.Order;
import dat.startcode.model.persistence.*;

import java.util.ArrayList;

public class OrderDTOFacade {

    public static OrderDTO getOrderWithAllInfo(int orderId, ConnectionPool connectionPool) {
        OrderMapper orderMapper = new OrderMapper(connectionPool);

        CarportRequestDTOMapper carportRequestDTOMapper = new CarportRequestDTOMapper(connectionPool);
        BomMapper bomMapper = new BomMapper(connectionPool);
        BomDTOMapper bomDTOMapper = new BomDTOMapper(connectionPool);

        Order order = orderMapper.getSpecificOrder(orderId);
        CarportRequestDTO carportRequestDTO = carportRequestDTOMapper.getSpecificCarportRequestDTO(order.getCarportRequestId());

        int bomId = bomMapper.getBomIdFromOrderId(orderId);
        ArrayList<BomDTO> bomDTOArrayList = bomDTOMapper.getBomlineWithInfo(bomId);

        OrderDTO orderDTO = new OrderDTO(order,carportRequestDTO,bomDTOArrayList);



        return orderDTO;

    }
}
