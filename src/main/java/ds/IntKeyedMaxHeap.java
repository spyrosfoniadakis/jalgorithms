package ds;

import KeyedElement.IntKeyedElement;
import comparator.IntComparator;
import utils.ArrayUtils;

import java.util.List;

public final class IntKeyedMaxHeap<T> extends AbstractIntKeyedArrayHeap<T> {

    IntKeyedMaxHeap(){
        this(10, 0);
    }

    IntKeyedMaxHeap(final int capacity, final int size){
        this(new IntKeyedElement[capacity], size);
    }

    IntKeyedMaxHeap(final IntKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    IntKeyedMaxHeap(final IntKeyedElement<T>[] elements, int size){
        super(elements, size, (IntComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    IntKeyedMaxHeap(final List<IntKeyedElement<T>> elements){
        super(elements, elements.size(), (IntComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    IntKeyedMaxHeap(final IntKeyedMaxHeap heap){
        super(heap);
    }

    @Override
    public void increaseElementKeyBy(final int index, final int offset) {
        this.elements[index].increaseKeyBy(offset);
        if (offset == 0){
            return;
        }
        else if(offset > 0){
            int parentIndex;
            int currentIndex = index;
            while(currentIndex > 0 && this.getComparator().shouldSwap(this.elements[currentIndex].getKey(), this.elements[parentIndex = this.getParentIndexOf(currentIndex)].getKey())){
                ArrayUtils.swap(this.elements, currentIndex, parentIndex);
                currentIndex = parentIndex;
            }
        }
        else {
            this.heapifyFrom(index);
        }
    }

    public final static IntKeyedMaxHeap newHeap(){
        return new IntKeyedMaxHeap();
    }

    public final static IntKeyedMaxHeap newHeap(final int capacity){
        return new IntKeyedMaxHeap(capacity, 0);
    }

    public final static <T> IntKeyedMaxHeap from(final IntKeyedElement<T>[] elements){
        return new IntKeyedMaxHeap(elements);
    }

    public final static <T> IntKeyedMaxHeap from(final IntKeyedElement<T>[] elements, final int capacity){
        return new IntKeyedMaxHeap(elements, capacity);
    }

    public final static IntKeyedMaxHeap from(final List<IntKeyedMaxHeap> elements){ return new IntKeyedMaxHeap(elements); }

    public final static IntKeyedMaxHeap from(final IntKeyedMaxHeap heap){ return new IntKeyedMaxHeap(heap); }
}
