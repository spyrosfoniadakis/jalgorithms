package sorting;

import org.junit.Test;
import sorting.MergeSort;
import utils.AssertUtils;

import java.util.Arrays;

public class TestMergeSort {

    @Test
    public void test_mergeSort_int(){
        System.out.println(" ==== Test: test_mergeSort_int == STARTED =====");

        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};

        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        MergeSort.sort(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers);

        System.out.println(" ==== Test: test_mergeSort_int == STARTED ===== \n\n");
    }

    @Test
    public void test_mergeSort_intSorted(){
        System.out.println(" ==== Test: test_mergeSort_intSorted == STARTED =====");

        int[] numbers = new int[]{0, 1, 3, 6, 8, 9, 10, 12, 14, 16, 21};
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        MergeSort.sort(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers);

        System.out.println(" ==== Test: test_mergeSort_intSorted == ENDED ===== \n\n");
    }

    @Test
    public void test_mergeSort_float(){
        System.out.println(" ==== Test: test_mergeSort_float == STARTED =====");

        float[] numbers = new float[]{1.0f, 14.1f, 8.3f, 10.8f, 6.2f, 9.01f, 21.3f, 16.7f, 12.2f, 3.3f, 0.4f};
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        MergeSort.sort(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers);

        System.out.println(" ==== Test: test_mergeSort_float == STARTED ===== \n\n");
    }

    @Test
    public void test_mergeSort_floatSorted(){
        System.out.println(" ==== Test: test_mergeSort_floatSorted == STARTED =====");

        float[] numbers = new float[]{0.4f, 1.0f, 3.3f, 6.2f, 8.3f, 9.01f, 10.8f, 12.2f, 14.1f, 16.7f, 21.3f};
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        MergeSort.sort(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers);

        System.out.println(" ==== Test: test_mergeSort_floatSorted == ENDED ===== \n\n");
    }

}
