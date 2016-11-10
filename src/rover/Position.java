package rover;

import plateau.Plateau;

public class Position {
    private int x;
    private int y;
    private Plateau boundary;

    public Position(int x, int y, Plateau plateau){
        this.x = x;
        this.y = y;
        this.boundary = plateau;
    }

    public void moveUp(){
        int newY = this.y + 1;
        if(this.boundary.isInsideBoundary(this.x, newY)){
            this.y += 1;
        }
    }

    public void moveDown(){
        int newY = this.y - 1;
        if(this.boundary.isInsideBoundary(this.x, newY)){
            this.y -= 1;
        }
    }

    public void moveLeft(){
        int newX = this.x - 1;
        if(this.boundary.isInsideBoundary(newX, this.y)){
            this.x -= 1;
        }
    }

    public void moveRight(){
        int newX = this.x + 1;
        if(this.boundary.isInsideBoundary(newX, this.y)){
            this.x += 1;
        }
    }

    @Override
    public String toString(){
        return String.format("%d %d", this.x, this.y);
    }
}
