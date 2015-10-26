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
public class MyCircle extends Circle{
    @Override
    public void setRadius(int radius){
        this.radius = radius;
    }

    public MyCircle(int radius, int x, int y) {
        super(radius, x, y);
    }
    
    
}
