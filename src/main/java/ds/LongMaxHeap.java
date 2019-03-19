package ds;

import utils.ArrayUtils;

public class LongMaxHeap extends AbstractLongHeap  {

    LongMaxHeap(){
        this(10, 0);
    }

    LongMaxHeap(int capacity, int size){
        this(new long[capacity], size);
    }

    LongMaxHeap(long[] elements){
        this(elements, elements.length);
    }

    LongMaxHeap(long[] elements, int size){
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
    public final void increaseElementValueBy(int index, long value){
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

    public final static LongMaxHeap newHeap(){
        return new LongMaxHeap();
    }

    public final static LongMaxHeap newHeap(int capacity){
        return new LongMaxHeap(capacity, 0);
    }

    public final static LongMaxHeap from(long[] elements){
        return new LongMaxHeap(elements);
    }

    public final static LongMaxHeap from(long[] elements, int capacity){
        return new LongMaxHeap(elements, capacity);
    }
}
