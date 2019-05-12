package KeyedElement;

public class LongKeyedElement<T> implements Comparable<LongKeyedElement<T>>{

    private long key;
    private T value;

    public LongKeyedElement(long key, T value) {
        this.key = key;
        this.value = value;
    }

    public static <T> LongKeyedElement<T> from(long key, T value) {
        return new LongKeyedElement<>(key, value);
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void increaseKeyBy(long offset) {
        this.key += offset;
    }

    @Override
    public int compareTo(LongKeyedElement<T> o) {
        return Long.compare(this.key, o.key);
    }

    @Override
    public boolean equals(Object o) {
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
