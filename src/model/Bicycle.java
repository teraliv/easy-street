/*
 * TCSS 305 
 * 
 * Assignment 3 - EasyStreet.
 */

package model;

import java.util.Map;

/**
 * Represents bicycle.
 * 
 * @author Alex Terikov teraliv@uw.edu
 * @version April 23, 2015
 *
 */
public class Bicycle extends AbstractVehicle {
    
    //instance fields
    
    /** Death time for a bicycle. */
    private static final int DEATH_TIME = 20;
    
    /** Direction of a bicycle. */
    private Direction myDirection;
    
    
    //constructors
    
    /**
     * Constructs a bicycle object with give x, y coordinates and direction. 
     * 
     * @param theX   The X coordinate of a bicycle.
     * @param theY   The Y coordinate of a bicycle.
     * @param theDir The direction of a bicycle.
     */
    public Bicycle(final int theX, final int theY, final Direction theDir) {
        
        super(theX, theY, theDir, DEATH_TIME);
        
        myDirection = theDir;
    }
    
    /**
     * Check if a bicycle can pass the terrain.
     * 
     * @param theTerrain The terrain that bicycle trying to pass.
     * @param theLight The color of the light for bicycle to pass.
     * @return true if bicycle can pass or false otherwise.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        
        boolean allowedToPass = false;
        
        if (theTerrain == Terrain.TRAIL) {
            allowedToPass = true;
        }
        if ((theTerrain == Terrain.STREET) || (theTerrain == Terrain.LIGHT)) {
            allowedToPass = true;
        }
        if ((theTerrain == Terrain.LIGHT) && (theLight == Light.YELLOW)) {
            allowedToPass = false;
        }
        if ((theTerrain == Terrain.LIGHT) && (theLight == Light.RED)) {
            allowedToPass = false;
        }
        
        return allowedToPass;
    }
    
    /**
     * Returns the direction bicycle is going to move, based on the given
     * map of the neighboring terrain.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this object would like to move.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) {
            myDirection = getDirection();
        
        } else if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
            myDirection = getDirection().left();
        
        } else if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
            myDirection = getDirection().right();
        
        } else if ((theNeighbors.get(getDirection()) == Terrain.STREET) 
                        || (theNeighbors.get(getDirection()) == Terrain.LIGHT)) {
            myDirection = getDirection();
        
        } else if ((theNeighbors.get(getDirection().left()) == Terrain.STREET) 
                        || (theNeighbors.get(getDirection().left())) == Terrain.LIGHT) {
            myDirection = getDirection().left();
        
        } else if ((theNeighbors.get(getDirection().right()) == Terrain.STREET) 
                        || (theNeighbors.get(getDirection().right())) == Terrain.LIGHT) {
            myDirection = getDirection().right();
        
        } else {
            myDirection = getDirection().reverse();
        }
        
        return myDirection;
    }

}