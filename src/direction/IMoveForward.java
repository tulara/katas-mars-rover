package direction;

import rover.Position;

public interface IMoveForward {
    void moveForward(Position position);
    char symbol();
}
