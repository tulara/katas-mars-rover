package plateau;
public class Plateau {
    int maxX;
    int maxY;

    public Plateau(int x, int y){
        this.maxX = x;
        this.maxY = y;
    }

    public boolean isInsideBoundary(int x, int y) {
        if(x > this.maxX
                || x < 0
                || y > this.maxY
                || y < 0 ){
            return false;
        }
        else return true;
    }
}
