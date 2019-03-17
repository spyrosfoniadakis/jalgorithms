package ds;

import utils.ArrayUtils;

public final class IntMaxHeap extends AbstractIntHeap {

    private IntMaxHeap(){
        this(10, 0);
    }

    private IntMaxHeap(int capacity, int size){
        this(new int[capacity], size);
    }

    private IntMaxHeap(int[] elements){
        this(elements, elements.length);
    }

    private IntMaxHeap(int[] elements, int size){
        super(elements, size, (a, b) -> a > b ? -1 : a < b ? 1 : 0);
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

    public static IntMaxHeap newHeap(){
        return new IntMaxHeap();
    }

    public static IntMaxHeap newHeap(int capacity){
        return new IntMaxHeap(capacity, 0);
    }

    public static IntMaxHeap from(int[] elements){
        return new IntMaxHeap(elements);
    }

    public static IntMaxHeap from(int[] elements, int capacity){
        return new IntMaxHeap(elements, capacity);
    }
}
