import command.*;
import direction.Direction;
import org.junit.Before;
import org.junit.Test;
import plateau.Plateau;
import rover.Position;
import rover.Rover;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RoverTest {
    private Rover rover;
    private Plateau plateau = new Plateau(5,5);

    @Before
    public void setup()
    {
        Map<Character,Command> roverProtocol = new HashMap<>();
        roverProtocol.put('L', new TurnLeft());
        roverProtocol.put('R', new TurnRight());
        roverProtocol.put('M', new MoveForward());
        CommandParser commandParser = new CommandParser(roverProtocol);

        Position initialPosition = new Position(0,0, plateau);
        Direction initialDirection = new Direction('N');
        rover = new Rover(initialPosition, initialDirection, commandParser);
    }

    @Test
    public void shouldRecieveInitialCoordinatesAndReportThem(){
        assertEquals("0 0 N", rover.reportPosition());
    }

    @Test
    public void shouldExecuteCommandToMoveForward(){
        char[] moveForward = new char[]{'M'};
        rover.executeCommands(moveForward);
        assertEquals("0 1 N", rover.reportPosition());
    }

    @Test
    public void shouldExecuteCommandToTurnRight(){
        char[] turnRight = new char[]{'R'};
        rover.executeCommands(turnRight);
        assertEquals("0 0 E", rover.reportPosition());
    }

    @Test
    public void shouldExecuteCommandToTurnLeft(){
        char[] turnLeft = new char[]{'L'};
        rover.executeCommands(turnLeft);
        assertEquals("0 0 W", rover.reportPosition());
    }
}