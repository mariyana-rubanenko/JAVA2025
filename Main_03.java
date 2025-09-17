import java.util.Arrays;

final class ImmutableVector {
    private final int[] coord;

    public ImmutableVector(int[] coord) {
        this.coord = new int[coord.length];
        for (int i = 0; i < coord.length; i++) {
            this.coord[i] = coord[i];
        }
    }

    public ImmutableVector() {
        this.coord = new int[2];
    }

    public final int[] getCoord() {
        int[] tempCoord = new int[coord.length];
        for (int i = 0; i < tempCoord.length; i++) {
            tempCoord[i] = this.coord[i];
        }
        return tempCoord;
    }
    @Override
    public String toString() {
        return "ImmutablePoint [coord=" + Arrays.toString(coord) + "]";
    }
}

public class Main_03 {
    public static void main(String[] args) {
        ImmutableVector point = new ImmutableVector(new int[] { 1, 1 });
        System.out.println(point);
        int[] coord = point.getCoord();
        coord[0] = 10;
        System.out.println(point);
    }
}
