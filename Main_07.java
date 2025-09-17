class Outer {
    private int id;

    public Outer(int id) {
        this.id = id;
    }

    public Outer() {
    }

    public class Inner {
        private String text;

        public Inner(String text) {
            this.text = text;
        }

        public String getTotalInfo() {
            return text + " " + id;
        }
    }
}

class InnerSubclass extends Outer.Inner {
    public InnerSubclass(Outer outer) {
        outer.super("Hello");
    }
}

public class Main_07 {
    public static void main(String[] args) {
        Outer outer = new Outer(11);
        InnerSubclass ins = new InnerSubclass(outer);
    }
}
