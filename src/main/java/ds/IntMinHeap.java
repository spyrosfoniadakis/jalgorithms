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
 * @author Spyros Foniadakis
 */
public class IntMinHeap extends AbstractIntHeap{

    IntMinHeap(){
        this(10);
    }

    IntMinHeap(int capacity){
        this(new int[capacity], 0);
    }

    IntMinHeap(int[] elements){
        this(elements, elements.length);
    }

    IntMinHeap(int[] elements, int size){
        super(elements, size, (IntHeapComparator) (a, b) -> a < b ? -1 : a > b ? 1 : 0);
    }

    IntMinHeap(IntMinHeap heap){
        super(heap);
    }

    @Override
    public final void increaseElementValueBy(int index, int value){
        this.elements[index] += value;
        if (value == 0){
            return;
        }
        else if(value > 0){
            this.heapifyFrom(index);
        }
        else {
            int parentIndex;
            while(index > 0 && this.getComparator().shouldSwap(this.elements[index], this.elements[parentIndex = this.getParentIndexOf(index)])){
                ArrayUtils.swap(this.elements, index, parentIndex);
                index= parentIndex;
            }
        }
    }

    public final static IntMinHeap newHeap(){
        return new IntMinHeap();
    }

    public final static IntMinHeap newHeap(int capacity){
        return new IntMinHeap(capacity);
    }

    public final static IntMinHeap from(int[] elements){
        return new IntMinHeap(elements);
    }

    public final static IntMinHeap from(int[] elements, int capacity){
        return new IntMinHeap(elements, capacity);
    }

    public final static IntMinHeap from(IntMinHeap heap){ return new IntMinHeap(heap); }
}
