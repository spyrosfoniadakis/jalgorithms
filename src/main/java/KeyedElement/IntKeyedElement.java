package KeyedElement;

public final class IntKeyedElement<T> implements Comparable<IntKeyedElement<T>>{

    private int key;
    private T value;

    public IntKeyedElement(final int key, final T value) {
        this.key = key;
        this.value = value;
    }

    public static <T> IntKeyedElement<T> from(final int key, final T value) {
        return new IntKeyedElement<>(key, value);
    }

    public int getKey() {
        return key;
    }

    public void setKey(final int key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public void increaseKeyBy(final int offset) {
        this.key += offset;
    }

    @Override
    public int compareTo(final IntKeyedElement<T> o) {
        return Integer.compare(this.key, o.key);
    }

    @Override
    public boolean equals(final Object o) {
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
