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
        // passing plateau to position is weird
        Position oldPosition = new Position(0, 1, plateau);
        Position position = new Position(1, 1, plateau);
        plateau.updatePosition(oldPosition, position);
        assertTrue(plateau.coordinatesAreBlocked(position));
    }

    @Test
    public void OnlyBlockedPositionsShouldBeBlocked(){
        // passing plateau to position is weird
        Position oldPosition = new Position(0, 1, plateau);
        Position blockedPosition = new Position(1, 1, plateau);
        Position unblockedPosition = new Position(2, 2, plateau);
        plateau.updatePosition(oldPosition,blockedPosition);
        assertFalse(plateau.coordinatesAreBlocked(unblockedPosition));
    }

//    @Test
//    public void shouldReturnNewPositionThatIsInsideBoundariesAndNotBlocked(){
//
//
//        plateau.getNewPosition(oldPosition, intendedPosition);
//    }
}