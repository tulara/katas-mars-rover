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

    public void RotateClockwise() {
        this.facing.rotateClockwise();
    }

    public void RotateAntiClockwise() {
        this.facing.rotateAntiClockwise();
    }

    public void moveForward() {
        this.position.moveInDirection(this.facing);
    }
}
