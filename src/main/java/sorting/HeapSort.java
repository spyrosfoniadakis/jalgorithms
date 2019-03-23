package sorting;

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

    public static void sort(long[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(double[] numbers){
        sorter.sort(numbers);
    }

    private static class HeapSorter implements Sorter {

        @Override
        public void sort(int[] numbers) {
            IntMaxHeap heap = IntMaxHeap.from(numbers);
            heap.sort();
        }

        // TODO: Allow the client code to decide between ascending and descending ordering
        //      in all Sorters, so put it in the Sorter interface. Also redesign the
        //      SortingDirection enum.
        public void sort(int[] numbers, SortingDirection direction) {
            AbstractIntHeap heap = direction.createHeapFrom(numbers);
            heap.sort();
        }

        @Override
        public void sort(long[] numbers) {
            LongMaxHeap heap = LongMaxHeap.from(numbers);
            heap.sort();
        }

        public void sort(long[] numbers, SortingDirection direction) {
            AbstractLongHeap heap = direction.createHeapFrom(numbers);
            heap.sort();
        }

        @Override
        public void sort(float[] numbers) {
            FloatMaxHeap heap = FloatMaxHeap.from(numbers);
            heap.sort();
        }

        @Override
        public void sort(double[] numbers) {
            DoubleMaxHeap heap = DoubleMaxHeap.from(numbers);
            heap.sort();
        }

        @Override
        public <T extends Comparable<T>> void sort(T[] elements) {

        }

        @Override
        public <T> void sort(T[] elements, Comparator<T> comparator) {

        }
    }
}
