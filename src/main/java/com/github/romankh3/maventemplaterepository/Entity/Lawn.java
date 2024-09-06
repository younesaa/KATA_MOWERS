package com.github.romankh3.maventemplaterepository.Entity;

/**
 * The Lawn class represents a rectangular lawn where the mowers operate.
 * It defines the boundaries of the lawn with maximum x and y coordinates.
 */
public class Lawn {
    
    /**
     * The maximum x-coordinate of the lawn (top-right corner on the x-axis).
     */
    private int maxX;
    
    /**
     * The maximum y-coordinate of the lawn (top-right corner on the y-axis).
     */
    private int maxY;
    
    /**
     * Constructor to initialize the Lawn with its maximum boundaries.
     *
     * @param maxX The maximum x-coordinate (width) of the lawn.
     * @param maxY The maximum y-coordinate (height) of the lawn.
     */
    public Lawn(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Gets the maximum x-coordinate of the lawn.
     *
     * @return The maximum x-coordinate.
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * Gets the maximum y-coordinate of the lawn.
     *
     * @return The maximum y-coordinate.
     */
    public int getMaxY() {
        return maxY;
    }
}