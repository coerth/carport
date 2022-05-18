package dat.startcode.model.DTO;

import java.time.LocalDateTime;

public class OrderDTO {
    int descriptionId;
    int materialId;
    int bomId;
    int orderId;
    int customerId;
    LocalDateTime date;
    int carportType;
    int orderPrice;
    int carportRequestID;
    int bomlineId;
    int bomlineQuantity;
    String name;
    int materialPrice;
    String unit;
    int length;
    int typeId;
    int width;
    int height;
    int materialQuantity;
    String description;

    public OrderDTO(int descriptionId, int materialId, int bomId, int orderId, int customerId, LocalDateTime date, int carportType, int orderPrice, int carportRequestID, int bomlineId, int bomlineQuantity, String name, int materialPrice, String unit, int length, int typeId, int width, int height, int materialQuantity, String description) {
        this.descriptionId = descriptionId;
        this.materialId = materialId;
        this.bomId = bomId;
        this.orderId = orderId;
        this.customerId = customerId;
        this.date = date;
        this.carportType = carportType;
        this.orderPrice = orderPrice;
        this.carportRequestID = carportRequestID;
        this.bomlineId = bomlineId;
        this.bomlineQuantity = bomlineQuantity;
        this.name = name;
        this.materialPrice = materialPrice;
        this.unit = unit;
        this.length = length;
        this.typeId = typeId;
        this.width = width;
        this.height = height;
        this.materialQuantity = materialQuantity;
        this.description = description;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public int getBomId() {
        return bomId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getCarportType() {
        return carportType;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getCarportRequestID() {
        return carportRequestID;
    }

    public int getBomlineId() {
        return bomlineId;
    }

    public int getBomlineQuantity() {
        return bomlineQuantity;
    }

    public String getName() {
        return name;
    }

    public int getMaterialPrice() {
        return materialPrice;
    }

    public String getUnit() {
        return unit;
    }

    public int getLength() {
        return length;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMaterialQuantity() {
        return materialQuantity;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "descriptionId=" + descriptionId +
                ", materialId=" + materialId +
                ", bomId=" + bomId +
                ", orderId=" + orderId +
                ", customerId=" + customerId +
                ", date=" + date +
                ", carportType=" + carportType +
                ", orderPrice=" + orderPrice +
                ", carportRequestID=" + carportRequestID +
                ", bomlineId=" + bomlineId +
                ", bomlineQuantity=" + bomlineQuantity +
                ", name='" + name + '\'' +
                ", materialPrice=" + materialPrice +
                ", unit='" + unit + '\'' +
                ", length=" + length +
                ", typeId=" + typeId +
                ", width=" + width +
                ", height=" + height +
                ", materialQuantity=" + materialQuantity +
                ", description='" + description + '\'' +
                '}';
    }
}
