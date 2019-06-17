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
public final class DoubleKeyedMaxHeap<T> extends AbstractDoubleKeyedArrayHeap<T> {

    DoubleKeyedMaxHeap(){
        this(10, 0);
    }

    DoubleKeyedMaxHeap(final int capacity, final int size){
        this(new DoubleKeyedElement[capacity], size);
    }

    DoubleKeyedMaxHeap(final DoubleKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    DoubleKeyedMaxHeap(final DoubleKeyedElement<T>[] elements, final int size){
        super(elements, size, (DoubleComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    DoubleKeyedMaxHeap(final List<DoubleKeyedElement<T>> elements){
        super(elements, elements.size(), (DoubleComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    DoubleKeyedMaxHeap(final DoubleKeyedMaxHeap heap){
        super(heap);
    }

    @Override
    public void increaseElementKeyBy(final int index, final double offset) {
        this.elements[index].increaseKeyBy(offset);
        if (offset == 0){
            return;
        }
        else if(offset > 0){
            int parentIndex;
            int currentIndex = index;
            while(currentIndex > 0 && this.getComparator().shouldSwap(this.elements[currentIndex].getKey(), this.elements[parentIndex = this.getParentIndexOf(currentIndex)].getKey())){
                ArrayUtils.swap(this.elements, currentIndex, parentIndex);
                currentIndex= parentIndex;
            }
        }
        else {
            this.heapifyFrom(index);
        }
    }

    public final static DoubleKeyedMaxHeap newHeap(){
        return new DoubleKeyedMaxHeap();
    }

    public final static DoubleKeyedMaxHeap newHeap(int capacity){
        return new DoubleKeyedMaxHeap(capacity, 0);
    }

    public final static <T> DoubleKeyedMaxHeap from(DoubleKeyedElement<T>[] elements){
        return new DoubleKeyedMaxHeap(elements);
    }

    public final static <T> DoubleKeyedMaxHeap from(DoubleKeyedElement<T>[] elements, int size){
        return new DoubleKeyedMaxHeap(elements, size);
    }

    public final static DoubleKeyedMaxHeap from(List<DoubleKeyedMaxHeap> elements){ return new DoubleKeyedMaxHeap(elements); }

    public final static DoubleKeyedMaxHeap from(DoubleKeyedMaxHeap heap){ return new DoubleKeyedMaxHeap(heap); }
}
