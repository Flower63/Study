package oop;

/**
 * Created by Flower on 10/26/2015.
 */
public class Triangle extends Point {

    private Point pointB;
    private Point pointC;

    private double perimeterCache = -1;
    private double squareCache = -1;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        super(pointA);
        this.pointB = new Point(pointB);
        this.pointC = new Point(pointC);
    }

    @Override
    public double perimeter() {

        if (perimeterCache == -1) {
            double sideA = Point.distance(pointB, pointC);
            double sideB = Point.distance(this, pointC);
            double sideC = Point.distance(pointB, this);

            perimeterCache = sideA + sideB + sideC;
        }

        return perimeterCache;
    }

    @Override
    public double square() {
        if (squareCache == -1) {
            double halfPerim = perimeter() / 2;

            squareCache = Math.sqrt(halfPerim * (halfPerim - Point.distance(pointB, pointC)));
        }

        return squareCache;
    }

    public void setPointB(Point pointB) {
        this.pointB = new Point(pointB);


    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public void resetCache() {
        perimeterCache = -1;
        squareCache = -1;
    }

    @Override
    public void setX(int x) {
        super.setX(x);
        resetCache();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
        resetCache();
    }

    public Point getPointB() {
        return new Point(pointB);
    }

    public Point getPointC() {
        return new Point(pointC);
    }
}
