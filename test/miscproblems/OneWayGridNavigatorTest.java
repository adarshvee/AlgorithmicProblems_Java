/*
 * Test class for one way grid problem
 */
package miscproblems;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adarsh V
 */
public class OneWayGridNavigatorTest {
    
    public OneWayGridNavigatorTest() {
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
     * Test with 0 input, of class OneWayGridNavigator.
     */
    @Test
    public void testWithBoth0() {
        int expected = 0;
        int length = 0;
        int height = 0;
        assertEquals(expected,OneWayGridNavigator.findPaths(length, height));
    }
    
    /**
     * Test input with either length or heigh as 0
     */
    @Test
    public void testWithOneSide0() {
        int expected = 0;
        int length = 0;
        int height = 1;
        assertEquals(expected,OneWayGridNavigator.findPaths(length, height));
        
        length = 10;
        height = 0;
        assertEquals(expected,OneWayGridNavigator.findPaths(length, height));
        
    }
    
    /**
     * Test input with either length and height as 1
     */
    @Test
    public void testWithLength1() {
        int expected = 2;
        int length = 1;
        int height = 1;
        assertEquals(expected,OneWayGridNavigator.findPaths(length, height));
        
    }
    
    /**
     * Test input with either length and height as 1
     */
    @Test
    public void testWithReasonableLength() {
        int expected = 126;
        int length = 4;
        int height = 5;
        assertEquals(expected,OneWayGridNavigator.findPaths(length, height));
        
    }
    
}
