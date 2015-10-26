package ua.epam.lab_five.var_eight;

import ua.epam.lab_five.MarkerAnnotation;
import ua.epam.lab_five.View;

/**
 * Class Graduand extends Student, has additional field "diplomaTheme"
 *
 * @author  Dennis_Zvarich
 *
 * on 10/25/2015.
 */
public class Graduand extends Student {
    private String diplomaTheme;

    public Graduand(String name, int course, int id, String diplomaTheme) {
        super(name, course, id);
        this.diplomaTheme = diplomaTheme;
    }

    /*
     * Prints diploma theme
     */
    @MarkerAnnotation
    public void printDiplomaTheme() {
        View.print(diplomaTheme);
    }

    @Override
    public String toString() {
        return super.toString() + "; Diploma theme: " + diplomaTheme;
    }
}
