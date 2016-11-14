package direction;

import org.junit.Test;
import plateau.Plateau;
import rover.Position;

import static org.junit.Assert.assertEquals;

public class DirectionTest {
    private Direction direction;
    private Plateau plateau = new Plateau(5,5);

    @Test
    public void shouldPrintCurrentDirection(){
        direction = new Direction('N');
        assertEquals("N", direction.toString());
    }

    @Test
    public void shouldFaceEastWhenRotatingClockWiseFromNorth(){
        direction = new Direction('N');
        direction.rotateClockwise();
        assertEquals("E", direction.toString());
    }
    
    @Test
    public void shouldShouldFaceNorthWhenRotatingClockwiseFromWest(){
        direction = new Direction('W');
        direction.rotateClockwise();
        assertEquals("N", direction.toString());
    }

    @Test
    public void shouldFaceSouthWhenRotatingAntiClockwiseFromWest(){
        direction = new Direction('W');
        direction.rotateAntiClockwise();
        assertEquals("S", direction.toString());
    }

    @Test
    public void shouldFaceWestWhenRotatingAntiClockwiseFromNorth(){
        direction = new Direction('N');
        direction.rotateAntiClockwise();
        assertEquals("W", direction.toString());
    }

    @Test
    public void shouldAlterPositionUpWhenDirectionIsNorth(){
        direction = new Direction('N');
        Position position = new Position(0,0, plateau);
        direction.moveForward(position);
        assertEquals("0 1", position.toString());
    }

    @Test
    public void shouldAlterPositionDownWhenDirectionIsSouth(){
        direction = new Direction('S');
        Position position = new Position(0,1, plateau);
        direction.moveForward(position);
        assertEquals("0 0", position.toString());
    }

    @Test
    public void shouldAlterPositionLeftWhenDirectionIsEast(){
        direction = new Direction('E');
        Position position = new Position(0,0, plateau);
        direction.moveForward(position);
        assertEquals("1 0", position.toString());
    }

    @Test
    public void shouldAlterPositionRightWhenDirectionIsWest(){
        direction = new Direction('W');
        Position position = new Position(1,0, plateau);
        direction.moveForward(position);
        assertEquals("0 0", position.toString());
    }
}