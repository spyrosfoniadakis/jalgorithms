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
 * It models a MinHeap containing elements alone float primitive data type. The implementation is identical
 * to the rest of the primitive-typed MinHeaps in the <code>ds</code> package, yet not much generalization can be made
 * due to the difference in the returned type and in the inability to generalize on the primitive types.
 * <br/> <br/>
 * The client can:
 * <ul>
 *     <li>Create an empty heap of floats</li>
 *     <li>Create a heap of floats given an array of floats containing elements in arbitrary order</li>
 *     <li>Peek the minimum element</li>
 *     <li>Extract the minimum element of the heap - the remaining elements will still form a heap after the element's
 *          extraction</li>
 *     <li>Sort the elements of the heap - this action will destroy the heap.</li>
 * </ul>
 *
 * @author Spyros Foniadakis
 */
public class FloatMinHeap extends AbstractFloatHeap implements FloatHeap, FloatPriorityQueue {

    FloatMinHeap(){
        this(10, 0);
    }

    FloatMinHeap(final int capacity, final int size){
        this(new float[capacity], size);
    }

    FloatMinHeap(final float[] elements){
        this(elements, elements.length);
    }

    FloatMinHeap(final float[] elements, final int size){
        super(elements, size, (FloatHeapComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    FloatMinHeap(final FloatMinHeap heap){
        super(heap);
    }

    @Override
    public final void increaseElementValueBy(final int index, final float value){
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

    public final static FloatMinHeap newHeap(){
        return new FloatMinHeap();
    }

    public final static FloatMinHeap newHeap(final int capacity){
        return new FloatMinHeap(capacity, 0);
    }

    public final static FloatMinHeap from(final float[] elements){
        return new FloatMinHeap(elements);
    }

    public final static FloatMinHeap from(final float[] elements, int capacity){
        return new FloatMinHeap(elements, capacity);
    }

    public final static FloatMinHeap from(final FloatMinHeap heap){ return new FloatMinHeap(heap); }
}

