package ds;

import utils.ArrayUtils;

public abstract class AbstractLongHeap extends AbstractPrimitiveArrayHeap  {

    @FunctionalInterface
    public interface LongHeapComparator {

        int compare(long a, long b);

        default boolean shouldSwap(long a, long b){
            return this.compare(a, b) > 0;
        }
    }

    protected long[] elements;
    private LongHeapComparator comparator;

    protected AbstractLongHeap(LongHeapComparator comparator){
        this(comparator, 10);
    }

    protected AbstractLongHeap(LongHeapComparator comparator, int capacity){
        this(new long[capacity], comparator);
    }

    protected AbstractLongHeap(long[] elements, LongHeapComparator comparator){
        this(elements, elements.length, comparator);
    }

    protected AbstractLongHeap(long[] elements, int size, LongHeapComparator comparator){
        this.elements = elements;
        this.comparator = comparator;
        this.setSize(size);
        this.build();
    }

    @Override
    public int getCapacity() {
        return elements.length;
    }

    public long peek(){
        return elements[0];
    }

    public long extract(){
        long extracted = elements[0];
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
    public abstract void increaseElementValueBy(int index, long value);

    public void insert(long element){
        this.ensureInsertion(0);
        this.increaseElementValueBy(size-1, element);
    }

    protected void ensureInsertion(long element){
        if(this.size < this.elements.length){
            this.elements[this.size++] = element;
            return;
        }

        long[] newElements = new long[2*this.elements.length];
        for(int i=0; i< this.elements.length; i++){
            newElements[i]= elements[i];
        }
        newElements[this.size++] = element;
        this.elements = newElements;
    }

    protected LongHeapComparator getComparator(){
        return this.comparator;
    }
}
