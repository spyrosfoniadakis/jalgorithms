package ds;

import KeyedElement.DoubleKeyedElement;
import comparator.DoubleComparator;
import utils.ArrayUtils;

import java.util.List;

public class DoubleKeyedMinHeap<T> extends AbstractDoubleKeyedArrayHeap<T> {

    DoubleKeyedMinHeap(){
        this(10, 0);
    }

    DoubleKeyedMinHeap(int capacity, int size){
        this(new DoubleKeyedElement[capacity], size);
    }

    DoubleKeyedMinHeap(DoubleKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    DoubleKeyedMinHeap(DoubleKeyedElement<T>[] elements, int size){
        super(elements, size, (DoubleComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    DoubleKeyedMinHeap(List<DoubleKeyedElement<T>> elements){
        super(elements, elements.size(), (DoubleComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    DoubleKeyedMinHeap(DoubleKeyedMinHeap heap){
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

    public final static DoubleKeyedMinHeap newHeap(){
        return new DoubleKeyedMinHeap();
    }

    public final static DoubleKeyedMinHeap newHeap(int capacity){
        return new DoubleKeyedMinHeap(capacity, 0);
    }

    public final static <T> DoubleKeyedMinHeap from(DoubleKeyedElement<T>[] elements){
        return new DoubleKeyedMinHeap(elements);
    }

    public final static <T> DoubleKeyedMinHeap from(DoubleKeyedElement<T>[] elements, int capacity){
        return new DoubleKeyedMinHeap(elements, capacity);
    }

    public final static DoubleKeyedMinHeap from(List<DoubleKeyedMinHeap> elements){ return new DoubleKeyedMinHeap(elements); }

    public final static DoubleKeyedMinHeap from(DoubleKeyedMinHeap heap){ return new DoubleKeyedMinHeap(heap); }
}
