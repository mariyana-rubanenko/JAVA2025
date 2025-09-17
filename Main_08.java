import java.util.Comparator;

class OuterClass {
    private boolean reverse; // потом будем использовать данное поле во внутреннем классе

    public OuterClass() {
    }

    public OuterClass(boolean reverse) {
        this.reverse = reverse;
    }

    // метод, который содержит класс StringLengComparator => StringLengComparator - локальный внутренний класс
    public Comparator<String> getLengthComparator() {
        int n = 1; // effective-final, ее значение не меняется  в области видимости метода

//        n = 2;   - здесь будет ошибка компиляции, т.к. n уже не effective-final, ее значение изменили

        // цикл, который содержит класс Printer => Printer - локальный внутренний класс
        for (int i = 0; i < 10; i++) {
            class Printer {
                private String text;

                public Printer(String text) {
                    this.text = text;
                }

                public void print() {
                    System.out.println("***" + text + "***");
                    System.out.println(n);
                }
            }
            Printer prt = new Printer("Hello");
            prt.print();
        }

        class StringLengComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                int direction = 1;
                if (OuterClass.this.reverse) { // здесь берем поле reverse внешнего класса OuterClass
                    direction = -1;
                }
                return (o1.length() - o2.length()) * n * direction;
            }
        }
        return new StringLengComparator();
    }
}

public class Main_08 {
    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        System.out.println(oc.getLengthComparator().compare("Cat", "Lion"));
    }
}
