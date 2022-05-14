package dat.startcode.model.persistence;

import dat.startcode.model.entities.Bomline;
import dat.startcode.model.entities.Order;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderMapper implements IOrderMapper{

    ConnectionPool connectionPool;

    public OrderMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public ArrayList<Order> getAllOrders() {

        ArrayList<Order> orderList = new ArrayList<>();

        String sql = "SELECT * FROM order";

        try (Connection connection = connectionPool.getConnection()){
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    int customerId = rs.getInt("customer_id");
                    Timestamp timeStamp = rs.getTimestamp("date");
                    LocalDateTime date = timeStamp.toLocalDateTime();
                    int price = rs.getInt("price");
                    Order newOrder = new Order(orderId, customerId, date, price);
                    orderList.add(newOrder);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return orderList;
    }

    @Override
    public Order getSpecificOrder(int orderId) {

        String sql = "SELECT * FROM order WHERE order_id = ?";
        Order order = null;

        try (Connection connection = connectionPool.getConnection()){
            try ( PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, orderId);

                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    int customerId = rs.getInt("customer_id");
                    Timestamp timeStamp = rs.getTimestamp("date");
                    LocalDateTime date = timeStamp.toLocalDateTime();
                    int price = rs.getInt("price");

                    order = new Order(orderId, customerId, date, price);

                    return  order;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean createOrder(int customerId, LocalDateTime dateTime, int price) {

        String sql = "INSERT INTO order (customer_id, date, price) VALUES (?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, customerId);
                ps.setTimestamp(2, Timestamp.valueOf(dateTime));
                ps.setInt(3, price);
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected == 1) {
                    return true;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
