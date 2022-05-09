package dat.startcode.model.entities;

public class CarportRequest {
    @Override
    public String toString() {
        return "CarportRequest{" +
                "width=" + width +
                ", length=" + length +
                ", roofType='" + roofType + '\'' +
                ", shedOrNoShed=" + shedOrNoShed +
                ", shedWidth=" + shedWidth +
                ", shedLength=" + shedLength +
                ", roofIncline=" + roofIncline +
                '}';
    }

    int width;
    int length;
    String roofType;
    boolean shedOrNoShed;
    int shedWidth;
    int shedLength;
    int roofIncline;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public boolean isShedOrNoShed() {
        return shedOrNoShed;
    }

    public void setShedOrNoShed(boolean shedOrNoShed) {
        this.shedOrNoShed = shedOrNoShed;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    public void setShedWidth(int shedWidth) {
        this.shedWidth = shedWidth;
    }

    public int getShedLength() {
        return shedLength;
    }

    public void setShedLength(int shedLength) {
        this.shedLength = shedLength;
    }

    public int getRoofIncline() {
        return roofIncline;
    }

    public void setRoofIncline(int roofIncline) {
        this.roofIncline = roofIncline;
    }

    public CarportRequest(int width, int length, String roofType, boolean shedOrNoShed, int shedWidth, int shedLength, int roofIncline) {
        this.width = width;
        this.length = length;
        this.roofType = roofType;
        this.shedOrNoShed = shedOrNoShed;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
        this.roofIncline = roofIncline;
    }

    public CarportRequest(int width, int length, String roofType, int shedWidth, int shedLength) {
        this.width = width;
        this.length = length;
        this.roofType = roofType;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
    }
}
