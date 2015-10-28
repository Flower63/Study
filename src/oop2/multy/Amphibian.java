package oop2.multy;

/**
 * Created by Flower on 10/28/2015.
 */
public class Amphibian implements RoadTransport, WaterTransport {

    int capacity;
    boolean byWater;

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int speed() {
        return !byWater ? RoadTransport.super.speed() : WaterTransport.super.speed();
    }
}
