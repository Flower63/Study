package oop2.interfaces.hierarchy.top;

/**
 * Created by Flower on 10/28/2015.
 */
public abstract class AbstractCar implements Car {

    String model;
    boolean inCity;
    int hp;

    @Override
    public String name() {
        return model;
    }

    @Override
    public int hp() {
        return hp;
    }
}
