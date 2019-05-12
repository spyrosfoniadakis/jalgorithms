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

import KeyedElement.IntKeyedElement;
import KeyedElement.LongKeyedElement;
import ds.DoubleMaxHeap;
import ds.DoubleMinHeap;
import ds.FloatMaxHeap;
import ds.FloatMinHeap;
import ds.IntKeyedMaxHeap;
import ds.IntKeyedMinHeap;
import ds.IntMaxHeap;
import ds.IntMinHeap;
import ds.LongKeyedMaxHeap;
import ds.LongKeyedMinHeap;
import ds.LongMaxHeap;
import ds.LongMinHeap;
import org.junit.Assert;
import sorting.SortingDirection;

import java.util.Arrays;
import java.util.Comparator;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Spyros Foniadakis
 */
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
        IntMaxHeap copiedHeap = IntMaxHeap.from(heap);
        Object value = ReflectionUtils.getFieldValueOf(copiedHeap, copiedHeap.getClass().getCanonicalName(), "elements");
        int[] elements = (int[]) value;
        int[] extracted = new int[copiedHeap.getSize()];
        int index = 0;
        while (copiedHeap.getSize() > 0){
            extracted[index++]= copiedHeap.extract();
        }
        assertIsSorted(extracted, SortingDirection.DESCENDING);
    }

    public static void assertIsMaxHeap(LongMaxHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        LongMaxHeap copiedHeap = LongMaxHeap.from(heap);
        Object value = ReflectionUtils.getFieldValueOf(copiedHeap, copiedHeap.getClass().getCanonicalName(), "elements");
        long[] elements = (long[]) value;
        long[] extracted = new long[copiedHeap.getSize()];
        int index = 0;
        while (copiedHeap.getSize() > 0){
            extracted[index++]= copiedHeap.extract();
        }
        assertIsSorted(extracted, SortingDirection.DESCENDING);
    }

    public static void assertIsMaxHeap(FloatMaxHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        FloatMaxHeap copiedHeap = FloatMaxHeap.from(heap);
        Object value = ReflectionUtils.getFieldValueOf(copiedHeap, copiedHeap.getClass().getCanonicalName(), "elements");
        float[] elements = (float[]) value;
        float[] extracted = new float[copiedHeap.getSize()];
        int index = 0;
        while (copiedHeap.getSize() > 0){
            extracted[index++]= copiedHeap.extract();
        }
        assertIsSorted(extracted, SortingDirection.DESCENDING);
    }

    public static void assertIsMaxHeap(DoubleMaxHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        DoubleMaxHeap copiedHeap = DoubleMaxHeap.from(heap);
        Object value = ReflectionUtils.getFieldValueOf(copiedHeap, copiedHeap.getClass().getCanonicalName(), "elements");
        double[] elements = (double[]) value;
        double[] extracted = new double[copiedHeap.getSize()];
        int index = 0;
        while (copiedHeap.getSize() > 0){
            extracted[index++]= copiedHeap.extract();
        }
        assertIsSorted(extracted, SortingDirection.DESCENDING);
    }

    public static <T> void assertIsMaxHeap(IntKeyedMaxHeap<T> heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        IntKeyedMaxHeap copiedHeap = IntKeyedMaxHeap.from(heap);
        Object value = ReflectionUtils.getFieldValueOf(copiedHeap, copiedHeap.getClass().getCanonicalName(), "elements");
        IntKeyedElement<T>[] elements = (IntKeyedElement<T>[]) value;
        IntKeyedElement<T>[] extracted = new IntKeyedElement[copiedHeap.getSize()];
        int index = 0;
        while (copiedHeap.getSize() > 0){
            extracted[index++]= copiedHeap.extract();
        }
        assertIsSorted(extracted, SortingDirection.DESCENDING);
    }

    public static <T> void assertIsMaxHeap(LongKeyedMaxHeap<T> heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        LongKeyedMaxHeap copiedHeap = LongKeyedMaxHeap.from(heap);
        Object value = ReflectionUtils.getFieldValueOf(copiedHeap, copiedHeap.getClass().getCanonicalName(), "elements");
        LongKeyedElement<T>[] elements = (LongKeyedElement<T>[]) value;
        LongKeyedElement<T>[] extracted = new LongKeyedElement[copiedHeap.getSize()];
        int index = 0;
        while (copiedHeap.getSize() > 0){
            extracted[index++]= copiedHeap.extract();
        }
        assertIsSorted(extracted, SortingDirection.DESCENDING);
    }

    public static void assertIsMinHeap(IntMinHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        IntMinHeap copiedHeap = IntMinHeap.from(heap);
        Object value = ReflectionUtils.getFieldValueOf(copiedHeap, copiedHeap.getClass().getCanonicalName(), "elements");
        int[] elements = (int[]) value;
        int[] extracted = new int[copiedHeap.getSize()];
        int index = 0;
        while (copiedHeap.getSize() > 0){
            extracted[index++]= copiedHeap.extract();
        }
        assertIsSorted(extracted, SortingDirection.ASCENDING);
    }

    public static void assertIsMinHeap(LongMinHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        LongMinHeap copiedHeap = LongMinHeap.from(heap);
        Object value = ReflectionUtils.getFieldValueOf(copiedHeap, copiedHeap.getClass().getCanonicalName(), "elements");
        long[] elements = (long[]) value;
        long[] extracted = new long[copiedHeap.getSize()];
        int index = 0;
        while (copiedHeap.getSize() > 0){
            extracted[index++]= copiedHeap.extract();
        }
        assertIsSorted(extracted, SortingDirection.ASCENDING);
    }

    public static void assertIsMinHeap(FloatMinHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        FloatMinHeap copiedHeap = FloatMinHeap.from(heap);
        Object value = ReflectionUtils.getFieldValueOf(copiedHeap, copiedHeap.getClass().getCanonicalName(), "elements");
        float[] elements = (float[]) value;
        float[] extracted = new float[copiedHeap.getSize()];
        int index = 0;
        while (copiedHeap.getSize() > 0){
            extracted[index++]= copiedHeap.extract();
        }
        assertIsSorted(extracted, SortingDirection.ASCENDING);
    }

    public static void assertIsMinHeap(DoubleMinHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        DoubleMinHeap copiedHeap = DoubleMinHeap.from(heap);
        Object value = ReflectionUtils.getFieldValueOf(copiedHeap, copiedHeap.getClass().getCanonicalName(), "elements");
        double[] elements = (double[]) value;
        double[] extracted = new double[copiedHeap.getSize()];
        int index = 0;
        while (copiedHeap.getSize() > 0){
            extracted[index++]= copiedHeap.extract();
        }
        assertIsSorted(extracted, SortingDirection.ASCENDING);
    }

    public static <T> void assertIsMinHeap(IntKeyedMinHeap<T> heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        IntKeyedMinHeap copiedHeap = IntKeyedMinHeap.from(heap);
        Object value = ReflectionUtils.getFieldValueOf(copiedHeap, copiedHeap.getClass().getCanonicalName(), "elements");
        IntKeyedElement<T>[] elements = (IntKeyedElement<T>[]) value;
        IntKeyedElement<T>[] extracted = new IntKeyedElement[copiedHeap.getSize()];
        int index = 0;
        while (copiedHeap.getSize() > 0){
            extracted[index++]= copiedHeap.extract();
        }
        assertIsSorted(extracted, SortingDirection.ASCENDING);
    }

    public static <T> void assertIsMinHeap(LongKeyedMinHeap<T> heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        LongKeyedMinHeap copiedHeap = LongKeyedMinHeap.from(heap);
        Object value = ReflectionUtils.getFieldValueOf(copiedHeap, copiedHeap.getClass().getCanonicalName(), "elements");
        LongKeyedElement<T>[] elements = (LongKeyedElement<T>[]) value;
        LongKeyedElement<T>[] extracted = new LongKeyedElement[copiedHeap.getSize()];
        int index = 0;
        while (copiedHeap.getSize() > 0){
            extracted[index++]= copiedHeap.extract();
        }
        assertIsSorted(extracted, SortingDirection.ASCENDING);
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

    public static <T> void assertIsSorted(IntKeyedElement<T>[] numbers, SortingDirection direction) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
            Assert.assertThat(direction.getIntComparator().shouldSwap(numbers[prev++].getKey(), numbers[current++].getKey()), is(equalTo(false)));
        }
    }

    public static <T> void assertIsSorted(LongKeyedElement<T>[] numbers, SortingDirection direction) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
            Assert.assertThat(direction.getLongComparator().shouldSwap(numbers[prev++].getKey(), numbers[current++].getKey()), is(equalTo(false)));
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
