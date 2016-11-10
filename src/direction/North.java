package direction;

import rover.Position;

public class North implements Moveable {

    @Override
    public void moveForward(Position position) {
        position.moveUp();
    }

    @Override
    public char symbol() {
        return 'N';
    }
}
