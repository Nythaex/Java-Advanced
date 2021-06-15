package Wild_Farm;

import java.text.DecimalFormat;

public abstract class Animal {
    protected String animalName;
    protected String animalType;
    protected Double animalWeight;
    protected Integer foodEaten;


    protected abstract void makeSound();
    protected abstract void eat(Food food);

    public Animal(String animalType,String animalName, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }


}
