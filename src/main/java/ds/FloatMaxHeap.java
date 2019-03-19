package ds;

import utils.ArrayUtils;

public class FloatMaxHeap extends AbstractFloatHeap {

    FloatMaxHeap(){
        this(10, 0);
    }

    FloatMaxHeap(int capacity, int size){
        this(new float[capacity], size);
    }

    FloatMaxHeap(float[] elements){
        this(elements, elements.length);
    }

    FloatMaxHeap(float[] elements, int size){
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
    public final void increaseElementValueBy(int index, float value){
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

    public final static FloatMaxHeap newHeap(){
        return new FloatMaxHeap();
    }

    public final static FloatMaxHeap newHeap(int capacity){
        return new FloatMaxHeap(capacity, 0);
    }

    public final static FloatMaxHeap from(float[] elements){
        return new FloatMaxHeap(elements);
    }

    public final static FloatMaxHeap from(float[] elements, int capacity){
        return new FloatMaxHeap(elements, capacity);
    }
}
