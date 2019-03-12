package sorting;

import org.junit.Test;
import utils.AssertUtils;

import java.util.Arrays;

public class TestHeapSort {

    @Test
    public void test_heapSort_intDesending(){
        System.out.println(" ==== Test: test_heapSort_int == STARTED =====");

        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};

        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        HeapSort.sort(numbers, SortingDirection.DESCENDING);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers, AssertUtils.SortingDirection.DESCENDING);

        System.out.println(" ==== Test: test_heapSort_int == END ===== \n\n");
    }

    @Test
    public void test_heapSort_intAscending(){
        System.out.println(" ==== Test: test_heapSort_int == STARTED =====");

        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};

        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        HeapSort.sort(numbers, SortingDirection.ASCENDING);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers, AssertUtils.SortingDirection.ASCENDING);

        System.out.println(" ==== Test: test_heapSort_int == END ===== \n\n");
    }
}
