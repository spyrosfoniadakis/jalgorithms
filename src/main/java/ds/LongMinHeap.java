package ds;

import utils.ArrayUtils;

public class LongMinHeap extends AbstractLongHeap  {

    LongMinHeap(){
        this(10, 0);
    }

    LongMinHeap(int capacity, int size){
        this(new long[capacity], size);
    }

    LongMinHeap(long[] elements){
        this(elements, elements.length);
    }

    LongMinHeap(long[] elements, int size){
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

    public final static LongMinHeap newHeap(){
        return new LongMinHeap();
    }

    public final static LongMinHeap newHeap(int capacity){
        return new LongMinHeap(capacity, 0);
    }

    public final static LongMinHeap from(long[] elements){
        return new LongMinHeap(elements);
    }

    public final static LongMinHeap from(long[] elements, int capacity){
        return new LongMinHeap(elements, capacity);
    }
}
