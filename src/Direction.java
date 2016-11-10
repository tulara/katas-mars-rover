public class Direction {
    private String directions = "NESW";
    private char direction;

    public Direction(char direction){
        this.direction = direction;
    }

    @Override
    public String toString(){
        return String.valueOf(this.direction);
    }

    public void rotateClockwise() {
        int currentIndex = directions.indexOf(this.direction);
        int nextIndex = (currentIndex + 1)% 4;
        this.direction = directions.charAt(nextIndex);
    }
}

