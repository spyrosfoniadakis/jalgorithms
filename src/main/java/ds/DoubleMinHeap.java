package ds;

import utils.ArrayUtils;

/**
 * It models a MinHeap containing elements alone double primitive data type. The implementation is identical
 * to the rest of the primitive-typed MinHeaps in the <code>ds</code> package, yet not much generalization can be made
 * due to the difference in the returned type and in the inability to generalize on the primitive types.
 * <br/> <br/>
 * The client can:
 * <ul>
 *     <li>Create an empty heap of doubles</li>
 *     <li>Create a heap of doubles given an array of doubles containing elements in arbitrary order</li>
 *     <li>Peek the minimum element</li>
 *     <li>Extract the minimum element of the heap - the remaining elements will still form a heap after the element's
 *          extraction</li>
 *     <li>Sort the elements of the heap - this action will destroy the heap.</li>
 * </ul>
 */
public class DoubleMinHeap extends AbstractDoubleHeap{

    DoubleMinHeap(){
        this(10, 0);
    }

    // TODO: reconsider
    DoubleMinHeap(int capacity, int size){
        this(new double[capacity], size);
    }

    DoubleMinHeap(double[] elements){
        this(elements, elements.length);
    }

    DoubleMinHeap(double[] elements, int size){
        super(elements, size, (a, b) -> a > b ? 1 : a < b ? -1 : 0);
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

    public final static DoubleMinHeap newHeap(){
        return new DoubleMinHeap();
    }

    public final static DoubleMinHeap newHeap(int capacity){
        return new DoubleMinHeap(capacity, 0);
    }

    public final static DoubleMinHeap from(double[] elements){
        return new DoubleMinHeap(elements);
    }

    public final static DoubleMinHeap from(double[] elements, int capacity){
        return new DoubleMinHeap(elements, capacity);
    }
}
