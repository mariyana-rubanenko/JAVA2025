package example_04;

public class Main_04 {
    public static void main(String[] args) {
//      Modificator<String> mod = (text) -> text.toUpperCase();
        Modificator<String> mod = Main_04::modify;
        System.out.println(mod.modification("hello"));
    }
    static String modify(String text) {
        return text.toUpperCase();
    }
}
