package JBDCLab;

public class Product {

    private int id = 0;
    private String name = "";
    private double price = 0.0;
    private int quantity = 0;

    // default constructor
    public Product() {
        this.id = 0;
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    // parameterized constructor
    public Product(int newId, String newName, double newPrice, int newQuantity) {
        this.id = newId;
        this.name = newName;
        this.price = newPrice;
        this.quantity = newQuantity;
    }

    // get methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // set methods
    public void setId(int newId) {
        this.id = newId;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

}
