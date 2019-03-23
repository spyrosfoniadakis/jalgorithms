package ds;

import utils.ArrayUtils;

/**
 *
 */
public class IntMinHeap extends AbstractIntHeap{

    IntMinHeap(){
        this(10);
    }

    IntMinHeap(int capacity){
        this(new int[capacity], 0);
    }

    IntMinHeap(int[] elements){
        this(elements, elements.length);
    }

    IntMinHeap(int[] elements, int size){
        super(elements, size, (a, b) -> a < b ? -1 : a > b ? 1 : 0);
    }

//    @Override
//    public final void heapify(){
//        super.heapifyFrom(0);
//    }

//    @Override
//    public final void build(){
//        for(int i=Math.floorDiv(this.elements.length, 2); i>=0; i--){
//            heapifyFrom(i);
//        }
//    }

    @Override
    public final void increaseElementValueBy(int index, int value){
        this.elements[index] += value;
        if (value == 0){
            return;
        }
        else if(value > 0){
            this.heapifyFrom(index);
        }
        else {
            int parentIndex;
            while(index > 0 && this.getComparator().shouldSwap(this.elements[index], this.elements[parentIndex = this.getParentIndexOf(index)])){
                ArrayUtils.swap(this.elements, index, parentIndex);
                index= parentIndex;
            }
        }
    }

    public final static IntMinHeap newHeap(){
        return new IntMinHeap();
    }

    public final static IntMinHeap newHeap(int capacity){
        return new IntMinHeap(capacity);
    }

    public final static IntMinHeap from(int[] elements){
        return new IntMinHeap(elements);
    }

    public final static IntMinHeap from(int[] elements, int capacity){
        return new IntMinHeap(elements, capacity);
    }
}
