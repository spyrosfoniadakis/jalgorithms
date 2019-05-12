package ds;

import KeyedElement.DoubleKeyedElement;
import comparator.DoubleComparator;
import utils.ArrayUtils;

import java.util.List;

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

    private AbstractDoubleKeyedArrayHeap(int capacity){
        elements = new DoubleKeyedElement[10];
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
    public abstract void increaseElementKeyBy(int index, int offset);

    public final void insert(T value, int key){
        this.ensureInsertion(DoubleKeyedElement.from(0, value));
        this.increaseElementKeyBy(size-1, key);
    }

    protected final void ensureInsertion(DoubleKeyedElement<T> element){
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

    private boolean shouldSwap(DoubleKeyedElement<T> t1, DoubleKeyedElement<T> t2){
        return this.keysComparator.shouldSwap(t1.getKey(), t2.getKey());
    }

    protected final DoubleComparator getComparator(){
        return this.keysComparator;
    }

}
