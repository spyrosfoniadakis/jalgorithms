package sorting;

import org.junit.Test;
import utils.AssertUtils;

import java.util.Arrays;

public class TestHeapSort {

    @Test
    public void test_heapSort_intDesending(){
        System.out.println(" ==== Test: test_heapSort_intDesending == STARTED =====");

        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};

        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        HeapSort.sort(numbers, SortingDirection.DESCENDING);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers, AssertUtils.SortingDirection.DESCENDING);

        System.out.println(" ==== Test: test_heapSort_intDesending == END ===== \n\n");
    }

    @Test
    public void test_heapSort_intAscending(){
        System.out.println(" ==== Test: test_heapSort_intAscending == STARTED =====");

        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};

        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        HeapSort.sort(numbers, SortingDirection.ASCENDING);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers, AssertUtils.SortingDirection.ASCENDING);

        System.out.println(" ==== Test: test_heapSort_intAscending == END ===== \n\n");
    }

    @Test
    public void test_heapSort_longDesending(){
        System.out.println(" ==== Test: test_heapSort_long == STARTED =====");

        long[] numbers = new long[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};

        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        HeapSort.sort(numbers, SortingDirection.DESCENDING);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers, AssertUtils.SortingDirection.DESCENDING);

        System.out.println(" ==== Test: test_heapSort_long == END ===== \n\n");
    }

    @Test
    public void test_heapSort_longAscending(){
        System.out.println(" ==== Test: test_heapSort_int == STARTED =====");

        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};

        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        HeapSort.sort(numbers, SortingDirection.ASCENDING);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers, AssertUtils.SortingDirection.ASCENDING);

        System.out.println(" ==== Test: test_heapSort_int == END ===== \n\n");
    }

    @Test
    public void test_heapSort_floatDesending(){
        System.out.println(" ==== Test: test_heapSort_floatDesending == STARTED =====");

        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};

        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        HeapSort.sort(numbers, SortingDirection.DESCENDING);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers, AssertUtils.SortingDirection.DESCENDING);

        System.out.println(" ==== Test: test_heapSort_floatDesending == END ===== \n\n");
    }

    @Test
    public void test_heapSort_floatAscending(){
        System.out.println(" ==== Test: test_heapSort_floatAscending == STARTED =====");

        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};

        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        HeapSort.sort(numbers, SortingDirection.ASCENDING);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers, AssertUtils.SortingDirection.ASCENDING);

        System.out.println(" ==== Test: test_heapSort_floatAscending == END ===== \n\n");
    }

    @Test
    public void test_heapSort_doubleDesending(){
        System.out.println(" ==== Test: test_heapSort_doubleDesending == STARTED =====");

        double[] numbers = new double[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};

        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        HeapSort.sort(numbers, SortingDirection.DESCENDING);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers, AssertUtils.SortingDirection.DESCENDING);

        System.out.println(" ==== Test: test_heapSort_doubleDesending == END ===== \n\n");
    }

    @Test
    public void test_heapSort_doubleAscending(){
        System.out.println(" ==== Test: test_heapSort_doubleAscending == STARTED =====");

        double[] numbers = new double[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};

        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        HeapSort.sort(numbers, SortingDirection.ASCENDING);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        AssertUtils.assertIsSorted(numbers, AssertUtils.SortingDirection.ASCENDING);

        System.out.println(" ==== Test: test_heapSort_doubleAscending == END ===== \n\n");
    }
}
