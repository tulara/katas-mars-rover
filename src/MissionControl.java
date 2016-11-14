import command.*;
import direction.Direction;
import plateau.Plateau;
import rover.Position;
import rover.Rover;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MissionControl {

    private static Map<Character, Command> roverProtocol;
    static {
        roverProtocol = new HashMap<>();
        roverProtocol.put('L', new TurnLeft());
        roverProtocol.put('R', new TurnRight());
        roverProtocol.put('M', new MoveForward());
    }

    public static void main(String[] args) {
        CommandParser commandParser = new CommandParser(roverProtocol);
        Scanner in = new Scanner(System.in);
        int maxx = in.nextInt();
        int maxy = in.nextInt();
        Plateau plateau = new Plateau(maxx, maxy);

        int x = in.nextInt();
        int y = in.nextInt();
        String directionFacing  = in.next();

        Position initialPosition = new Position(x, y, plateau);
        Direction initialDirection = new Direction(directionFacing.charAt(0));
        Rover rover = new Rover(initialPosition, initialDirection, commandParser);

        String commands = in.next();
        rover.executeCommands(commands.toCharArray());
        System.out.print(rover.reportPosition());
    }
}
