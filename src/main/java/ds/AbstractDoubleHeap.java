package ds;

import comparator.DoubleComparator;
import utils.ArrayUtils;


public abstract class AbstractDoubleHeap extends AbstractPrimitiveArrayHeap {

    @FunctionalInterface
    public interface DoubleHeapComparator extends DoubleComparator {

        @Override
        int compare(double a, double b);

        @Override
        default boolean shouldSwap(double a, double b){
            return this.compare(a, b) > 0;
        }
    }

    protected double[] elements;
    private DoubleComparator comparator;

    protected AbstractDoubleHeap(DoubleComparator comparator){
        this(comparator, 10);
    }

    protected AbstractDoubleHeap(DoubleComparator comparator, int capacity){
        this(new double[capacity], comparator);
    }

    protected AbstractDoubleHeap(double[] elements, DoubleComparator comparator){
        this(elements, elements.length, comparator);
    }

    protected AbstractDoubleHeap(double[] elements, int size, DoubleComparator comparator){
        this.elements = elements;
        this.comparator = comparator;
        this.setSize(size);
        this.build();
    }

    @Override
    public final int getCapacity() {
        return elements.length;
    }

    public final double peek(){
        return elements[0];
    }

    public final double extract(){
        double extracted = elements[0];
        this.elements[0] = this.elements[elements.length-1];
        this.size--;
        this.heapify();
        return extracted;
    }

    protected final void heapifyFrom(int index) {
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

    public final void sort(){
        for(int i = this.getSize()-1; i>=0 ; i--){
            ArrayUtils.swap(this.elements, 0, i);
            this.setSize(this.getSize()-1);
            this.heapify();
        }
    }

    public final void build() {
        for(int i=Math.floorDiv(this.elements.length, 2); i>=0; i--){
            heapifyFrom(i);
        }
    }

    @Override
    public final void heapify() {
        heapifyFrom(0);
    }

    /**
     * Increases or decreases (by adding a negative value) the initial value of the
     * element at <code>index</code>
     * @param index
     * @param value
     */
    public abstract void increaseElementValueBy(int index, double value);

    public final void insert(double element){
        this.ensureInsertion(0);
        this.increaseElementValueBy(size-1, element);
    }

    protected final void ensureInsertion(double element){
        if(this.size < this.elements.length){
            this.elements[this.size++] = element;
            return;
        }

        double[] newElements = new double[2*this.elements.length];
        for(int i=0; i< this.elements.length; i++){
            newElements[i]= elements[i];
        }
        newElements[this.size++] = element;
        this.elements = newElements;
    }

    protected final DoubleComparator getComparator(){
        return this.comparator;
    }
}