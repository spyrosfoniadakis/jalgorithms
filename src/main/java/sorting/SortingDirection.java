package sorting;

import comparator.*;
import ds.*;

public enum SortingDirection {
    ASCENDING{
        @Override
        SortingDirection getOpposite() {
            return DESCENDING;
        }

        @Override
        IntComparator getIntComparator() {
            return Comparators.INT_ASCENDING_COMPARATOR;
        }

        @Override
        LongComparator getLongComparator() {
            return Comparators.LONG_ASCENDING_COMPARATOR;
        }

        @Override
        FloatComparator getFloatComparator() {
            return Comparators.FLOAT_ASCENDING_COMPARATOR;
        }

        @Override
        DoubleComparator getDoubleComparator() {
            return Comparators.DOUBLE_ASCENDING_COMPARATOR;
        }
//        @Override
//        public boolean shouldSwap(int a, int b){
//            return this.comparator.applyAsInt(a, b) > 0;
//        }

//        @Override
//        AbstractIntHeap createHeapFrom(int[] numbers) {
//            return IntMaxHeap.from(numbers);
//        }
//
//        @Override
//        AbstractLongHeap createHeapFrom(long[] numbers) {
//            return LongMaxHeap.from(numbers);
//        }
//
//        @Override
//        AbstractFloatHeap createHeapFrom(float[] numbers) {
//            return FloatMaxHeap.from(numbers);
//        }
//
//        @Override
//        AbstractDoubleHeap createHeapFrom(double[] numbers) {
//            return DoubleMaxHeap.from(numbers);
//        }
    },
    DESCENDING{
        @Override
        SortingDirection getOpposite() {
            return ASCENDING;
        }

        @Override
        IntComparator getIntComparator() {
            return Comparators.INT_DESCENDING_COMPARATOR;
        }

        @Override
        LongComparator getLongComparator() {
            return Comparators.LONG_DESCENDING_COMPARATOR;
        }

        @Override
        FloatComparator getFloatComparator() {
            return Comparators.FLOAT_DESCENDING_COMPARATOR;
        }

        @Override
        DoubleComparator getDoubleComparator() {
            return Comparators.DOUBLE_DESCENDING_COMPARATOR;
        }
//        @Override
//        public boolean shouldSwap(int a, int b){
//            return this.comparator.applyAsInt(a, b) < 0;
//        }

//        @Override
//        AbstractIntHeap createHeapFrom(int[] numbers) {
//            return IntMinHeap.from(numbers);
//        }
//
//        @Override
//        AbstractLongHeap createHeapFrom(long[] numbers) {
//            return LongMinHeap.from(numbers);
//        }
//
//        @Override
//        AbstractFloatHeap createHeapFrom(float[] numbers) {
//            return FloatMinHeap.from(numbers);
//        }
//
//        @Override
//        AbstractDoubleHeap createHeapFrom(double[] numbers) {
//            return DoubleMinHeap.from(numbers);
//        }
    };

//    protected IntBinaryOperator comparator = (a, b) -> a < b ? 1 : (a > b) ? -1 : 0;
//    public abstract boolean shouldSwap(int a, int b);
//    abstract AbstractIntHeap createHeapFrom(int[] numbers);
//    abstract AbstractLongHeap createHeapFrom(long[] numbers);
//    abstract AbstractFloatHeap createHeapFrom(float[] numbers);
//    abstract AbstractDoubleHeap createHeapFrom(double[] numbers);

    abstract SortingDirection getOpposite();
    abstract IntComparator getIntComparator();
    abstract LongComparator getLongComparator();
    abstract FloatComparator getFloatComparator();
    abstract DoubleComparator getDoubleComparator();
}
