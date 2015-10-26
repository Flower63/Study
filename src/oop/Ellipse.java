/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author Денис
 */
public class Ellipse  extends Point{
    private double xAxis;
    private double yAxis;

    public Ellipse(double xAxis, double yAxis, int x, int y) {
        super(x, y);
        this.xAxis = checkXAxis(xAxis);
        this.yAxis = checkXAxis(yAxis);
    }

    public final double checkXAxis(double xAxis) {
        return Math.abs(xAxis);
    }

    public final double checkYAxis(double yAxis) {
        return Math.abs(yAxis);
    }

    public double getxAxis() {
        return xAxis;
    }

    public void setxAxis(double xAxis) {
        this.xAxis = checkXAxis(xAxis) ;
    }

    public double getyAxis() {
        return yAxis;
    }

    public void setyAxis(double yAxis) {
        this.yAxis = checkYAxis(yAxis);
    }
    
    public double square() {
        return Math.PI * xAxis * yAxis;
    }

    public double perimeter() {
        return 0;
    }
    
}
