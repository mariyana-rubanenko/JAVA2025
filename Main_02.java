package example_02;

public class Main_02 {
    public static void main(String[] args) {
        SimpleClass a = new SimpleClass(new int[] { 1, 2, 3 });
        Summator sm = a.getSummatorInstance();
        System.out.println(sm.getSum());
    }
}
