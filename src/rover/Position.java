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
        updateCoordinates(this.coordinates.getX(), this.coordinates.getY() + 1);
    }

    public void moveDown(){
        updateCoordinates(this.coordinates.getX(), this.coordinates.getY() - 1);
    }

    public void moveLeft(){
        updateCoordinates(this.coordinates.getX() - 1, this.coordinates.getY());
    }


    public void moveRight(){
        updateCoordinates(this.coordinates.getX() + 1, this.coordinates.getY());
    }

    private void updateCoordinates(int x, int y) {
        Coordinates intendedPosition = new Coordinates(x, y);
        this.coordinates = plateau.getNewPosition(this.coordinates, intendedPosition);
    }
    
    @Override
    public String toString(){
        return String.format("%d %d", this.coordinates.getX(), this.coordinates.getY());
    }




}
