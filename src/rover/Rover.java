package rover;

import command.Command;
import command.CommandParser;
import direction.Direction;

public class Rover {
    private Position position;
    private Direction facing;
    private CommandParser commandParser;

    public Rover(Position initialPosition, Direction initialDirection, CommandParser commandParser) {
        this.position  = initialPosition;
        this.facing = initialDirection;
        this.commandParser = commandParser;
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

    public void executeCommands(char[] instructionSet) {
        for(Character instruction : instructionSet){
            Command command = commandParser.Parse(instruction);
            command.execute(this);
        }
    }
}
