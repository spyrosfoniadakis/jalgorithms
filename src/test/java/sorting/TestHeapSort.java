package sorting;

import org.junit.Test;
import utils.AssertUtils;

import java.util.Arrays;

public class TestHeapSort {

    @Test
    public void test_heapSort_intDesending(){
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.DESCENDING, (a) -> HeapSort.sort(a, SortingDirection.DESCENDING),"test_heapSort_intDesending");
    }

    @Test
    public void test_heapSort_intAscending(){
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, (a) -> HeapSort.sort(a, SortingDirection.ASCENDING),"test_heapSort_intAscending");
    }

    @Test
    public void test_heapSort_longDesending(){
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        SortingUtils.executeSortTestOn(numbers,SortingDirection.DESCENDING, (a) -> HeapSort.sort(a, SortingDirection.DESCENDING),"test_heapSort_longDesending");
    }

    @Test
    public void test_heapSort_longAscending(){
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, (a) -> HeapSort.sort(a, SortingDirection.ASCENDING),"test_heapSort_longAscending");
    }

    @Test
    public void test_heapSort_floatDesending(){
        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.DESCENDING, (a) -> HeapSort.sort(a, SortingDirection.DESCENDING),"test_heapSort_floatDesending");
    }

    @Test
    public void test_heapSort_floatAscending(){
        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, (a) -> HeapSort.sort(a, SortingDirection.ASCENDING),"test_heapSort_floatAscending");
    }

    @Test
    public void test_heapSort_doubleDesending(){
        double[] numbers = new double[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.DESCENDING, (a) -> HeapSort.sort(a, SortingDirection.DESCENDING),"test_heapSort_doubleDesending");
    }

    @Test
    public void test_heapSort_doubleAscending(){
        double[] numbers = new double[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, (a) -> HeapSort.sort(a, SortingDirection.ASCENDING),"test_heapSort_doubleAscending");
    }
}
