package inner_classes;

/**
 * Created by Flower on 11/2/2015.
 */
public class Carrier extends Ship {

    private int planes;


    public Carrier(int planes) {
        this.planes = planes;
        this.engine = new NuclearEngine(20000, "RR", EngineType.STEAM, 100000);
    }

    public class NuclearEngine extends Engine {
        private int maxSailDuration;

        public NuclearEngine(int hp, String model, EngineType type, int maxSailDuration) {
            super(hp, model, type);
            this.maxSailDuration = maxSailDuration;
        }
    }
}
