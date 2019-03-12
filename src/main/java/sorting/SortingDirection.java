package sorting;

import ds.AbstractIntHeap;
import ds.IntMaxHeap;
import ds.IntMinHeap;

import java.util.function.BiFunction;

public enum SortingDirection {
    ASCENDING{
        @Override
        public BiFunction<Integer, Integer, Boolean> shouldSwap() {
            return (a, b) -> a > b ;
        }

        @Override
        public AbstractIntHeap getIntHeap(int[] numbers) {
            return IntMaxHeap.from(numbers);
        }
    },
    DESCENDING{
        @Override
        public BiFunction<Integer, Integer, Boolean> shouldSwap() {
            return (a, b) -> a < b ;
        }

        @Override
        public AbstractIntHeap getIntHeap(int[] numbers) {
            return IntMinHeap.from(numbers);
        }
    };

    public abstract BiFunction<Integer, Integer, Boolean> shouldSwap();
    public abstract AbstractIntHeap getIntHeap(int[] numbers) ;
}
