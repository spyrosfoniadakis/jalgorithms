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

import comparator.FloatComparator;
import utils.ArrayUtils;

/**
 * @author Spyros Foniadakis
 */
public abstract class AbstractFloatHeap extends AbstractIndexedHeap { //AbstractPrimitiveArrayHeap {

    /**
     * This interface although a Comparator it does not extends the Comparator interface
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
    public interface FloatHeapComparator extends FloatComparator {

        @Override
        int compare(float a, float b);

        @Override
        default boolean shouldSwap(float a, float b){
            return this.compare(a, b) > 0;
        }

    }

    protected float[] elements;
    private FloatComparator comparator;

    protected AbstractFloatHeap(FloatComparator comparator){
        this(comparator, 10);
    }

    protected AbstractFloatHeap(FloatComparator comparator, int capacity){
        this(new float[capacity], comparator);
    }

    protected AbstractFloatHeap(float[] elements, FloatComparator comparator){
        this(elements, elements.length, comparator);
    }

    protected AbstractFloatHeap(float[] elements, int size, FloatComparator comparator){
        this.elements = elements;
        this.comparator = comparator;
        this.setSize(size);
        this.build();
    }

    protected AbstractFloatHeap(AbstractFloatHeap heap){
        this(heap.elements.clone(), heap.size, heap.comparator);
    }

    @Override
    public final int getCapacity() {
        return elements.length;
    }

    public final float peek(){
        return elements[0];
    }

    public float extract(){
        float extracted = elements[0];
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

        System.out.println(String.format("heap size: %s, left: %s, right: %s, root: %s", this.getSize(), leftIndex, rightIndex, index));

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

    @Override
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
    public abstract void increaseElementValueBy(int index, float value);

    public final void insert(float element){
        this.ensureInsertion(0);
        this.increaseElementValueBy(size-1, element);
    }

    protected final void ensureInsertion(float element){
        if(this.size < this.elements.length){
            this.elements[this.size++] = element;
            return;
        }

        float[] newElements = new float[2*this.elements.length];
        for(int i=0; i< this.elements.length; i++){
            newElements[i]= elements[i];
        }
        newElements[this.size++] = element;
        this.elements = newElements;
    }

    protected final FloatComparator getComparator(){
        return this.comparator;
    }
}
