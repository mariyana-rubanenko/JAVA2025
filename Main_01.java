class MutablePoint {
    private double x;
    private double y;
    public MutablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "MutablePoint [x=" + x + ", y=" + y + "]";
    }
}

public class Main_01 {
    public static void main(String[] args) {
        MutablePoint point1 = new MutablePoint(1, 1);
        point1.setX(3);
        System.out.println(point1);
    }
}
