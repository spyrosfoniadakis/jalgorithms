package sorting;

import ds.AbstractIntHeap;
import ds.IntMaxHeap;
import ds.IntMinHeap;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public enum SortingDirection {
    ASCENDING{
        @Override
        public boolean shouldSwap(int a, int b){
            return this.comparator.applyAsInt(a, b) > 0;
        }

        @Override
        public AbstractIntHeap getIntHeap(int[] numbers) {
            return IntMaxHeap.from(numbers);
        }
    },
    DESCENDING{
        @Override
        public boolean shouldSwap(int a, int b){
            return this.comparator.applyAsInt(a, b) < 0;
        }

        @Override
        public AbstractIntHeap getIntHeap(int[] numbers) {
            return IntMinHeap.from(numbers);
        }
    };

    protected IntBinaryOperator comparator = (a, b) -> a < b ? 1 : (a > b) ? -1 : 0;
    public abstract boolean shouldSwap(int a, int b);
    public abstract AbstractIntHeap getIntHeap(int[] numbers);
}
