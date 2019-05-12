package ds;

import KeyedElement.FloatKeyedElement;
import comparator.FloatComparator;
import utils.ArrayUtils;

import java.util.List;

public class FloatKeyedMinHeap<T> extends AbstractFloatKeyedArrayHeap<T> {

    FloatKeyedMinHeap(){
        this(10, 0);
    }

    FloatKeyedMinHeap(int capacity, int size){
        this(new FloatKeyedElement[capacity], size);
    }

    FloatKeyedMinHeap(FloatKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    FloatKeyedMinHeap(FloatKeyedElement<T>[] elements, int size){
        super(elements, size, (FloatComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    FloatKeyedMinHeap(List<FloatKeyedElement<T>> elements){
        super(elements, elements.size(), (FloatComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    FloatKeyedMinHeap(FloatKeyedMinHeap heap){
        super(heap);
    }

    @Override
    public void increaseElementKeyBy(int index, float offset) {
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

    public final static FloatKeyedMinHeap newHeap(){
        return new FloatKeyedMinHeap();
    }

    public final static FloatKeyedMinHeap newHeap(int capacity){
        return new FloatKeyedMinHeap(capacity, 0);
    }

    public final static <T> FloatKeyedMinHeap from(FloatKeyedElement<T>[] elements){
        return new FloatKeyedMinHeap(elements);
    }

    public final static <T> FloatKeyedMinHeap from(FloatKeyedElement<T>[] elements, int capacity){
        return new FloatKeyedMinHeap(elements, capacity);
    }

    public final static FloatKeyedMinHeap from(List<FloatKeyedMinHeap> elements){ return new FloatKeyedMinHeap(elements); }

    public final static FloatKeyedMinHeap from(FloatKeyedMinHeap heap){ return new FloatKeyedMinHeap(heap); }
}
