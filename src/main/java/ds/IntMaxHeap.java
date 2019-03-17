package ds;

import utils.ArrayUtils;

public class IntMaxHeap extends AbstractIntHeap {

    IntMaxHeap(){
        this(10, 0);
    }

    IntMaxHeap(int capacity, int size){
        this(new int[capacity], size);
    }

    IntMaxHeap(int[] elements){
        this(elements, elements.length);
    }

    IntMaxHeap(int[] elements, int size){
        super(elements, size, (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    @Override
    public final void heapify(){
        super.heapifyFrom(0);
    }

    @Override
    public final void build(){
        for(int i=Math.floorDiv(this.elements.length, 2); i>=0; i--){
            heapifyFrom(i);
        }
    }

    @Override
    public final void increaseElementValueBy(int index, int value){
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

    public final static IntMaxHeap newHeap(){
        return new IntMaxHeap();
    }

    public final static IntMaxHeap newHeap(int capacity){
        return new IntMaxHeap(capacity, 0);
    }

    public final static IntMaxHeap from(int[] elements){
        return new IntMaxHeap(elements);
    }

    public final static IntMaxHeap from(int[] elements, int capacity){
        return new IntMaxHeap(elements, capacity);
    }
}
