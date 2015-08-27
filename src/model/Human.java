/*
 * TCSS 305 
 * 
 * Assignment 3 - EasyStreet.
 */

package model;

import java.util.Map;

/**
 * Represents human.
 * 
 * @author Alex Terikov teraliv@uw.edu
 * @version April 23, 2015
 *
 */
public class Human extends AbstractVehicle {
    
    //instance fields
    
    /** Death time for a human. */
    private static final int DEATH_TIME = 50;
    
    /** The human initial terrain. */ 
    private final Terrain myTerrain;
    
    
    /**
     * Constructs a human object with give x, y coordinates and direction. 
     * 
     * @param theX       The X coordinate of a human.
     * @param theY       The Y coordinate of a human.
     * @param theDir     The direction of a human.
     * @param theTerrain The terrain of a human.
     */
    public Human(final int theX, final int theY, final Direction theDir, 
                 final Terrain theTerrain) {
        
        super(theX, theY, theDir, DEATH_TIME);
        
        myTerrain = theTerrain;
    }
    
    /**
     * Check if a human can pass the terrain.
     * 
     * @param theTerrain The terrain that human trying to pass.
     * @param theLight The color of the light for human to pass.
     * @return true if human can pass or false otherwise.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        
        boolean allowedToPass = false;
        
        if (theTerrain.equals(myTerrain)) {
            allowedToPass = true;
            
        } else if ((myTerrain.equals(Terrain.GRASS)) 
                        && (theTerrain.equals(Terrain.STREET))) {
            allowedToPass = false;
            
        } else if ((myTerrain.equals(Terrain.STREET)) 
                        && (theTerrain.equals(Terrain.LIGHT))) {
            allowedToPass = true;
            
        } else if ((myTerrain.equals(Terrain.LIGHT)) 
                        && (theTerrain.equals(Terrain.STREET))) {
            allowedToPass = true;
            
        }
        
        return allowedToPass;

    }
    
    /**
     * Returns the direction human is going to move, based on the given
     * map of the neighboring terrain.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this object would like to move.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
        Direction newDirection = Direction.random();
        Terrain newTerrain = theNeighbors.get(newDirection);
        
        
        switch(myTerrain) {
            case GRASS:
                while (newTerrain != Terrain.GRASS) {
                    newDirection = Direction.random();
                    newTerrain = theNeighbors.get(newDirection);
                }
                break;
                
            case TRAIL:
                while (newTerrain != Terrain.TRAIL) {
                    newDirection = Direction.random();
                    newTerrain = theNeighbors.get(newDirection);
                }
                break;
            
            // STREET and LIGHT terrain considered the same
            case STREET:
            
            case LIGHT:
                while (newTerrain != Terrain.STREET && newTerrain != Terrain.LIGHT) {
                    newDirection = Direction.random();
                    newTerrain = theNeighbors.get(newDirection);
                }
                break;
            
            default: 
                break;
        }
        

        return newDirection;

    }

}
