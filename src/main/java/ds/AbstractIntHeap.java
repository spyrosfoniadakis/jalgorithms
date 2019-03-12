package ds;

import utils.ArrayUtils;

import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

public abstract class AbstractIntHeap extends AbstractPrimitiveArrayHeap{

    @FunctionalInterface
    interface IntHeapOrderComparator{
        boolean shouldSwap(int a, int b);
    }

//    protected IntBinaryOperator comparator;


    protected int[] elements;

    protected AbstractIntHeap(){
        this(10);
    }

    protected AbstractIntHeap(int capacity){
        this.elements = new int[capacity];
        this.setSize(0);
    }

    protected AbstractIntHeap(int[] elements){
        this(elements, elements.length);
    }

    protected AbstractIntHeap(int[] elements, int size){
        this.elements = elements;
        this.setSize(size);
        this.build();
    }

    @Override
    public int getCapacity() {
        return elements.length;
    }

    public int peek(){
        return elements[0];
    }

    public int extract(){
        int extracted = elements[0];
        this.elements[0] = this.elements[elements.length-1];
        this.size--;
        this.heapify();
        return extracted;
    }

    protected void heapifyFrom(int index, IntHeapOrderComparator cmp) {
        int leftIndex = getLeftChildIndexOf(index);
        int rightIndex= getRightChildIndexOf(index);
        int nextIndex = index;

        if(leftIndex == -1 && rightIndex == -1)
            return;

        System.out.println(String.format("heap size: %s, left: %s, right: %s, root: %s", this.getSize(), leftIndex, rightIndex, index));

        if (leftIndex != -1 && cmp.shouldSwap(elements[nextIndex], elements[leftIndex])){
            nextIndex = leftIndex;
        }
        if(rightIndex != -1 && cmp.shouldSwap(elements[nextIndex], elements[rightIndex])){
            nextIndex = rightIndex;
        }
        if(index != nextIndex){
            ArrayUtils.swap(elements, index, nextIndex);
            this.heapifyFrom(nextIndex, cmp);
        }
    }

    public void sort(){
        for(int i = this.getSize()-1; i>=0 ; i--){
            ArrayUtils.swap(this.elements, 0, i);
            this.setSize(this.getSize()-1);
            this.heapify();
        }
    }

    public abstract void build();

    public abstract void increaseElementValueBy(int index, int value);

    public void insert(int element){
        this.ensureInsertion(0);
        this.increaseElementValueBy(size-1, element);
    }

    protected void ensureInsertion(int element){
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
}
