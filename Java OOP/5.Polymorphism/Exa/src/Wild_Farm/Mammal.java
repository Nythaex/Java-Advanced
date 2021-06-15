package Wild_Farm;

import java.text.DecimalFormat;

public abstract class Mammal extends  Animal {
    public Mammal(String animalName, String animalType, Double animalWeight,String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion=livingRegion;
    }

    protected String livingRegion;

    @Override
    public String toString() {
        DecimalFormat df=new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",animalType,animalName,df.format(animalWeight),this.livingRegion,foodEaten);
    }
}
