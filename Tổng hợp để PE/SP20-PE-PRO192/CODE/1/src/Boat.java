
public class Boat {
    String name; 
    double price; 

    public Boat() {
    }

    public Boat(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name.toLowerCase();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
