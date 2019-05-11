package ds;


import KeyedElement.IntKeyedElement;
import comparator.IntComparator;
import utils.ArrayUtils;

import java.util.List;

public abstract class AbstractIntKeyedArrayHeap<T> extends AbstractIndexedHeap implements IndexedHeapCollection  {

    protected IntKeyedElement<T>[] elements;
    private IntComparator keysComparator;

    protected AbstractIntKeyedArrayHeap(final IntComparator comparator){
        this(comparator, 10);
    }

    protected AbstractIntKeyedArrayHeap(final IntComparator comparator, final int capacity){
        this.elements = new IntKeyedElement[capacity];
        this.keysComparator = comparator;
        this.setSize(size);
        this.build();
    }

    protected AbstractIntKeyedArrayHeap(final IntKeyedElement<T>[] elements, final int size, final IntComparator comparator){
        this.elements = elements;
        this.keysComparator = comparator;
        this.setSize(size);
        this.build();
    }

    protected AbstractIntKeyedArrayHeap(final List<IntKeyedElement<T>> elements, final IntComparator comparator){
        this(elements, elements.size(), comparator);
    }

    protected AbstractIntKeyedArrayHeap(final List<IntKeyedElement<T>> elements, final int size, final IntComparator comparator){
        this.elements = new IntKeyedElement[elements.size()];
        int index = 0;
        for(IntKeyedElement<T> element : elements){
            this.elements[index++] = element;
        }
        this.keysComparator = comparator;
        this.setSize(size);
        this.build();
    }

    protected AbstractIntKeyedArrayHeap(AbstractIntKeyedArrayHeap heap){
        this(heap.elements.clone(), heap.size, heap.keysComparator);
    }

    private AbstractIntKeyedArrayHeap(){
        this(10);
    }

    private AbstractIntKeyedArrayHeap(int capacity){
        elements = new IntKeyedElement[10];
    }

    @Override
    public int getCapacity() {
        return elements.length;
    }

    public final IntKeyedElement<T> peek(){
        return elements[0];
    }

    public final T peekValue(){
        return elements[0].getValue();
    }

    public final int peekKey(){ return elements[0].getKey(); }


    public final IntKeyedElement<T> extract(){
        IntKeyedElement<T> extracted = elements[0];
        this.elements[0] = this.elements[--this.size];
        this.heapify();
        return extracted;
    }

    public final T extractValue(){
        return this.extract().getValue();
    }

    public final int extractKey(){
        return this.extract().getKey();
    }

    // TODO: Move up the hierarchy
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

    // TODO: Move up the hierarchy
    public final void sort(){
        for(int i = this.getSize()-1; i>=0 ; i--){
            ArrayUtils.swap(this.elements, 0, i);
            this.setSize(this.getSize()-1);
            this.heapify();
        }
    }

    // TODO: Move up the hierarchy
    public final void build(){
        for(int i=Math.floorDiv(this.elements.length, 2); i>=0; i--){
            heapifyFrom(i);
        }
    }

    /**
     * Increases or decreases (by adding a negative value) the initial value of the
     * element at <code>index</code>
     * @param index
     * @param offset
     */
    public abstract void increaseElementKeyBy(int index, int offset);

    public final void insert(T value, int key){
        this.ensureInsertion(IntKeyedElement.from(0, value));
        this.increaseElementKeyBy(size-1, key);
    }

    protected final void ensureInsertion(IntKeyedElement<T> element){
        if(this.size < this.elements.length){
            this.elements[this.size++] = element;
            return;
        }

        IntKeyedElement<T>[] newElements = new IntKeyedElement[2*this.elements.length];
        for(int i=0; i< this.elements.length; i++){
            newElements[i] = elements[i];
        }
        newElements[this.size++] = element;
        this.elements = newElements;
    }

    private boolean shouldSwap(IntKeyedElement<T> t1, IntKeyedElement<T> t2){
        return this.keysComparator.shouldSwap(t1.getKey(), t2.getKey());
    }

    protected final IntComparator getComparator(){
        return this.keysComparator;
    }

}