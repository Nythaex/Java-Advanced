package Raw_Data;

public class Cargo {
   private String CargoType;
   private int CargoWeight;

    public Cargo( int cargoWeight,String cargoType) {
        CargoType = cargoType;
        CargoWeight = cargoWeight;
    }

    public boolean check(String wantedType,Tire tire,Engine engine){
        switch (wantedType){
            case "fragile":
                if (wantedType.equals(this.CargoType)){
                  return tire.checkFragile();
                }
                break;
            case "flamable":
                if (wantedType.equals(this.CargoType)){
                   return engine.checkFlamable();
                }
                break;
        }
       return false;
   }
}
