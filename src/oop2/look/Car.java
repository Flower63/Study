package oop2.look;

/**
 * Created by Flower on 10/28/2015.
 */
public class Car implements Goods {

    String model;
    int maxSpeed;
    int year;
    int price;

    @Override
    public int price() {
        return price;
    }

    @Override
    public String name() {
        return model;
    }

    @Override
    public String description() {
        return "max speed " + maxSpeed + " year " + year;
    }
}
