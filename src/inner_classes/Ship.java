package inner_classes;

/**
 * Created by Flower on 11/2/2015.
 */
public class Ship {
    private String name;
    private int tonnage;
    private Boat boat;
    protected Engine engine;

    public Ship(String name, int tonnage) {
        this.name = name;
        this.tonnage = tonnage;
    }

    public Ship() {
        name = "Britanic";
        tonnage = 70000;
        boat = new Boat(this, 200);
        engine = new Engine(5000, "RR", EngineType.STEAM);
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public static class Boat {
        private int capacity;
        private Ship ship;

        public Boat(Ship ship, int capacity) {
            this.ship = ship;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "Boat{" +
                    "capacity=" + capacity + "of ship" + ship.name +
                    '}';
        }
    }

    public class Engine {
        private int hp;
        private String model;
        private EngineType type;

        public Engine(int hp, String model, EngineType type) {
            this.hp = hp;
            this.model = model;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "hp=" + hp +
                    ", model='" + model + '\'' +
                    ", type=" + type + " of ship " + Ship.this.name +
                    '}';
        }
    }

    public enum EngineType {
        DIESEL, STEAM, TURBINE
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", tonnage=" + tonnage +
                ", boat=" + boat + " engine " + engine +
                '}';
    }
}
