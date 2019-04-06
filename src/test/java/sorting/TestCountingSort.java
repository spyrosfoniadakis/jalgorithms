package sorting;

import org.junit.Test;

public class TestCountingSort {

    @Test
    public void test_countingSort_intDesending(){
        int[] numbers = new int[]{1, 14, 8, 10, -6, 9, 21, 16, 12, 3, -20};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.DESCENDING, (a) -> CountingSort.sort(a, SortingDirection.DESCENDING),"test_countingSort_intDesending");
    }

    @Test
    public void test_countingSort_intAscending(){
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, -100};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, (a) -> CountingSort.sort(a, SortingDirection.ASCENDING),"test_countingSort_intAscending");
    }
}
