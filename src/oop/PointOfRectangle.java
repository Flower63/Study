package oop;

/**
 * Created by Flower on 10/26/2015.
 */
public class PointOfRectangle extends Point {
    private SecondRectangle parent;

    public PointOfRectangle(int x, int y, SecondRectangle parent) {
        super(x, y);
        this.parent = parent;
        if (parent == null) {
            throw new IllegalArgumentException();
        }
    }
}
