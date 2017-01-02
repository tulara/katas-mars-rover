package rover;

import plateau.Coordinates;
import plateau.Plateau;

public class Position {
    private Plateau plateau;
    private Coordinates coordinates;

    public Position(int x, int y, Plateau plateau){
        this.coordinates = new Coordinates(x, y);
        this.plateau = plateau;
    }

    public void moveUp(){
        Coordinates intendedPosition = new Coordinates(this.coordinates.getX(), this.coordinates.getY() + 1);
        this.coordinates = plateau.getNewPosition(this.coordinates, intendedPosition);
    }

    public void moveDown(){
        Coordinates intendedPosition = new Coordinates(this.coordinates.getX(), this.coordinates.getY() - 1);
        this.coordinates = plateau.getNewPosition(this.coordinates, intendedPosition);
    }

    public void moveLeft(){
        Coordinates intendedPosition = new Coordinates(this.coordinates.getX() - 1, this.coordinates.getY());
        this.coordinates = plateau.getNewPosition(this.coordinates, intendedPosition);
    }

    public void moveRight(){
        Coordinates intendedPosition = new Coordinates(this.coordinates.getX() + 1, this.coordinates.getY());
        this.coordinates = plateau.getNewPosition(this.coordinates, intendedPosition);
    }

    @Override
    public String toString(){
        return String.format("%d %d", this.coordinates.getX(), this.coordinates.getY());
    }




}
