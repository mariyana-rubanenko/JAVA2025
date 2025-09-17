import java.util.Iterator;
import java.util.NoSuchElementException;

class StringWrapper implements Iterable<Character> {
    private String text;

    public StringWrapper(String text) {
        this.text = text;
    }

    public Iterator<Character> iterator() {
        return new StringIterator();
    }

    private class StringIterator implements Iterator<Character> {
        private int start = 0;

        public boolean hasNext() {
            return start < text.length();
        }

        public Character next() {
            if (hasNext()) {
                return text.charAt(start++);
            }
            throw new NoSuchElementException();
        }
    }
}

public class Main_06 {
    public static void main(String[] args) {
        StringWrapper sw = new StringWrapper("Java course");
        for (Character c : sw) {
            System.out.println(c);
            for (Character d : sw) {
                System.out.print(d);
            }
            System.out.println();
        }
    }
}
