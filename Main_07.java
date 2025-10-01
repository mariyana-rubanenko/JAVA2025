package example_07;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Main_07 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", "X");
        Cat cat2 = new Cat("Rusia", "Y");
        Cat[] cats = new Cat[] {cat1, cat2};

        Cat findCat = findCatByName("Barsikk", cats);
        System.out.println(findCat);

        if (findCat != null) {
            System.out.println(findCat);
        }

        //
        try {
            Cat findCat_1 = findByNameEx("Barsikk", cats);
            System.out.println(findCat_1);
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }

        //
        Optional<Cat> result = findCatByNameOptional("Barsikk", cats);
        if (result.isPresent()) {
            Cat cat = result.get();
            System.out.println(cat);
        }else {
            System.out.println("Cat not found");
        }

        //Если значение ссылки равно null и нужно вернуть ссылку
        //на существующий объект по умолчанию
        Cat defaultCat = new Cat("Default name", "Default color");
        Optional<Cat> result_1 = findCatByNameOptional("Barsikk", cats);
        Cat findCat_1 = result_1.orElse(defaultCat);
        System.out.println(findCat_1);

        //Если значение ссылки равно null и нужно сначала
        //создать объект по умолчанию и потом вернуть ссылку на
        //него
        Optional<Cat> result_2 = findCatByNameOptional("Barsikk", cats);
        Cat findCat_2 = result_2.orElseGet(Cat::new);

        //Если храниться null то генерировать исключение
        //NoSuchElementException
        Optional<Cat> result_3 = findCatByNameOptional("Barsikk", cats);
        Cat findCat_3 = result_3.orElseThrow();
        System.out.println(findCat_3);

        //Как получить имя кота?
        Optional<Cat> result_4 = findCatByNameOptional("Barsik", cats);
        Cat findCat_4 = result_4.get();
        String catName = findCat_4.getName();
        System.out.println(catName);

        //Map
        Optional<Cat> result_5 = findCatByNameOptional("Vaska", cats);
        String findCat_5 = result_5.map(a -> a.getName()).get();

        //or - если в result_6 храниться null, а
        //temp при этом не null, то result будет равен текущему temp.
        //Остальные значения при этом пропустяться.

        Optional<Cat> result_6 = Optional.ofNullable(cats[0]);
        for (Cat n : cats) {
            Optional<Cat> temp = Optional.ofNullable(n);
            result_6 = result_6.or(() -> temp);
        }
        System.out.println(result_6.get());

        //filter
        Optional<Cat> result_7 = Optional.ofNullable(cats[0]);
        for (Cat n : cats) {
            Optional<Cat> temp = Optional.ofNullable(n).filter(a -> a.startsWith("B"));
            result_7 = result_7.or(() -> temp);
        }
        System.out.println(result_7.get());

        //flatMap {Cat1, Cat2} -> {{Cat1}, {Cat2}}
        Optional<Cat> result_71 = Optional.ofNullable(cats[0]);
        for (Cat n : cats) {
            Optional<Cat> temp = Optional.ofNullable(n).flatMap(a -> Optional.of(a));
            result_71 = result_71.or(() -> temp);
        }
        System.out.println(result_71.get());


        //ifPresent
        Optional<Cat> result_8 = findCatByNameOptional("Vaska", cats);
        result_8.ifPresent(a -> System.out.println(a));

        //ifPresentOrElse
        Optional<Cat> result_9 = findCatByNameOptional("Vaska", cats);
        result_9.ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));

    }

    public static Cat findCatByName(String name, Cat[] cats) {
        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                return cat;
            }
        }
        return null;
    }

    public static Cat findByNameEx(String name, Cat[] cats) throws NoSuchElementException {
        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                return cat;
            }
        }
        throw new NoSuchElementException();
    }

    public static Optional<Cat> findCatByNameOptional(String name, Cat[] cats) {
        Cat result = null;
        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                result = cat;
                break;
            }
        }
        return Optional.ofNullable(result);
    }
}
