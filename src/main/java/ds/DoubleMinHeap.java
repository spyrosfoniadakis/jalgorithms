package ds;

import utils.ArrayUtils;

public class DoubleMinHeap extends AbstractDoubleHeap{

    DoubleMinHeap(){
        this(10, 0);
    }

    // TODO: reconsider
    DoubleMinHeap(int capacity, int size){
        this(new double[capacity], size);
    }

    DoubleMinHeap(double[] elements){
        this(elements, elements.length);
    }

    DoubleMinHeap(double[] elements, int size){
        super(elements, size, (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    @Override
    public void build() {
        for(int i=Math.floorDiv(this.elements.length, 2); i>=0; i--){
            heapifyFrom(i);
        }
    }

    @Override
    public void increaseElementValueBy(int index, double value) {
        this.elements[index] += value;
        if (value == 0){
            return;
        }
        else if(value > 0){
            int parentIndex;
            while(index > 0 && this.getComparator().shouldSwap(this.elements[index], this.elements[parentIndex = this.getParentIndexOf(index)])){
                ArrayUtils.swap(this.elements, index, parentIndex);
                index= parentIndex;
            }
        }
        else {
            this.heapifyFrom(index);
        }
    }

    @Override
    public void heapify() {
        super.heapifyFrom(0);
    }

    public final static DoubleMinHeap newHeap(){
        return new DoubleMinHeap();
    }

    public final static DoubleMinHeap newHeap(int capacity){
        return new DoubleMinHeap(capacity, 0);
    }

    public final static DoubleMinHeap from(double[] elements){
        return new DoubleMinHeap(elements);
    }

    public final static DoubleMinHeap from(double[] elements, int capacity){
        return new DoubleMinHeap(elements, capacity);
    }
}
