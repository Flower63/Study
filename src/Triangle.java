/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Денис
 */
public class Triangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double firstCathetus = 0.03;
        double secondCathetus = 0.04;
        double hypothenuse = 0.05;
        
        System.out.println( firstCathetus*firstCathetus + secondCathetus*secondCathetus
                            == hypothenuse * hypothenuse ? "square triange" : 
                             "not square triangle" );
        System.out.println(firstCathetus*firstCathetus + secondCathetus*secondCathetus
                            - hypothenuse * hypothenuse);
        final double EPS = 1e-10;
        
        System.out.println( Math.abs( firstCathetus*firstCathetus + secondCathetus*secondCathetus
                            - hypothenuse * hypothenuse ) < EPS ? "square triange" : 
                             "not square triangle" );
    }
    
}
