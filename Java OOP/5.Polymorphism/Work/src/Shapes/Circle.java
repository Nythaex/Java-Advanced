package Shapes;

public class Circle extends Shape   {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double getPerimeter() {
        return calculatePerimeter();
    }

    @Override
    public Double getArea() {
        return calculateArea();
    }

    @Override
    public Double calculatePerimeter() {
        return 2*radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI*radius*2;
    }
   final public Double getRadius() {
        return radius;
    }
}
