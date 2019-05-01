/*
 * Copyright 2019 Spyridon Foniadakis
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
 *
 */
package ds;

import comparator.IntComparator;
import utils.ArrayUtils;

public abstract class AbstractIntHeap extends AbstractPrimitiveArrayHeap{

    /**
     * This interface although a Comparator it does not extends teh Comparator interface
     * because the latter is not defined for primitives and it would be better to avoid
     * any unnecessary boxing and unboxing. Both Comparator and IntHeapComparator define
     * the same method - boxing left aside - so nothing will actually be noticed by
     * anyone who is going to use it with a lambda expression.
     *
     * It could extend the IntBinaryOperator to maximize re-usability but it would confuse
     * those who will try to create an anonymous class or implement it some how in a class
     * based syntax.
     */
    @FunctionalInterface
    public interface IntHeapComparator extends IntComparator {

        int compare(int a, int b);

        default boolean shouldSwap(int a, int b){
            return this.compare(a, b) > 0;
        }
    }

    protected int[] elements;
    private IntComparator comparator;

    protected AbstractIntHeap(IntComparator comparator){
        this(comparator, 10);
    }

    protected AbstractIntHeap(IntComparator comparator, int capacity){
        this(new int[capacity], comparator);
    }

    protected AbstractIntHeap(int[] elements, IntComparator comparator){
        this(elements, elements.length, comparator);
    }

    protected AbstractIntHeap(int[] elements, int size, IntComparator comparator){
        this.elements = elements;
        this.comparator = comparator;
        this.setSize(size);
        this.build();
    }

    protected AbstractIntHeap(AbstractIntHeap heap){
        this(heap.elements.clone(), heap.size, heap.comparator);
    }

    @Override
    public final int getCapacity() {
        return elements.length;
    }

    public final int peek(){
        return elements[0];
    }

    public final int extract(){
        int extracted = elements[0];
        this.elements[0] = this.elements[--this.size];
        this.heapify();
        return extracted;
    }

    @Override
    public final void heapify(){
        heapifyFrom(0);
    }

    protected final void heapifyFrom(int index) {
        int leftIndex = getLeftChildIndexOf(index);
        int rightIndex= getRightChildIndexOf(index);
        int nextIndex = index;

        if(leftIndex == -1 && rightIndex == -1)
            return;

        System.out.println(String.format("heap size: %s, left: elements[%s] = %s, right: elements[%s] = %s, root: elements[%s] = %s",
                this.getSize(),
                leftIndex, (leftIndex != -1) ? elements[leftIndex] : "n/a",
                rightIndex, (rightIndex != -1) ? elements[rightIndex] : "n/a",
                index, (index != -1) ? elements[index] : "n/a"));

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
    public abstract void increaseElementValueBy(int index, int value);

    public final void insert(int element){
        this.ensureInsertion(0);
        this.increaseElementValueBy(size-1, element);
    }

    protected final void ensureInsertion(int element){
        if(this.size < this.elements.length){
            this.elements[this.size++] = element;
            return;
        }

        int[] newElements = new int[2*this.elements.length];
        for(int i=0; i< this.elements.length; i++){
            newElements[i]= elements[i];
        }
        newElements[this.size++] = element;
        this.elements = newElements;
    }

    protected final IntComparator getComparator(){
        return this.comparator;
    }
}
