package dat.startcode.model.entities;

public class Material
{
   private int materialId;
   private String name;
   private int price;
   private String unit;
   private int maxLength;
   private int typeId;
   private String typeName;


    public Material(int materialId, String name, int price, String unit, int maxLength, int typeId, String typeName) {
        this.materialId = materialId;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.maxLength = maxLength;
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Material(int materialId, String name, int price, String unit, int typeId, String typeName) {
        this.materialId = materialId;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public int getMaterialId() {
        return materialId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }
}
