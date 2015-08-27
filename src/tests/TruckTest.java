/*
 * TCSS 305 
 * 
 * Assignment 3 - EasyStreet.
 */
package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import model.Direction;
import model.Light;
import model.Terrain;
import model.Truck;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for the Truck class.
 * 
 * @author Alex Terikov teraliv@uw.edu
 * @version April 23, 2015
 *
 */
public class TruckTest {
    
    /** A Truck object to be used in the tests. */
    private Truck myTruck;
    
    /** A Map object with Direction and Terrain. */
    private Map<Direction, Terrain> myNeighbors; 
    
    /** A method to initialize the test fixture before each test. */
    @Before
    public void setUp() {
        myTruck = new Truck(1, 1, Direction.NORTH);
        myNeighbors = new HashMap<Direction, Terrain>();
    }
    
    /** Test method for Truck constructor. */
    @Test
    public void testTruckConstructor() {
        
        assertEquals("Truck X coordinate not initialized correctly!", 1, myTruck.getX());
        assertEquals("Truck Y coordinate not initialized correctly!", 1, myTruck.getY());
        assertEquals("Truck direction not initialized correctly!",
                     Direction.NORTH, myTruck.getDirection());
        assertTrue("Truck isAlive() fails initially!", myTruck.isAlive());
        
    }
    
    /**
     * Test method for {@link Truck#canPass(Terrain, Light)}.
     */
    @Test
    public void testCanPassStreetGreen() {
 
        myTruck.canPass(Terrain.STREET, Light.GREEN);
        assertEquals("Test testCanPassStreetGreen failed", true, 
                     myTruck.canPass(Terrain.STREET, Light.GREEN));
    }
    
    /**
     * Test method for {@link Truck#canPass(Terrain, Light)}.
     */
    @Test
    public void testCanPassStreetYellow() {
 
        myTruck.canPass(Terrain.STREET, Light.YELLOW);
        assertEquals("Test testCanPassStreetGreen failed", true, 
                     myTruck.canPass(Terrain.STREET, Light.YELLOW));
    }
    
    /**
     * Test method for {@link Truck#canPass(Terrain, Light)}.
     */
    @Test
    public void testCanPassStreetRed() {
 
        myTruck.canPass(Terrain.STREET, Light.RED);
        assertEquals("Test testCanPassStreetGreen failed", true, 
                     myTruck.canPass(Terrain.STREET, Light.RED));
    }
    
    /**
     * Test method for {@link Truck#canPass(Terrain, Light)}.
     */
    @Test
    public void testCanPassLightGreen() {
 
        myTruck.canPass(Terrain.LIGHT, Light.GREEN);
        assertEquals("Test testCanPassStreetGreen failed", true, 
                     myTruck.canPass(Terrain.LIGHT, Light.GREEN));
    }
    
    /**
     * Test method for {@link Truck#canPass(Terrain, Light)}.
     */
    @Test
    public void testCanPassLightYellow() {
 
        myTruck.canPass(Terrain.LIGHT, Light.YELLOW);
        assertEquals("Test testCanPassStreetGreen failed", true, 
                     myTruck.canPass(Terrain.LIGHT, Light.YELLOW));
    }
    
    /**
     * Test method for {@link Truck#canPass(Terrain, Light)}.
     */
    @Test
    public void testCanPassLightRed() {
 
        myTruck.canPass(Terrain.LIGHT, Light.RED);
        assertEquals("Test testCanPassStreetGreen failed", true, 
                     myTruck.canPass(Terrain.LIGHT, Light.RED));
    }
    
    
    /**
     * Test method for {@link Truck#canPass(Terrain, Light)}.
     */
    @Test
    public void testCanPassLight2() {
 
        myTruck.canPass(Terrain.GRASS, Light.RED);
        assertEquals("Test testCanPassStreetGreen failed", true, 
                     myTruck.canPass(Terrain.LIGHT, Light.RED));
    }

    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionNorthStreet() {
        myNeighbors.put(Direction.NORTH, Terrain.STREET);
        myTruck.setDirection(Direction.WEST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Truck chooseDirection failed!", Terrain.STREET, 
                     myNeighbors.get(Direction.NORTH));
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionEastStreet() {
        myNeighbors.put(Direction.EAST, Terrain.STREET);
        myTruck.setDirection(Direction.EAST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Truck chooseDirection failed!", Terrain.STREET, 
                     myNeighbors.get(Direction.EAST));
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionWestStreet() {
        myNeighbors.put(Direction.WEST, Terrain.STREET);
        myTruck.setDirection(Direction.WEST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Truck chooseDirection failed!", Terrain.STREET, 
                     myNeighbors.get(Direction.WEST));
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionSouthStreet() {
        myNeighbors.put(Direction.SOUTH, Terrain.STREET);
        myTruck.setDirection(Direction.WEST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Truck chooseDirection failed!", Terrain.STREET, 
                     myNeighbors.get(Direction.SOUTH));
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionNorthLight() {
        myNeighbors.put(Direction.NORTH, Terrain.LIGHT);
        myTruck.setDirection(Direction.WEST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Truck chooseDirection failed!", Terrain.LIGHT, 
                     myNeighbors.get(Direction.NORTH));
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionEastLight() {
        myNeighbors.put(Direction.EAST, Terrain.LIGHT);
        myTruck.setDirection(Direction.WEST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Truck chooseDirection failed!", Terrain.LIGHT, 
                     myNeighbors.get(Direction.EAST));
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionWestLight() {
        myNeighbors.put(Direction.WEST, Terrain.LIGHT);
        myTruck.setDirection(Direction.WEST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Truck chooseDirection failed!", Terrain.LIGHT, 
                     myNeighbors.get(Direction.WEST));
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionSouthLight() {
        myNeighbors.put(Direction.SOUTH, Terrain.LIGHT);
        myTruck.setDirection(Direction.WEST);
        myTruck.chooseDirection(myNeighbors);
        assertEquals("Truck chooseDirection failed!", Terrain.LIGHT, 
                     myNeighbors.get(Direction.SOUTH));
    }
    
    /** Test method for Truck isAlive. */
    @Test
    public void testIsAlive() {
        assertTrue("Truck isAlive() failed !", myTruck.isAlive());
    }

    /** Test method for Truck setDirection. */
    @Test
    public void testSetDirection() {
        myTruck.setDirection(Direction.NORTH);
        assertEquals("Truck setDirection() failed!", Direction.NORTH, myTruck.getDirection());
    }
    
    /**
     * Test method for {@link Truck#setX()}.
     */
    @Test
    public void testSetX() {
        myTruck.setX(10);
        assertEquals("Truck setX failed!", 10, myTruck.getX());
    }
    
    /**
     * Test method for {@link Truck#setY()}.
     */
    @Test
    public void testSetY() {
        myTruck.setY(11);
        assertEquals("Truck setX failed!", 11, myTruck.getY());
    }
    
    /**
     * Test method for {@link Truck#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("Truck: [Direction: NORTH] [Pokes: 0] ", myTruck.toString());
    }
    
    

}
