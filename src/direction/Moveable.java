package direction;

import rover.Position;

public interface Moveable {
    void moveForward(Position position);
    char symbol();
}
