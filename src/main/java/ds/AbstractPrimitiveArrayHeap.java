package ds;

public abstract class AbstractPrimitiveArrayHeap implements PrimitiveHeap, IndexedHeapCollection {

    protected int size;

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getParentIndexOf(int index) {
        if (index == 0){
            return -1;
        }
        return index >> 1;
    }

    @Override
    public int getLeftChildIndexOf(int index) {
        int childIndex =  (index != 0) ? index << 1 : 1;
        return (childIndex < this.size) ? childIndex : -1;
    }

    @Override
    public int getRightChildIndexOf(int index) {
        int childIndex =  (index != 0) ? (index << 1) + 1 : 2;
        return (childIndex < this.size) ? childIndex : -1;
    }



    protected void setSize(int size) {
        this.size = size;
    }
}
