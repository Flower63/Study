package oop2.look;

/**
 * Created by Flower on 10/28/2015.
 */
public class House implements Goods {

    String address;
    int square;

    int price;

    @Override
    public int price() {
        return price;
    }

    @Override
    public String name() {
        return address;
    }

    @Override
    public String description() {
        return address + square;
    }
}
