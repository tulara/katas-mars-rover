import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    private Position position;

    @Test
    public void shouldPrintCoordinatesAndDirection(){
        position = new Position(0, 0);
        assertEquals("0 0", position.toString());
    }

    @Test
    public void shouldMoveYAxisUpWhenAskedToMoveForwardNorth(){
        position = new Position(0, 0);
        position.moveInDirection(new Direction('N'));
        assertEquals("0 1", position.toString());
    }

    @Test
    public void shouldMoveYAxisDownWhenAskedToMoveForwardSouth(){
        position = new Position(0, 1);
        position.moveInDirection(new Direction('S'));
        assertEquals("0 0", position.toString());
    }

    @Test
    public void shouldMoveXAxisLeftWhenAskedToMoveForwardEast(){
        position = new Position(0, 0);
        position.moveInDirection(new Direction('E'));
        assertEquals("1 0", position.toString());
    }

    @Test
    public void shouldMoveXAxisRightWhenAskedToMoveForwardWest(){
        position = new Position(1, 0);
        position.moveInDirection(new Direction('W'));
        assertEquals("0 0", position.toString());
    }
}
