package onlineShop.core;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller {
    private Map<Integer, Computer> computers;
    private Map<Integer, Component> components;
    private Map<Integer, Peripheral> peripheries;

    public ControllerImpl() {
        this.computers = new LinkedHashMap<>();
        this.components = new LinkedHashMap<>();
        this.peripheries = new LinkedHashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
        } else if (!(computerType.equals("Laptop")) && (!computerType.equals("DesktopComputer"))) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }
        switch (computerType) {
            case "DesktopComputer":
                computers.put(id,new DesktopComputer(id,manufacturer,model,price,computerType));
                break;
            case "Laptop":{
                computers.put(id,new Laptop(id,manufacturer,model,price,computerType));
            }
        }
        return String.format(OutputMessages.ADDED_COMPUTER,id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
         doesComputerExists(computerId);
         if (peripheries.containsKey(id)){
             throw new IllegalArgumentException((ExceptionMessages.EXISTING_PERIPHERAL_ID));
         }

        Peripheral p=null;
         switch (peripheralType){
             case "Headset":
                 p=new Headset(id,manufacturer,model,price,overallPerformance,connectionType,peripheralType);
                 break;
             case "Keyboard":
                 p=new Keyboard(id,manufacturer,model,price,overallPerformance,connectionType,peripheralType);
                 break;
             case "Monitor":
                 p=new Monitor(id,manufacturer,model,price,overallPerformance,connectionType,peripheralType);
                 break;
             case "Mouse":
                 p=new Mouse(id,manufacturer,model,price,overallPerformance,connectionType,peripheralType);
                 break;
         }
         if (p==null){
             throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
         }
         peripheries.put(id,p);
         computers.get(computerId).addPeripheral(p);
        return String.format(OutputMessages.ADDED_PERIPHERAL,peripheralType,id,computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        doesComputerExists(computerId);
        Peripheral p=computers.get(computerId).removePeripheral(peripheralType);
        peripheries.values().remove(peripheries.values().stream().filter(s->s.getType().equals(peripheralType)).findFirst());
        return String.format(OutputMessages.REMOVED_PERIPHERAL,peripheralType,p.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        doesComputerExists(computerId);
        if (components.containsKey(id)){
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT_ID,id));
        }

        Component p=null;
        switch (componentType){
            case "CentralProcessingUnit":
                p=new CentralProcessingUnit(id,manufacturer,model,price,overallPerformance,generation,componentType);
                break;
            case "Motherboard":
                p=new Motherboard(id,manufacturer,model,price,overallPerformance,generation,componentType);
                break;
            case "PowerSupply":
                p=new PowerSupply(id,manufacturer,model,price,overallPerformance,generation,componentType);
                break;
            case "RandomAccessMemory":
                p=new RandomAccessMemory(id,manufacturer,model,price,overallPerformance,generation,componentType);
                break;
            case "SolidStateDrive":
                p=new SolidStateDrive(id,manufacturer,model,price,overallPerformance,generation,componentType);
                break;
            case "VideoCard":
                p=new VideoCard(id,manufacturer,model,price,overallPerformance,generation,componentType);
                break;
        }
        if (p==null){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }
        components.put(id,p);
        computers.get(computerId).addComponent(p);
        return String.format(OutputMessages.ADDED_COMPONENT,componentType,id,computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        doesComputerExists(computerId);
        Component c=computers.get(computerId).removeComponent(componentType);
        components.values().remove(components.values().stream().filter(s->s.getType().equals(componentType)).findFirst());
        return String.format(OutputMessages.REMOVED_COMPONENT,componentType,c.getId());
    }

    @Override
    public String buyComputer(int id) {
        doesComputerExists(id);
        Computer com= computers.get(id);
        computers.remove(id);
        return com.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer c= computers.values().stream().filter(s->s.getPrice()<=budget).sorted((s1, s2)->Double.compare(s2.getOverallPerformance(), s1.getOverallPerformance())).findFirst().orElse(null);
        if (c==null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER,budget));
        }
        return c.toString();
    }

    @Override
    public String getComputerData(int id) {
        doesComputerExists(id);
        Computer com= computers.get(id);
        return com.toString();
    }

    private void doesComputerExists(Integer id) {
        if (!computers.containsKey(id)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
    }
}
