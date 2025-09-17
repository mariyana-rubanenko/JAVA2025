import java.util.Arrays;
import java.util.Comparator;

class OuterClassAnonymousCase {
    private String text;

    // создаем анонимный класс (класс без имени + его тело всегда идет после new [Интерфейс/Класс-родитель]())
    public Comparable<String> cmp = new Comparable<String>() {
        @Override
        public int compareTo(String o) {
            return OuterClassAnonymousCase.this.text.compareTo(o); // доступ к полю text внешнего класса OuterClassAnonymousCase
        }
    };

    public OuterClassAnonymousCase(String text) {
        super();
        this.text = text;
    }

}

public class Main_10 {
    public static void main(String[] args) {
        OuterClassAnonymousCase out1 = new OuterClassAnonymousCase("Java");
        OuterClassAnonymousCase out2 = new OuterClassAnonymousCase("Hello");


        String[] words = new String[]{"Hello", "Cat", "Home", "Student"};
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Arrays.sort(words, cmp);
        System.out.println(Arrays.toString(words));
    }
}
