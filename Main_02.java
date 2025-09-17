final class SimpleImmutablePoint {
    private final double x;
    private final double y;
    public SimpleImmutablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public SimpleImmutablePoint() {
        this.x = 0;
        this.y = 0;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public SimpleImmutablePoint setX(double x) {
        return new SimpleImmutablePoint(x, y);
    }
    public SimpleImmutablePoint setY(double y) {
        return new SimpleImmutablePoint(x, y);

    }

    @Override
    public String toString() {
        return "ImmuatablePoint [x=" + x + ", y=" + y + "]";
    }
}

public class Main_02 {
    public static void main(String[] args) {
        SimpleImmutablePoint point1 = new SimpleImmutablePoint(2, 4);
        SimpleImmutablePoint point2 = point1.setX(4);
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point1 == point2);

//        (2,4) -> (4,4)
    }
}
