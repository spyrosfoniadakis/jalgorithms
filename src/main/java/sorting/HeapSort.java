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

import comparator.Comparators;
import comparator.DoubleComparator;
import comparator.FloatComparator;
import comparator.IntComparator;
import comparator.LongComparator;
import ds.AbstractDoubleHeap;
import ds.AbstractFloatHeap;
import ds.AbstractIndexedHeap;
import ds.AbstractIntHeap;
import ds.AbstractLongHeap;
import utils.ArrayUtils;

import java.util.Comparator;

/**
 * @author Spyros Foniadakis
 */
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

    public static <T extends Comparable<T>> void sort(T[] elements){
        sorter.sort(elements);
    }

    public static <T> void sort(T[] elements, Comparator<T> comparator){
        sorter.sort(elements, comparator);
    }

//    public static <T> void sort(IntKeyedElement<T> elements, SortingDirection direction){ sorter.sort(elements, direction); }
//    public static <T> void sort(LongKeyedElement<T> elements, SortingDirection direction){ sorter.sort(elements, direction); }
//    public static <T> void sort(FloatKeyedElement<T> elements, SortingDirection direction){ sorter.sort(elements, direction); }
//    public static <T> void sort(DoubleKeyedElement<T> elements, SortingDirection direction){ sorter.sort(elements, direction); }

//    public static <T extends IntEvaluator<T>> void sort(T[] elements, SortingDirection direction){ sorter.sort(elements, direction); }
//    public static <T extends LongEvaluator<T>> void sort(T[] elements, SortingDirection direction){ sorter.sort(elements, direction); }
//    public static <T extends FloatEvaluator<T>> void sort(T[] elements, SortingDirection direction){ sorter.sort(elements, direction); }
//    public static <T extends DoubleEvaluator<T>> void sort(T[] elements, SortingDirection direction){ sorter.sort(elements, direction); }

//    public static <T> void sort(T[] elements, IntEvaluator<T> evaluator, SortingDirection direction){ sorter.sort(elements, evaluator, direction); }
//    public static <T> void sort(T[] elements, LongEvaluator<T> evaluator, SortingDirection direction){ sorter.sort(elements, evaluator, direction); }
//    public static <T> void sort(T[] elements, FloatEvaluator<T> evaluator, SortingDirection direction){ sorter.sort(elements, evaluator, direction); }
//    public static <T> void sort(T[] elements, DoubleEvaluator<T> evaluator, SortingDirection direction){ sorter.sort(elements, evaluator, direction); }


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

    private static class Heap<T> extends AbstractIndexedHeap {

        protected T[] elements;
        private Comparator<T> comparator;

        private Heap(T[] elements, Comparator<T> comparator){
            super.setSize(elements.length);
            this.elements = elements;
            this.comparator = comparator;
            this.build();
        }

        private final void build() {
            for(int i=Math.floorDiv(this.size, 2); i>=0; i--){
                heapifyFrom(i);
            }
        }

        @Override
        public void heapify() {
            heapifyFrom(0);
        }

        protected final void heapifyFrom(final int index) {
            int leftIndex = getLeftChildIndexOf(index);
            int rightIndex= getRightChildIndexOf(index);
            int nextIndex = index;

            if(leftIndex == -1 && rightIndex == -1)
                return;

            if (leftIndex != -1 && this.comparator.compare(elements[nextIndex], elements[leftIndex]) <= 0 ){
                nextIndex = leftIndex;
            }
            if(rightIndex != -1 && this.comparator.compare(elements[nextIndex], elements[rightIndex]) <= 0 ) {
                nextIndex = rightIndex;
            }
            if(index != nextIndex){
                ArrayUtils.swap(elements, index, nextIndex);
                this.heapifyFrom(nextIndex);
            }
        }

        public static <T> Heap from(T[] elements, Comparator<T> comparator){
            return new Heap(elements, comparator);
        }

        public static <T extends Comparable<T>> Heap from(T[] elements){
            return new Heap<T>(elements, (T t1, T t2) -> t1.compareTo(t2));
        }

        public final void sort(){
            for(int i = this.getSize()-1; i>=0 ; i--){
                ArrayUtils.swap(this.elements, 0, i);
                this.setSize(this.getSize()-1);
                this.heapify();
            }
        }

        @Override
        public int getCapacity() {
            throw new UnsupportedOperationException();
        }
    }


//    private static class IntKeyedHeap<T> extends AbstractIntKeyedArrayHeap<T> {
//
//        private IntKeyedHeap(IntKeyedElement<T>[] elements, IntComparator comparator){
//            super(elements, elements.length, comparator);
//        }
//
//        @Override
//        public void increaseElementKeyBy(int index, int offset) {
//            throw new UnsupportedOperationException();
//        }
//
//        public static <T> IntKeyedHeap<T> from(IntKeyedElement<T>[] elements, IntComparator comparator){
//            return new IntKeyedHeap(elements, comparator);
//        }
//    }
//
//    private static class LongKeyedHeap<T> extends AbstractLongKeyedArrayHeap<T> {
//
//        private LongKeyedHeap(LongKeyedElement<T>[] elements, LongComparator comparator){
//            super(elements, elements.length, comparator);
//        }
//
//        @Override
//        public void increaseElementKeyBy(int index, long offset) {
//            throw new UnsupportedOperationException();
//        }
//
//        public static <T> LongKeyedHeap<T> from(LongKeyedElement<T>[] elements, LongComparator comparator){
//            return new LongKeyedHeap(elements, comparator);
//        }
//    }
//
//    private static class DoubleKeyedHeap<T> extends AbstractDoubleKeyedArrayHeap<T> {
//
//        private DoubleKeyedHeap(DoubleKeyedElement<T>[] elements, DoubleComparator comparator){
//            super(elements, elements.length, comparator);
//        }
//
//        @Override
//        public void increaseElementKeyBy(int index, double offset) {
//            throw new UnsupportedOperationException();
//        }
//
//        public static <T> IntKeyedHeap<T> from(IntKeyedElement<T>[] elements, IntComparator comparator){
//            return new IntKeyedHeap(elements, comparator);
//        }
//    }
//
//    private static class FloatKeyedHeap<T> extends AbstractFloatKeyedArrayHeap<T> {
//
//        private FloatKeyedHeap(FloatKeyedElement<T>[] elements, FloatComparator comparator){
//            super(elements, elements.length, comparator);
//        }
//
//        @Override
//        public void increaseElementKeyBy(int index, float offset) {
//            throw new UnsupportedOperationException();
//        }
//
//        public static <T> FloatKeyedHeap<T> from(FloatKeyedElement<T>[] elements, IntComparator comparator){
//            return new FloatKeyedHeap(elements, comparator);
//        }
//    }


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

//        @Override
//        public <T, E extends IntKeyedElement<T>> void sort(E[] elements, SortingDirection direction) {
//            IntKeyedHeap.from(elements, direction.getOpposite().getIntComparator());
//        }
//
//        @Override
//        public <T, E extends FloatKeyedElement<T>> void sort(E[] elements, SortingDirection direction) {
//            FloatKeyedHeap.from(elements, direction.getOpposite().getFloatComparator());
//        }
//
//        @Override
//        public <T, E extends LongKeyedElement<T>> void sort(E[] elements, SortingDirection direction) {
//            LongKeyedHeap.from(elements, direction.getOpposite().getLongComparator());
//        }
//
//        @Override
//        public <T, E extends DoubleKeyedElement<T>> void sort(E[] elements, SortingDirection direction) {
//            DoubleKeyedHeap.from(elements, direction.getOpposite().getDoubleComparator());
//        }

        @Override
        public <T extends Comparable<T>> void sort(T[] elements) {
//            throw new NotImplementedException("HeapSort for Objects implementing Comparable is not yet implemented.");
            Heap.from(elements).sort();
        }

        @Override
        public <T> void sort(T[] elements, Comparator<T> comparator) {
//            throw new NotImplementedException("HeapSort for Objects ordered via Comparator is not yet implemented.");
            Heap.from(elements, comparator).sort();
        }
    }
}
