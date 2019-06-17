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
package sorting;

import misc.Person;
import org.junit.Test;
import utils.DateUtils;

/**
 * @author Spyros Foniadakis
 */
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

    @Test
    public void test_heapSort_objects_comparable(){
        Person[] persons = new Person[]{
                Person.from("John", "Doe", DateUtils.getDateFrom(1980, 7, 19)),
                Person.from("Jack", "Brown", DateUtils.getDateFrom(1990, 8, 14)),
                Person.from("Joe", "Black", DateUtils.getDateFrom(1997, 3, 20)),
                Person.from("Hank", "Smith", DateUtils.getDateFrom(1972, 10, 30)),
                Person.from("Tim", "Johnson", DateUtils.getDateFrom(1979, 1, 22)),
                Person.from("George", "Edison", DateUtils.getDateFrom(1992, 12, 7)),
                Person.from("Alan", "Edison", DateUtils.getDateFrom(1990, 9, 7))
        };
        SortingUtils.executeSortTestOn(persons, HeapSort::sort, "test_heapSort_objects_comparable");
    }

    @Test
    public void test_heapSort_objects_comparable_sorted(){
        Person[] persons = new Person[]{
                Person.from("Jack", "Brown", DateUtils.getDateFrom(1990, 8, 14)),
                Person.from("Joe", "Black", DateUtils.getDateFrom(1997, 3, 20)),
                Person.from("John", "Doe", DateUtils.getDateFrom(1980, 7, 19)),
                Person.from("Alan", "Edison", DateUtils.getDateFrom(1990, 9, 7)),
                Person.from("George", "Edison", DateUtils.getDateFrom(1992, 12, 7)),
                Person.from("Tim", "Johnson", DateUtils.getDateFrom(1979, 1, 22)),
                Person.from("Hank", "Smith", DateUtils.getDateFrom(1972, 10, 30))
        };
        SortingUtils.executeSortTestOn(persons, HeapSort::sort, "test_heapSort_objects_comparable_sorted");
    }

    @Test
    public void test_heapSort_objects_comparator(){
        Person[] persons = new Person[]{
                Person.from("John", "Doe", DateUtils.getDateFrom(1980, 7, 19)),
                Person.from("Jack", "Brown", DateUtils.getDateFrom(1990, 8, 14)),
                Person.from("Joe", "Black", DateUtils.getDateFrom(1997, 3, 20)),
                Person.from("Hank", "Smith", DateUtils.getDateFrom(1972, 10, 30)),
                Person.from("Tim", "Johnson", DateUtils.getDateFrom(1979, 1, 22)),
                Person.from("George", "Edison", DateUtils.getDateFrom(1992, 12, 7)),
                Person.from("Alan", "Edison", DateUtils.getDateFrom(1990, 9, 7))
        };
        Person.AgeComparator comparator = Person.newAgeComparator();
        SortingUtils.executeSortTestOn(persons, comparator, HeapSort::sort, "test_heapSort_objects_comparator");
    }

    @Test
    public void test_heapSort_objects_comparator_sorted(){
        Person[] persons = new Person[]{
                Person.from("Hank", "Smith", DateUtils.getDateFrom(1972, 10, 30)),
                Person.from("Tim", "Johnson", DateUtils.getDateFrom(1979, 1, 22)),
                Person.from("John", "Doe", DateUtils.getDateFrom(1980, 7, 19)),
                Person.from("Alan", "Edison", DateUtils.getDateFrom(1990, 9, 7)),
                Person.from("Jack", "Brown", DateUtils.getDateFrom(1990, 8, 14)),
                Person.from("George", "Edison", DateUtils.getDateFrom(1992, 12, 7)),
                Person.from("Joe", "Black", DateUtils.getDateFrom(1997, 3, 20))
        };
        Person.AgeComparator comparator = Person.newAgeComparator();
        SortingUtils.executeSortTestOn(persons, comparator, HeapSort::sort,  "test_heapSort_objects_comparator_sorted");
    }
}
