package ds;

public class ArrayHeap<T> extends AbstractIndexedHeap {

    @FunctionalInterface
    public interface ElementComparator<T extends ToIntEvaluator<T>>{
        int compare(T t1, T t2);
    }

    @FunctionalInterface
    public interface ToIntEvaluator<T>{
        int evaluate();
    }

    @FunctionalInterface
    public interface ToLongEvaluator<T>{
        long evaluate();
    }

    @FunctionalInterface
    public interface ToFloatEvaluator<T>{
        float evaluate();
    }

    @FunctionalInterface
    public interface ToDoubleEvaluator<T>{
        double evaluate();
    }



    private ArrayHeap(ToIntEvaluator<T> evaluator){

    }
    private ArrayHeap(ToDoubleEvaluator<T> evaluator){

    }
    private ArrayHeap(ToLongEvaluator<T> evaluator){

    }
    private ArrayHeap(ToFloatEvaluator<T> evaluator){

    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public void heapify() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
