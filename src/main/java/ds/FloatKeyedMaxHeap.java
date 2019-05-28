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

import KeyedElement.FloatKeyedElement;
import comparator.FloatComparator;
import utils.ArrayUtils;

import java.util.List;

/**
 * @author Spyros Foniadakis
 */
public final class FloatKeyedMaxHeap<T> extends AbstractFloatKeyedArrayHeap<T> {

    FloatKeyedMaxHeap(){
        this(10, 0);
    }

    FloatKeyedMaxHeap(final int capacity, final int size){
        this(new FloatKeyedElement[capacity], size);
    }

    FloatKeyedMaxHeap(final FloatKeyedElement<T>[] elements){
        this(elements, elements.length);
    }

    FloatKeyedMaxHeap(final FloatKeyedElement<T>[] elements, final int size){
        super(elements, size, (FloatComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    FloatKeyedMaxHeap(final List<FloatKeyedElement<T>> elements){
        super(elements, elements.size(), (FloatComparator) (a, b) -> a > b ? -1 : a < b ? 1 : 0);
    }

    FloatKeyedMaxHeap(final FloatKeyedMaxHeap heap){
        super(heap);
    }

    @Override
    public void increaseElementKeyBy(final int index, final float offset) {
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

    public final static FloatKeyedMaxHeap newHeap(){
        return new FloatKeyedMaxHeap();
    }

    public final static FloatKeyedMaxHeap newHeap(int capacity){
        return new FloatKeyedMaxHeap(capacity, 0);
    }

    public final static <T> FloatKeyedMaxHeap from(FloatKeyedElement<T>[] elements){
        return new FloatKeyedMaxHeap(elements);
    }

    public final static <T> FloatKeyedMaxHeap from(FloatKeyedElement<T>[] elements, int capacity){
        return new FloatKeyedMaxHeap(elements, capacity);
    }

    public final static FloatKeyedMaxHeap from(List<FloatKeyedMaxHeap> elements){ return new FloatKeyedMaxHeap(elements); }

    public final static FloatKeyedMaxHeap from(FloatKeyedMaxHeap heap){ return new FloatKeyedMaxHeap(heap); }
}
