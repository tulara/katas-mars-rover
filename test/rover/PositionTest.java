import org.junit.Test;
import plateau.Plateau;
import rover.Position;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class PositionTest {
    private Position position;
    private Plateau plateau = new Plateau(5,5);

    @Test
    public void shouldPrintCoordinatesAndDirection(){
        position = new Position(0, 0, plateau);
        assertEquals("0 0", position.toString());
    }

    @Test
    public void shouldMoveYAxisUp(){
        position = new Position(0, 0, plateau);
        position.moveUp();
        assertEquals("0 1", position.toString());
    }

    @Test
    public void shouldMoveYAxisDown(){
        position = new Position(0, 1, plateau);
        position.moveDown();
        assertEquals("0 0", position.toString());
    }

    @Test
    public void shouldMoveXAxisRight(){
        position = new Position(0, 0, plateau);
        position.moveRight();
        assertEquals("1 0", position.toString());
    }

    @Test
    public void shouldMoveXAxisLeft(){
        position = new Position(1, 0, plateau);
        position.moveLeft();
        assertEquals("0 0", position.toString());
    }

    @Test
    public void shouldNotMoveIfNewPositionIsOutOfBounds(){
        position = new Position(0,0, plateau);
        position.moveDown();
        assertEquals("0 0", position.toString());
    }

    @Test
    public void shouldNotMoveIfNewPositionIsBlocked(){
        Position oldPosition = new Position(0, 1, plateau);
        Position newPosition = new Position(1, 1, plateau);
        plateau.updatePosition(oldPosition, newPosition);
        
        oldPosition.moveRight();
        assertEquals("0 1", oldPosition.toString());
    }

    @Test
    public void shouldBlockNewPosition(){
        Position oldPosition = new Position(0, 1, plateau);
        Position newPosition = new Position(1, 1, plateau);
        oldPosition.moveRight();

        assertTrue(plateau.coordinatesAreBlocked(newPosition));
    }
}
