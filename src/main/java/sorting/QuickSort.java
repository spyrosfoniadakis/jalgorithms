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

import utils.ArrayUtils;

import java.util.Comparator;

/**
 * @author Spyros Foniadakis
 */
public final class QuickSort {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", QuickSort.class);
    private static QuickSorter sorter = new QuickSorter();

    private QuickSort(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    public static void sort(int[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(int[] numbers, SortingDirection direction){
        sorter.sort(numbers, direction);
    }

    public static void sort(long[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(long[] numbers, SortingDirection direction){
        sorter.sort(numbers, direction);
    }

    public static void sort(float[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(float[] numbers, SortingDirection direction){
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

    private static class QuickSorter implements Sorter{

        @Override
        public void sort(int[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(int[] numbers, SortingDirection direction) {
            this.sort(numbers, 0, numbers.length, direction);
        }

        public void sort(int[] numbers, int start, int end, SortingDirection direction) {
            if(isSingleElementArray(start, end))
                return;

            int partitionIndex = this.getPartitionIndex(numbers, start, end, direction);
            this.sort(numbers, start, partitionIndex, direction);
            this.sort(numbers, partitionIndex+1, end, direction);
        }

        private int getPartitionIndex(int[] numbers, int start, int end, SortingDirection direction) {
            int pointOfReference = numbers[end-1];
            int partitionIndex = start - 1;
            for(int i=start; i<end-1; i++){
                if(direction.getOpposite().getIntComparator().shouldSwap(numbers[i], pointOfReference)){
                    ArrayUtils.swap(numbers, i, ++partitionIndex);
                }
            }

            ArrayUtils.swap(numbers, end-1, ++partitionIndex);
            return partitionIndex;
        }

        @Override
        public void sort(long[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(long[] numbers, SortingDirection direction) {
            this.sort(numbers, 0, numbers.length, direction);
        }

        public void sort(long[] numbers, int start, int end, SortingDirection direction) {
            if(isSingleElementArray(start, end))
                return;

            int partitionIndex = this.getPartitionIndex(numbers, start, end, direction);
            this.sort(numbers, start, partitionIndex, direction);
            this.sort(numbers, partitionIndex+1, end, direction);
        }

        private int getPartitionIndex(long[] numbers, int start, int end, SortingDirection direction) {
            long pointOfReference = numbers[end-1];
            int partitionIndex = start - 1;
            for(int i=start; i<end-1; i++){
                if(direction.getOpposite().getLongComparator().shouldSwap(numbers[i], pointOfReference)){
                    ArrayUtils.swap(numbers, i, ++partitionIndex);
                }
            }

            ArrayUtils.swap(numbers, end-1, ++partitionIndex);
            return partitionIndex;
        }

        @Override
        public void sort(float[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(float[] numbers, SortingDirection direction) {
            this.sort(numbers, 0, numbers.length, direction);
        }

        public void sort(float[] numbers, int start, int end, SortingDirection direction) {
            if(isSingleElementArray(start, end))
                return;

            int partitionIndex = this.getPartitionIndex(numbers, start, end, direction);
            this.sort(numbers, start, partitionIndex, direction);
            this.sort(numbers, partitionIndex+1, end, direction);
        }

        private int getPartitionIndex(float[] numbers, int start, int end, SortingDirection direction) {
            float pointOfReference = numbers[end-1];
            int partitionIndex = start - 1;
            for(int i=start; i<end-1; i++){
                if(direction.getOpposite().getFloatComparator().shouldSwap(numbers[i], pointOfReference)){
                    ArrayUtils.swap(numbers, i, ++partitionIndex);
                }
            }

            ArrayUtils.swap(numbers, end-1, ++partitionIndex);
            return partitionIndex;
        }

        @Override
        public void sort(double[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(double[] numbers, SortingDirection direction) {
            this.sort(numbers, 0, numbers.length, direction);
        }

        public void sort(double[] numbers, int start, int end, SortingDirection direction) {
            if(isSingleElementArray(start, end))
                return;

            int partitionIndex = this.getPartitionIndex(numbers, start, end, direction);
            this.sort(numbers, start, partitionIndex, direction);
            this.sort(numbers, partitionIndex+1, end, direction);
        }

        private int getPartitionIndex(double[] numbers, int start, int end, SortingDirection direction) {
            double pointOfReference = numbers[end-1];
            int partitionIndex = start - 1;
            for(int i=start; i<end-1; i++){
                if(direction.getOpposite().getDoubleComparator().shouldSwap(numbers[i], pointOfReference)){
                    ArrayUtils.swap(numbers, i, ++partitionIndex);
                }
            }

            ArrayUtils.swap(numbers, end-1, ++partitionIndex);
            return partitionIndex;
        }

        @Override
        public <T extends Comparable<T>> void sort(T[] elements) {
            this.sort(elements, 0, elements.length);
        }

        public <T extends Comparable<T>> void sort(T[] elements, int start, int end) {
            if(isSingleElementArray(start, end))
                return;

            int partitionIndex = this.getPartitionIndex(elements, start, end);
            this.sort(elements, start, partitionIndex);
            this.sort(elements, partitionIndex+1, end);
        }

        private <T extends Comparable<T>> int getPartitionIndex(T[] elements, int start, int end) {
            T pointOfReference = elements[end-1];
            int partitionIndex = start - 1;
            for(int i=start; i<end-1; i++){
                if(elements[i].compareTo(pointOfReference) <= 0){
                    ArrayUtils.swap(elements, i, ++partitionIndex);
                }
            }

            ArrayUtils.swap(elements, end-1, ++partitionIndex);
            return partitionIndex;
        }

        @Override
        public <T> void sort(T[] elements, Comparator<T> comparator) {
            this.sort(elements, 0, elements.length, comparator);
        }

        public <T> void sort(T[] elements, int start, int end, Comparator<T> comparator) {
            if(isSingleElementArray(start, end))
                return;

            int partitionIndex = this.getPartitionIndex(elements, start, end, comparator);
            this.sort(elements, start, partitionIndex, comparator);
            this.sort(elements, partitionIndex+1, end, comparator);
        }

        private <T> int getPartitionIndex(T[] elements, int start, int end, Comparator<T> comparator) {
            T pointOfReference = elements[end-1];
            int partitionIndex = start - 1;
            for(int i=start; i<end-1; i++){
                if(comparator.compare(elements[i], pointOfReference) <=0){
                    ArrayUtils.swap(elements, i, ++partitionIndex);
                }
            }

            ArrayUtils.swap(elements, end-1, ++partitionIndex);
            return partitionIndex;
        }

        private boolean isSingleElementArray(int start, int end) {
            return start >= end - 1;
        }
    }
}
