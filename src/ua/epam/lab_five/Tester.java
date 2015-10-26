package ua.epam.lab_five;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * This class invokes tests.
 *
 * Its methods takes instance of MarkerInterface as a parameter
 *
 * @author Dennis_Zvarich
 *
 * on 10/25/2015.
 */
public class Tester {

    /*
     * Invokes methods, marked by @Marker annotation
     */
    public static void invokeAnnotatedMethods(MarkerInterface object) throws Exception {
        Method[] methods = object.getClass().getMethods();

        for (Method method : methods) {
            MarkerAnnotation marker = method.getAnnotation(MarkerAnnotation.class);

            if (marker != null) {
                method.invoke(object);
            }
        }

        View.print("");
    }


    /*
     * Prints superclass to given object
     */
    public static void showSuperclass(MarkerInterface object) {
        View.print("Superclass of " + object.getClass().getSimpleName());

        Class myClass = object.getClass();

        View.print(myClass.getSuperclass().getSimpleName());

        View.print("");
    }


    /*
     * Prints all declared methods with access modifiers and parameters
     */
    public static void showMethods(MarkerInterface object) {
        View.print("Methods of " + object.getClass().getSimpleName());

        Method[] methods = object.getClass().getDeclaredMethods();

        for (Method method : methods) {
            View.print(method.getName() + " " + Modifier.toString(method.getModifiers()) + " "
                                            + Arrays.toString(method.getParameterTypes()));
        }

        View.print("");
    }

    /*
     * Prints all declared constructors with parameters
     */
    public static void showConstructors(MarkerInterface object) {
        View.print("Constructors of " + object.getClass().getSimpleName());

        Constructor[] constructors = object.getClass().getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            View.print(constructor.getName() + " " + Modifier.toString(constructor.getModifiers()) + " "
                                            + Arrays.toString(constructor.getParameterTypes()));
        }

        View.print("");
    }

    /*
     * Prints modifiers of class of given object
     */
    public static void showClassModifiers(MarkerInterface object) {
        View.print("Modifiers of " + object.getClass().getSimpleName());

        View.print(Modifier.toString(object.getClass().getModifiers()));

        View.print("");
    }

    /*
     * Prints all declared methods with annotations and parameters
     */
    public static void showMethodAnnotations(MarkerInterface object) {
        View.print("Methods of " + object.getClass().getSimpleName());

        Method[] methods = object.getClass().getDeclaredMethods();

        for (Method method : methods) {
            View.print(method.getName() + " " + Arrays.toString(method.getAnnotations()) + " "
                    + Arrays.toString(method.getParameterTypes()));
        }

        View.print("");
    }

    /*
     * Prints package name and simple class name
     */
    public static void showPackageName(MarkerInterface object) {
        View.print("Package of " + object.getClass().getSimpleName());

        View.print(object.getClass().getPackage().getName() + "." + object.getClass().getSimpleName());

        View.print("");
    }

    /*
     * Prints declared fields of class
     */
    public static void showFields(MarkerInterface object) {
        View.print("Fields of " + object.getClass().getSimpleName());

        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            View.print(field.getName() + " " + field.getType().getSimpleName() + " "
                                        + Modifier.toString(field.getModifiers()));
        }

        View.print("");
    }

    /*
     * Prints class annotations
     */
    public static void showClassAnnotations(MarkerInterface object) {
        View.print("Annotations of " + object.getClass().getSimpleName());

        Annotation[] annotations = object.getClass().getDeclaredAnnotations();

        for (Annotation annotation : annotations) {
            View.print(annotation.toString());
        }

        View.print("");
    }

    /*
     * Prints interfaces, implemented by class
     */
    public static void showInterfaces(MarkerInterface object) {
        View.print("Implemented interfaces in " + object.getClass().getSimpleName());

        Class[] interfaces = object.getClass().getInterfaces();

        for (Class myInterface : interfaces) {
            View.print(myInterface.getSimpleName());
        }

        View.print("");
    }

    /*
     * Prints fields of class with types and declared annotations
     */
    public static void showFieldAnnotations(MarkerInterface object) {
        View.print("Fields of " + object.getClass().getSimpleName());

        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            View.print(field.getName() + " " + field.getType().getSimpleName() + " "
                    + Arrays.toString(field.getDeclaredAnnotations()));
        }

        View.print("");
    }
}

