package ds;

import KeyedElement.FloatKeyedElement;
import comparator.FloatComparator;
import utils.ArrayUtils;

import java.util.List;

public class FloatKeyedMinHeap<T> extends AbstractFloatKeyedArrayHeap<T> {

    FloatKeyedMinHeap(){
        this(10, 0);
    }

    FloatKeyedMinHeap(final int capacity, final int size){
        this(new FloatKeyedElement[capacity], size);
    }

    FloatKeyedMinHeap(final FloatKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    FloatKeyedMinHeap(final FloatKeyedElement<T>[] elements, final int size){
        super(elements, size, (FloatComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    FloatKeyedMinHeap(final List<FloatKeyedElement<T>> elements){
        super(elements, elements.size(), (FloatComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    FloatKeyedMinHeap(final FloatKeyedMinHeap heap){
        super(heap);
    }

    @Override
    public void increaseElementKeyBy(final int index, final float offset) {
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

    public final static FloatKeyedMinHeap newHeap(){
        return new FloatKeyedMinHeap();
    }

    public final static FloatKeyedMinHeap newHeap(final int capacity){
        return new FloatKeyedMinHeap(capacity, 0);
    }

    public final static <T> FloatKeyedMinHeap from(final FloatKeyedElement<T>[] elements){
        return new FloatKeyedMinHeap(elements);
    }

    public final static <T> FloatKeyedMinHeap from(final FloatKeyedElement<T>[] elements, final int capacity){
        return new FloatKeyedMinHeap(elements, capacity);
    }

    public final static FloatKeyedMinHeap from(final List<FloatKeyedMinHeap> elements){ return new FloatKeyedMinHeap(elements); }

    public final static FloatKeyedMinHeap from(final FloatKeyedMinHeap heap){ return new FloatKeyedMinHeap(heap); }
}
