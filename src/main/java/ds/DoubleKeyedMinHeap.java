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

import keyedElement.DoubleKeyedElement;
import comparator.DoubleComparator;
import utils.ArrayUtils;

import java.util.List;

/**
 * @author Spyros Foniadakis
 */
public final class DoubleKeyedMinHeap<T> extends AbstractDoubleKeyedArrayHeap<T> {

    DoubleKeyedMinHeap(){
        this(10, 0);
    }

    DoubleKeyedMinHeap(final int capacity, final int size){
        this(new DoubleKeyedElement[capacity], size);
    }

    DoubleKeyedMinHeap(final DoubleKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    DoubleKeyedMinHeap(final DoubleKeyedElement<T>[] elements, final int size){
        super(elements, size, (DoubleComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    DoubleKeyedMinHeap(final List<DoubleKeyedElement<T>> elements){
        super(elements, elements.size(), (DoubleComparator) (a, b) -> a > b ? 1 : a < b ? -1 : 0);
    }

    DoubleKeyedMinHeap(final DoubleKeyedMinHeap heap){
        super(heap);
    }

    @Override
    public void increaseElementKeyBy(final int index, final double offset) {
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
                currentIndex= parentIndex;
            }
        }
    }

    public final static DoubleKeyedMinHeap newHeap(){
        return new DoubleKeyedMinHeap();
    }

    public final static DoubleKeyedMinHeap newHeap(final int capacity){
        return new DoubleKeyedMinHeap(capacity, 0);
    }

    public final static <T> DoubleKeyedMinHeap from(final DoubleKeyedElement<T>[] elements){
        return new DoubleKeyedMinHeap(elements);
    }

    public final static <T> DoubleKeyedMinHeap from(final DoubleKeyedElement<T>[] elements, int size){
        return new DoubleKeyedMinHeap(elements, size);
    }

    public final static DoubleKeyedMinHeap from(final List<DoubleKeyedMinHeap> elements){ return new DoubleKeyedMinHeap(elements); }

    public final static DoubleKeyedMinHeap from(final DoubleKeyedMinHeap heap){ return new DoubleKeyedMinHeap(heap); }
}
