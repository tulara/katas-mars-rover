package direction;

import rover.Position;

public class East implements IMoveForward {
    @Override
    public void moveForward(Position position) {
        position.moveRight();
    }

    @Override
    public char symbol() {
        return 'E';
    }
}
