package sorting;

import java.util.Comparator;

interface Sorter {

//    @FunctionalInterface
//    interface SwapRule<T>{
//        boolean decide(T element1, T element2);
//    }

    void sort(int[] numbers);

    void sort(int[] numbers, SortingDirection direction);

    void sort(long[] numbers);

    void sort(long[] numbers, SortingDirection direction);

    void sort(float[] numbers);

    void sort(float[] numbers, SortingDirection direction);

    void sort(double[] numbers);

    void sort(double[] numbers, SortingDirection direction);

    <T extends Comparable<T>> void sort(T[] elements);

    <T> void sort(T[] elements, Comparator<T> comparator);
}
