package direction;

import rover.Position;

import java.util.HashMap;
import java.util.Map;

public class Direction {
    private String directions = "NESW";
    private Map<Character, Moveable> moveables;
    private Moveable direction;

    public Direction(char direction){
        moveables = new HashMap<>();
        moveables.put('N', new North());
        moveables.put('E', new East());
        moveables.put('S', new South());
        moveables.put('W', new West());
        updateMovingDirection(direction);
    }

    private void updateMovingDirection(char direction) {
        this.direction = moveables.get(direction);
    }

    @Override
    public String toString(){
        return String.valueOf(this.direction.symbol());
    }

    public void rotateClockwise() {
        int currentIndex = directions.indexOf(this.direction.symbol());
        int nextIndex = (currentIndex + 1)% 4;
        updateMovingDirection(directions.charAt(nextIndex));
    }

    public void rotateAntiClockwise() {
        int currentIndex = directions.indexOf(this.direction.symbol());
        if(currentIndex == 0){currentIndex = 4;}
        int nextIndex = (currentIndex - 1);
        updateMovingDirection(directions.charAt(nextIndex));
    }

    public void moveForward(Position position) {
        this.direction.moveForward(position);
    }
}

