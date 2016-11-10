package direction;

import rover.Position;

public class South implements IMoveForward {
    @Override
    public void moveForward(Position position) {
        position.moveDown();
    }

    @Override
    public char symbol() {
        return 'S';
    }
}
