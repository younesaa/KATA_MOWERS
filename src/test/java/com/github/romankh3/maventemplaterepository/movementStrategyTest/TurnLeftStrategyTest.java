package com.github.romankh3.maventemplaterepository.movementStrategyTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.github.romankh3.maventemplaterepository.Entity.Lawn;
import com.github.romankh3.maventemplaterepository.Entity.Mower;
import com.github.romankh3.maventemplaterepository.Entity.Orientation;
import com.github.romankh3.maventemplaterepository.Entity.Position;
import com.github.romankh3.maventemplaterepository.MovementStrategy.MovementStrategy;
import com.github.romankh3.maventemplaterepository.MovementStrategy.impl.TurnLeftStrategy;

public class TurnLeftStrategyTest {
    @Test
    public void testTurnLeftFromNorth_True() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(new Position(1, 2), Orientation.N, lawn);
        MovementStrategy strategy = new TurnLeftStrategy();
        strategy.execute(mower);
        assertEquals("1 2 W", mower.getPositionAndOrientation());
    }

    @Test
    public void testTurnLeftFromNorth_False() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(new Position(1, 2), Orientation.N, lawn);
        MovementStrategy strategy = new TurnLeftStrategy();
        strategy.execute(mower);
        assertNotEquals("1 2 E", mower.getPositionAndOrientation());
    }
}
