package dat.startcode.model.entities;

import java.time.LocalDateTime;

public class Order {

    int customer_id;
    LocalDateTime dateTime;
    int price;

    public Order(int customer_id, LocalDateTime dateTime, int price) {
        this.customer_id = customer_id;
        this.dateTime = dateTime;
        this.price = price;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
