package array2d;

/**
 * Simple Coordinate class used to test the {@code Array2D}.
 * 
 * @author Jesus R Mendoza
 */
public class Coor 
{
    private final int xCoor;
    private final int yCoor;
    
    public Coor(int x, int y) {
        xCoor = x;
        yCoor = y;
    }
    
    @Override
    public String toString() {
        return " (" + xCoor + ", " + yCoor + ")";
    }
}
