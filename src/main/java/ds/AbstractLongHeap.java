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

import comparator.LongComparator;
import utils.ArrayUtils;

/**
 * @author Spyros Foniadakis
 */
public abstract class AbstractLongHeap extends AbstractIndexedHeap { //AbstractPrimitiveArrayHeap  {

    @FunctionalInterface
    public interface LongHeapComparator extends LongComparator {

        @Override
        int compare(long a, long b);

        @Override
        default boolean shouldSwap(long a, long b){
            return this.compare(a, b) > 0;
        }
    }

    protected long[] elements;
    private LongComparator comparator;

    protected AbstractLongHeap(LongComparator comparator){
        this(comparator, 10);
    }

    protected AbstractLongHeap(LongComparator comparator, int capacity){
        this(new long[capacity], comparator);
    }

    protected AbstractLongHeap(long[] elements, LongComparator comparator){
        this(elements, elements.length, comparator);
    }

    protected AbstractLongHeap(long[] elements, int size, LongComparator comparator){
        this.elements = elements;
        this.comparator = comparator;
        this.setSize(size);
        this.build();
    }

    protected AbstractLongHeap(AbstractLongHeap heap){
        this(heap.elements.clone(), heap.size, heap.comparator);
    }

    @Override
    public final int getCapacity() {
        return elements.length;
    }

    public final long peek(){
        return elements[0];
    }

    public final long extract(){
        long extracted = elements[0];
        this.elements[0] = this.elements[--this.size];
        this.heapify();
        return extracted;
    }

    protected final void heapifyFrom(int index) {
        int leftIndex = getLeftChildIndexOf(index);
        int rightIndex= getRightChildIndexOf(index);
        int nextIndex = index;

        if(leftIndex == -1 && rightIndex == -1)
            return;

        if (leftIndex != -1 && this.comparator.shouldSwap(elements[nextIndex], elements[leftIndex])){
            nextIndex = leftIndex;
        }
        if(rightIndex != -1 && this.comparator.shouldSwap(elements[nextIndex], elements[rightIndex])){
            nextIndex = rightIndex;
        }
        if(index != nextIndex){
            ArrayUtils.swap(elements, index, nextIndex);
            this.heapifyFrom(nextIndex);
        }
    }

    public final void sort(){
        for(int i = this.getSize()-1; i>=0 ; i--){
            ArrayUtils.swap(this.elements, 0, i);
            this.setSize(this.getSize()-1);
            this.heapify();
        }
    }

    public final void heapify(){
        heapifyFrom(0);
    }

    public final void build(){
        for(int i=Math.floorDiv(this.elements.length, 2); i>=0; i--){
            heapifyFrom(i);
        }
    }

    /**
     * Increases or decreases (by adding a negative value) the initial value of the
     * element at <code>index</code>
     * @param index
     * @param value
     */
    public abstract void increaseElementValueBy(int index, long value);

    public final void insert(long element){
        this.ensureInsertion(0);
        this.increaseElementValueBy(size-1, element);
    }

    protected final void ensureInsertion(long element){
        if(this.size < this.elements.length){
            this.elements[this.size++] = element;
            return;
        }

        long[] newElements = new long[2*this.elements.length];
        for(int i=0; i< this.elements.length; i++){
            newElements[i]= elements[i];
        }
        newElements[this.size++] = element;
        this.elements = newElements;
    }

    protected final LongComparator getComparator(){
        return this.comparator;
    }
}
