package example_07;

import java.util.Optional;

public class Main_07_01 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vaska", "Black");
        Optional<Cat> result = Optional.of(cat1);
        Optional<Cat> repCat1 = result.map(Main_07_01::repaintCat);
        Optional<Cat> repCat2 = result.flatMap(Main_07_01::repaintCatOptinal);
    }
    public static Cat repaintCat(Cat cat) {
        Cat repaintCat = new Cat(cat.getName(), "white");
        return repaintCat;
    }
    public static Optional<Cat> repaintCatOptinal(Cat cat) {
        Cat repaintCat = new Cat(cat.getName(), "white");
        Optional<Cat> repaintCatInOptional = Optional.of(repaintCat);
        return repaintCatInOptional;
    }
}
