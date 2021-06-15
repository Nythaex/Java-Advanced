package onlineShop.models.products.peripherals;

import onlineShop.models.products.BaseProduct;

public abstract class BasePeripheral extends BaseProduct implements Peripheral{
    private  String connectionType;

    public BasePeripheral(int id, String manufacturer, String model, double price, double overallPerformance,String connectionType,String type) {
        super(id, manufacturer, model, price, overallPerformance,type);
        this.connectionType = connectionType;
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public String getConnectionType() {
        return connectionType;
    }

    @Override
    public String toString() {
        return String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d) Connection Type: %s",getOverallPerformance(),getPrice(),this.getType(),getManufacturer(),getModel(),getId(),getConnectionType());
    }
}
