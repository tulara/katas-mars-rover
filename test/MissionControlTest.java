import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class MissionControlTest {
    private ByteArrayOutputStream output;

    @Before
    public void setup(){
        output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps);
    }

    @Test
    public void shouldMoveRoverAround(){
        String data = "5 5\r\n1 2 N\r\nLMLMLMLMM";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        MissionControl.main(new String[]{});
        assertEquals("1 3 N", output.toString());
    }

    @Test
    public void shouldNotMoveBeyondBoundaries(){
        String data = "5 5\r\n0 0 N\r\nLM";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        MissionControl.main(new String[]{});
        assertEquals("0 0 W", output.toString());
    }

    @After
    public void clear(){
        System.out.flush();
    }

}