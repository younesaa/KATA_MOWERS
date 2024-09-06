package com.github.romankh3.maventemplaterepository.MovementStrategy.impl;

import com.github.romankh3.maventemplaterepository.Entity.Mower;
import com.github.romankh3.maventemplaterepository.MovementStrategy.MovementStrategy;

/**
 * The TurnLeftStrategy class implements the MovementStrategy interface
 * to define the behavior of turning the mower 90 degrees to the left.
 */
public class TurnLeftStrategy implements MovementStrategy {

    /**
     * Executes the turn-left strategy by rotating the mower's orientation 90 degrees to the left.
     * The new orientation of the mower is set based on the current orientation.
     *
     * @param mower The mower object whose orientation will be changed.
     */
    @Override
    public void execute(Mower mower) {
        mower.setOrientation(mower.getOrientation().rotateLeft());
    }
}
