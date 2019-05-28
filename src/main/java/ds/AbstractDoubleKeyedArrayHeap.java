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

import KeyedElement.DoubleKeyedElement;
import comparator.DoubleComparator;
import utils.ArrayUtils;

import java.util.List;

/**
 * @author Spyros Foniadakis
 */
public abstract class AbstractDoubleKeyedArrayHeap<T> extends AbstractIndexedHeap implements IndexedHeapCollection  {

    protected DoubleKeyedElement<T>[] elements;
    private DoubleComparator keysComparator;

    protected AbstractDoubleKeyedArrayHeap(final DoubleComparator comparator){
        this(comparator, 10);
    }

    protected AbstractDoubleKeyedArrayHeap(final DoubleComparator comparator, final int capacity){
        this.elements = new DoubleKeyedElement[capacity];
        this.keysComparator = comparator;
        this.setSize(size);
        this.build();
    }

    protected AbstractDoubleKeyedArrayHeap(final DoubleKeyedElement<T>[] elements, final int size, final DoubleComparator comparator){
        this.elements = elements;
        this.keysComparator = comparator;
        this.setSize(size);
        this.build();
    }

    protected AbstractDoubleKeyedArrayHeap(final List<DoubleKeyedElement<T>> elements, final DoubleComparator comparator){
        this(elements, elements.size(), comparator);
    }

    protected AbstractDoubleKeyedArrayHeap(final List<DoubleKeyedElement<T>> elements, final int size, final DoubleComparator comparator){
        this.elements = new DoubleKeyedElement[elements.size()];
        int index = 0;
        for(DoubleKeyedElement<T> element : elements){
            this.elements[index++] = element;
        }
        this.keysComparator = comparator;
        this.setSize(size);
        this.build();
    }

    protected AbstractDoubleKeyedArrayHeap(AbstractDoubleKeyedArrayHeap heap){
        this(heap.elements.clone(), heap.size, heap.keysComparator);
    }

    private AbstractDoubleKeyedArrayHeap(){
        this(10);
    }

    private AbstractDoubleKeyedArrayHeap(final int capacity){
        elements = new DoubleKeyedElement[capacity];
    }

    @Override
    public int getCapacity() {
        return elements.length;
    }

    public final DoubleKeyedElement<T> peek(){
        return elements[0];
    }

    public final T peekValue(){
        return elements[0].getValue();
    }

    public final double peekKey(){ return elements[0].getKey(); }


    public final DoubleKeyedElement<T> extract(){
        DoubleKeyedElement<T> extracted = elements[0];
        this.elements[0] = this.elements[--this.size];
        this.heapify();
        return extracted;
    }

    public final T extractValue(){
        return this.extract().getValue();
    }

    public final double extractKey(){
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

        if (leftIndex != -1 && this.shouldSwap(elements[nextIndex], elements[leftIndex])){
            nextIndex = leftIndex;
        }
        if(rightIndex != -1 && this.shouldSwap(elements[nextIndex], elements[rightIndex])){
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
    public abstract void increaseElementKeyBy(final int index, final double offset);

    public final void insert(final T value, final int key){
        this.ensureInsertion(DoubleKeyedElement.from(0, value));
        this.increaseElementKeyBy(size-1, key);
    }

    protected final void ensureInsertion(final DoubleKeyedElement<T> element){
        if(this.size < this.elements.length){
            this.elements[this.size++] = element;
            return;
        }

        DoubleKeyedElement<T>[] newElements = new DoubleKeyedElement[2*this.elements.length];
        for(int i=0; i< this.elements.length; i++){
            newElements[i] = elements[i];
        }
        newElements[this.size++] = element;
        this.elements = newElements;
    }

    private boolean shouldSwap(final DoubleKeyedElement<T> t1, final DoubleKeyedElement<T> t2){
        return this.keysComparator.shouldSwap(t1.getKey(), t2.getKey());
    }

    protected final DoubleComparator getComparator(){
        return this.keysComparator;
    }

}
