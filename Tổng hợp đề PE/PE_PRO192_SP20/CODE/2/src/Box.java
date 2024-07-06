
public class Box {
    String code; 
    double price; 

    public Box() {
    }

    public Box(String code, double price) {
        this.code = code;
        this.price = price;
    }

    public String getCode() {
        return code;
    }
   
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "" + code + " " + price;
    }

    


    
    
    
}
