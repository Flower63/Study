package oop2.multy;

/**
 * Created by Flower on 10/28/2015.
 */
public interface RoadTransport extends Transport {
    @Override
    default int speed() {
        return 100;
    };
}
