package example_02;

public class MathUtilite {
    private static int[] arr = new int[] { 1, 2, 3 };
    private static Summator summator = () -> getSum(arr);
    public static void setArr(int[] arr) {
        MathUtilite.arr = arr;
    }
    public static Summator getSummator() {
        return summator;
    }
    public static int getSum(int[] array) {
        int s = 0;
        for (int element : array) {
            s += element;
        }
        return s;
    }
}
