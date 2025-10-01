package example_06;

import java.util.Arrays;

public class Main_06 {
    public static void main(String[] args) {
        String[] names = new String[] { "Anna", "Ira", "Alexander", "Katia" };
        Arrays.sort(names, (a, b) -> a.length() - b.length());

        System.out.println(Arrays.toString(names));
    }
}
