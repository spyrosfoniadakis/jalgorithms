package sorting;

import utils.AssertUtils;

import java.util.Arrays;
import java.util.function.Consumer;

public class SortingUtils {

    public static void executeSortTestOn(int[] numbers, Consumer<int[]> sortingAction, String testName){
        System.out.println(String.format(" ==== Test: %s == STARTED =====", testName));

        int[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        sortingAction.accept(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        int[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(String.format(" ==== Test: %s == ENDED =====", testName));
    }

    public static void executeSortTestOn(long[] numbers, Consumer<long[]> sortingAction, String testName){
        System.out.println(String.format(" ==== Test: %s == STARTED =====", testName));

        long[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        sortingAction.accept(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        long[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(String.format(" ==== Test: %s == ENDED =====", testName));
    }

    public static void executeSortTestOn(float[] numbers, Consumer<float[]> sortingAction, String testName){
        System.out.println(String.format(" ==== Test: %s == STARTED =====", testName));

        float[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        sortingAction.accept(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        float[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(String.format(" ==== Test: %s == ENDED =====", testName));
    }

    public static void executeSortTestOn(double[] numbers, Consumer<double[]> sortingAction, String testName){
        System.out.println(String.format(" ==== Test: %s == STARTED =====", testName));

        double[] copiedBefore = Arrays.copyOf(numbers, numbers.length);
        System.out.println(String.format("Before sorting: %s", Arrays.toString(numbers)));
        sortingAction.accept(numbers);
        System.out.println(String.format("After sorting: %s", Arrays.toString(numbers)));

        double[] copiedAfter = Arrays.copyOf(numbers, numbers.length);
        AssertUtils.assertIsSorted(numbers);
        AssertUtils.areIdentical(copiedBefore, copiedAfter);

        System.out.println(String.format(" ==== Test: %s == ENDED =====", testName));
    }
}
