/*
 * Copyright 2019 Spyridon Foniadakis
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
package sorting;

import org.junit.Test;

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
