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
    void increaseElementValueBy(int index, float value);

    void insert(float element);
}
