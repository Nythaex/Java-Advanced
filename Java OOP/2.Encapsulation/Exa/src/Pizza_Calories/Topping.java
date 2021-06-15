package Pizza_Calories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch(toppingType){
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                throw new  IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight>=1&&weight<=50) {
            this.weight = weight;
        }else{
            throw new  IllegalArgumentException(String.format("%s weight should be in the range [1..50].",this.toppingType));
        }
    }

    public  double calculateCalories(){
        return calculatedCalories(toppingType,weight);
    }

    private double calculatedCalories(String toppingType, double weight) {
        double toppingCalPerGram=0;
        switch(toppingType){
            case "Meat":
                toppingCalPerGram=1.2;
                break;
            case "Veggies":
                toppingCalPerGram=0.8;
                break;
            case "Cheese":
                toppingCalPerGram=1.1;
                break;
            case "Sauce":
                toppingCalPerGram=0.9;
                break;
        }
        return (weight*2)*toppingCalPerGram;
    }

    @Override
    public String toString() {
        return "Topping "+this.toppingType+" "+this.weight;
    }
}
