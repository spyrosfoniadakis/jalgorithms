package ds;

import utils.ArrayUtils;

public final class IntMaxHeap extends AbstractIntHeap {

    private IntMaxHeap(){
        super();
    }

    private IntMaxHeap(int capacity){
        super(capacity);
    }

    private IntMaxHeap(int[] elements){
        super(elements);
    }

    private IntMaxHeap(int[] elements, int size){
        super(elements);
    }

    @Override
    public void heapify(){
        super.heapifyFrom(0, (a, b) -> a < b);
    }

    @Override
    public void build(){
        for(int i=Math.floorDiv(this.elements.length, 2); i>=0; i--){
            heapifyFrom(i, (a, b) -> a < b);
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
            while(index > 0 && this.elements[index] > this.elements[parentIndex = this.getParentIndexOf(index)]){
                ArrayUtils.swap(this.elements, index, parentIndex);
                index= parentIndex;
            }
        }
        else {
            this.heapifyFrom(index, (a, b) -> a < b);
        }
    }

    public static IntMaxHeap newHeap(){
        return new IntMaxHeap();
    }

    public static IntMaxHeap newHeap(int capacity){
        return new IntMaxHeap(capacity);
    }

    public static IntMaxHeap from(int[] elements){
        return new IntMaxHeap(elements);
    }

    public static IntMaxHeap from(int[] elements, int capacity){
        return new IntMaxHeap(elements, capacity);
    }
}
