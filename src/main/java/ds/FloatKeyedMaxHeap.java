package ds;

import KeyedElement.FloatKeyedElement;
import comparator.FloatComparator;
import utils.ArrayUtils;

import java.util.List;

public class FloatKeyedMaxHeap<T> extends AbstractFloatKeyedArrayHeap<T> {

    FloatKeyedMaxHeap(){
        this(10, 0);
    }

    FloatKeyedMaxHeap(int capacity, int size){
        this(new FloatKeyedElement[capacity], size);
    }

    FloatKeyedMaxHeap(FloatKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    FloatKeyedMaxHeap(FloatKeyedElement<T>[] elements, int size){
        super(elements, size, (FloatComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    FloatKeyedMaxHeap(List<FloatKeyedElement<T>> elements){
        super(elements, elements.size(), (FloatComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    FloatKeyedMaxHeap(FloatKeyedMaxHeap heap){
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

    public final static FloatKeyedMaxHeap newHeap(){
        return new FloatKeyedMaxHeap();
    }

    public final static FloatKeyedMaxHeap newHeap(int capacity){
        return new FloatKeyedMaxHeap(capacity, 0);
    }

    public final static <T> FloatKeyedMaxHeap from(FloatKeyedElement<T>[] elements){
        return new FloatKeyedMaxHeap(elements);
    }

    public final static <T> FloatKeyedMaxHeap from(FloatKeyedElement<T>[] elements, int capacity){
        return new FloatKeyedMaxHeap(elements, capacity);
    }

    public final static FloatKeyedMaxHeap from(List<FloatKeyedMaxHeap> elements){ return new FloatKeyedMaxHeap(elements); }

    public final static FloatKeyedMaxHeap from(FloatKeyedMaxHeap heap){ return new FloatKeyedMaxHeap(heap); }
}
