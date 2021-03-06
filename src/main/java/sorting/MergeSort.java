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

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Spyros Foniadakis
 */
public final class MergeSort {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", MergeSort.class);
    private static MergeSorter sorter = new MergeSorter();

    private MergeSort(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    public static void sort(int[] numbers){
        sorter.sort(numbers);
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

    private static class MergeSorter implements Sorter {

        private int getMiddleIndex(int start, int end) {
            return ((start + end) % 2 == 0) ? Math.floorDiv(start + end, 2) : Math.floorDiv(start + end, 2) + 1;
        }

        @Override
        public void sort(int[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(int[] numbers, SortingDirection direction) {
            sort(numbers, 0, numbers.length, direction);
        }

        public void sort(int[] numbers, int start, int end, SortingDirection direction){
            if(isSingleElementArray(start, end))
                return;

            int middle = getMiddleIndex(start, end);
            System.out.println(String.format("start: %d, end: %d, middle: %d", start, end, middle));
            this.sort(numbers, start, middle, direction);
            this.sort(numbers, middle, end, direction);
            merge(numbers, start, middle, end, direction);
        }

        private void merge(int[] numbers, int start, int middle, int end, SortingDirection direction) {
            int[] left = Arrays.copyOfRange(numbers, start, middle);
            int[] right = Arrays.copyOfRange(numbers, middle, end);

            int i = 0;
            int j = 0;
            for(int index = start; index < end; index++){
                boolean chooseFromleft = (j == right.length) || (i < left.length && !direction.getIntComparator().shouldSwap(left[i], right[j]));
                numbers[index] = (chooseFromleft) ? left[i++] : right[j++];
            }
        }

        @Override
        public void sort(long[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(long[] numbers, SortingDirection direction) {
            sort(numbers, 0, numbers.length, direction);
        }

        public void sort(long[] numbers, int start, int end, SortingDirection direction){
            if(isSingleElementArray(start, end))
                return;

            int middle = getMiddleIndex(start, end);
            System.out.println(String.format("start: %d, end: %d, middle: %d", start, end, middle));
            this.sort(numbers, start, middle, direction);
            this.sort(numbers, middle, end, direction);
            merge(numbers, start, middle, end, direction);
        }

        private void merge(long[] numbers, int start, int middle, int end, SortingDirection direction) {
            long[] left = Arrays.copyOfRange(numbers, start, middle);
            long[] right = Arrays.copyOfRange(numbers, middle, end);

            int i = 0;
            int j = 0;
            for(int index = start; index < end; index++){
                boolean chooseFromleft = (j == right.length) || (i < left.length && !direction.getLongComparator().shouldSwap(left[i], right[j]));
                numbers[index] = (chooseFromleft) ? left[i++] : right[j++];
            }
        }

        @Override
        public void sort(float[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(float[] numbers, SortingDirection direction) {
            sort(numbers, 0, numbers.length, direction);
        }

        public void sort(float[] numbers, int start, int end, SortingDirection direction){
            if(isSingleElementArray(start, end))
                return;

            int middle = getMiddleIndex(start, end);
            System.out.println(String.format("start: %d, end: %d, middle: %d", start, end, middle));
            this.sort(numbers, start, middle, direction);
            this.sort(numbers, middle, end, direction);
            merge(numbers, start, middle, end, direction);
        }

        private void merge(float[] numbers, int start, int middle, int end, SortingDirection direction) {
            float[] left = Arrays.copyOfRange(numbers, start, middle);
            float[] right = Arrays.copyOfRange(numbers, middle, end);

            int i = 0;
            int j = 0;
            for(int index = start; index < end; index ++){
                boolean chooseFromleft = (j == right.length) || (i < left.length && !direction.getFloatComparator().shouldSwap(left[i], right[j]));
                numbers[index] = (chooseFromleft) ? left[i++] : right[j++];
            }
        }

        @Override
        public void sort(double[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(double[] numbers, SortingDirection direction) {
            sort(numbers, 0, numbers.length, direction);
        }

        public void sort(double[] numbers, int start, int end, SortingDirection direction){
            if(isSingleElementArray(start, end))
                return;

            int middle = getMiddleIndex(start, end);
            this.sort(numbers, start, middle, direction);
            this.sort(numbers, middle, end, direction);
            merge(numbers, start, middle, end, direction);
        }

        private void merge(double[] numbers, int start, int middle, int end, SortingDirection direction) {
            double[] left = Arrays.copyOfRange(numbers, start, middle);
            double[] right = Arrays.copyOfRange(numbers, middle, end);

            int i = 0;
            int j = 0;
            for(int index = start; index < end; index ++){
                boolean chooseFromleft = (j == right.length) || (i < left.length && !direction.getDoubleComparator().shouldSwap(left[i], right[j]));
                numbers[index] = (chooseFromleft) ? left[i++] : right[j++];
            }
        }

        @Override
        public <T extends Comparable<T>> void sort(T[] elements) {
            sort(elements, 0, elements.length);
        }

        public <T extends Comparable<T>> void sort(T[] elements, int start, int end){
            if(isSingleElementArray(start, end))
                return;

            int middle = getMiddleIndex(start, end);
            this.sort(elements, start, middle);
            this.sort(elements, middle, end);
            merge(elements, start, middle, end);
        }

        private boolean isSingleElementArray(int start, int end) {
            return start >= end - 1;
        }

        private <T extends Comparable<T>> void merge(T[] elements, int start, int middle, int end) {
            T[] left = Arrays.copyOfRange(elements, start, middle);
            T[] right = Arrays.copyOfRange(elements, middle, end);

            int i = 0;
            int j = 0;
            for(int index = start; index < end; index ++){
                boolean chooseFromleft = (j == right.length) || (i < left.length && left[i].compareTo(right[j]) <= 0);
                elements[index] = (chooseFromleft) ? left[i++] : right[j++];
            }
        }

        @Override
        public <T> void sort(T[] elements, Comparator<T> comparator) {
            sort(elements, 0, elements.length, comparator);
        }

        public <T> void sort(T[] elements, int start, int end, Comparator<T> comparator){
            if(isSingleElementArray(start, end))
                return;

            int middle = getMiddleIndex(start, end);
            this.sort(elements, start, middle, comparator);
            this.sort(elements, middle, end, comparator);
            merge(elements, start, middle, end, comparator);
        }

        private <T> void merge(T[] elements, int start, int middle, int end, Comparator<T> comparator) {
            T[] left = Arrays.copyOfRange(elements, start, middle);
            T[] right = Arrays.copyOfRange(elements, middle, end);

            int i = 0;
            int j = 0;
            for(int index = start; index < end; index ++){
                boolean chooseFromleft = (j == right.length) || (i < left.length && comparator.compare(left[i], right[j]) <= 0);
                elements[index] = (chooseFromleft) ? left[i++] : right[j++];
            }
        }
    }
}
