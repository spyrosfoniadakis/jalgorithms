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
 * It models a MaxHeap containing elements alone integer primitive data type. The implementation is identical
 * to the rest of the primitive-typed MinHeaps in the <code>ds</code> package, yet not much generalization can be made
 * due to the difference in the returned type and in the inability to generalize on the primitive types.
 * <br/> <br/>
 * The client can:
 * <ul>
 *     <li>Create an empty heap of ints</li>
 *     <li>Create a heap of ints given an array of ints containing elements in arbitrary order</li>
 *     <li>Peek the maximum element</li>
 *     <li>Extract the maximum element of the heap - the remaining elements will still form a heap after the element's
 *          extraction</li>
 *     <li>Sort the elements of the heap - this action will destroy the heap.</li>
 * </ul>
 *
 * @author Spyros Foniadakis
 */
public final class IntMaxHeap extends AbstractIntHeap implements IntHeap, IntPriorityQueue{

    IntMaxHeap(){
        this(10, 0);
    }

    IntMaxHeap(final int capacity, final int size){
        this(new int[capacity], size);
    }

    IntMaxHeap(final int[] elements){
        this(elements, elements.length);
    }

    IntMaxHeap(final int[] elements, final int size){
        super(elements, size, (IntHeapComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    IntMaxHeap(final IntMaxHeap heap){
        super(heap);
    }

    @Override
    public final void increaseElementValueBy(final int index, final int value){
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

    public final static IntMaxHeap newHeap(){
        return new IntMaxHeap();
    }

    public final static IntMaxHeap newHeap(final int capacity){
        return new IntMaxHeap(capacity, 0);
    }

    public final static IntMaxHeap from(final int[] elements){
        return new IntMaxHeap(elements);
    }

    public final static IntMaxHeap from(final int[] elements, final int size){
        return new IntMaxHeap(elements, size);
    }

    public final static IntMaxHeap from(final IntMaxHeap heap){ return new IntMaxHeap(heap); }
}
