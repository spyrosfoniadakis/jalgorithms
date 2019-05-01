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
package utils;

public class Statistics {

    public static IntArrayInfo from(int[] numbers){
        if(numbers.length == 0){
            throw new IllegalArgumentException("");
        }
        if(numbers.length == 1){
            return IntArrayInfo.from(0, numbers[0], 0, numbers[0]);
        }

        IntermediateIntArrayInfo tmp = initCalculation(numbers);
        return completeCalculation(numbers, tmp);
    }

    private static IntArrayInfo completeCalculation(int[] numbers, IntermediateIntArrayInfo tmp) {

        int minIndex= tmp.getMinIndex();
        int min = numbers[minIndex];

        int maxIndex= tmp.getMaxIndex();
        int max = numbers[maxIndex];

        int index = tmp.getStartingIndex();

        int tmpMin, tmpMax, tmpMinIndex, tmpMaxIndex;
        for(int i = index; i<numbers.length; i+=2){

            if(numbers[i] < numbers[i+1]){
                tmpMinIndex = i;
                tmpMaxIndex = i+1;
            }
            else{
                tmpMinIndex = i+1;
                tmpMaxIndex = i;
            }
            tmpMin = numbers[tmpMinIndex];
            tmpMax = numbers[tmpMaxIndex];

            if(tmpMin < min){
                min = tmpMin;
                minIndex = tmpMinIndex;
            }
            if(tmpMax > max){
                max = tmpMax;
                maxIndex = tmpMaxIndex;
            }
        }

        return IntArrayInfo.from(minIndex, min, maxIndex, max);
    }

    private static IntermediateIntArrayInfo initCalculation(int[] numbers) {
        int minIndex, min, maxIndex, max, index;
        if(numbers.length % 2 == 0){
            if(numbers[0] < numbers[1]){
                minIndex = 0;
                maxIndex = 1;
            }
            else{
                minIndex = 1;
                maxIndex = 0;
            }
            index = 2;
        }
        else {
            minIndex = 0;
            maxIndex = 0;
            index = 1;
        }
        min = numbers[minIndex];
        max = numbers[maxIndex];

        return IntermediateIntArrayInfo.from(minIndex, min, maxIndex, max, index);
    }

    public static class IntArrayInfo{

        private final int minIndex;
        private final int min;
        private final int maxIndex;
        private final int max;

        private IntArrayInfo(int minIndex, int min, int maxIndex, int max) {
            this.minIndex = minIndex;
            this.min = min;
            this.maxIndex = maxIndex;
            this.max = max;
        }

        public int getMinIndex() {
            return minIndex;
        }

        public int getMin() {
            return this.min;
        }

        public int getMaxIndex() {
            return maxIndex;
        }

        public int getMax() {
            return this.max;
        }

        @Override
        public String toString() {
            return "IntArrayInfo{" +
                    "minIndex=" + minIndex +
                    ", min=" + min +
                    ", maxIndex=" + maxIndex +
                    ", max=" + max +
                    '}';
        }

        private static IntArrayInfo from(int minIndex, int min, int maxIndex, int max){
            return new IntArrayInfo(minIndex, min, maxIndex, max);
        }
    }

    private static class IntermediateIntArrayInfo {

        private int minIndex;
        private int min;
        private int maxIndex;
        private int max;
        private int startingIndex;

        private IntermediateIntArrayInfo(int minIndex, int min, int maxIndex, int max, int startingIndex) {
            this.minIndex = minIndex;
            this.min = min;
            this.maxIndex = maxIndex;
            this.max = max;
            this.startingIndex = startingIndex;
        }

        public int getMinIndex() {
            return this.minIndex;
        }

        public void setMinIndex(int minIndex) {
            this.minIndex = minIndex;
        }

        public int getMaxIndex() {
            return this.maxIndex;
        }

        public void setMaxIndex(int maxIndex) {
            this.maxIndex = maxIndex;
        }

        public int getStartingIndex() {
            return this.startingIndex;
        }

        public void setStartingIndex(int startingIndex) {
            this.startingIndex = startingIndex;
        }

        private static IntermediateIntArrayInfo from(int minIndex, int min, int maxIndex, int max, int startingIndex) {
            return new IntermediateIntArrayInfo(minIndex, min, maxIndex, max, startingIndex);
        }
    }
}
