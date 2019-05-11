package ds;

import KeyedElement.IntKeyedElement;
import comparator.IntComparator;
import utils.ArrayUtils;

public class IntKeyedMaxHeap<T> extends AbstractIntKeyedArrayHeap<T> {

    IntKeyedMaxHeap(){
        this(10, 0);
    }

    IntKeyedMaxHeap(int capacity, int size){
        this(new IntKeyedElement[capacity], size);
    }

    IntKeyedMaxHeap(IntKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    IntKeyedMaxHeap(IntKeyedElement<T>[] elements, int size){
//        super(elements, size, (AbstractIntHeap.IntHeapComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
        super(elements, size, (IntComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    IntKeyedMaxHeap(IntKeyedMaxHeap heap){
        super(heap);
    }

//    @Override
//    public final void increaseElementValueBy(int index, int value){
//        this.elements[index] += value;
//        if (value == 0){
//            return;
//        }
//        else if(value > 0){
//            int parentIndex;
//            while(index > 0 && this.getComparator().shouldSwap(this.elements[index], this.elements[parentIndex = this.getParentIndexOf(index)])){
//                ArrayUtils.swap(this.elements, index, parentIndex);
//                index= parentIndex;
//            }
//        }
//        else {
//            this.heapifyFrom(index);
//        }
//    }

    @Override
    public void increaseElementKeyBy(int index, int offset) {
        this.elements[index].increaseKeyBy(offset);
        if (offset == 0){
            return;
        }
        else if(offset > 0){
            int parentIndex;
            while(index > 0 && this.getComparator().shouldSwap(this.elements[index].getKey(), this.elements[parentIndex = this.getParentIndexOf(index)].getKey())){
                ArrayUtils.swap(this.elements, index, parentIndex);
                index= parentIndex;
            }
        }
        else {
            this.heapifyFrom(index);
        }
    }

    public final static IntKeyedMaxHeap newHeap(){
        return new IntKeyedMaxHeap();
    }

    public final static IntKeyedMaxHeap newHeap(int capacity){
        return new IntKeyedMaxHeap(capacity, 0);
    }

    public final static <T> IntKeyedMaxHeap from(IntKeyedElement<T>[] elements){
        return new IntKeyedMaxHeap(elements);
    }

    public final static <T> IntKeyedMaxHeap from(IntKeyedElement<T>[] elements, int capacity){
        return new IntKeyedMaxHeap(elements, capacity);
    }

    public final static IntKeyedMaxHeap from(IntKeyedMaxHeap heap){ return new IntKeyedMaxHeap(heap); }
}
