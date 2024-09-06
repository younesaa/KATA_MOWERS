package com.github.romankh3.maventemplaterepository.commandProcessor;

import java.util.HashMap;
import java.util.Map;

import com.github.romankh3.maventemplaterepository.Entity.Mower;
import com.github.romankh3.maventemplaterepository.MovementStrategy.MovementStrategy;
import com.github.romankh3.maventemplaterepository.MovementStrategy.impl.MoveForwardStrategy;
import com.github.romankh3.maventemplaterepository.MovementStrategy.impl.TurnLeftStrategy;
import com.github.romankh3.maventemplaterepository.MovementStrategy.impl.TurnRightStrategy;

/**
 * CommandProcessor method for processing the commands for the mower.
 * It uses a strategy design pattern to handle different types of movements (turn left, turn right, move forward).
 */
public class CommandProcessor {

    /**
     * A map that stores the available movement strategies. 
     * The key is the command character (e.g., 'G', 'D', 'A'), and the value is the corresponding movement strategy.
     */    
    private final Map<Character, MovementStrategy> strategyMap = new HashMap<>();
    
    /**
     * Constructor that initializes the movement strategies.
     * It maps the commands 'G' (left), 'D' (right), and 'A' (advance) to their respective strategies.
     */
    public CommandProcessor() {
        strategyMap.put('G', new TurnLeftStrategy());
        strategyMap.put('D', new TurnRightStrategy());
        strategyMap.put('A', new MoveForwardStrategy());
    }

    /**
     * Processes a sequence of commands for the given mower.
     *
     * @param mower    The mower object that will execute the movements.
     * @param commands A string representing the sequence of commands (e.g., "GAGAGAGAA").
     */
    public void processCmds(Mower mower,String commands){
        for (char command : commands.toCharArray()){
            MovementStrategy strategy = strategyMap.get(command);
            if (strategy != null) {
                mower.executeMovement(strategy);
            }
        }
        System.out.println(mower.getPositionAndOrientation());
    }
}
