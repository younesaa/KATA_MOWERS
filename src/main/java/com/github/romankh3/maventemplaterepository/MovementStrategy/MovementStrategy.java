package com.github.romankh3.maventemplaterepository.MovementStrategy;

import com.github.romankh3.maventemplaterepository.Entity.Mower;

/**
 * The MovementStrategy interface defines a strategy for moving a mower.
 * Implementations of this interface should specify the behavior for a particular movement action.
 */
public interface MovementStrategy {

    /**
     * Executes the movement strategy on the given mower.
     * The specific movement behavior depends on the implementation of this method.
     *
     * @param mower The mower on which the movement strategy will be applied.
     */    
    void execute(Mower mower);
}
