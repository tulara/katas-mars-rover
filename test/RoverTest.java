import org.junit.Before;
import org.junit.Test;
import plateau.Plateau;
import rover.Rover;

import static org.junit.Assert.*;

public class RoverTest {
    private Rover rover;
    private Plateau plateau = new Plateau(5,5);

    @Before
    public void setup(){
        rover = new Rover(0, 0, 'N', plateau);
    }

    @Test
    public void shouldRecieveInitialCoordinatesAndReportThem(){
        assertEquals("0 0 N", rover.reportPosition());
    }

    @Test
    public void shouldRecieveInstructionToRotateClockwise(){
        rover.rotateClockwise();
        assertEquals("0 0 E", rover.reportPosition());
    }

    @Test
    public void shouldRecieveInstructionToRotateAntiClockwise(){
        rover.rotateAntiClockwise();
        assertEquals("0 0 W", rover.reportPosition());
    }

    @Test
    public void shouldRecieveInstructionsToMoveForward(){
        rover.moveForward();
        assertEquals("0 1 N", rover.reportPosition());
    }
}