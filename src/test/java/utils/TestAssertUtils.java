/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package utils;

import org.junit.Test;
import sorting.SortingDirection;

/**
 * @author Spyros Foniadakis
 */
public class TestAssertUtils {

    // ascending
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
