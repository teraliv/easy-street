/*
 * TCSS 305 
 * 
 * Assignment 3 - EasyStreet.
 */

package model;

import java.util.Map;

/**
 * Represents car.
 * 
 * @author Alex Terikov teraliv@uw.edu
 * @version April 23, 2015
 *
 */
public class Car extends AbstractVehicle {
    
    //instance fields
    
    /** Death time for a car. */
    private static final int DEATH_TIME = 10;
    
    /** Direction of a car. */
    private Direction myDirection;
    
    //constructors
    
    /**
     * Constructs a car object with give x, y coordinates and direction. 
     * 
     * @param theX   The X coordinate of a car.
     * @param theY   The Y coordinate of a car.
     * @param theDir The direction of a car.
     */
    public Car(final int theX, final int theY, final Direction theDir) {
        
        super(theX, theY, theDir, DEATH_TIME);
        
        myDirection = theDir;
    }
    
    
    //instance methods
    
    /**
     * Check if a car can pass the terrain.
     * 
     * @param theTerrain The terrain that car trying to pass.
     * @param theLight The color of the light for car to pass.
     * @return true if car can pass or false otherwise.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean allowedToPass = false;
        
        if ((theTerrain == Terrain.STREET) || (theTerrain == Terrain.LIGHT)) {
            allowedToPass = true;
        }
        if ((theTerrain == Terrain.LIGHT) && (theLight == Light.RED)) {
            allowedToPass = false;
        }
        
        return allowedToPass;
    }
    
    /**
     * Returns the direction car is going to move, based on the given
     * map of the neighboring terrain.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this object would like to move.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
        if ((theNeighbors.get(getDirection()) == Terrain.STREET) 
                      || (theNeighbors.get(getDirection()) == Terrain.LIGHT)) {
            myDirection = getDirection();
      
        } else if ((theNeighbors.get(getDirection().left()) == Terrain.STREET) 
                      || (theNeighbors.get(getDirection().left()) == Terrain.LIGHT)) {
            myDirection = getDirection().left();
      
        } else if ((theNeighbors.get(getDirection().right()) == Terrain.STREET) 
                      || (theNeighbors.get(getDirection().right()) == Terrain.LIGHT)) {
            myDirection = getDirection().right();
      
        } else {
            myDirection = getDirection().reverse();
        }
    
        return myDirection;
    }

}
