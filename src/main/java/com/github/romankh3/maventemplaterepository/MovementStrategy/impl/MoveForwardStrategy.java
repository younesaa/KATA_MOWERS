package com.github.romankh3.maventemplaterepository.MovementStrategy.impl;

import com.github.romankh3.maventemplaterepository.Entity.Mower;
import com.github.romankh3.maventemplaterepository.Entity.Position;
import com.github.romankh3.maventemplaterepository.MovementStrategy.MovementStrategy;

/**
 * The MoveForwardStrategy class implements the MovementStrategy interface
 * to define the behavior of moving the mower forward by one step in its current orientation.
 */
public class MoveForwardStrategy implements MovementStrategy{

    /**
     * Executes the movement strategy by moving the mower forward in its current orientation.
     * If the new position is within the lawn boundaries, the mower's position is updated.
     *
     * @param mower The mower object that will be moved forward based on its current orientation.
     */    
    @Override
    public void execute(Mower mower){
        Position newPosition = mower.getPosition().moveForward(mower.getOrientation());
        if (newPosition.isInLawn(mower.getLawn().getMaxX(), mower.getLawn().getMaxY())){
            mower.setPosition(newPosition);
        }
    }

}
