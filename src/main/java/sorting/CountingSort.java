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

import org.apache.commons.lang3.NotImplementedException;
import utils.Statistics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Spyros Foniadakis
 */
public final class CountingSort {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", CountingSort.class);
    private static CountingSort.CountingSorter sorter = new CountingSort.CountingSorter();

    private CountingSort(){
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

    public final static class CountingSorter implements Sorter {

        private enum Direction{

            ASCENDING(SortingDirection.ASCENDING){

                @Override
                public void accumulate(final int[] tmp) {
                    Stream.iterate(1, i -> i + 1).limit(tmp.length-1).forEach(i -> tmp[i] = tmp[i-1] + tmp[i]);
                }

                @Override
                public void finalizeSorting(int[] numbers, Statistics.IntArrayInfo statistics, int[] sorted, int[] tmp) {
                    Stream.iterate(numbers.length-1, i -> i - 1).limit(numbers.length).forEach( i -> doSortStep(numbers, statistics, sorted, tmp, i));
                }
            },

            DESCENDING(SortingDirection.DESCENDING){

                @Override
                public void accumulate(final int[] tmp) {
                    for(int i=tmp.length-2; i>0; i--){
                        tmp[i] = tmp[i+1] + tmp[i];
                    }
                }

                @Override
                public void finalizeSorting(int[] numbers, Statistics.IntArrayInfo statistics, int[] sorted, int[] tmp) {
                    for(int i=0; i<numbers.length; i++){
                        doSortStep(numbers, statistics, sorted, tmp, i);
                    }
                }
            };

            private static Map<SortingDirection, Direction> map = new HashMap<>();
            static{
                map.put(SortingDirection.ASCENDING, ASCENDING);
                map.put(SortingDirection.DESCENDING, DESCENDING);
            }

            private SortingDirection direction;

            Direction(SortingDirection direction){
                this.direction = direction;
            }

            public abstract void accumulate(final int[] tmp);

            public abstract void finalizeSorting(int[] numbers, Statistics.IntArrayInfo statistics, int[] sorted, int[] tmp);

            protected void doSortStep(int[] numbers, Statistics.IntArrayInfo statistics, int[] sorted, int[] tmp, int i) {
                sorted[tmp[normalize(statistics.getMin(), numbers[i])] - (normalize(statistics.getMin(), numbers[statistics.getMinIndex()]))] = numbers[i];
                tmp[normalize(statistics.getMin(), numbers[i])]--;
            }

            public static Direction get(SortingDirection direction){
                return map.get(direction);
            }
        }

        @Override
        public void sort(int[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(int[] numbers, SortingDirection direction) {
            Statistics.IntArrayInfo statistics = Statistics.from(numbers);

            int[] sorted = new int[numbers.length];
            int[] tmp = new int[normalize(statistics.getMin(), statistics.getMax()) + 1];
            for(int i=0; i<numbers.length; i++){
                tmp[normalize(statistics.getMin(), numbers[i])]++;
            }

            Direction.get(direction).accumulate(tmp);
            Direction.get(direction).finalizeSorting(numbers, statistics, sorted, tmp);

            for(int i=0; i<numbers.length; i++){
                numbers[i] = sorted[i];
            }
        }

        @Override
        public void sort(long[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(long[] numbers, SortingDirection direction) {
            throw new UnsupportedOperationException("CountingSort does not support longs");
        }

        @Override
        public void sort(float[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(float[] numbers, SortingDirection direction) {
            throw new UnsupportedOperationException("CountingSort does not support floats");
        }

        @Override
        public void sort(double[] numbers) {
            this.sort(numbers, SortingDirection.ASCENDING);
        }

        @Override
        public void sort(double[] numbers, SortingDirection direction) {
            throw new UnsupportedOperationException("CountingSort does not support doubles");
        }

        @Override
        public <T extends Comparable<T>> void sort(T[] elements) {
            throw new NotImplementedException("CountingSort for Objects implementing Comparable is not yet implemented.");
        }

        @Override
        public <T> void sort(T[] elements, Comparator<T> comparator) {
            throw new NotImplementedException("CountingSort for Objects ordered via Comparator is not yet implemented.");
        }

        private static int normalize(int min, int value){
            return value + Math.abs(Math.min(min - 1 , 0));
        }
    }
}
