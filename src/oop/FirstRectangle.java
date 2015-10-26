package oop;

/**
 * Created by Flower on 10/26/2015.
 */
public class FirstRectangle extends Point {
    private int width;
    private int height;

    public FirstRectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + "FirstRectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public double square() {
        return 2 * (width + height);
    }

    @Override
    public double perimeter() {
        return width * height;
    }
}
