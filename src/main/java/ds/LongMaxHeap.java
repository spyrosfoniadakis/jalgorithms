package ds;

import utils.ArrayUtils;

/**
 * It models a MaxHeap containing elements alone long primitive data type. The implementation is identical
 * to the rest of the primitive-typed MinHeaps in the <code>ds</code> package, yet not much generalization can be made
 * due to the difference in the returned type and in the inability to generalize on the primitive types.
 * <br/> <br/>
 * The client can:
 * <ul>
 *     <li>Create an empty heap of longs</li>
 *     <li>Create a heap of longs given an array of longs containing elements in arbitrary order</li>
 *     <li>Peek the maximum element</li>
 *     <li>Extract the maximum element of the heap - the remaining elements will still form a heap after the element's
 *          extraction</li>
 *     <li>Sort the elements of the heap - this action will destroy the heap.</li>
 * </ul>
 */
public class LongMaxHeap extends AbstractLongHeap  {

    LongMaxHeap(){
        this(10, 0);
    }

    LongMaxHeap(int capacity, int size){
        this(new long[capacity], size);
    }

    LongMaxHeap(long[] elements){
        this(elements, elements.length);
    }

    LongMaxHeap(long[] elements, int size){
        super(elements, size, (LongHeapComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
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

    public final LongHeapComparator getMaxHeapComparator(){
        return (a, b) -> a > b ? -1 : a < b ? 1 : 0;
    }

    public final static LongMaxHeap newHeap(){
        return new LongMaxHeap();
    }

    public final static LongMaxHeap newHeap(int capacity){
        return new LongMaxHeap(capacity, 0);
    }

    public final static LongMaxHeap from(long[] elements){
        return new LongMaxHeap(elements);
    }

    public final static LongMaxHeap from(long[] elements, int capacity){
        return new LongMaxHeap(elements, capacity);
    }
}
