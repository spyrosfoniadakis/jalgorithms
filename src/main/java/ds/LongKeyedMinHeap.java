package ds;

import KeyedElement.LongKeyedElement;
import comparator.LongComparator;
import utils.ArrayUtils;

import java.util.List;

public class LongKeyedMinHeap<T> extends AbstractLongKeyedArrayHeap<T> {

    LongKeyedMinHeap(){
        this(10, 0);
    }

    LongKeyedMinHeap(final int capacity, final int size){
        this(new LongKeyedElement[capacity], size);
    }

    LongKeyedMinHeap(final LongKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    LongKeyedMinHeap(final LongKeyedElement<T>[] elements, final int size){
        super(elements, size, (LongComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    LongKeyedMinHeap(final List<LongKeyedElement<T>> elements){
        super(elements, elements.size(), (LongComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    LongKeyedMinHeap(final LongKeyedMinHeap heap){
        super(heap);
    }

    @Override
    public void increaseElementKeyBy(final int index, final long offset) {
        this.elements[index].increaseKeyBy(offset);
        if (offset == 0){
            return;
        }
        else if(offset > 0){
            this.heapifyFrom(index);
        }
        else {
            int parentIndex;
            int currentIndex = index;
            while(currentIndex > 0 && this.getComparator().shouldSwap(this.elements[currentIndex].getKey(), this.elements[parentIndex = this.getParentIndexOf(currentIndex)].getKey())){
                ArrayUtils.swap(this.elements, currentIndex, parentIndex);
                currentIndex = parentIndex;
            }
        }
    }

    public final static LongKeyedMinHeap newHeap(){
        return new LongKeyedMinHeap();
    }

    public final static LongKeyedMinHeap newHeap(final int capacity){
        return new LongKeyedMinHeap(capacity, 0);
    }

    public final static <T> LongKeyedMinHeap from(final LongKeyedElement<T>[] elements){
        return new LongKeyedMinHeap(elements);
    }

    public final static <T> LongKeyedMinHeap from(final LongKeyedElement<T>[] elements, int capacity){
        return new LongKeyedMinHeap(elements, capacity);
    }

    public final static LongKeyedMinHeap from(final List<LongKeyedMinHeap> elements){ return new LongKeyedMinHeap(elements); }

    public final static LongKeyedMinHeap from(final LongKeyedMinHeap heap){ return new LongKeyedMinHeap(heap); }
}
