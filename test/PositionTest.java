import org.junit.Test;
import rover.Position;

import static org.junit.Assert.assertEquals;

public class PositionTest {
    private Position position;

    @Test
    public void shouldPrintCoordinatesAndDirection(){
        position = new Position(0, 0);
        assertEquals("0 0", position.toString());
    }

    @Test
    public void shouldMoveYAxisUp(){
        position = new Position(0, 0);
        position.moveUp();
        assertEquals("0 1", position.toString());
    }

    @Test
    public void shouldMoveYAxisDown(){
        position = new Position(0, 1);
        position.moveDown();
        assertEquals("0 0", position.toString());
    }

    @Test
    public void shouldMoveXAxisRight(){
        position = new Position(0, 0);
        position.moveRight();
        assertEquals("1 0", position.toString());
    }

    @Test
    public void shouldMoveXAxisLeft(){
        position = new Position(1, 0);
        position.moveLeft();
        assertEquals("0 0", position.toString());
    }
}
