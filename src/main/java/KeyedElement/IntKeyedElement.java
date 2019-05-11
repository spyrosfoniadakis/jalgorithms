package KeyedElement;

public class IntKeyedElement<T> implements Comparable<IntKeyedElement<T>>{

    private int key;
    private T value;

    public IntKeyedElement(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public static <T> IntKeyedElement<T> from(int key, T value) {
        return new IntKeyedElement<>(key, value);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void increaseKeyBy(int offset) {
        this.key += offset;
    }

    @Override
    public int compareTo(IntKeyedElement<T> o) {
        return Integer.compare(this.key, o.key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntKeyedElement)) return false;
        IntKeyedElement<?> that = (IntKeyedElement<?>) o;
        return key == that.key &&
                value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int value = 17;
        value += this.key * 19;
        value += this.value.hashCode() * 19;
        return value;
    }
}
