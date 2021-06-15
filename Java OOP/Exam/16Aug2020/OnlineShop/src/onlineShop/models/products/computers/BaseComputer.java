package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance,String type) {
        super(id, manufacturer, model, price, overallPerformance,type);
        components = new ArrayList<>();
        peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public double getPrice() {
        return super.getPrice()+components.stream().mapToDouble(Product::getPrice).sum()+peripherals.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public double getOverallPerformance() {
        if (components.isEmpty()){
            return super.getOverallPerformance();
        }
        return super.getOverallPerformance()+(components.stream().mapToDouble(Product::getOverallPerformance).sum()/components.size());
    }

    @Override
    public void addComponent(Component component) {
        String type=component.getType();
        if (components.stream().filter(s->s.getType().equals(type)).findFirst().orElse(null)!=null){
            throw  new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT,type,getType(),getId()));
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component component = components.stream().filter(s->s.getType().equals(componentType)).findFirst().orElse(null);
        if (component==null){
            throw  new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,componentType,getType(),getId()));
        }
        this.components.remove(component);
        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        String type=peripheral.getClass().getSimpleName();
        if (peripherals.stream().filter(s->s.getClass().getSimpleName().equals(type)).findFirst().orElse(null)!=null){
            throw  new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_PERIPHERAL,type,getType(),getId()));
        }
      this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peripheral = peripherals.stream().filter(s->s.getType().equals(peripheralType)).findFirst().orElse(null);
        if (peripheral==null){
            throw  new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,peripheralType,getType(),getId()));
        }
        this.peripherals.remove(peripheral);
        return peripheral;
    }


    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();

         builder.append(String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)",getOverallPerformance(),getPrice(),getType(),getManufacturer(),getModel(),getId()));
         builder.append(System.lineSeparator());
         builder.append(String.format(" Components (%d):",components.size()));
        for (Component component : components) {
            builder.append(System.lineSeparator());
            builder.append("  "+component.toString());
        }
        double per=peripherals.stream().mapToDouble(Product::getOverallPerformance).sum()/peripherals.size();
        builder.append(System.lineSeparator());
        builder.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):",peripherals.size(),per<0?per:0));
        for (Peripheral peripheral : peripherals) {
            builder.append(System.lineSeparator());
            builder.append("  "+peripheral.toString());
        }

        return builder.toString().trim();
    }
}
