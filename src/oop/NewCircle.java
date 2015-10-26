/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;


/**
 *
 * @author Денис
 */
public class NewCircle extends Ellipse {

    public NewCircle(int radius, int x, int y) {
        super(radius, radius, x, y);
    }
    
    public int getRadius() {
        return (int)getxAxis();
    }

    public void setRadius(int radius) {
        super.checkXAxis(radius);
        super.checkYAxis(radius);
        
    }

    @Override
    public void setyAxis(double yAxis) {
        throw new NotImplementedException();
    }

    @Override
    public void setxAxis(double xAxis) {
        throw new NotImplementedException();
    }
    
    
    
}
