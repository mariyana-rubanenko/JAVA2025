package example_02;

import java.util.Optional;

public class SimpleClass {
    private int[] arr;

    private Summator sm = () -> {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    };

    public SimpleClass(int[] arr) {
        super();
        this.arr = arr;
    }

    public Summator getSummatorInstance() {
        return this.sm;
    }
}
