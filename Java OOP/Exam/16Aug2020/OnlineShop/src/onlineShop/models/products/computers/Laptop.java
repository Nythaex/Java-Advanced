package onlineShop.models.products.computers;

public class Laptop extends BaseComputer{
    public Laptop(int id, String manufacturer, String model, double price,String type) {
        super(id, manufacturer, model, price, 10,type);
    }
}
