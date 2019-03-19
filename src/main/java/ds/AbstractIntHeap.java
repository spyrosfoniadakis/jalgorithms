package ds;

import utils.ArrayUtils;

public abstract class AbstractIntHeap extends AbstractPrimitiveArrayHeap{

    // TODO: Consider defining it in a separate file as a top-level interface so as to be accessible for the sorting
    //  utility classes as well
    /**
     * This interface although a Comparator it does not extends teh Comparator interface
     * because the latter is not defined for primitives and it would be better to avoid
     * any unnecessary boxing and unboxing. Both Comparator and IntHeapComparator define
     * the same method - boxing left aside - so nothing will actually be noticed by
     * anyone who is going to use it with a lambda expression.
     *
     * It could extend the IntBinaryOperator to maximize re-usability but it would confuse
     * those who will try to create an anonymous class or implement it some how in a class
     * based syntax.
     */
    @FunctionalInterface
    public interface IntHeapComparator {

        int compare(int a, int b);

        default boolean shouldSwap(int a, int b){
            return this.compare(a, b) > 0;
        }

    }

    protected int[] elements;
    private IntHeapComparator comparator;

    protected AbstractIntHeap(IntHeapComparator comparator){
        this(comparator, 10);
    }

    protected AbstractIntHeap(IntHeapComparator comparator, int capacity){
        this(new int[capacity], comparator);
    }

    protected AbstractIntHeap(int[] elements, IntHeapComparator comparator){
        this(elements, elements.length, comparator);
    }

    protected AbstractIntHeap(int[] elements, int size, IntHeapComparator comparator){
        this.elements = elements;
        this.comparator = comparator;
        this.setSize(size);
        this.build();
    }

    @Override
    public int getCapacity() {
        return elements.length;
    }

    public int peek(){
        return elements[0];
    }

    public int extract(){
        int extracted = elements[0];
        this.elements[0] = this.elements[elements.length-1];
        this.size--;
        this.heapify();
        return extracted;
    }

    protected void heapifyFrom(int index) {
        int leftIndex = getLeftChildIndexOf(index);
        int rightIndex= getRightChildIndexOf(index);
        int nextIndex = index;

        if(leftIndex == -1 && rightIndex == -1)
            return;

        System.out.println(String.format("heap size: %s, left: %s, right: %s, root: %s", this.getSize(), leftIndex, rightIndex, index));

        if (leftIndex != -1 && this.comparator.shouldSwap(elements[nextIndex], elements[leftIndex])){
            nextIndex = leftIndex;
        }
        if(rightIndex != -1 && this.comparator.shouldSwap(elements[nextIndex], elements[rightIndex])){
            nextIndex = rightIndex;
        }
        if(index != nextIndex){
            ArrayUtils.swap(elements, index, nextIndex);
            this.heapifyFrom(nextIndex);
        }
    }

    public void sort(){
        for(int i = this.getSize()-1; i>=0 ; i--){
            ArrayUtils.swap(this.elements, 0, i);
            this.setSize(this.getSize()-1);
            this.heapify();
        }
    }

    public abstract void build();

    /**
     * Increases or decreases (by adding a negative value) the initial value of the
     * element at <code>index</code>
     * @param index
     * @param value
     */
    public abstract void increaseElementValueBy(int index, int value);

    public void insert(int element){
        this.ensureInsertion(0);
        this.increaseElementValueBy(size-1, element);
    }

    protected void ensureInsertion(int element){
        if(this.size < this.elements.length){
            this.elements[this.size++] = element;
            return;
        }

        int[] newElements = new int[2*this.elements.length];
        for(int i=0; i< this.elements.length; i++){
            newElements[i]= elements[i];
        }
        newElements[this.size++] = element;
        this.elements = newElements;
    }

    protected IntHeapComparator getComparator(){
        return this.comparator;
    }
}
