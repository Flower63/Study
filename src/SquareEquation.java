/**
 *
 * @author Денис
 */
public class SquareEquation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a = 1;
        double b = -5;
        double c = 6;

        double[] x = solveSquareEquation(b, a, c);

        System.out.println("x1=" + x[0]);
        System.out.println("x2=" + x[1]);

    }

    public static double[] solveSquareEquation(double a, double b, double c) {
        if ( a == 0 ){
            return solveLinearEquation(c, b);
        }
        double D = b * b - 4 * a * c;
        
        
        if ( D == 0 ){
           
            return solveLinearEquation(b, 2*a);
        } else if ( D < 0 ){
            return new double[0];
        }
        double x1 = (Math.sqrt(D) - b) / (2 * a);
        double x2 = (-Math.sqrt(D) - b) / (2 * a);
        double x[] = {x1, x2};
        
        return x;
    }

    public static double[] solveLinearEquation(double c, double b) {
        if ( b == 0){
            return new double[0];
        }
        return new double[] { - c / b};
    }

}
