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
interface Sorter {

    void sort(int[] numbers);

    void sort(int[] numbers, SortingDirection direction);

    void sort(long[] numbers);

    void sort(long[] numbers, SortingDirection direction);

    void sort(float[] numbers);

    void sort(float[] numbers, SortingDirection direction);

    void sort(double[] numbers);

    void sort(double[] numbers, SortingDirection direction);

    <T extends Comparable<T>> void sort(T[] elements);

    <T> void sort(T[] elements, Comparator<T> comparator);
}
