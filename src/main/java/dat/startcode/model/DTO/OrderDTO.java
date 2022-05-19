package dat.startcode.model.DTO;

import dat.startcode.model.entities.Bomline;
import dat.startcode.model.entities.Order;


import java.util.ArrayList;


public class OrderDTO {
    Order order;
    CarportRequestDTO carportRequestDTO;
    ArrayList<Bomline> bomlineArrayList;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "order=" + order +
                ", carportRequestDTO=" + carportRequestDTO +
                ", bomlineArrayList=" + bomlineArrayList +
                '}';
    }

    public OrderDTO(Order order, CarportRequestDTO carportRequestDTO, ArrayList<Bomline> bomlineArrayList) {
        this.order = order;
        this.carportRequestDTO = carportRequestDTO;
        this.bomlineArrayList = bomlineArrayList;
    }


    public Order getOrder() {
        return order;
    }

    public CarportRequestDTO getCarportRequestDTO() {
        return carportRequestDTO;
    }

    public ArrayList<Bomline> getBomlineArrayList() {
        return bomlineArrayList;
    }
}
