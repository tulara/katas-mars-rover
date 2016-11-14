package command;

import rover.Rover;

public interface Command {
    void execute(Rover rover);
}
