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

import keyedElement.IntKeyedElement;
import comparator.IntComparator;
import utils.ArrayUtils;

import java.util.List;

/**
 * @author Spyros Foniadakis
 */
public final class IntKeyedMinHeap<T> extends AbstractIntKeyedArrayHeap<T> {

    IntKeyedMinHeap(){
        this(10, 0);
    }

    IntKeyedMinHeap(final int capacity, final int size){
        this(new IntKeyedElement[capacity], size);
    }

    IntKeyedMinHeap(final IntKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    IntKeyedMinHeap(final IntKeyedElement<T>[] elements, final int size){
        super(elements, size, (IntComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    IntKeyedMinHeap(final List<IntKeyedElement<T>> elements){
        super(elements, elements.size(), (IntComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    IntKeyedMinHeap(final IntKeyedMinHeap heap){
        super(heap);
    }

    @Override
    public void increaseElementKeyBy(final int index, final int offset) {
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

    public final static IntKeyedMinHeap newHeap(){
        return new IntKeyedMinHeap();
    }

    public final static IntKeyedMinHeap newHeap(final int capacity){
        return new IntKeyedMinHeap(capacity, 0);
    }

    public final static <T> IntKeyedMinHeap from(final IntKeyedElement<T>[] elements){
        return new IntKeyedMinHeap(elements);
    }

    public final static <T> IntKeyedMinHeap from(final IntKeyedElement<T>[] elements, final int size){
        return new IntKeyedMinHeap(elements, size);
    }

    public final static IntKeyedMinHeap from(final List<IntKeyedMinHeap> elements){ return new IntKeyedMinHeap(elements); }

    public final static IntKeyedMinHeap from(final IntKeyedMinHeap heap){ return new IntKeyedMinHeap(heap); }
}
