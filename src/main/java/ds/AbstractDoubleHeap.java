package ds;

import utils.ArrayUtils;

/**
 * It models a Heap conatining double elements alone of teh double primitive data type. The implementation is identical
 * to the rest of the primitive-typed Heaps in the <code>ds</code> package, yet not much generalization can be made
 * due to teh difference in the returned type and in the inability to generalize on the primitive types.
 * <br/> <br/>
 * The client can:
 * <ul>
 *     <li></li>
 * </ul>
 */
public abstract class AbstractDoubleHeap extends AbstractPrimitiveArrayHeap {

    @FunctionalInterface
    public interface DoubleHeapComparator {

        int compare(double a, double b);

        default boolean shouldSwap(double a, double b){
            return this.compare(a, b) > 0;
        }
    }

    protected double[] elements;
    private DoubleHeapComparator comparator;

    protected AbstractDoubleHeap(DoubleHeapComparator comparator){
        this(comparator, 10);
    }

    protected AbstractDoubleHeap(DoubleHeapComparator comparator, int capacity){
        this(new double[capacity], comparator);
    }

    protected AbstractDoubleHeap(double[] elements, DoubleHeapComparator comparator){
        this(elements, elements.length, comparator);
    }

    protected AbstractDoubleHeap(double[] elements, int size, DoubleHeapComparator comparator){
        this.elements = elements;
        this.comparator = comparator;
        this.setSize(size);
        this.build();
    }

    @Override
    public int getCapacity() {
        return elements.length;
    }

    public double peek(){
        return elements[0];
    }

    public double extract(){
        double extracted = elements[0];
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
    public abstract void increaseElementValueBy(int index, double value);

    public void insert(double element){
        this.ensureInsertion(0);
        this.increaseElementValueBy(size-1, element);
    }

    protected void ensureInsertion(double element){
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

    protected DoubleHeapComparator getComparator(){
        return this.comparator;
    }
}
