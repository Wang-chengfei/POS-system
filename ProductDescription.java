package POS;

public class ProductDescription {
    String ID;
    String name;
    float price;

    public ProductDescription(String ID, String name, float price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

}
