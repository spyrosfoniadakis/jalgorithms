package sorting;

import org.junit.Test;
import utils.AssertUtils;

import java.util.Arrays;
import java.util.function.Consumer;

public class TestInsertionSort {

    @Test
    public void test_insertionSort_int(){
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        this.executeSortTestOn(numbers,  InsertionSort::sort);
    }

    @Test
    public void test_insertionSort_intSorted(){
        int[] numbers = new int[]{0, 1, 3, 6, 8, 9, 10, 12, 14, 16, 21};
        this.executeSortTestOn(numbers,  InsertionSort::sort);
    }

    public void executeSortTestOn(int[] numbers, Consumer<int[]> sortingAction){
        System.out.println(" ==== Test: test_insertionSort_intSorted == STARTED =====");

        int[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        sortingAction.accept(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        int[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(" ==== Test: test_insertionSort_intSorted == ENDED ===== \n\n");
    }

    @Test
    public void test_insertionSort_long(){
        long[] numbers = new long[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        this.executeSortTestOn(numbers,  InsertionSort::sort);
    }

    @Test
    public void test_insertionSort_longSorted(){
        long[] numbers = new long[]{0, 1, 3, 6, 8, 9, 10, 12, 14, 16, 21};
        this.executeSortTestOn(numbers,  InsertionSort::sort);
    }

    public void executeSortTestOn(long[] numbers, Consumer<long[]> sortingAction){
        System.out.println(" ==== Test: test_insertionSort_intSorted == STARTED =====");

        long[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        sortingAction.accept(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        long[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(" ==== Test: test_insertionSort_intSorted == ENDED ===== \n\n");
    }

    @Test
    public void test_insertionSort_float(){
        float[] numbers = new float[]{1.0f, 14.1f, 8.3f, 10.8f, 6.2f, 9.01f, 21.3f, 16.7f, 12.2f, 3.3f, 0.4f};
        this.executeSortTestOn(numbers, InsertionSort::sort);
    }

    @Test
    public void test_insertionSort_floatSorted(){
        float[] numbers = new float[]{0.4f, 1.0f, 3.3f, 6.2f, 8.3f, 9.01f, 10.8f, 12.2f, 14.1f, 16.7f, 21.3f};
        this.executeSortTestOn(numbers, InsertionSort::sort);
    }

    public void executeSortTestOn(float[] numbers, Consumer<float[]> sortingAction){
        System.out.println(" ==== Test: test_insertionSort_floatSorted == STARTED =====");

        float[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        sortingAction.accept(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        float[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(" ==== Test: test_insertionSort_floatSorted == ENDED ===== \n\n");
    }

    @Test
    public void test_insertionSort_double(){
        double[] numbers = new double[]{1.0d, 14.1d, 8.3d, 10.8d, 6.2d, 9.01d, 21.3d, 16.7d, 12.2d, 3.3d, 0.4d};
        this.executeSortTestOn(numbers, InsertionSort::sort);
    }

    @Test
    public void test_insertionSort_doubleSorted(){
        double[] numbers = new double[]{1.0d, 14.1d, 8.3d, 10.8d, 6.2d, 9.01d, 21.3d, 16.7d, 12.2d, 3.3d, 0.4d};
        this.executeSortTestOn(numbers, InsertionSort::sort);
    }

    public void executeSortTestOn(double[] numbers, Consumer<double[]> sortingAction){
        System.out.println(" ==== Test: test_insertionSort_floatSorted == STARTED =====");

        double[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        sortingAction.accept(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        double[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(" ==== Test: test_insertionSort_floatSorted == ENDED ===== \n\n");
    }
}
