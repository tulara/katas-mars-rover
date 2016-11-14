package command;

import rover.Rover;

public class CommandNotFound implements Command {
    @Override
    public void execute(Rover rover) {
        // does nothing or prints command not found
    }
}
