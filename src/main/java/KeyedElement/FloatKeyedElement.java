package KeyedElement;

public final class FloatKeyedElement<T> implements Comparable<FloatKeyedElement<T>>{

    private float key;
    private T value;

    public FloatKeyedElement(final float key, final T value) {
        this.key = key;
        this.value = value;
    }

    public static <T> FloatKeyedElement<T> from(final float key, final T value) {
        return new FloatKeyedElement<>(key, value);
    }

    public float getKey() {
        return key;
    }

    public void setKey(final float key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public void increaseKeyBy(final float offset) {
        this.key += offset;
    }

    @Override
    public int compareTo(final FloatKeyedElement<T> o) {
        return Float.compare(this.key, o.key);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof FloatKeyedElement)) return false;
        FloatKeyedElement<?> that = (FloatKeyedElement<?>) o;
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
