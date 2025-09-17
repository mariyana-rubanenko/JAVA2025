import java.util.Arrays;
import java.util.Comparator;

class OuterClassAnonymousCase2 {
    private String text;
    //
    public Comparable<String> cmp = new Comparable<String>() {
        public int direction = 1; // effective-final, т.е. по факту не изменяется

        //у анонимных классов нет конструктора, т.к. явно нет имени класса
        // (неявно оно есть и его можно получить средствами Reflection API)
        //обойти проблему отсутствия конструкторов может наличие блоков инициализации
        public int direction2;

        {
            direction2 = 1;
        }

        public int compareTo(String o) {
            return (OuterClassAnonymousCase2.this.text.length() - o.length()) * direction;
            // используем внешнее поле text
        }
    };

    public OuterClassAnonymousCase2(String text) {
        this.text = text;
    }

    public int compareLength(String text) {
        //int temp = cmp.direction;     - здесь ошибка компиляции,
        // т.к. direction недоступна за пределами анонимного класса
        return cmp.compareTo(text);
    }
}

public class Main_11 {
    public static void main(String[] args) {
        String[] words = new String[]{"Hello", "Cat", "Home", "Student"};
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        System.out.println(cmp.getClass().getName()); // получаем
        // имя анонимного класса через Reflection API (получим Main_11$1)
        Arrays.sort(words, cmp);
        System.out.println(Arrays.toString(words));
    }
}
