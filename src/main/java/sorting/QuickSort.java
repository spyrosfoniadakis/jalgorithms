package sorting;

import utils.ArrayUtils;

import java.util.Comparator;

public final class QuickSort {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", QuickSort.class);
    private static QuickSorter sorter = new QuickSorter();

    private QuickSort(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    public static void sort(int[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(long[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(float[] numbers){
        sorter.sort(numbers);
    }

    public static void sort(double[] numbers){
        sorter.sort(numbers);
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
            this.sort(numbers, 0, numbers.length);
        }

        public void sort(int[] numbers, int start, int end) {
            if(isSingleElementArray(start, end))
                return;

            int partitionIndex = this.getPartitionIndex(numbers, start, end);
            this.sort(numbers, start, partitionIndex);
            this.sort(numbers, partitionIndex+1, end);
        }

        private int getPartitionIndex(int[] numbers, int start, int end) {
            int pointOfReference = numbers[end-1];
            int partitionIndex = start - 1;
            for(int i=start; i<end-1; i++){
                if(numbers[i] <= pointOfReference){
                    ArrayUtils.swap(numbers, i, ++partitionIndex);
                }
            }

            ArrayUtils.swap(numbers, end-1, ++partitionIndex);
            return partitionIndex;
        }

        @Override
        public void sort(long[] numbers) {
            this.sort(numbers, 0, numbers.length);
        }

        public void sort(long[] numbers, int start, int end) {
            if(isSingleElementArray(start, end))
                return;

            int partitionIndex = this.getPartitionIndex(numbers, start, end);
            this.sort(numbers, start, partitionIndex);
            this.sort(numbers, partitionIndex+1, end);
        }

        private int getPartitionIndex(long[] numbers, int start, int end) {
            long pointOfReference = numbers[end-1];
            int partitionIndex = start - 1;
            for(int i=start; i<end-1; i++){
                if(numbers[i] <= pointOfReference){
                    ArrayUtils.swap(numbers, i, ++partitionIndex);
                }
            }

            ArrayUtils.swap(numbers, end-1, ++partitionIndex);
            return partitionIndex;
        }

        @Override
        public void sort(float[] numbers) {
            this.sort(numbers, 0, numbers.length);
        }

        public void sort(float[] numbers, int start, int end) {
            if(isSingleElementArray(start, end))
                return;

            int partitionIndex = this.getPartitionIndex(numbers, start, end);
            this.sort(numbers, start, partitionIndex);
            this.sort(numbers, partitionIndex+1, end);
        }

        private int getPartitionIndex(float[] numbers, int start, int end) {
            float pointOfReference = numbers[end-1];
            int partitionIndex = start - 1;
            for(int i=start; i<end-1; i++){
                if(numbers[i] <= pointOfReference){
                    ArrayUtils.swap(numbers, i, ++partitionIndex);
                }
            }

            ArrayUtils.swap(numbers, end-1, ++partitionIndex);
            return partitionIndex;
        }

        @Override
        public void sort(double[] numbers) {
            this.sort(numbers, 0, numbers.length);
        }

        public void sort(double[] numbers, int start, int end) {
            if(isSingleElementArray(start, end))
                return;

            int partitionIndex = this.getPartitionIndex(numbers, start, end);
            this.sort(numbers, start, partitionIndex);
            this.sort(numbers, partitionIndex+1, end);
        }

        private int getPartitionIndex(double[] numbers, int start, int end) {
            double pointOfReference = numbers[end-1];
            int partitionIndex = start - 1;
            for(int i=start; i<end-1; i++){
                if(numbers[i] <= pointOfReference){
                    ArrayUtils.swap(numbers, i, ++partitionIndex);
                }
            }

            ArrayUtils.swap(numbers, end-1, ++partitionIndex);
            return partitionIndex;
        }

        @Override
        public <T extends Comparable<T>> void sort(T[] elements) {

        }

        public <T extends Comparable<T>> void sort(T[] numbers, int start, int end) {
            if(isSingleElementArray(start, end))
                return;

            int partitionIndex = this.getPartitionIndex(numbers, start, end);
            this.sort(numbers, start, partitionIndex);
            this.sort(numbers, partitionIndex+1, end);
        }

        private <T extends Comparable<T>> int getPartitionIndex(T[] numbers, int start, int end) {
            T pointOfReference = numbers[end-1];
            int partitionIndex = start - 1;
            for(int i=start; i<end-1; i++){
                if(numbers[i].compareTo(pointOfReference) <= 0){
                    ArrayUtils.swap(numbers, i, ++partitionIndex);
                }
            }

            ArrayUtils.swap(numbers, end-1, ++partitionIndex);
            return partitionIndex;
        }

        @Override
        public <T> void sort(T[] elements, Comparator<T> comparator) {

        }

        public <T> void sort(T[] numbers, int start, int end, Comparator<T> comparator) {
            if(isSingleElementArray(start, end))
                return;

            int partitionIndex = this.getPartitionIndex(numbers, start, end, comparator);
            this.sort(numbers, start, partitionIndex, comparator);
            this.sort(numbers, partitionIndex+1, end, comparator);
        }

        private <T> int getPartitionIndex(T[] numbers, int start, int end, Comparator<T> comparator) {
            T pointOfReference = numbers[end-1];
            int partitionIndex = start - 1;
            for(int i=start; i<end-1; i++){
                if(comparator.compare(numbers[i], pointOfReference) <=0){
                    ArrayUtils.swap(numbers, i, ++partitionIndex);
                }
            }

            ArrayUtils.swap(numbers, end-1, ++partitionIndex);
            return partitionIndex;
        }

        private boolean isSingleElementArray(int start, int end) {
            return start >= end - 1;
        }
    }
}
