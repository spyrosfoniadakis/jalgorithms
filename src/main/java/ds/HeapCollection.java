package ds;

public interface HeapCollection {

    int getSize();

    int getParentIndexOf(int index);

    int getLeftChildIndexOf(int index);

    int getRightChildIndexOf(int index);

    void heapify();

    boolean isEmpty();

}
