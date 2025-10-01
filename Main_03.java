package example_03;

public class Main_03 {
    public static void main(String[] args) {
        Summator sm = getIntegerSummator(new int[] { 1, 2, 3 });
        System.out.println(sm.getSum());
    }
    public static Summator getIntegerSummator(int[] array) {
        Summator sm = () -> {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            return sum;
        };
        return sm;
    }
}
