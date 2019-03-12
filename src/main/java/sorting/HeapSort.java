package sorting;

import ds.AbstractIntHeap;
import ds.IntMaxHeap;

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

        public void sort(int[] numbers, SortingDirection direction) {
            AbstractIntHeap heap = direction.getIntHeap(numbers);
//            IntMaxHeap heap = IntMaxHeap.from(numbers);
            heap.sort();
        }




        @Override
        public void sort(long[] numbers) {

        }

        @Override
        public void sort(float[] numbers) {

        }

        @Override
        public void sort(double[] numbers) {

        }

        @Override
        public <T extends Comparable<T>> void sort(T[] elements) {

        }

        @Override
        public <T> void sort(T[] elements, Comparator<T> comparator) {

        }
    }
}
