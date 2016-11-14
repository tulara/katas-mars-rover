package command;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CommandParserTest {
    private CommandParser commandParser;
    private static Map<Character, Command> roverProtocol;
    static {
        roverProtocol = new HashMap<>();
        roverProtocol.put('L', new TurnLeft());
        roverProtocol.put('R', new TurnRight());
        roverProtocol.put('M', new MoveForward());
    }

    @Before
    public void setup(){
        commandParser = new CommandParser(roverProtocol);
    }

    @Test
    public void shouldParseLAsTurnLeft(){
        Command command = commandParser.Parse('L');
        assertTrue( command instanceof TurnLeft);
    }

    @Test
    public void shouldParseRAsTurnRight(){
        Command command = commandParser.Parse('R');
        assertTrue( command instanceof TurnRight);
    }

    @Test
    public void shouldParseMAsMoveForward(){
        Command command = commandParser.Parse('M');
        assertTrue(command instanceof MoveForward);
    }

    @Test
    public void shouldNoOpWhenCommandNotFound(){
        Command command = commandParser.Parse('N');
        assertTrue(command instanceof CommandNotFound);
    }
}