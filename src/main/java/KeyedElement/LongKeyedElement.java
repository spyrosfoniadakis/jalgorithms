package KeyedElement;

public final class LongKeyedElement<T> implements Comparable<LongKeyedElement<T>>{

    private long key;
    private T value;

    public LongKeyedElement(final long key, final T value) {
        this.key = key;
        this.value = value;
    }

    public static <T> LongKeyedElement<T> from(final long key, final T value) {
        return new LongKeyedElement<>(key, value);
    }

    public long getKey() {
        return key;
    }

    public void setKey(final long key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public void increaseKeyBy(final long offset) {
        this.key += offset;
    }

    @Override
    public int compareTo(final LongKeyedElement<T> o) {
        return Long.compare(this.key, o.key);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LongKeyedElement)) return false;
        LongKeyedElement<?> that = (LongKeyedElement<?>) o;
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
