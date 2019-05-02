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

import java.util.Comparator;

/**
 * @author Spyros Foniadakis
 */
public final class InsertionSort {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", InsertionSort.class);
    private static InsertionSorter sorter = new InsertionSorter();

    private InsertionSort(){
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

    public static <T extends Comparable<T>> void sort(T[] numbers){
        sorter.sort(numbers);
    }

    public static <T> void sort(T[] numbers, Comparator<T> comparator){
        sorter.sort(numbers, comparator);
    }


    private static class InsertionSorter implements Sorter{

        @Override
        public void sort(int[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(int[] numbers, SortingDirection direction) {
            for(int i = 1; i < numbers.length; i++){
                int key = numbers[i];
                int j = i-1;
                while(j >= 0 && direction.getIntComparator().shouldSwap(numbers[j], key)){
                    numbers[j+1] = numbers[j];
                    j--;
                }
                numbers[j+1] = key;
            }
        }

        @Override
        public void sort(long[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(long[] numbers, SortingDirection direction) {
            for(int i = 1; i < numbers.length; i++){
                long key = numbers[i];
                int j = i-1;
                while(j >= 0 && direction.getLongComparator().shouldSwap(numbers[j], key)){
                    numbers[j+1] = numbers[j];
                    j--;
                }
                numbers[j+1] = key;
            }
        }

        @Override
        public void sort(float[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(float[] numbers, SortingDirection direction) {
            for(int i = 1; i < numbers.length; i++){
                float key = numbers[i];
                int j = i-1;
                while(j >= 0 && direction.getFloatComparator().shouldSwap(numbers[j], key)){
                    numbers[j+1] = numbers[j];
                    j--;
                }
                numbers[j+1] = key;
            }
        }

        @Override
        public void sort(double[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(double[] numbers, SortingDirection direction) {
            for(int i = 1; i < numbers.length; i++){
                double key = numbers[i];
                int j = i-1;
                while(j >= 0 && direction.getDoubleComparator().shouldSwap(numbers[j], key)){
                    numbers[j+1] = numbers[j];
                    j--;
                }
                numbers[j+1] = key;
            }
        }

        // TODO: update the implementation using function objects!
        @Override
        public <T extends Comparable<T>> void sort(T[] elements) {
            for(int i = 1; i < elements.length; i++){
                T key = elements[i];
                int j = i-1;
                while(j >= 0 && elements[j].compareTo(key) > 0 ){
                    elements[j+1] = elements[j];
                    j--;
                }
                elements[j+1] = key;
            }
        }

        @Override
        public <T> void sort(T[] elements, Comparator<T> comparator) {
            for(int i = 1; i < elements.length; i++){
                T key = elements[i];
                int j = i-1;
                while(j >= 0 && comparator.compare(elements[j], key) > 0 ){
                    elements[j+1] = elements[j];
                    j--;
                }
                elements[j+1] = key;
            }
        }
    }
}
