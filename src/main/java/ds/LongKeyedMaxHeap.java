package ds;

import KeyedElement.LongKeyedElement;
import comparator.LongComparator;
import utils.ArrayUtils;

import java.util.List;

public class LongKeyedMaxHeap<T> extends AbstractLongKeyedArrayHeap<T> {

    LongKeyedMaxHeap(){
        this(10, 0);
    }

    LongKeyedMaxHeap(int capacity, int size){
        this(new LongKeyedElement[capacity], size);
    }

    LongKeyedMaxHeap(LongKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    LongKeyedMaxHeap(LongKeyedElement<T>[] elements, int size){
        super(elements, size, (LongComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    LongKeyedMaxHeap(List<LongKeyedElement<T>> elements){
        super(elements, elements.size(), (LongComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    LongKeyedMaxHeap(LongKeyedMaxHeap heap){
        super(heap);
    }

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

    public final static LongKeyedMaxHeap newHeap(){
        return new LongKeyedMaxHeap();
    }

    public final static LongKeyedMaxHeap newHeap(int capacity){
        return new LongKeyedMaxHeap(capacity, 0);
    }

    public final static <T> LongKeyedMaxHeap from(LongKeyedElement<T>[] elements){
        return new LongKeyedMaxHeap(elements);
    }

    public final static <T> LongKeyedMaxHeap from(LongKeyedElement<T>[] elements, int capacity){
        return new LongKeyedMaxHeap(elements, capacity);
    }

    public final static LongKeyedMaxHeap from(List<LongKeyedMaxHeap> elements){ return new LongKeyedMaxHeap(elements); }

    public final static LongKeyedMaxHeap from(LongKeyedMaxHeap heap){ return new LongKeyedMaxHeap(heap); }
}
