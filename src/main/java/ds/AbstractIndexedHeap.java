package ds;

public abstract class AbstractIndexedHeap extends AbstractHeap implements IndexedHeapCollection {

    @Override
    public int getParentIndexOf(final int index) {
        if (index == 0){
            return -1;
        }
        return index >> 1;
    }

    @Override
    public int getLeftChildIndexOf(final int index) {
        int childIndex =  (index != 0) ? index << 1 : 1;
        return (childIndex < this.size) ? childIndex : -1;
    }

    @Override
    public int getRightChildIndexOf(final int index) {
        int childIndex =  (index != 0) ? (index << 1) + 1 : 2;
        return (childIndex < this.size) ? childIndex : -1;
    }
}
