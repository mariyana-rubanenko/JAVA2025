package example_04;

@FunctionalInterface
public interface Modificator<T> {
    public T modification(T element);
}
