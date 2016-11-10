package rover;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveUp(){
        this.y += 1;
    }

    public void moveDown(){
        this.y -=1;
    }

    public void moveLeft(){
        this.x -= 1;
    }

    public void moveRight(){
        this.x += 1;
    }

    @Override
    public String toString(){
        return String.format("%d %d", this.x, this.y);
    }
}
