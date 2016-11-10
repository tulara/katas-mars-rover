package direction;

import rover.Position;

public class West implements IMoveForward {
    @Override
    public void moveForward(Position position) {
        position.moveLeft();
    }

    @Override
    public char symbol() {
        return 'W';
    }
}
