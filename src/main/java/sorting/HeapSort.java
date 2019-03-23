package sorting;

import comparator.*;
import ds.*;

import java.util.Comparator;

public final class HeapSort {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", HeapSort.class);
    private static HeapSorter sorter = new HeapSorter();

    private HeapSort(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    public static void sort(int[] numbers, SortingDirection direction){
        sorter.sort(numbers, direction);
    }

    public static void sort(float[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(float[] numbers, SortingDirection direction){
        sorter.sort(numbers, direction);
    }

    public static void sort(long[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(long[] numbers, SortingDirection direction){
        sorter.sort(numbers, direction);
    }

    public static void sort(double[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(double[] numbers, SortingDirection direction){
        sorter.sort(numbers, direction);
    }

    private static class IntHeap extends AbstractIntHeap{

        private IntHeap(int[] elements, IntComparator comparator){
            super(elements, elements.length, comparator);
        }

        @Override
        public void increaseElementValueBy(int index, int value) {
            throw new UnsupportedOperationException();
        }

        public static IntHeap from(int[] elements, IntComparator comparator){
            return new IntHeap(elements, comparator);
        }
    }

    private static class LongHeap extends AbstractLongHeap{

        private LongHeap(long[] elements, LongComparator comparator){
            super(elements, elements.length, comparator);
        }

        @Override
        public void increaseElementValueBy(int index, long value) {
            throw new UnsupportedOperationException();
        }

        public static LongHeap from(long[] elements, LongComparator comparator){
            return new LongHeap(elements, comparator);
        }
    }

    private static class FloatHeap extends AbstractFloatHeap{

        private FloatHeap(float[] elements, FloatComparator comparator){
            super(elements, elements.length, comparator);
        }

        @Override
        public void increaseElementValueBy(int index, float value) {
            throw new UnsupportedOperationException();
        }

        public static FloatHeap from(float[] elements, FloatComparator comparator){
            return new FloatHeap(elements, comparator);
        }
    }

    private static class DoubleHeap extends AbstractDoubleHeap{

        private DoubleHeap(double[] elements, DoubleComparator comparator){
            super(elements, elements.length, comparator);
        }

        @Override
        public void increaseElementValueBy(int index, double value) {
            throw new UnsupportedOperationException();
        }

        public static DoubleHeap from(double[] elements, DoubleComparator comparator){
            return new DoubleHeap(elements, comparator);
        }
    }

    private static class HeapSorter implements Sorter {

        @Override
        public void sort(int[] numbers) {
            IntHeap.from(numbers, Comparators.INT_ASCENDING_COMPARATOR).sort();
        }

        public void sort(int[] numbers, SortingDirection direction) {
            IntHeap.from(numbers, direction.getOpposite().getIntComparator()).sort();
        }

        @Override
        public void sort(long[] numbers) {
            LongHeap.from(numbers, Comparators.LONG_ASCENDING_COMPARATOR).sort();
        }

        public void sort(long[] numbers, SortingDirection direction) {
            LongHeap.from(numbers, direction.getOpposite().getLongComparator()).sort();
        }

        @Override
        public void sort(float[] numbers) {
            FloatHeap.from(numbers, Comparators.FLOAT_ASCENDING_COMPARATOR).sort();
        }

        public void sort(float[] numbers, SortingDirection direction) {
            FloatHeap.from(numbers, direction.getOpposite().getFloatComparator()).sort();
        }

        @Override
        public void sort(double[] numbers) {
            DoubleHeap.from(numbers, Comparators.DOUBLE_ASCENDING_COMPARATOR).sort();
        }

        public void sort(double[] numbers, SortingDirection direction) {
            DoubleHeap.from(numbers, direction.getOpposite().getDoubleComparator()).sort();
        }


        @Override
        public <T extends Comparable<T>> void sort(T[] elements) {

        }

        @Override
        public <T> void sort(T[] elements, Comparator<T> comparator) {

        }
    }
}
