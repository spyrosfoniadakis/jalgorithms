package KeyedElement;

public final class DoubleKeyedElement<T> implements Comparable<DoubleKeyedElement<T>>{

    private double key;
    private T value;

    public DoubleKeyedElement(final double key, final T value) {
        this.key = key;
        this.value = value;
    }

    public static <T> DoubleKeyedElement<T> from(final double key, final T value) {
        return new DoubleKeyedElement<>(key, value);
    }

    public double getKey() {
        return key;
    }

    public void setKey(final double key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public void increaseKeyBy(final double offset) {
        this.key += offset;
    }

    @Override
    public int compareTo(final DoubleKeyedElement<T> o) {
        return Double.compare(this.key, o.key);
    }

    @Override
    public boolean equals(final Object o) {
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
