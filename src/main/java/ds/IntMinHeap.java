package ds;

import utils.ArrayUtils;

/**
 *
 */
public class IntMinHeap extends AbstractIntHeap{

    private IntMinHeap(){
        super();
    }

    private IntMinHeap(int capacity){
        super(capacity);
    }

    private IntMinHeap(int[] elements){
        super(elements);
    }

    private IntMinHeap(int[] elements, int size){
        super(elements);
    }

    @Override
    public void heapify(){
        super.heapifyFrom(0, (a, b) -> a > b);
    }

    @Override
    public void build(){
        for(int i=Math.floorDiv(this.elements.length, 2); i>=0; i--){
            heapifyFrom(i, (a, b) -> a > b);
        }
    }

    @Override
    public void increaseElementValueBy(int index, int value){
        this.elements[index] += value;
        if (value == 0){
            return;
        }
        else if(value > 0){
            this.heapifyFrom(index, (a, b) -> a > b);
        }
        else {
            int parentIndex;
            while(index > 0 && this.elements[index] < this.elements[parentIndex = this.getParentIndexOf(index)]){
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
