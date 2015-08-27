/*
 * TCSS 305 
 * 
 * Assignment 3 - easy street.
 */
package model;

/**
 * Represents default behavior for Vehicle subclasses.
 * 
 * @author Alex Terikov teraliv@uw.edu
 * @version April 23, 2015
 *
 */
public abstract class AbstractVehicle implements Vehicle {
    
    //instance fields
    
    /** The X coordinate a vehicle. */
    private int myX;
    
    /** The Y coordinate of a vehicle. */
    private int myY;
    
    /** The initial X coordinate of a vehicle. */
    private final int myInitialX;
    
    /** The initial Y coordinate of a vehicle. */
    private final int myInitialY;
    
    /** The direction of a vehicle. */
    private Direction myDirection;
    
    /** The initial direction of a vehicle. */
    private final Direction myInitialDirection;
    
    /** The death time of a vehicle. */
    private final int myDeathTime;
    
    /** The live status of a vehicle (live or dead). */
    private boolean myAlive;
    
    /** The number of pokes. */
    private int myPoke;
    
    
    /**
     * Construct a vehicle with given x, y coordinates and direction.
     * 
     * @param theX  The X coordinate of a vehicle.
     * @param theY  The Y coordinate of a vehicle.
     * @param theDir The Direction of a vehicle to travel.
     * @param theDeathTime The death time of a vehicle.
     */
    protected AbstractVehicle(final int theX, final int theY, 
                           final Direction theDir, final int theDeathTime) {
        myX = theX;
        myY = theY;
        myInitialX = theX;
        myInitialY = theY;
        myDirection = theDir;
        myDeathTime = theDeathTime;
        myInitialDirection = theDir;
        myAlive = true;
    }
    
    /**
     * A query that notifies this vehicle that it has collided with the 
     * given other Vehicle object.
     * 
     * @param theOther the number of updates.
     */
    @Override
    public void collide(final Vehicle theOther) {
        
        if ((isAlive() && theOther.isAlive()) && (myDeathTime > theOther.getDeathTime())) {
            myAlive = false;
        
        } else if ((isAlive() && theOther.isAlive()) 
                        && (myDeathTime < theOther.getDeathTime())) {
            myAlive = true;
        
        } else if ((isAlive() && theOther.isAlive()) 
                        && (myDeathTime == theOther.getDeathTime())) {
            myAlive = true;
        }
    }

    /**
     * A query that returns the number of updates between 
     * this vehicle's death and it should revive.
     * 
     * @return the death time.
     */
    @Override
    public int getDeathTime() {
        
        return myDeathTime;
    }
    
    /**
     * A query that returns the file name of a vehicle.
     * 
     *  @return the name of the file.
     */
    @Override
    public String getImageFileName() {
        
        final StringBuilder fileName = new StringBuilder();
        fileName.append(getClass().getSimpleName().toLowerCase());
        
        if (myAlive) {
            fileName.append(".gif");
        
        } else if (!myAlive) {
            fileName.append("_dead.gif");
        }
        
        return fileName.toString();
    }
    
    /**
     * A query that returns the direction this vehicle is facing.
     * 
     * @return current direction.
     */
    @Override
    public Direction getDirection() {
        
        return myDirection;
    }
    
    /**
     * Command that set the X coordinate of this vehicle.
     * 
     * @return the X coordinate.
     */
    @Override
    public int getX() {
        
        return myX;
    }
    
    /**
     * Command that set the Y coordinate of this vehicle.
     * 
     * @return the Y coordinate.
     */
    @Override
    public int getY() {
        
        return myY;
    }
    
    /**
     * A query that returns whether this vehicle is alive.
     * 
     * @return true if the object is alive, false otherwise.
     */
    @Override
    public boolean isAlive() {
        
        return myAlive;
    }
    
    /**
     * Called by the UI to notify a dead vehicle that 1 movement round has
     * passed, so that it will become 1 move closer to revival.
     */
    @Override
    public void poke() {
        
        if (isAlive()) {
            myAlive = true;
        
        } else if (myPoke == myDeathTime) {
            myAlive = true;
            setDirection(Direction.random());
            myPoke = 0;
        
        } else if (myPoke < myDeathTime) {
            myPoke++;
        }
    }
    
    /**
     * Moves this vehicle back to its initial position.
     */
    @Override
    public void reset() {
        
        setX(myInitialX);
        setY(myInitialY);
        setDirection(myInitialDirection);
        myAlive = true;
        myPoke = 0;
    }
    
    /**
     * Sets this object's facing direction to the given value.
     * 
     * @param theDir The new direction.
     */
    @Override
    public void setDirection(final Direction theDir) {
        
        myDirection = theDir;
    }
    
    /**
     * Sets this object's x-coordinate to the given value.
     * 
     * @param theX The new x-coordinate.
     */
    @Override
    public void setX(final int theX) {
        
        myX = theX;
    }
    
    /**
     * Sets this object's y-coordinate to the given value.
     * 
     * @param theY The new y-coordinate.
     */
    @Override
    public void setY(final int theY) {
        
        myY = theY;
    }
    
    /** {@inheritDoc} */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(100);
        
        sb.append(getClass().getSimpleName());
        sb.append(": [Direction: ");
        sb.append(myDirection);
        sb.append("] [Pokes: ");
        sb.append(myPoke);
        sb.append("] ");
        
        return sb.toString();
    }

}
