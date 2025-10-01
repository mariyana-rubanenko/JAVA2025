package example_05;

import java.io.File;
import java.io.PrintWriter;

public class Main_05 {
    public static void main(String[] args) {
        Saver saver = (obj) ->{
            File file = new File("save.txt");
            PrintWriter pw = new PrintWriter(file);
            pw.println(obj.toString());
            pw.close();
        };
    }
}
