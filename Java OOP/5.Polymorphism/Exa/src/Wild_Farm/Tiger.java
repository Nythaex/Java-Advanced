package Wild_Farm;

public class Tiger extends Felime{
    public Tiger(String animalType, String animalName, Double animalWeight,String livingRegion) {
        super(animalType, animalName, animalWeight,livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    protected void eat(Food food) {
      if (food instanceof Meat){
          super.foodEaten=food.quantity;
      }else {
          throw new IllegalArgumentException("Tigers are not eating that type of food!");
      }
    }

}
