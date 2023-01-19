package fr.publicis.sapient.mower5000xrturbo.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mower {

    private enum Direction {
        NORTH('N'),
        WEST('W'),
        SOUTH('S'),
        EAST('E');

        private final char letter;

        Direction(char letter) {
            this.letter = letter;
        }
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Mower.class);

    private final int xMax;
    private final int yMax;
    private int x;
    private int y;
    private Direction direction;

    public Mower(int xMax, int yMax, int x, int y, char initialDirection) {
        this.xMax = xMax;
        this.yMax = yMax;
        this.x = x;
        this.y = y;
        this.direction = switch (initialDirection) {
            case 'N' -> Direction.NORTH;
            case 'W' -> Direction.WEST;
            case 'S' -> Direction.SOUTH;
            case 'E' -> Direction.EAST;
            default -> throw new IllegalArgumentException(initialDirection + " is not a valid direction value");
        };
    }

    public void move(String movements) {
        for (char move : movements.toCharArray()) {
            if ('A' == move) moveForward();
            else changeDirection(move);
        }
    }

    private void moveForward() {
        switch (this.direction) {
            case NORTH -> {
                if (this.y < this.yMax) this.y ++;
            }
            case WEST -> {
                if (this.x > 0) this.x --;
            }
            case SOUTH -> {
                if (this.y > 0) this.y --;
            }
            case EAST -> {
                if (this.x < this.xMax) this.x ++;
            }
        }
    }

    private void changeDirection(char move) {
        switch (move) {
            case 'G' -> this.direction = turnLeft();
            case 'D' -> this.direction = turnRight();
            default -> LOGGER.warn("{} is not a valid move code", move);
        }
    }

    private Direction turnLeft() {
        return switch (this.direction) {
            case NORTH -> Direction.WEST;
            case WEST -> Direction.SOUTH;
            case SOUTH -> Direction.EAST;
            case EAST -> Direction.NORTH;
        };
    }

    private Direction turnRight() {
        return switch (this.direction) {
            case NORTH -> Direction.EAST;
            case WEST -> Direction.NORTH;
            case SOUTH -> Direction.WEST;
            case EAST -> Direction.SOUTH;
        };
    }

    @Override
    public String toString() {
        return this.x + " " + this.y + " " + this.direction.letter;
    }
}
