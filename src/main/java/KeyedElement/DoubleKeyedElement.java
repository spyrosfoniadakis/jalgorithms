package KeyedElement;

public class DoubleKeyedElement<T> implements Comparable<DoubleKeyedElement<T>>{

    private double key;
    private T value;

    public DoubleKeyedElement(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public static <T> DoubleKeyedElement<T> from(int key, T value) {
        return new DoubleKeyedElement<>(key, value);
    }

    public double getKey() {
        return key;
    }

    public void setKey(double key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void increaseKeyBy(double offset) {
        this.key += offset;
    }

    @Override
    public int compareTo(DoubleKeyedElement<T> o) {
        return Double.compare(this.key, o.key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoubleKeyedElement)) return false;
        DoubleKeyedElement<?> that = (DoubleKeyedElement<?>) o;
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
