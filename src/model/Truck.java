/*
 * TCSS 305 
 * 
 * Assignment 3 - EasyStreet.
 */

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represents truck.
 * 
 * @author Alex Terikov teraliv@uw.edu
 * @version April 23, 2015
 *
 */
public class Truck extends AbstractVehicle {
    
    //instance fields
    
    /** Death time for a truck. */
    private static final int DEATH_TIME = 0;
    
    
    //constructors
    
    /**
     * Constructs a truck object with give x, y coordinates and direction. 
     * 
     * @param theX   The X coordinate of a truck.
     * @param theY   The Y coordinate of a truck.
     * @param theDir The direction of a truck.
     */
    public Truck(final int theX, final int theY, final Direction theDir) {
       
        super(theX, theY, theDir, DEATH_TIME);
    }
    
    //instance methods
    
    /**
     * Check if a truck can pass the terrain.
     * 
     * @param theTerrain The terrain that truck trying to pass.
     * @param theLight The color of the light for truck to pass.
     * @return true if truck can pass or false otherwise.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean allowedToPass = false;
        
        if ((theTerrain == Terrain.STREET) || (theTerrain == Terrain.LIGHT)) {
            allowedToPass = true;
        }
        
        return allowedToPass;
    }
    
    /**
     * Returns the direction truck is going to move, based on the given
     * map of the neighboring terrain.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this object would like to move.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
        final Random random = new Random();
        
        Direction directions;
        final List<Direction> possibleDirections = new ArrayList<>();
        
        if (theNeighbors.get(getDirection().left()) == Terrain.STREET 
                        || theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {
            possibleDirections.add(getDirection().left());
        
        } 
        
        if (theNeighbors.get(getDirection().right()) == Terrain.STREET 
                        || theNeighbors.get(getDirection().right()) == Terrain.LIGHT) {
            possibleDirections.add(getDirection().right());
        
        } 
        
        if (theNeighbors.get(getDirection()) == Terrain.STREET 
                        || theNeighbors.get(getDirection()) == Terrain.LIGHT) {
            possibleDirections.add(getDirection());
        
        }
        
        if (possibleDirections.isEmpty()) {
            directions = getDirection().reverse();
        
        } else {
            final int randomIndex = random.nextInt(possibleDirections.size());
            directions = possibleDirections.get(randomIndex);
        }
        
        return directions;
    }


}
