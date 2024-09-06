package com.github.romankh3.maventemplaterepository.movementStrategyTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.github.romankh3.maventemplaterepository.Entity.Lawn;
import com.github.romankh3.maventemplaterepository.Entity.Mower;
import com.github.romankh3.maventemplaterepository.Entity.Orientation;
import com.github.romankh3.maventemplaterepository.Entity.Position;
import com.github.romankh3.maventemplaterepository.MovementStrategy.MovementStrategy;
import com.github.romankh3.maventemplaterepository.MovementStrategy.impl.MoveForwardStrategy;

public class MoveForwardStrategyTest {

    @Test
    public void testMoveForward_true() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(new Position(1, 2), Orientation.N, lawn);
        MovementStrategy strategy = new MoveForwardStrategy();
        strategy.execute(mower);
        assertEquals("1 3 N", mower.getPositionAndOrientation());
    }

    @Test
    public void testMoveForward_False() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(new Position(1, 2), Orientation.N, lawn);
        MovementStrategy strategy = new MoveForwardStrategy();
        strategy.execute(mower);
        assertNotEquals("1 2 N", mower.getPositionAndOrientation());
    }

    @Test
    public void testMoveForwardOutBounds_True() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(new Position(5, 5), Orientation.N, lawn);
        MovementStrategy strategy = new MoveForwardStrategy();
        strategy.execute(mower);
        assertEquals("5 5 N", mower.getPositionAndOrientation());
    }

    @Test
    public void testMoveForwardOutBounds_False() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(new Position(1, 2), Orientation.N, lawn);
        MovementStrategy strategy = new MoveForwardStrategy();
        strategy.execute(mower);
        assertNotEquals("5 6 N", mower.getPositionAndOrientation());
    }
}
