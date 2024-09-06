package com.github.romankh3.maventemplaterepository.Entity;

import com.github.romankh3.maventemplaterepository.MovementStrategy.MovementStrategy;
/**
 * The Mower class represents a lawnmower that can move on a rectangular lawn
 * and change its orientation based on commands. 
 * It holds the current position, orientation, and reference to the lawn it operates on.
 */
public class Mower {

    /**
     * The current position of the mower (x, y coordinates).
     */
    private Position position;

    /**
     * The current orientation of the mower (N, E, S, W).
     */
    private Orientation orientation;

    /**
     * The lawn that the mower is navigating on.
     */
    private Lawn lawn;

    /**
     * Constructor to initialize the Mower with its starting position, orientation, and the lawn.
     *
     * @param position    The initial position of the mower on the lawn.
     * @param orientation The initial orientation of the mower (N, E, S, W).
     * @param lawn        The lawn on which the mower is operating.
     */    
    public Mower(Position position,Orientation orientation,Lawn lawn){
        this.position = position;
        this.orientation = orientation;
        this.lawn = lawn;
    }

    /**
     * Sets a new position for the mower.
     *
     * @param position The new position of the mower.
     */    
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Sets a new orientation for the mower.
     *
     * @param orientation The new orientation of the mower (N, E, S, W).
     */   
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /**
     * Gets the current position of the mower.
     *
     * @return The current position as a {@link Position} object.
     */    
    public Position getPosition() {
        return position;
    }

    /**
     * Gets the current orientation of the mower.
     *
     * @return The current orientation as an {@link Orientation} object.
     */    
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Gets the lawn the mower is operating on.
     *
     * @return The {@link Lawn} object that represents the lawn.
     */    
    public Lawn getLawn() {
        return lawn;
    }

    /**
     * Executes a movement strategy. The strategy defines how the mower will move 
     * (e.g., turn left, turn right, or move forward).
     *
     * @param strategy The movement strategy to execute, implementing {@link MovementStrategy}.
     */
    public void executeMovement(MovementStrategy strategy) {
        strategy.execute(this);
    }

    /**
     * Returns the mower's current position and orientation as a formatted string.
     *
     * @return A string in the format "x y O", where x and y are the coordinates and O is the orientation.
     */    
    public String getPositionAndOrientation() {
        return this.position + " " + this.orientation;
    }
}
