package utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sorting.SortingDirection;

public class TestAssertUtils {

    // ascending
    @Test(expected=AssertionError.class)
    public void test_isSorted_throwsAssertionErrorOnNotSorted(){
        int[] a = new int[]{1, 3, 6, 8, 0, 2, 3, 4, 11, 56, 23, 98};
        AssertUtils.assertIsSorted(a);
    }

    @Test(expected=AssertionError.class)
    public void test_isSortedAscending_throwsAssertionErrorOnNotSorted(){
        int[] a = new int[]{1, 3, 6, 8, 0, 2, 3, 4, 11, 56, 23, 98};
        AssertUtils.assertIsSorted(a, SortingDirection.ASCENDING);
    }

    @Test(expected=AssertionError.class)
    public void test_isSortedAscending_throwsAssertionErrorOnSortedDescending(){
        int[] a = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        AssertUtils.assertIsSorted(a, SortingDirection.ASCENDING);
    }

    @Test(expected=AssertionError.class)
    public void test_isSortedAscending_throwsAssertionErrorOnAlmostSortedAscending(){
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 6, 8, 9, 10};
        AssertUtils.assertIsSorted(a, SortingDirection.ASCENDING);
    }

    @Test
    public void test_isSortedAscending_doesNotThrowsAssertionErrorOnSortedAscending(){
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        AssertUtils.assertIsSorted(a, SortingDirection.ASCENDING);
    }

    @Test
    public void test_isSortedAscending_doesNotThrowsAssertionErrorOnSortedAscendingWithDuplicates(){
        int[] a = new int[]{1, 2, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8, 8, 8, 8, 9, 10};
        AssertUtils.assertIsSorted(a, SortingDirection.ASCENDING);
    }

    // descending
    @Test(expected=AssertionError.class)
    public void test_isSortedDescending_throwsAssertionErrorOnNotSorted(){
        int[] a = new int[]{1, 3, 6, 8, 0, 2, 3, 4, 11, 56, 23, 98};
        AssertUtils.assertIsSorted(a, SortingDirection.DESCENDING);
    }

    @Test(expected=AssertionError.class)
    public void test_isSortedDescending_throwsAssertionErrorOnSortedAscending(){
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        AssertUtils.assertIsSorted(a, SortingDirection.DESCENDING);
    }

    @Test(expected=AssertionError.class)
    public void test_isSortedDescending_throwsAssertionErrorOnAlmostSortedDescending(){
        int[] a = new int[]{10, 9, 8, 7, 6, 5, 3, 4, 3, 2, 1, 0};
        AssertUtils.assertIsSorted(a, SortingDirection.DESCENDING);
    }

    @Test
    public void test_isSortedDescending_doesNotThrowsAssertionErrorOnSortedDescending(){
        int[] a = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        AssertUtils.assertIsSorted(a, SortingDirection.DESCENDING);
    }

    @Test
    public void test_isSortedDescending_doesNotThrowsAssertionErrorOnSortedAscendingWithDuplicates(){
        int[] a = new int[]{10, 9, 8, 7, 7, 7, 7, 6, 5, 4, 4, 4, 4, 3, 2, 1, 0};
        AssertUtils.assertIsSorted(a, SortingDirection.DESCENDING);
    }
}
