package Class_Box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setHeight(height);
        setWidth(width);
    }

    private void setLength(double length) {
        if (IsItBelowZero(length)) {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (IsItBelowZero(width)) {
            this.width = width;
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (IsItBelowZero(height)) {
            this.height = height;
        }
        this.height = height;
    }

    private boolean IsItBelowZero(double num) {
        if (num <= 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public double calculateSurfaceArea() {
        return 2*this.length*this.width+2*this.length*this.height+2*this.width*this.height;
    }

    public double calculateLateralSurfaceArea() {
        return 2*this.length*this.height+2*this.width*this.height;
    }

    public double calculateVolume() {
        return this.length * this.height * this.width;
    }
}
