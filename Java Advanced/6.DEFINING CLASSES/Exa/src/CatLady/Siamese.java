package CatLady;

public class Siamese {
    private String name;
    private String type;
    private double specification;

    public Siamese(String type,String name, double specification) {
        this.name = name;
        this.type = type;
        this.specification = specification;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",type,name,specification);
    }
}
