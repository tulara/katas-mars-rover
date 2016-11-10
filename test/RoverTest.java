import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoverTest {
    private Rover rover;

    @Before
    public void setup(){
        rover = new Rover(0, 0, 'N');
    }

    @Test
    public void shouldRecieveInitialCoordinatesAndReportThem(){
        assertEquals("0 0 N", rover.reportPosition());
    }

    @Test
    public void shouldRecieveInstructionToRotateClockwise(){
        rover.RotateClockwise();
        assertEquals("0 0 E", rover.reportPosition());
    }

    @Test
    public void shouldRecieveInstructionToRotateAntiClockwise(){
        rover.RotateAntiClockwise();
        assertEquals("0 0 W", rover.reportPosition());
    }
}