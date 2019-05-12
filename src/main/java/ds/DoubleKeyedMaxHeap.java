package ds;

import KeyedElement.DoubleKeyedElement;
import comparator.DoubleComparator;
import utils.ArrayUtils;

import java.util.List;

public class DoubleKeyedMaxHeap<T> extends AbstractDoubleKeyedArrayHeap<T> {

    DoubleKeyedMaxHeap(){
        this(10, 0);
    }

    DoubleKeyedMaxHeap(int capacity, int size){
        this(new DoubleKeyedElement[capacity], size);
    }

    DoubleKeyedMaxHeap(DoubleKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    DoubleKeyedMaxHeap(DoubleKeyedElement<T>[] elements, int size){
        super(elements, size, (DoubleComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    DoubleKeyedMaxHeap(List<DoubleKeyedElement<T>> elements){
        super(elements, elements.size(), (DoubleComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    DoubleKeyedMaxHeap(DoubleKeyedMaxHeap heap){
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

    public final static DoubleKeyedMaxHeap newHeap(){
        return new DoubleKeyedMaxHeap();
    }

    public final static DoubleKeyedMaxHeap newHeap(int capacity){
        return new DoubleKeyedMaxHeap(capacity, 0);
    }

    public final static <T> DoubleKeyedMaxHeap from(DoubleKeyedElement<T>[] elements){
        return new DoubleKeyedMaxHeap(elements);
    }

    public final static <T> DoubleKeyedMaxHeap from(DoubleKeyedElement<T>[] elements, int capacity){
        return new DoubleKeyedMaxHeap(elements, capacity);
    }

    public final static DoubleKeyedMaxHeap from(List<DoubleKeyedMaxHeap> elements){ return new DoubleKeyedMaxHeap(elements); }

    public final static DoubleKeyedMaxHeap from(DoubleKeyedMaxHeap heap){ return new DoubleKeyedMaxHeap(heap); }
}
