package ds;

import utils.ArrayUtils;

/**
 * It models a MaxHeap containing elements alone double primitive data type. The implementation is identical
 * to the rest of the primitive-typed MaxHeaps in the <code>ds</code> package, yet not much generalization can be made
 * due to the difference in the returned type and in the inability to generalize on the primitive types.
 * <br/> <br/>
 * The client can:
 * <ul>
 *     <li>Create an empty heap of doubles</li>
 *     <li>Create a heap of doubles given an array of doubles containing elements in arbitrary order</li>
 *     <li>Peek the maximum element</li>
 *     <li>Extract the maximum element of the heap - the remaining elements will still form a heap after the element's
 *          extraction</li>
 *     <li>Sort the elements of the heap - this action will destroy the heap.</li>
 * </ul>
 */
public class DoubleMaxHeap extends AbstractDoubleHeap{

    DoubleMaxHeap(){
        this(10, 0);
    }

    // TODO: reconsider
    DoubleMaxHeap(int capacity, int size){
        this(new double[capacity], size);
    }

    DoubleMaxHeap(double[] elements){
        this(elements, elements.length);
    }

    DoubleMaxHeap(double[] elements, int size){
        super(elements, size, (DoubleHeapComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    DoubleMaxHeap(DoubleMaxHeap heap){
        super(heap);
    }

    @Override
    public void increaseElementValueBy(int index, double value) {
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

    public final static DoubleMaxHeap newHeap(){
        return new DoubleMaxHeap();
    }

    public final static DoubleMaxHeap newHeap(int capacity){
        return new DoubleMaxHeap(capacity, 0);
    }

    public final static DoubleMaxHeap from(double[] elements){
        return new DoubleMaxHeap(elements);
    }

    public final static DoubleMaxHeap from(double[] elements, int capacity){
        return new DoubleMaxHeap(elements, capacity);
    }

    public final static DoubleMaxHeap from(DoubleMaxHeap heap){ return new DoubleMaxHeap(heap); }
}
