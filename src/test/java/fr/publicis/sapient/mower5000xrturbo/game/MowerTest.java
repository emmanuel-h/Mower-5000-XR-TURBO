package fr.publicis.sapient.mower5000xrturbo.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerTest {

    @Test
    void whenMowerGetsTheInstructionA_thenItShouldMoveForward() {
        var mower = new Mower(2, 2, 1, 1, 'N');
        mower.move("A");
        assertEquals("1 2 N", mower.toString());


        mower = new Mower(2, 2, 1, 1, 'W');
        mower.move("A");
        assertEquals("0 1 W", mower.toString());


        mower = new Mower(2, 2, 1, 1, 'S');
        mower.move("A");
        assertEquals("1 0 S", mower.toString());


        mower = new Mower(2, 2, 1, 1, 'E');
        mower.move("A");
        assertEquals("2 1 E", mower.toString());
    }

    @Test
    void whenMowerGetsTheInstructionD_thenItShouldTurnRight() {
        var mower = new Mower(2, 2, 1, 1, 'N');
        mower.move("D");
        assertEquals("1 1 E", mower.toString());


        mower = new Mower(2, 2, 1, 1, 'W');
        mower.move("D");
        assertEquals("1 1 N", mower.toString());


        mower = new Mower(2, 2, 1, 1, 'S');
        mower.move("D");
        assertEquals("1 1 W", mower.toString());


        mower = new Mower(2, 2, 1, 1, 'E');
        mower.move("D");
        assertEquals("1 1 S", mower.toString());
    }

    @Test
    void whenMowerGetsTheInstructionG_thenItShouldTurnLeft() {
        var mower = new Mower(2, 2, 1, 1, 'N');
        mower.move("G");
        assertEquals("1 1 W", mower.toString());


        mower = new Mower(2, 2, 1, 1, 'W');
        mower.move("G");
        assertEquals("1 1 S", mower.toString());


        mower = new Mower(2, 2, 1, 1, 'S');
        mower.move("G");
        assertEquals("1 1 E", mower.toString());


        mower = new Mower(2, 2, 1, 1, 'E');
        mower.move("G");
        assertEquals("1 1 N", mower.toString());
    }

    @Test
    void whenMoverMoveBeyondLimits_thenItShouldNotMove() {
        var mower = new Mower(2, 2, 2, 2, 'N');
        mower.move("A");
        assertEquals("2 2 N", mower.toString());

        mower = new Mower(2, 2, 0, 0, 'W');
        mower.move("A");
        assertEquals("0 0 W", mower.toString());

        mower = new Mower(2, 2, 0, 0, 'S');
        mower.move("A");
        assertEquals("0 0 S", mower.toString());

        mower = new Mower(2, 2, 2, 2, 'E');
        mower.move("A");
        assertEquals("2 2 E", mower.toString());
    }
}
