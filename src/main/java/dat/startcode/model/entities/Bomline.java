package dat.startcode.model.entities;

public class Bomline {

    int descriptionId;
    Material material;
    int quantity;
    int bomId;
    int bomlineId;
    int materialId;

    public Bomline(int bomId, int quantity, int descriptionId, int materialId) {
        this.descriptionId = descriptionId;
        this.materialId = materialId;
        this.quantity = quantity;
        this.bomId = bomId;
    }

    public Bomline(int descriptionId, Material material, int quantity, int bomId) {
        this.descriptionId = descriptionId;
        this.material = material;
        this.quantity = quantity;
        this.bomId = bomId;
    }

    public Bomline(int descriptionId, Material material, int quantity) {
        this.descriptionId = descriptionId;
        this.material = material;
        this.quantity = quantity;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
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

    public int getBomlineId() {
        return bomlineId;
    }

    public void setBomlineId(int bomlineId) {
        this.bomlineId = bomlineId;
    }

    public int getMaterialId() {
        return materialId;
    }
}
