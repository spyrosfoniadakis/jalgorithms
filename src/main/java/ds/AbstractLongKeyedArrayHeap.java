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
public abstract class AbstractLongKeyedArrayHeap<T> extends AbstractIndexedHeap implements IndexedHeapCollection  {

    protected LongKeyedElement<T>[] elements;
    private LongComparator keysComparator;

    protected AbstractLongKeyedArrayHeap(final LongComparator comparator){
        this(comparator, 10);
    }

    protected AbstractLongKeyedArrayHeap(final LongComparator comparator, final int capacity){
        this.elements = new LongKeyedElement[capacity];
        this.keysComparator = comparator;
        this.setSize(size);
        this.build();
    }

    protected AbstractLongKeyedArrayHeap(final LongKeyedElement<T>[] elements, final int size, final LongComparator comparator){
        this.elements = elements;
        this.keysComparator = comparator;
        this.setSize(size);
        this.build();
    }

    protected AbstractLongKeyedArrayHeap(final List<LongKeyedElement<T>> elements, final LongComparator comparator){
        this(elements, elements.size(), comparator);
    }

    protected AbstractLongKeyedArrayHeap(final List<LongKeyedElement<T>> elements, final int size, final LongComparator comparator){
        this.elements = new LongKeyedElement[elements.size()];
        int index = 0;
        for(LongKeyedElement<T> element : elements){
            this.elements[index++] = element;
        }
        this.keysComparator = comparator;
        this.setSize(size);
        this.build();
    }

    protected AbstractLongKeyedArrayHeap(final AbstractLongKeyedArrayHeap heap){
        this(heap.elements.clone(), heap.size, heap.keysComparator);
    }

    private AbstractLongKeyedArrayHeap(){
        this(10);
    }

    private AbstractLongKeyedArrayHeap(final int capacity){
        elements = new LongKeyedElement[capacity];
    }

    @Override
    public int getCapacity() {
        return elements.length;
    }

    public final LongKeyedElement<T> peek(){
        return elements[0];
    }

    public final T peekValue(){
        return elements[0].getValue();
    }

    public final long peekKey(){ return elements[0].getKey(); }


    public final LongKeyedElement<T> extract(){
        LongKeyedElement<T> extracted = elements[0];
        this.elements[0] = this.elements[--this.size];
        this.heapify();
        return extracted;
    }

    public final T extractValue(){
        return this.extract().getValue();
    }

    public final long extractKey(){
        return this.extract().getKey();
    }

    @Override
    public final void heapify(){
        heapifyFrom(0);
    }

    protected final void heapifyFrom(final int index) {
        int leftIndex = getLeftChildIndexOf(index);
        int rightIndex= getRightChildIndexOf(index);
        int nextIndex = index;

        if(leftIndex == -1 && rightIndex == -1)
            return;

        if (leftIndex != -1 && this.shouldSwap(elements[nextIndex], elements[leftIndex])){ //this.keysComparator.shouldSwap(elements[nextIndex].getKey(), elements[leftIndex].getKey())){
            nextIndex = leftIndex;
        }
        if(rightIndex != -1 && this.shouldSwap(elements[nextIndex], elements[rightIndex])){ //&& this.comparator.shouldSwap(elements[nextIndex], elements[rightIndex])){
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

    public final void build(){
        for(int i=Math.floorDiv(this.size, 2); i>=0; i--){
            heapifyFrom(i);
        }
    }

    /**
     * Increases or decreases (by adding a negative value) the initial value of the
     * element at <code>index</code>
     * @param index
     * @param offset
     */
    public abstract void increaseElementKeyBy(final int index, final long offset);

    public final void insert(final T value, final int key){
        this.ensureInsertion(LongKeyedElement.from(0, value));
        this.increaseElementKeyBy(size-1, key);
    }

    protected final void ensureInsertion(final LongKeyedElement<T> element){
        if(this.size < this.elements.length){
            this.elements[this.size++] = element;
            return;
        }

        LongKeyedElement<T>[] newElements = new LongKeyedElement[2*this.elements.length];
        for(int i=0; i< this.elements.length; i++){
            newElements[i] = elements[i];
        }
        newElements[this.size++] = element;
        this.elements = newElements;
    }

    private boolean shouldSwap(final LongKeyedElement<T> t1, final LongKeyedElement<T> t2){
        return this.keysComparator.shouldSwap(t1.getKey(), t2.getKey());
    }

    protected final LongComparator getComparator(){
        return this.keysComparator;
    }

}
