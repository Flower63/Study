package oop;

/**
 * Created by Flower on 10/26/2015.
 */
public class SecondRectangle {
    private Point pointA;
    private Point pointB;

    public SecondRectangle(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    @Override
    public String toString() {
        return "SecondRectangle{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                '}';
    }
}
