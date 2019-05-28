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

import KeyedElement.LongKeyedElement;
import comparator.LongComparator;
import utils.ArrayUtils;

import java.util.List;

/**
 * @author Spyros Foniadakis
 */
public final class LongKeyedMaxHeap<T> extends AbstractLongKeyedArrayHeap<T> {

    LongKeyedMaxHeap(){
        this(10, 0);
    }

    LongKeyedMaxHeap(final int capacity, final int size){
        this(new LongKeyedElement[capacity], size);
    }

    LongKeyedMaxHeap(final LongKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    LongKeyedMaxHeap(final LongKeyedElement<T>[] elements, int size){
        super(elements, size, (LongComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    LongKeyedMaxHeap(final List<LongKeyedElement<T>> elements){
        super(elements, elements.size(), (LongComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    LongKeyedMaxHeap(final LongKeyedMaxHeap heap){
        super(heap);
    }

    @Override
    public void increaseElementKeyBy(final int index, final long offset) {
        this.elements[index].increaseKeyBy(offset);
        if (offset == 0){
            return;
        }
        else if(offset > 0){
            int parentIndex;
            int currentIndex = index;
            while(currentIndex > 0 && this.getComparator().shouldSwap(this.elements[currentIndex].getKey(), this.elements[parentIndex = this.getParentIndexOf(currentIndex)].getKey())){
                ArrayUtils.swap(this.elements, currentIndex, parentIndex);
                currentIndex = parentIndex;
            }
        }
        else {
            this.heapifyFrom(index);
        }
    }

    public final static LongKeyedMaxHeap newHeap(){
        return new LongKeyedMaxHeap();
    }

    public final static LongKeyedMaxHeap newHeap(final int capacity){
        return new LongKeyedMaxHeap(capacity, 0);
    }

    public final static <T> LongKeyedMaxHeap from(final LongKeyedElement<T>[] elements){
        return new LongKeyedMaxHeap(elements);
    }

    public final static <T> LongKeyedMaxHeap from(final LongKeyedElement<T>[] elements, int size){
        return new LongKeyedMaxHeap(elements, size);
    }

    public final static LongKeyedMaxHeap from(final List<LongKeyedMaxHeap> elements){ return new LongKeyedMaxHeap(elements); }

    public final static LongKeyedMaxHeap from(final LongKeyedMaxHeap heap){ return new LongKeyedMaxHeap(heap); }
}
