package sorting;

import org.junit.Test;
import sorting.InsertionSort;
import utils.AssertUtils;

import java.util.Arrays;

public class TestInsertionSort {

    @Test
    public void test_insertionSort_int(){
        System.out.println(" ==== Test: test_insertionSort_int == STARTED =====");

        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        int[] copiedBefore = Arrays.copyOf(numbers, numbers.length);

        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        InsertionSort.sort(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        int[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(" ==== Test: test_insertionSort_int == STARTED ===== \n\n");
    }

    @Test
    public void test_insertionSort_intSorted(){
        System.out.println(" ==== Test: test_insertionSort_intSorted == STARTED =====");

        int[] numbers = new int[]{0, 1, 3, 6, 8, 9, 10, 12, 14, 16, 21};
        int[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        InsertionSort.sort(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        int[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(" ==== Test: test_insertionSort_intSorted == ENDED ===== \n\n");
    }

    @Test
    public void test_insertionSort_float(){
        System.out.println(" ==== Test: test_insertionSort_float == STARTED =====");

        float[] numbers = new float[]{1.0f, 14.1f, 8.3f, 10.8f, 6.2f, 9.01f, 21.3f, 16.7f, 12.2f, 3.3f, 0.4f};
        float[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        InsertionSort.sort(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        float[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(" ==== Test: test_insertionSort_float == STARTED ===== \n\n");
    }

    @Test
    public void test_insertionSort_floatSorted(){
        System.out.println(" ==== Test: test_insertionSort_floatSorted == STARTED =====");

        float[] numbers = new float[]{0.4f, 1.0f, 3.3f, 6.2f, 8.3f, 9.01f, 10.8f, 12.2f, 14.1f, 16.7f, 21.3f};
        float[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        InsertionSort.sort(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        float[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(" ==== Test: test_insertionSort_floatSorted == ENDED ===== \n\n");
    }

    @Test
    public void test_insertionSort_double(){
        System.out.println(" ==== Test: test_insertionSort_double == STARTED =====");

        double[] numbers = new double[]{1.0d, 14.1d, 8.3d, 10.8d, 6.2d, 9.01d, 21.3d, 16.7d, 12.2d, 3.3d, 0.4d};
        double[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        InsertionSort.sort(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        double[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(" ==== Test: test_insertionSort_double == STARTED ===== \n\n");
    }

    @Test
    public void test_insertionSort_doubleSorted(){
        System.out.println(" ==== Test: test_insertionSort_doubleSorted == STARTED =====");

        double[] numbers = new double[]{1.0d, 14.1d, 8.3d, 10.8d, 6.2d, 9.01d, 21.3d, 16.7d, 12.2d, 3.3d, 0.4d};
        double[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        InsertionSort.sort(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        double[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(" ==== Test: test_insertionSort_doubleSorted == ENDED ===== \n\n");
    }
}
