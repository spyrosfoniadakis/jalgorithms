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
public class TestQuickSort {

    @Test
    public void test_quickSort_int(){
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, QuickSort::sort, "test_quickSort_int");
    }

    @Test
    public void test_quickSort_intSorted(){
        int[] numbers = new int[]{0, 1, 3, 6, 8, 9, 10, 12, 14, 16, 21};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, QuickSort::sort, "test_quickSort_intSorted");
    }

    @Test
    public void test_quickSort_float(){
        float[] numbers = new float[]{1.0f, 14.1f, 8.3f, 10.8f, 6.2f, 9.01f, 21.3f, 16.7f, 12.2f, 3.3f, 0.4f};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, QuickSort::sort, "test_quickSort_float");
    }

    @Test
    public void test_quickSort_floatSorted(){
        float[] numbers = new float[]{0.4f, 1.0f, 3.3f, 6.2f, 8.3f, 9.01f, 10.8f, 12.2f, 14.1f, 16.7f, 21.3f};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, QuickSort::sort, "test_quickSort_floatSorted");
    }

    @Test
    public void test_quickSort_double(){
        double[] numbers = new double[]{1.0d, 14.1d, 8.3d, 10.8d, 6.2d, 9.01d, 21.3d, 16.7d, 12.2d, 3.3d, 0.4d};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, QuickSort::sort, "test_quickSort_double");
    }

    @Test
    public void test_quickSort_doubleSorted(){
        double[] numbers = new double[]{1.0d, 14.1d, 8.3d, 10.8d, 6.2d, 9.01d, 21.3d, 16.7d, 12.2d, 3.3d, 0.4d};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, QuickSort::sort, "test_quickSort_doubleSorted");
    }

    @Test
    public void test_quickSort_objects_comparator(){
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
        SortingUtils.executeSortTestOn(persons, comparator, QuickSort::sort, "test_mergeSort_objects_comparator");
    }

    @Test
    public void test_quickSort_objects_comparator_sorted(){
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
        SortingUtils.executeSortTestOn(persons, comparator, QuickSort::sort,  "test_mergeSort_objects_comparator_sorted");
    }
}
