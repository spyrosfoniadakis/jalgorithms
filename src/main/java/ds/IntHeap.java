package ds;

public interface IntHeap {

    int peek();

    int extract();

    void heapify();

    /**
     * Increases or decreases (by adding a negative value) the initial value of the
     * element at <code>index</code>
     * @param index
     * @param value
     */
    void increaseElementValueBy(int index, int value);

    void insert(int element);
}
