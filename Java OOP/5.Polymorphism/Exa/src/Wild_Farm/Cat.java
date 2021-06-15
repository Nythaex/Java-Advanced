package Wild_Farm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight,String livingRegion,String breed) {
        super(animalType, animalName, animalWeight,livingRegion);
        this.breed = breed;
    }

    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eat(Food food) {
            super.foodEaten+=food.quantity;
    }


    @Override
    public String toString() {
        DecimalFormat df=new DecimalFormat("0.##");
        return String.format("%s[%s, %s, %s, %s, %d]",animalType,animalName,breed,df.format(animalWeight),this.livingRegion,foodEaten);
    }
}
