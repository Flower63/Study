package inner_classes;

/**
 * Created by Flower on 11/2/2015.
 */
public class Runner {
    public static void main(String[] args) {
        Ship ship = new Ship("Titanic", 70000);
        Ship.Boat boat = new Ship.Boat(ship, 200);

        ship.setBoat(boat);

        Ship.Engine engine = ship.new Engine(3000, "RR", Ship.EngineType.STEAM);

        ship.setEngine(engine);

        System.out.println(ship);

        ship = new Ship();
        System.out.println(ship);
    }
}
