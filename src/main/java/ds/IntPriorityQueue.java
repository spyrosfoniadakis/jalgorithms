package ds;

public interface IntPriorityQueue {

    int peek();

    int extract();

    void heapify();

    /**
     * Increases or decreases (by adding a negative value) the initial value of the
     * element at <code>index</code>
     * @param index
     * @param value
     */
    void increaseElementValueBy(final int index, final int value);

    void insert(final int element);
}
