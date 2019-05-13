package ds;

public interface LongHeap {

    long peek();

    long extract();

    void heapify();

    /**
     * Increases or decreases (by adding a negative value) the initial value of the
     * element at <code>index</code>
     * @param index
     * @param value
     */
    void increaseElementValueBy(final int index, final long value);

    void insert(final long element);
}
