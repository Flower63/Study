package ua.epam.lab_five.var_eight;

import ua.epam.lab_five.MarkerAnnotation;
import ua.epam.lab_five.MarkerInterface;
import ua.epam.lab_five.View;

/**
 * Superclass. Contains fields "name", "course" and "id" of
 * specified student
 *
 * @author Dennis_Zvarich
 *
 * on 10/25/2015.
 */
public class Student implements MarkerInterface {
    private String name;
    private int course;
    private int id;

    /*
     * Constructor
     */
    public Student(String name, int course, int id) {
        this.name = name;
        this.course = checkCourse(course);
        this.id = id;
    }

    /*
     * Prints entire data about student
     */
    @MarkerAnnotation
    public void print() {
        View.print(toString());
    }

    /*
     * Prints student name
     */
    @MarkerAnnotation
    public void printName() {
        View.print(name);
    }

    /*
     * Prints student ID
     */
    @MarkerAnnotation
    public void printId() {
        View.print("" + id);
    }

    @Override
    public String toString() {
        return "Name: " + name + "; Course: " + course + "; Student id: " + id;
    }

    /*
     * Just to be sure that course specified correctly
     */
    final int checkCourse(int course) {
        if (course > 0 && course <= 5) {
            return course;
        } else {
            throw new IllegalArgumentException("Course should be specified correctly!");
        }
    }
}
