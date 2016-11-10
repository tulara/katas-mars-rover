import rover.Rover;

import java.util.Scanner;

public class MissionControl {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        String directionFacing  = in.next();
        Rover rover = new Rover(x, y, directionFacing.charAt(0));

        String instructions = in.next();
        issueInstructions(rover, instructions.toCharArray());
        System.out.print(rover.reportPosition());
    }

    private static void issueInstructions(Rover rover, char[] instructionSet){
        for (char c: instructionSet){
            if(c == 'L'){
                rover.rotateAntiClockwise();
            }
            else if (c == 'R'){
                rover.rotateClockwise();
            }
            else if (c == 'M'){
                rover.moveForward();
            }
        }
    }
}
