package CarShopExtended;

public class Audi extends CarImpl implements Rentable{
    private Integer minRentDays;
    private Double pricePerDay;
    public Audi(String model, String color, Integer horsePower, String countryProduced,Integer minRentDays,Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDays=minRentDays;
        this.pricePerDay=pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDays;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
