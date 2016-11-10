import org.junit.Before;
import org.junit.Test;
import plateau.Plateau;

import static org.junit.Assert.*;

public class PlateauTest {
    Plateau plateau;

    @Before
    public void setup() {
         plateau = new Plateau(5, 5);
    }

    @Test
    public void shouldReturnTrueIfPositionIsInsideBounds(){
        assertTrue(plateau.isInsideBoundary(1, 1));
    }

    @Test
    public void shouldReturnOutOfBoundsWhenNegative(){
        assertFalse(plateau.isInsideBoundary(-1, 0));
    }

    @Test
    public void shouldReturnOutOfBoundsWhenExceedsMaximumPosition(){
        assertFalse(plateau.isInsideBoundary(0, 6));
    }
}