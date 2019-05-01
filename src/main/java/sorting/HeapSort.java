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

import comparator.*;
import ds.*;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Comparator;

public final class HeapSort {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", HeapSort.class);
    private static HeapSorter sorter = new HeapSorter();

    private HeapSort(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    public static void sort(int[] numbers, SortingDirection direction){
        sorter.sort(numbers, direction);
    }

    public static void sort(float[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(float[] numbers, SortingDirection direction){
        sorter.sort(numbers, direction);
    }

    public static void sort(long[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(long[] numbers, SortingDirection direction){
        sorter.sort(numbers, direction);
    }

    public static void sort(double[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(double[] numbers, SortingDirection direction){
        sorter.sort(numbers, direction);
    }

    private static class IntHeap extends AbstractIntHeap{

        private IntHeap(int[] elements, IntComparator comparator){
            super(elements, elements.length, comparator);
        }

        @Override
        public void increaseElementValueBy(int index, int value) {
            throw new UnsupportedOperationException();
        }

        public static IntHeap from(int[] elements, IntComparator comparator){
            return new IntHeap(elements, comparator);
        }
    }

    private static class LongHeap extends AbstractLongHeap{

        private LongHeap(long[] elements, LongComparator comparator){
            super(elements, elements.length, comparator);
        }

        @Override
        public void increaseElementValueBy(int index, long value) {
            throw new UnsupportedOperationException();
        }

        public static LongHeap from(long[] elements, LongComparator comparator){
            return new LongHeap(elements, comparator);
        }
    }

    private static class FloatHeap extends AbstractFloatHeap{

        private FloatHeap(float[] elements, FloatComparator comparator){
            super(elements, elements.length, comparator);
        }

        @Override
        public void increaseElementValueBy(int index, float value) {
            throw new UnsupportedOperationException();
        }

        public static FloatHeap from(float[] elements, FloatComparator comparator){
            return new FloatHeap(elements, comparator);
        }
    }

    private static class DoubleHeap extends AbstractDoubleHeap{

        private DoubleHeap(double[] elements, DoubleComparator comparator){
            super(elements, elements.length, comparator);
        }

        @Override
        public void increaseElementValueBy(int index, double value) {
            throw new UnsupportedOperationException();
        }

        public static DoubleHeap from(double[] elements, DoubleComparator comparator){
            return new DoubleHeap(elements, comparator);
        }
    }

    private static class HeapSorter implements Sorter {

        @Override
        public void sort(int[] numbers) {
            IntHeap.from(numbers, Comparators.INT_ASCENDING_COMPARATOR).sort();
        }

        @Override
        public void sort(int[] numbers, SortingDirection direction) {
            IntHeap.from(numbers, direction.getOpposite().getIntComparator()).sort();
        }

        @Override
        public void sort(long[] numbers) {
            LongHeap.from(numbers, Comparators.LONG_ASCENDING_COMPARATOR).sort();
        }

        @Override
        public void sort(long[] numbers, SortingDirection direction) {
            LongHeap.from(numbers, direction.getOpposite().getLongComparator()).sort();
        }

        @Override
        public void sort(float[] numbers) {
            FloatHeap.from(numbers, Comparators.FLOAT_ASCENDING_COMPARATOR).sort();
        }

        @Override
        public void sort(float[] numbers, SortingDirection direction) {
            FloatHeap.from(numbers, direction.getOpposite().getFloatComparator()).sort();
        }

        @Override
        public void sort(double[] numbers) {
            DoubleHeap.from(numbers, Comparators.DOUBLE_ASCENDING_COMPARATOR).sort();
        }

        @Override
        public void sort(double[] numbers, SortingDirection direction) {
            DoubleHeap.from(numbers, direction.getOpposite().getDoubleComparator()).sort();
        }


        @Override
        public <T extends Comparable<T>> void sort(T[] elements) {
            throw new NotImplementedException("HeapSort for Objects implementing Comparable is not yet implemented.");
        }

        @Override
        public <T> void sort(T[] elements, Comparator<T> comparator) {
            throw new NotImplementedException("HeapSort for Objects ordered via Comparator is not yet implemented.");
        }
    }
}
