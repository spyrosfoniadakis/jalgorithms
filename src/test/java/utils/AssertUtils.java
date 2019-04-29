package utils;


import ds.DoubleMaxHeap;
import ds.DoubleMinHeap;
import ds.FloatMaxHeap;
import ds.FloatMinHeap;
import ds.IntMaxHeap;
import ds.IntMinHeap;
import ds.LongMaxHeap;
import ds.LongMinHeap;
import org.junit.Assert;
import sorting.SortingDirection;

import java.util.Arrays;
import java.util.Comparator;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AssertUtils {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", AssertUtils.class.getSimpleName());

    private AssertUtils(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    public static void assertIsSorted(float[] numbers) {
        assertIsSorted(numbers, SortingDirection.ASCENDING);
    }

    public static void assertIsSorted(long[] numbers) {
        assertIsSorted(numbers, SortingDirection.ASCENDING);
    }

    public static void assertIsSorted(double[] numbers) {
        assertIsSorted(numbers, SortingDirection.ASCENDING);
    }

    public static void assertIsMaxHeap(IntMaxHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Object value = ReflectionUtils.getFieldValueOf(heap, heap.getClass().getCanonicalName(), "elements");
        int[] elements = (int[]) value;
        int[] extracted = new int[elements.length];
        int index = 0;
        while (heap.getSize() > 0){
            extracted[index++]= heap.extract();
        }
        assertIsSorted(extracted, SortingDirection.DESCENDING);
    }

    public static void assertIsMaxHeap(LongMaxHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Object value = ReflectionUtils.getFieldValueOf(heap, heap.getClass().getCanonicalName(), "elements");
        long[] elements = (long[]) value;
        long[] extracted = new long[elements.length];
        int index = 0;
        while (heap.getSize() > 0){
            extracted[index++]= heap.extract();
        }
        assertIsSorted(extracted, SortingDirection.DESCENDING);
    }

    public static void assertIsMaxHeap(FloatMaxHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Object value = ReflectionUtils.getFieldValueOf(heap, heap.getClass().getCanonicalName(), "elements");
        float[] elements = (float[]) value;
        float[] extracted = new float[elements.length];
        int index = 0;
        while (heap.getSize() > 0){
            extracted[index++]= heap.extract();
        }
        assertIsSorted(extracted, SortingDirection.DESCENDING);
    }

    public static void assertIsMaxHeap(DoubleMaxHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Object value = ReflectionUtils.getFieldValueOf(heap, heap.getClass().getCanonicalName(), "elements");
        double[] elements = (double[]) value;
        double[] extracted = new double[elements.length];
        int index = 0;
        while (heap.getSize() > 0){
            extracted[index++]= heap.extract();
        }
        assertIsSorted(extracted, SortingDirection.DESCENDING);
    }

    public static void assertIsMinHeap(IntMinHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Object value = ReflectionUtils.getFieldValueOf(heap, heap.getClass().getCanonicalName(), "elements");
        int[] elements = (int[]) value;
        int[] extracted = new int[elements.length];
        int index = 0;
        while (heap.getSize() > 0){
            extracted[index++]= heap.extract();
        }
        assertIsSorted(extracted, SortingDirection.ASCENDING);
    }

    public static void assertIsMinHeap(LongMinHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Object value = ReflectionUtils.getFieldValueOf(heap, heap.getClass().getCanonicalName(), "elements");
        long[] elements = (long[]) value;
        long[] extracted = new long[elements.length];
        int index = 0;
        while (heap.getSize() > 0){
            extracted[index++]= heap.extract();
        }
        assertIsSorted(extracted, SortingDirection.ASCENDING);
    }

    public static void assertIsMinHeap(FloatMinHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Object value = ReflectionUtils.getFieldValueOf(heap, heap.getClass().getCanonicalName(), "elements");
        float[] elements = (float[]) value;
        float[] extracted = new float[elements.length];
        int index = 0;
        while (heap.getSize() > 0){
            extracted[index++]= heap.extract();
        }
        assertIsSorted(extracted, SortingDirection.ASCENDING);
    }

    public static void assertIsMinHeap(DoubleMinHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Object value = ReflectionUtils.getFieldValueOf(heap, heap.getClass().getCanonicalName(), "elements");
        double[] elements = (double[]) value;
        double[] extracted = new double[elements.length];
        int index = 0;
        while (heap.getSize() > 0){
            extracted[index++]= heap.extract();
        }
        assertIsSorted(extracted, SortingDirection.ASCENDING);
    }

    public static void assertIsSorted(int[] numbers) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
            Assert.assertThat(numbers[prev++], is(lessThanOrEqualTo(numbers[current++])));
        }
    }

    public static <T extends Comparable<T>> void assertIsSorted(T[] numbers) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
            Assert.assertThat(numbers[prev++].compareTo(numbers[current++]), is(lessThanOrEqualTo(0)));
        }
    }

    public static <T> void assertIsSorted(T[] numbers, Comparator<T> comparator) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
            Assert.assertThat(comparator.compare(numbers[prev++], numbers[current++]), is(lessThanOrEqualTo(0)));
        }
    }

    public static void assertIsSorted(int[] numbers, SortingDirection direction) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
            Assert.assertThat(direction.getIntComparator().shouldSwap(numbers[prev++], numbers[current++]), is(equalTo(false)));
        }
    }

    public static void assertIsSorted(long[] numbers, SortingDirection direction) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
            Assert.assertThat(direction.getLongComparator().shouldSwap(numbers[prev++], numbers[current++]), is(equalTo(false)));
        }
    }

    public static void assertIsSorted(float[] numbers, SortingDirection direction) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
            Assert.assertThat(direction.getFloatComparator().shouldSwap(numbers[prev++], numbers[current++]), is(equalTo(false)));
        }
    }

    public static void assertIsSorted(double[] numbers, SortingDirection direction) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
            Assert.assertThat(direction.getDoubleComparator().shouldSwap(numbers[prev++], numbers[current++]), is(equalTo(false)));
        }
    }

    public static void areIdentical(double[] original, double[] target) {
        double[] copyOriginal = Arrays.copyOfRange(original, 0, original.length);
        double[] copyTarget = Arrays.copyOfRange(target, 0, target.length);
        Arrays.sort(copyOriginal);
        Arrays.sort(copyTarget);
        Assert.assertArrayEquals(copyOriginal, copyTarget, 0);
    }

    public static void areIdentical(int[] original, int[] target) {
        int[] copyOriginal = Arrays.copyOfRange(original, 0, original.length);
        int[] copyTarget = Arrays.copyOfRange(target, 0, target.length);
        Arrays.sort(copyOriginal);
        Arrays.sort(copyTarget);
        Assert.assertArrayEquals(copyOriginal, copyTarget);
    }

    public static void areIdentical(long[] original, long[] target) {
        long[] copyOriginal = Arrays.copyOfRange(original, 0, original.length);
        long[] copyTarget = Arrays.copyOfRange(target, 0, target.length);
        Arrays.sort(copyOriginal);
        Arrays.sort(copyTarget);
        Assert.assertArrayEquals(copyOriginal, copyTarget);
    }

    public static void areIdentical(float[] original, float[] target) {
        float[] copyOriginal = Arrays.copyOfRange(original, 0, original.length);
        float[] copyTarget = Arrays.copyOfRange(target, 0, target.length);
        Arrays.sort(copyOriginal);
        Arrays.sort(copyTarget);
        Assert.assertArrayEquals(copyOriginal, copyTarget, 0);
    }

    public static <T> void areIdentical(T[] original, T[] target) {
        T[] copyOriginal = Arrays.copyOfRange(original, 0, original.length);
        T[] copyTarget = Arrays.copyOfRange(target, 0, target.length);
        Arrays.sort(copyOriginal);
        Arrays.sort(copyTarget);
        Assert.assertArrayEquals(copyOriginal, copyTarget);
    }
}
