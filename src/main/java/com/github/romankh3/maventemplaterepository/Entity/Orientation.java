package com.github.romankh3.maventemplaterepository.Entity;

/**
 * The Orientation enum represents the four cardinal directions (North, East, South, West)
 * and provides methods to rotate the direction left or right by 90 degrees.
 */
public enum Orientation {
    N, E, S, W;

    /**
     * Rotates the current orientation 90 degrees to the left.
     * For example:
     * - From North (N) to West (W)
     * - From West (W) to South (S)
     * - From South (S) to East (E)
     * - From East (E) to North (N)
     *
     * @return The new orientation after turning left.
     */
    public Orientation rotateLeft(){
        switch (this) {
            case N: return W;
            case W: return S;
            case S: return E;
            case E: return N;
        }
        throw new IllegalArgumentException("Invalid orientation");
    }

    /**
     * Rotates the current orientation 90 degrees to the right.
     * For example:
     * - From North (N) to East (E)
     * - From East (E) to South (S)
     * - From South (S) to West (W)
     * - From West (W) to North (N)
     *
     * @return The new orientation after turning right.
     */
    public Orientation rotateRight(){
        switch (this) {
            case N: return E;
            case E: return S;
            case S: return W;
            case W: return N;
        }
        throw new IllegalArgumentException("Invalid orientation");
    }
}
