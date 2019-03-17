package ds;

import utils.ArrayUtils;

/**
 *
 */
public class IntMinHeap extends AbstractIntHeap{

    private IntMinHeap(){
        this(10);
    }

    private IntMinHeap(int capacity){
        this(new int[capacity], 0);
    }

    private IntMinHeap(int[] elements){
        this(elements, elements.length);
    }

    private IntMinHeap(int[] elements, int size){
        super(elements, size, (a, b) -> a < b ? -1 : a > b ? 1 : 0);
    }

    @Override
    public void heapify(){
        super.heapifyFrom(0);
    }

    @Override
    public void build(){
        for(int i=Math.floorDiv(this.elements.length, 2); i>=0; i--){
            heapifyFrom(i);
        }
    }

    @Override
    public void increaseElementValueBy(int index, int value){
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

    public static IntMinHeap newHeap(){
        return new IntMinHeap();
    }

    public static IntMinHeap newHeap(int capacity){
        return new IntMinHeap(capacity);
    }

    public static IntMinHeap from(int[] elements){
        return new IntMinHeap(elements);
    }

    public static IntMinHeap from(int[] elements, int capacity){
        return new IntMinHeap(elements, capacity);
    }
}
