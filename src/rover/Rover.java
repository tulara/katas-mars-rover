package rover;

import direction.Direction;

public class Rover {
    private Position position;
    private Direction facing;

    public Rover(int x, int y, char directionFacing) {
        this.position  = new Position(x,y);
        this.facing = new Direction(directionFacing);
    }

    public String reportPosition() {
        return this.position.toString() + " " + this.facing.toString();
    }

    public void rotateClockwise() {
        this.facing.rotateClockwise();
    }

    public void rotateAntiClockwise() {
        this.facing.rotateAntiClockwise();
    }

    public void moveForward() {
        this.facing.moveForward(this.position);
    }
}
