package dat.startcode.model.entities;

public class Description {

    int descriptionId;
    String description;

    public Description(int descriptionId, String description) {
        this.descriptionId = descriptionId;
        this.description = description;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
