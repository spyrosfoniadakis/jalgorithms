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

import java.util.List;

/**
 * @author Spyros Foniadakis
 */
public final class ArrayUtils {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", ArrayUtils.class.getSimpleName());

    private ArrayUtils(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }


    public static void swap(int[] numbers, int index1, int index2) {
        int tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    public static void swap(long[] numbers, int index1, int index2) {
        long tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    public static void swap(float[] numbers, int index1, int index2) {
        float tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    public static void swap(double[] numbers, int index1, int index2) {
        double tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    public static <T> void swap(T[] numbers, int index1, int index2) {
        T tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    public static int indexOfMax(int[] numbers){
        if(numbers.length == 0){
            throw new IllegalArgumentException("Array must have at least one element.");
        }
        int maxIndex = 0;
        for(int i=1; i<numbers.length; i++){
            maxIndex = (numbers[maxIndex] < numbers[i]) ? i : maxIndex;
        }
        return maxIndex;
    }

    public static int[] createIntArrayFrom(List<Integer> numbers) {
        int index = 0;
        int[] result = new int[numbers.size()];
        for(int number : numbers){
            result[index++] = number;
        }
        return result;
    }
}
