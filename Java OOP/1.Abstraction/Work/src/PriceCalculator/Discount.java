package PriceCalculator;

public enum Discount {
    VIP(20,"VIP"),
    SECOND_VISIT(10,"secondVisit"),
    NONE(0,"None");
   private int discount;
   private String name;
    Discount(int discount,String name) {
        this.discount=discount;
        this.name=name;

    }

    public int getDiscount() {
        return discount;
    }
}
