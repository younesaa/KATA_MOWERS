package com.github.romankh3.maventemplaterepository.Entity;

/**
 * The Position class represents a position on a 2D grid with x and y coordinates.
 * It provides methods to move the position forward based on orientation and check if the position is within the lawn boundaries.
 */
public class Position {

    /**
     * The x-coordinate of the position.
     */
    private int x;

    /**
     * The y-coordinate of the position.
     */
    private int y;

    /**
     * Constructor to initialize the position with x and y coordinates.
     *
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     */    
    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the position one step forward based on the given orientation.
     *
     * @param orientation The orientation indicating the direction to move (N, S, E, W).
     * @return A new Position object representing the new position after moving forward.
     */    
    public Position moveForward(Orientation orientation){
        switch (orientation) {
            case N: return new Position(x, y + 1);
            case S: return new Position(x, y - 1);
            case E: return new Position(x + 1, y);
            case W: return new Position(x - 1, y);
        }
        throw new IllegalArgumentException("Invalid orientation");
    }

    /**
     * Checks if the position is within the boundaries of the lawn.
     *
     * @param maxX The maximum x-coordinate of the lawn.
     * @param maxY The maximum y-coordinate of the lawn.
     * @return true if the position is within the lawn boundaries, false otherwise.
     */    
    public boolean isInLawn(int maxX, int maxY) {
        return ( x >= 0 && x <= maxX ) && ( y >= 0 && y <= maxY );
    }

    /**
     * Returns the position as a string in the format "x y".
     *
     * @return A string representation of the position.
     */    
    @Override
    public String toString() {
        return x + " " + y;
    }
}
