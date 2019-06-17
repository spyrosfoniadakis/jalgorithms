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

import utils.AssertUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Spyros Foniadakis
 */
public class SortingUtils {

    public static void executeSortTestOn(int[] numbers, SortingDirection direction, Consumer<int[]> sortingAction, String testName){
        System.out.println(String.format(" ==== Test: %s == STARTED =====", testName));

        int[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        sortingAction.accept(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        int[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers, direction);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(String.format(" ==== Test: %s == ENDED =====", testName));
    }

    public static void executeSortTestOn(long[] numbers, SortingDirection direction, Consumer<long[]> sortingAction, String testName){
        System.out.println(String.format(" ==== Test: %s == STARTED =====", testName));

        long[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        sortingAction.accept(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        long[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers, direction);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(String.format(" ==== Test: %s == ENDED =====", testName));
    }

    public static void executeSortTestOn(float[] numbers, SortingDirection direction, Consumer<float[]> sortingAction, String testName){
        System.out.println(String.format(" ==== Test: %s == STARTED =====", testName));

        float[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        sortingAction.accept(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        float[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers, direction);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(String.format(" ==== Test: %s == ENDED =====", testName));
    }

    public static void executeSortTestOn(double[] numbers, SortingDirection direction, Consumer<double[]> sortingAction, String testName){
        System.out.println(String.format(" ==== Test: %s == STARTED =====", testName));

        double[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        sortingAction.accept(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        double[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers, direction);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(String.format(" ==== Test: %s == ENDED =====", testName));
    }

    public static <T extends Comparable<T>> void executeSortTestOn(T[] items, Consumer<T[]> sortingAction, String testName){
        System.out.println(String.format(" ==== Test: %s == STARTED =====", testName));

        T[] copiedBefore = Arrays.copyOf(items, items.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(items)));
        sortingAction.accept(items);
        System.out.println(String.format("After sorting: %s", Arrays.toString(items)));

        T[] copiedAfter = Arrays.copyOf(items, items.length);
        AssertUtils.assertIsSorted(items);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(String.format(" ==== Test: %s == ENDED =====", testName));
    }

    public static <T> void executeSortTestOn(T[] items, Comparator<T> comparator, BiConsumer<T[], Comparator<T>> sortingAction, String testName){
        System.out.println(String.format(" ==== Test: %s == STARTED =====", testName));

        T[] copiedBefore = Arrays.copyOf(items, items.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(items)));
        sortingAction.accept(items, comparator);
        System.out.println(String.format("After sorting: %s", Arrays.toString(items)));

        T[] copiedAfter = Arrays.copyOf(items, items.length);
        AssertUtils.assertIsSorted(items, comparator);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(String.format(" ==== Test: %s == ENDED =====", testName));
    }
}
