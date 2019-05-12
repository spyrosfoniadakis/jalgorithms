package ds;

import KeyedElement.LongKeyedElement;
import comparator.LongComparator;
import utils.ArrayUtils;

import java.util.List;

public class LongKeyedMinHeap<T> extends AbstractLongKeyedArrayHeap<T> {

    LongKeyedMinHeap(){
        this(10, 0);
    }

    LongKeyedMinHeap(int capacity, int size){
        this(new LongKeyedElement[capacity], size);
    }

    LongKeyedMinHeap(LongKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    LongKeyedMinHeap(LongKeyedElement<T>[] elements, int size){
        super(elements, size, (LongComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    LongKeyedMinHeap(List<LongKeyedElement<T>> elements){
        super(elements, elements.size(), (LongComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    LongKeyedMinHeap(LongKeyedMinHeap heap){
        super(heap);
    }

    @Override
    public void increaseElementKeyBy(int index, int offset) {
        this.elements[index].increaseKeyBy(offset);
        if (offset == 0){
            return;
        }
        else if(offset > 0){
            this.heapifyFrom(index);
        }
        else {
            int parentIndex;
            while(index > 0 && this.getComparator().shouldSwap(this.elements[index].getKey(), this.elements[parentIndex = this.getParentIndexOf(index)].getKey())){
                ArrayUtils.swap(this.elements, index, parentIndex);
                index= parentIndex;
            }
        }
    }

    public final static LongKeyedMinHeap newHeap(){
        return new LongKeyedMinHeap();
    }

    public final static LongKeyedMinHeap newHeap(int capacity){
        return new LongKeyedMinHeap(capacity, 0);
    }

    public final static <T> LongKeyedMinHeap from(LongKeyedElement<T>[] elements){
        return new LongKeyedMinHeap(elements);
    }

    public final static <T> LongKeyedMinHeap from(LongKeyedElement<T>[] elements, int capacity){
        return new LongKeyedMinHeap(elements, capacity);
    }

    public final static LongKeyedMinHeap from(List<LongKeyedMinHeap> elements){ return new LongKeyedMinHeap(elements); }

    public final static LongKeyedMinHeap from(LongKeyedMinHeap heap){ return new LongKeyedMinHeap(heap); }
}
