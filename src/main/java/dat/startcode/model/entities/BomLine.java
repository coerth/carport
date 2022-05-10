package dat.startcode.model.entities;

public class BomLine
{
    Material material;
    int amount;

    public BomLine(Material material, int amount) {
        this.material = material;
        this.amount = amount;
    }

    public Material getMaterial() {
        return material;
    }

    public int getAmount() {
        return amount;
    }
}
