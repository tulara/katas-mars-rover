import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    private Direction direction;

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
}