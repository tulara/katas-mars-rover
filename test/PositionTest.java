import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void shouldPrintCoordinatesAndDirection(){
        assertEquals("0 0", new Position(0,0).toString());
    }
}
