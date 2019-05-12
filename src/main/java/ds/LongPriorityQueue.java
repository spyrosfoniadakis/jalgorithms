package ds;

public interface LongPriorityQueue {

    long peek();

    long extract();

    void heapify();

    /**
     * Increases or decreases (by adding a negative value) the initial value of the
     * element at <code>index</code>
     * @param index
     * @param value
     */
    void increaseElementValueBy(int index, long value);

    void insert(long element);
}