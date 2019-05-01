package ds;

import utils.ArrayUtils;

/**
 * It models a MinHeap containing elements alone long primitive data type. The implementation is identical
 * to the rest of the primitive-typed MinHeaps in the <code>ds</code> package, yet not much generalization can be made
 * due to the difference in the returned type and in the inability to generalize on the primitive types.
 * <br/> <br/>
 * The client can:
 * <ul>
 *     <li>Create an empty heap of longs</li>
 *     <li>Create a heap of longs given an array of longs containing elements in arbitrary order</li>
 *     <li>Peek the minimum element</li>
 *     <li>Extract the minimum element of the heap - the remaining elements will still form a heap after the element's
 *          extraction</li>
 *     <li>Sort the elements of the heap - this action will destroy the heap.</li>
 * </ul>
 */
public class LongMinHeap extends AbstractLongHeap  {

    LongMinHeap(){
        this(10, 0);
    }

    LongMinHeap(int capacity, int size){
        this(new long[capacity], size);
    }

    LongMinHeap(long[] elements){
        this(elements, elements.length);
    }

    LongMinHeap(long[] elements, int size){
        super(elements, size, (LongHeapComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    LongMinHeap(LongMinHeap heap){
        super(heap);
    }

    @Override
    public final void increaseElementValueBy(int index, long value){
        this.elements[index] += value;
        if (value == 0){
            return;
        }
        else if(value > 0){
            int parentIndex;
            while(index > 0 && this.getComparator().shouldSwap(this.elements[index], this.elements[parentIndex = this.getParentIndexOf(index)])){
                ArrayUtils.swap(this.elements, index, parentIndex);
                index= parentIndex;
            }
        }
        else {
            this.heapifyFrom(index);
        }
    }

    public final LongHeapComparator getMinHeapComparator(){
        return (a, b) -> a > b ? 1 : a < b ? -1 : 0;
    }

    public final static LongMinHeap newHeap(){
        return new LongMinHeap();
    }

    public final static LongMinHeap newHeap(int capacity){
        return new LongMinHeap(capacity, 0);
    }

    public final static LongMinHeap from(long[] elements){
        return new LongMinHeap(elements);
    }

    public final static LongMinHeap from(long[] elements, int capacity){
        return new LongMinHeap(elements, capacity);
    }

    public final static LongMinHeap from(LongMinHeap heap){ return new LongMinHeap(heap); }
}
