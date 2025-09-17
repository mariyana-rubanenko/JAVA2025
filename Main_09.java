class OuterClassStaticCase {
    private String text;
    private static int number = 10;
    public OuterClassStaticCase(String text) {
        super();
        this.text = text;
    }

    // NestedClass - статический вложенный класс, является членом класса, а значит может иметь любые модификаторы доступа
    public static class NestedClass {
        private String word;
        public static class NestedClass {
            private String word;

            //NestedClass - внутренний класс
            public NestedClass(String word) {
                super();
                this.word = word;
            }
            public void printText() {
                System.out.println(word + " " + number); // number - static, поэтому имеем доступ к ней во внешнем классе независимо от модификатора доступа
            }
            public void printTextUseOutVariable(OuterClassStaticCase oc) {
                System.out.println(word + " " + number + oc.text); // доступ к не static полю text внешнего класса возможен только через создание объекта внешнего класса
            }
        }
        //NestedClass - внутренний класс
        public NestedClass(String word) {
            super();
            this.word = word;
        }
        public void printText() {
            System.out.println(word + " " + number); // number - static, поэтому имеем доступ к ней во внешнем классе независимо от модификатора доступа
        }
        public void printTextUseOutVariable(OuterClassStaticCase oc) {
            System.out.println(word + " " + number + oc.text); // доступ к не static полю text внешнего класса возможен только через создание объекта внешнего класса
        }
    }
}

public class Main_09 {
    public static void main(String[] args) {
        OuterClassStaticCase.NestedClass on = new OuterClassStaticCase.NestedClass("Hello");
        on.printText();

        OuterClassStaticCase oc = new OuterClassStaticCase(" world");
        on.printTextUseOutVariable(oc);
    }
}
