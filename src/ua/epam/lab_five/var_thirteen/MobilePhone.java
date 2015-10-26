package ua.epam.lab_five.var_thirteen;

import ua.epam.lab_five.MarkerAnnotation;
import ua.epam.lab_five.MarkerInterface;
import ua.epam.lab_five.View;

/**
 * @author Dennis_Zvarich
 *
 * on 10/25/2015.
 */
public class MobilePhone implements MarkerInterface {
    private String modelName;
    private int weight;
    private double screenDiagonal;
    private int memory;
    private boolean camera;

    /*
     * Constructor
     */
    public MobilePhone(String modelName, int weight, double screenDiagonal,
                       int memory, boolean camera) {
        this.modelName = modelName;
        this.weight = weight;
        this.screenDiagonal = screenDiagonal;
        this.memory = memory;
        this.camera = camera;
    }

    /*
     * Prints model name
     */
    @MarkerAnnotation
    public void printModelName() {
        View.print(modelName);
    }

    /*
     * Prints complete specification of model
     */
    @MarkerAnnotation
    public void printCompleteSpecifications() {
        View.print(toString());
    }

    @Override
    public String toString() {
        return "Model " + modelName + "\nWeight " + weight
                + " grams\nScreen diagonal " + screenDiagonal + "\""
                + "\nMemory " + memory + "mb.\nCamera "
                + (camera ? "presented" : "absent");
    }
}
