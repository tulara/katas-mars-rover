package rover;

import plateau.Plateau;

public class Position {
    private Plateau plateau;
    private int x;
    private int y;

    public Position(int x, int y, Plateau plateau){
        this.x = x;
        this.y = y;
        this.plateau = plateau;
    }

    public void moveUp(){
        int newY = this.y + 1;
        Position intendedPosition = new Position(this.x, newY, plateau);
        if(plateau.isInsideBoundary(this.x, newY)
                & !plateau.coordinatesAreBlocked(intendedPosition)){
            plateau.updatePosition(this, intendedPosition);
            this.y += 1;
        }
    }

    public void moveDown(){
        int newY = this.y - 1;
        Position intendedPosition = new Position(this.x, newY, plateau);
        if(plateau.isInsideBoundary(this.x, newY)
                & !plateau.coordinatesAreBlocked(intendedPosition)){
            plateau.updatePosition(this, intendedPosition);
            this.y -= 1;
        }
    }

    public void moveLeft(){
        int newX = this.x - 1;
        Position intendedPosition = new Position(newX, this.y, plateau);
        if(plateau.isInsideBoundary(newX, this.y)
                & !plateau.coordinatesAreBlocked(intendedPosition)){
            plateau.updatePosition(this, intendedPosition);
            this.x -= 1;
        }
    }

    public void moveRight(){
        //
        // this.coordinates = plateau.update(old, new);? mutates state?
        int newX = this.x + 1;
        Position intendedPosition= new Position(newX, this.y, plateau);
        if(this.plateau.isInsideBoundary(newX, this.y)
                & !plateau.coordinatesAreBlocked(intendedPosition)){
            plateau.updatePosition(this, intendedPosition);
            this.x += 1;
        }
    }

    @Override
    public String toString(){
        return String.format("%d %d", this.x, this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
