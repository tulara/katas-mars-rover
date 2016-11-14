package command;

import rover.Rover;

public class MoveForward implements Command {
    @Override
    public void execute(Rover rover) {
        rover.moveForward();
    }
}
