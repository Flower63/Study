package oop2.interfaces.hierarchy.top;

/**
 * Created by Flower on 10/28/2015.
 */
public class Passenger extends AbstractCar {

    public final static int SPEED_LIMIT = 250;


    @Override
    public int maxSpeed() {
        if (inCity) {
            return CITY_LIMIT;
        }

        return SPEED_LIMIT;
    }
}
