package direction;

import rover.Position;

public class Direction {
    private String directions = "NESW";
    private IMoveForward direction;

    public Direction(char direction){
        updateMovingDirection(direction);
    }

    private void updateMovingDirection(char direction) {
        if(direction == 'N'){
            this.direction = new North();
        }
        else if(direction == 'S'){
            this.direction = new South();
        }
        else if(direction == 'E'){
            this.direction = new East();
        }
        else if(direction == 'W'){
            this.direction = new West();
        }
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

