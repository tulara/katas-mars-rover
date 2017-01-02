import javafx.geometry.Pos;
import org.junit.Test;
import plateau.Coordinates;
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
        plateau.updatePosition(new Coordinates(0,0), new Coordinates(1,0));

        Position position = new Position(0, 0, plateau);
        position.moveRight();
        assertEquals("0 0", position.toString());
    }

    @Test
    public void shouldBlockNewPosition(){
        Position oldPosition = new Position(0, 1, plateau);
        Coordinates newPosition = new Coordinates(1, 1);
        oldPosition.moveRight();

        assertTrue(plateau.coordinatesAreBlocked(newPosition));
    }
}
