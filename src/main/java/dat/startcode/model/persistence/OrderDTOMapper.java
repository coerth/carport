package dat.startcode.model.persistence;

import dat.startcode.model.DTO.OrderDTO;
import dat.startcode.model.entities.Order;

import java.sql.*;
import java.time.LocalDateTime;

public class OrderDTOMapper implements IOrderDTOMapper {

    ConnectionPool connectionPool;

    public OrderDTOMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }



   /* @Override
    public OrderDTO getOrderWithFulloverview(int orderId) {
        String sql = "SELECT * FROM carport.order_to_description_view WHERE order_id = ?";

        OrderDTO orderDTO = null;

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int descriptionId = rs.getInt("description_id");
                    int materialId = rs.getInt("material_id");
                    int bomId = rs.getInt("bom_id");
                    int customerId = rs.getInt("customer_id");
                    Timestamp timestamp = rs.getTimestamp("date");
                    LocalDateTime date = timestamp.toLocalDateTime();
                    int carportType = rs.getInt("carport_type");
                    int orderPrice = rs.getInt("order_price");
                    int carportRequestId = rs.getInt("carport_request_id");
                    int bomlineId = rs.getInt("bomline_id");
                    int bomlineQuantity = rs.getInt("bomline_quantity");
                    String name = rs.getString("name");
                    int materialPrice = rs.getInt("material_price");
                    String unit = rs.getString("unit");
                    int length = rs.getInt("length");
                    int typeId = rs.getInt("type_id");
                    int width = rs.getInt("width");
                    int height = rs.getInt("height");
                    int materialQuantity = rs.getInt("material_quantity");
                    String description = rs.getString("description");

                    orderDTO = new OrderDTO(descriptionId, materialId, bomId, orderId, customerId, date, carportType, orderPrice, carportRequestId, bomlineId, bomlineQuantity, name, materialPrice, unit, length, typeId, width, height, materialQuantity, description);
                    return orderDTO;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDTO;
    }*/
}
