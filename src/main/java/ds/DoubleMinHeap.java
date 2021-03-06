/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
 *
 * @author Spyros Foniadakis
 */
public final class DoubleMinHeap extends AbstractDoubleHeap{

    DoubleMinHeap(){
        this(10, 0);
    }

    // TODO: reconsider
    DoubleMinHeap(final int capacity, final int size){
        this(new double[capacity], size);
    }

    DoubleMinHeap(final double[] elements){
        this(elements, elements.length);
    }

    DoubleMinHeap(final double[] elements, final int size){
        super(elements, size, (DoubleHeapComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    DoubleMinHeap(final DoubleMinHeap heap){
        super(heap);
    }

    @Override
    public void increaseElementValueBy(final int index, final double value) {
        this.elements[index] += value;
        if (value == 0){
            return;
        }
        else if(value > 0){
            int parentIndex;
            int currentIndex = index;
            while(currentIndex > 0 && this.getComparator().shouldSwap(this.elements[currentIndex], this.elements[parentIndex = this.getParentIndexOf(currentIndex)])){
                ArrayUtils.swap(this.elements, currentIndex, parentIndex);
                currentIndex = parentIndex;
            }
        }
        else {
            this.heapifyFrom(index);
        }
    }

    public final static DoubleMinHeap newHeap(){
        return new DoubleMinHeap();
    }

    public final static DoubleMinHeap newHeap(final int capacity){
        return new DoubleMinHeap(capacity, 0);
    }

    public final static DoubleMinHeap from(final double[] elements){
        return new DoubleMinHeap(elements);
    }

    public final static DoubleMinHeap from(final double[] elements, final int size){
        return new DoubleMinHeap(elements, size);
    }

    public final static DoubleMinHeap from(final DoubleMinHeap heap){ return new DoubleMinHeap(heap); }
}
