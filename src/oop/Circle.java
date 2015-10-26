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
public class Circle extends Point {
    protected int radius;

    public Circle(int radius, int x, int y) {
        super(x, y);
        //this.radius = radius;
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = Math.abs(radius);
    }

    @Override
    public String toString() {
        return super.toString() + "Circle{" + "radius=" + radius + '}';
    }
    
    
    
    
}
