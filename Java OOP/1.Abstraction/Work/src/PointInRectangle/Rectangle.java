package PointInRectangle;

public class Rectangle {
    private int left;
    private int down;
    private int right;
    private int up;

    public Rectangle(int botFirst, int botSecond, int topFirst, int topSecond) {
        this.left = botFirst;
        this.down = botSecond;
        this.right = topFirst;
        this.up = topSecond;
    }
    public boolean contains(Point point){
        return contain(point);
    }

    private boolean contain(Point point) {
        return point.getFirstPoint()>= left && point.getFirstPoint()<= right&&
                point.getSecondPoint()>= down &&point.getSecondPoint()<= up;


    }
}
