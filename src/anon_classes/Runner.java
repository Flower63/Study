package anon_classes;

/**
 * Created by Flower on 11/2/2015.
 */
public class Runner {
    public static void main(String[] args) {
        int aaa = 12;

        Point circle = new Point(3, 4) {
            int radius = aaa;

            @Override
            public double square() {
                return radius * radius * Math.PI;
            }
        };

        System.out.println(circle);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double square() {
        return 0;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y + " square= " + square() +
                '}';
    }
}
