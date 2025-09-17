import java.util.concurrent.ArrayBlockingQueue;

abstract class Function {
    public abstract int function(int n);

    public int calculate(int begin, int end) {
        return function(end) - function(begin);
    }
}

class MathFunction {
    private class Square extends Function {
        @Override
        public int function(int n) {
            return n * n;
        }
    }

    private class Cube extends Function {
        @Override
        public int function(int n) {
            return n * n * n;
        }
    }

    public Function getSquare() {
        return new Square();
    }

    public Function getCube() {
        return new Cube();
    }
}

public class Main_05 {
    public static void main(String[] args) {
        MathFunction mf = new MathFunction();
        System.out.println(calculate(mf.getSquare(), 1, 4));
        System.out.println(calculate(mf.getCube(), 1, 4));
    }

    public static int calculate(Function fun, int begin, int end) {
        return fun.calculate(begin, end);
    }
}
