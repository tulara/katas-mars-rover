import javafx.geometry.Pos;
import org.junit.Before;
import org.junit.Test;
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

    @Test
    public void shouldBlockAPositionOnThePlateau(){
        // passing plateau to position is weird
        Position oldPosition = new Position(0, 1, plateau);
        Position position = new Position(1, 1, plateau);
        plateau.blockPosition(position, oldPosition);
        assertTrue(plateau.positionIsBlocked(position));
    }

    @Test
    public void OnlyBlockedPositionsShouldBeBlocked(){
        // passing plateau to position is weird
        Position oldPosition = new Position(0, 1, plateau);
        Position blockedPosition = new Position(1, 1, plateau);
        Position unblockedPosition = new Position(2, 2, plateau);
        plateau.blockPosition(blockedPosition, oldPosition);
        assertFalse(plateau.positionIsBlocked(unblockedPosition));
    }
}