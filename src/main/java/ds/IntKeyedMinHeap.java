package ds;

import KeyedElement.IntKeyedElement;
import comparator.IntComparator;
import utils.ArrayUtils;

import java.util.List;

public class IntKeyedMinHeap<T> extends AbstractIntKeyedArrayHeap<T> {

    IntKeyedMinHeap(){
        this(10, 0);
    }

    IntKeyedMinHeap(int capacity, int size){
        this(new IntKeyedElement[capacity], size);
    }

    IntKeyedMinHeap(IntKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    IntKeyedMinHeap(IntKeyedElement<T>[] elements, int size){
        super(elements, size, (IntComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    IntKeyedMinHeap(List<IntKeyedElement<T>> elements){
        super(elements, elements.size(), (IntComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    IntKeyedMinHeap(IntKeyedMinHeap heap){
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

    public final static IntKeyedMinHeap newHeap(){
        return new IntKeyedMinHeap();
    }

    public final static IntKeyedMinHeap newHeap(int capacity){
        return new IntKeyedMinHeap(capacity, 0);
    }

    public final static <T> IntKeyedMinHeap from(IntKeyedElement<T>[] elements){
        return new IntKeyedMinHeap(elements);
    }

    public final static <T> IntKeyedMinHeap from(IntKeyedElement<T>[] elements, int capacity){
        return new IntKeyedMinHeap(elements, capacity);
    }

    public final static IntKeyedMinHeap from(List<IntKeyedMinHeap> elements){ return new IntKeyedMinHeap(elements); }

    public final static IntKeyedMinHeap from(IntKeyedMinHeap heap){ return new IntKeyedMinHeap(heap); }
}
