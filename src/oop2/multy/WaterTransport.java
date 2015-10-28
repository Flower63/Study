package oop2.multy;

/**
 * Created by Flower on 10/28/2015.
 */
public interface WaterTransport extends Transport {

    @Override
    default int speed() {
        return 39; //20 knots
    };
}
