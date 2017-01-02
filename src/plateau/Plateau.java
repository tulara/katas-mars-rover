package plateau;

import rover.Position;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    int maxX;
    int maxY;
    List<Position> blockedPositions;

    public Plateau(int x, int y){
        this.maxX = x;
        this.maxY = y;
        blockedPositions = new ArrayList<>();
    }

    public boolean isInsideBoundary(Coordinates coordinates) {
        if(coordinates.getX() > this.maxX
                || coordinates.getX() < 0
                || coordinates.getY() > this.maxY
                || coordinates.getY() < 0 ){
            return false;
        }
        else return true;
    }

    public void updatePosition(Position oldPosition, Position newPosition){
        blockedPositions.remove(oldPosition);
        blockedPositions.add(newPosition);
    }

    public boolean coordinatesAreBlocked(Position position){
        return blockedPositions.contains(position);
    }

//    public Position getNewPosition(Position currentPosition, Position intendedPosition){
//
//        if(isInsideBoundary(intendedPosition)
//                & !coordinatesAreBlocked(intendedPosition)) {
//            updatePosition(currentPosition, intendedPosition);
//            return intendedPosition;
//        }
//        return currentPosition;
//    }
}
