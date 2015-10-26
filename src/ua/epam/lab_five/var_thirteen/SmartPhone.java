package ua.epam.lab_five.var_thirteen;

/**
 * @author  Dennis_Zvarich
 *
 * on 10/25/2015.
 */
public class SmartPhone extends MobilePhone {
    private double cpuSpeed;
    private int coresNumber;
    private int ram;

    /*
     * Constructor
     */
    public SmartPhone(String modelName, int weight, double screenDiagonal, int memory,
                      boolean camera, double cpuSpeed, int coresNumber, int ram) {
        super(modelName, weight, screenDiagonal, memory, camera);
        this.cpuSpeed = cpuSpeed;
        this.coresNumber = coresNumber;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return super.toString() + "\nProcessor: " + coresNumber + " core, "
                                + cpuSpeed + "GHz.\n" + ram + " RAM";
    }
}
