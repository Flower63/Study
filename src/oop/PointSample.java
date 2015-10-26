/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.util.Arrays;

/**
 *
 * @author Денис
 */
public class PointSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Circle circle = new MyCircle(-100500, 10, 20);
        System.out.println(circle);
        
        NewCircle newCircle = new NewCircle(10  , 10, 10);
        System.out.println(newCircle);
//        newCircle.setxAxis(-10);

        Point[] points = {
                new Point(0, 1),
                new FirstRectangle(1, 1, 10, 15),
                new Ellipse(10, 15, 100, 200),
                new Triangle(new Point(0, 0), new Point(0, 4), new Point(3, 0))
        };

//        Arrays.sort(points, (x, y) -> (int)(Math.signum(x.square() - y.square())));

        ((Triangle) points[3]).setPointB(new Point(0, 0));
        System.out.println(points[3]);

        System.out.println(points[3]);
    }
    
}
