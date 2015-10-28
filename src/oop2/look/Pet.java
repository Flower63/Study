package oop2.look;

/**
 * Created by Flower on 10/28/2015.
 */
public class Pet implements Goods {

    String name;
    int age;
    String owner;

    int price;

    @Override
    public int price() {
        return price;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return name + age + owner;
    }
}
