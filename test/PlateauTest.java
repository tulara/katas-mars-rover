import org.junit.Before;
import org.junit.Test;
import plateau.Coordinates;
import plateau.Plateau;
import rover.Position;

import static org.junit.Assert.*;

public class PlateauTest {
    Plateau plateau;

    @Before
    public void setup() {
         plateau = new Plateau(5, 5);
    }

    @Test
    public void shouldReturnTrueIfPositionIsInsideBounds(){
        Coordinates coordinates = new Coordinates(1, 1);
        assertTrue(plateau.isInsideBoundary(coordinates));
    }

    @Test
    public void shouldReturnOutOfBoundsWhenNegative(){
        Coordinates coordinates = new Coordinates(-1, 0);
        assertFalse(plateau.isInsideBoundary(coordinates));
    }

    @Test
    public void shouldReturnOutOfBoundsWhenExceedsMaximumPosition(){
        Coordinates coordinates = new Coordinates(0, 6);
        assertFalse(plateau.isInsideBoundary(coordinates));
    }

    @Test
    public void shouldBlockAPositionOnThePlateau(){
        Coordinates oldPosition = new Coordinates(0, 1);
        Coordinates position = new Coordinates(1, 1);
        plateau.updatePosition(oldPosition, position);
        assertTrue(plateau.coordinatesAreBlocked(position));
    }

    @Test
    public void OnlyBlockedPositionsShouldBeBlocked(){
        Coordinates oldPosition = new Coordinates(0, 1);
        Coordinates blockedPosition = new Coordinates(1, 1);
        Coordinates unblockedPosition = new Coordinates(2, 2);

        plateau.updatePosition(oldPosition,blockedPosition);

        assertFalse(plateau.coordinatesAreBlocked(unblockedPosition));
    }

    @Test
    public void shouldReturnNewPositionThatIsInsideBoundariesAndNotBlocked(){
        Coordinates oldPosition = new Coordinates(0,0);
        Coordinates newPosition = new Coordinates(0, 1);

        Coordinates validPosition = plateau.getNewPosition(oldPosition, newPosition);
        assertEquals(newPosition, validPosition);
    }
}