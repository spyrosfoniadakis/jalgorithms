package ds;

public abstract class AbstractHeap implements Heap{

    protected int size;

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
