package ds;

public interface DoubleHeap {

    double peek();

    double extract();

    double heapify();

    /**
     * Increases or decreases (by adding a negative value) the initial value of the
     * element at <code>index</code>
     * @param index
     * @param value
     */
    void increaseElementValueBy(int index, double value);

    void insert(double element);
}
