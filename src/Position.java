public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return String.format("%d %d", this.x, this.y);
    }

    public void moveInDirection(Direction facing) {
        //direction into enum? facing.NORTH
        String facingValue = facing.toString();
        if(facingValue.equals("N")){
            this.y += 1;
        }
        else if(facingValue.equals("S")){
            this.y -=1;
        }
        else if(facingValue.equals("E")){
            this.x += 1;
        }
        else if(facingValue.equals("W")){
            this.x -= 1;
        }
    }
}
