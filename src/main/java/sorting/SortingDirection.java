package sorting;

import ds.*;

import java.util.function.IntBinaryOperator;


// TODO: Redefine it as a static class in the Heap, so as to legitimately handle the heap construction
public enum SortingDirection {
    ASCENDING{
        @Override
        public boolean shouldSwap(int a, int b){
            return this.comparator.applyAsInt(a, b) > 0;
        }

        @Override
        AbstractIntHeap createHeapFrom(int[] numbers) {
            return IntMaxHeap.from(numbers);
        }

        @Override
        AbstractLongHeap createHeapFrom(long[] numbers) {
            return LongMaxHeap.from(numbers);
        }

        @Override
        AbstractFloatHeap createHeapFrom(float[] numbers) {
            return FloatMaxHeap.from(numbers);
        }

        @Override
        AbstractDoubleHeap createHeapFrom(double[] numbers) {
            return DoubleMaxHeap.from(numbers);
        }
    },
    DESCENDING{
        @Override
        public boolean shouldSwap(int a, int b){
            return this.comparator.applyAsInt(a, b) < 0;
        }

        @Override
        AbstractIntHeap createHeapFrom(int[] numbers) {
            return IntMinHeap.from(numbers);
        }

        @Override
        AbstractLongHeap createHeapFrom(long[] numbers) {
            return LongMinHeap.from(numbers);
        }

        @Override
        AbstractFloatHeap createHeapFrom(float[] numbers) {
            return FloatMinHeap.from(numbers);
        }

        @Override
        AbstractDoubleHeap createHeapFrom(double[] numbers) {
            return DoubleMinHeap.from(numbers);
        }
    };

    protected IntBinaryOperator comparator = (a, b) -> a < b ? 1 : (a > b) ? -1 : 0;
    public abstract boolean shouldSwap(int a, int b);
    abstract AbstractIntHeap createHeapFrom(int[] numbers);
    abstract AbstractLongHeap createHeapFrom(long[] numbers);
    abstract AbstractFloatHeap createHeapFrom(float[] numbers);
    abstract AbstractDoubleHeap createHeapFrom(double[] numbers);
}
