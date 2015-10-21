import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Денис
 */
public class SquareEquationTest {
    
    public SquareEquationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class SquareEquation.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        SquareEquation.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
    @Test
    public void testTwoRoots(){
        System.out.println("testTwoRoots");
        double x[] = SquareEquation.solveSquareEquation( 1, -5 ,6);
        assertTrue( x != null );
        assertEquals(2 , x.length );
        assertEquals(3.0, x[0], 1e-10);
        assertEquals(2.0, x[1], 1e-10);
    }
    @Test
    public void testTwoRootsSecond(){
        System.out.println("testTwoRootsSecond");
        double x[] = SquareEquation.solveSquareEquation( 2, -10 ,12);
        assertTrue( x != null );
        assertEquals(2 , x.length );
        assertEquals(3.0, x[0], 1e-10);
        assertEquals(2.0, x[1], 1e-10);
    }
    
    @Test// (expected = Ex)
    public void testOneRoot(){
        double x[] = SquareEquation.solveSquareEquation( 2, -4 ,2);
        assertNotNull(x);
        assertArrayEquals(new double[]{1.0}, x, 1e-10);
        
    }
    @Test
    public void testNoRoots(){
        double x[] = SquareEquation.solveSquareEquation( 2, 4 ,4);
        assertNotNull(x);
        assertArrayEquals(new double [] {}, x,  1e-10);
    }
    
    @Test
    public void notSquareEquation(){
        double x[] = SquareEquation.solveSquareEquation( 0, 1 ,-1);
        assertNotNull(x);
        assertArrayEquals(new double[] {1}, x , 1e-10);
    }

    /*
     * This tests was added by me
     */
    @Test
    public void testLinearEquationZeroB() {
        double x[] = SquareEquation.solveLinearEquation(1, 0);
        assertNotNull(x);
        assertArrayEquals(new double[0], x, 1e-10);
    }

    @Test
    public void testLinearEquation() {
        double x[] = SquareEquation.solveLinearEquation(1, 1);
        assertNotNull(x);
        assertArrayEquals(new double[] {-1}, x, 1e-10);
    }
    
    
    
    
}
