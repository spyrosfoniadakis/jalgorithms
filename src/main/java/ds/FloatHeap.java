package ds;

public interface FloatHeap {

    float peek();

    float extract();

    void heapify();

    /**
     * Increases or decreases (by adding a negative value) the initial value of the
     * element at <code>index</code>
     * @param index
     * @param value
     */
    void increaseElementValueBy(final int index, final float value);

    void insert(final float element);
}
