package dat.startcode.model.entities;

public class Bomline {
    String description;
    Material material;
    int quantity;
    int bomId;

    public Bomline(String description, Material material, int quantity, int bomId) {
        this.description = description;
        this.material = material;
        this.quantity = quantity;
        this.bomId = bomId;
    }

    public Bomline(String description, Material material, int quantity) {
        this.description = description;
        this.material = material;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBomId() {
        return bomId;
    }

    public void setBomId(int bomId) {
        this.bomId = bomId;
    }
}
