package Module_4.BowlingShopApp;

public class Product {
    
    private String code = "";
    private String description = "";
    private double price = 0.0;

    public Product() {}

    // Accessor methods
    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    // Mutator methods
    public void setCode(String code){
        this.code = code;
    }
    
    public void setDescription(String description){
        this.description = description;
    }

    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Code: %s\nDescription: %s\nPrice: $%,6.2f", code, description, price);
    }

}
