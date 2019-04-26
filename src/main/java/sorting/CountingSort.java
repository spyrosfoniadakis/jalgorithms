package sorting;

import utils.Statistics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CountingSort {

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
                    //for(int i=1; i<tmp.length; i++){
                    //    tmp[i] = tmp[i-1] + tmp[i];
                    //}
                }

                @Override
                public void finalizeSorting(int[] numbers, Statistics.IntArrayInfo statistics, int[] sorted, int[] tmp) {
                    Stream.iterate(numbers.length-1, i -> i - 1).limit(numbers.length).forEach( i -> doSortStep(numbers, statistics, sorted, tmp, i));
                    //for(int i=numbers.length-1; i>=0; i--){
                    //    doSortStep(numbers, statistics, sorted, tmp, i);
                    //}
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

            // TODO: Part of a partial solution fo a counting sort for long integers
//            Map<DecodingEntry, Long> mapping = new HashMap<>();
//            Map<Long, List<Integer>> grouped = new HashMap<>();
//            for(int i=0; i<numbers.length; i++){
//                Long key = numbers[i] / 100; //Numbers.reduceToIntByDividingWith(numbers[i], 10000);
//                Integer value = Numbers.reduceToIntByModuloWith(numbers[i], 100);
//                if(!grouped.containsKey(key)){
//                    grouped.put(key, new ArrayList<>());
//                }
//                grouped.get(key).add(value);
//                mapping.put(DecodingEntry.from(key, value), numbers[i]);
//            }
//
//            Map<Long, int[]> arrays = new HashMap<>();
//            for(Map.Entry<Long, List<Integer>> entry : grouped.entrySet()){
//                arrays.put(entry.getKey(), ArrayUtils.createIntArrayFrom(entry.getValue()));
//                this.sort(arrays.get(entry.getKey()), direction);
//            }
//
//
//            int index = 0;
//            TreeSet<Map.Entry<Long, int[]>> sortedArrays = new TreeSet<>(Map.Entry.comparingByKey());
//            sortedArrays.addAll(arrays.entrySet());
//            TmpDecodingEntry tmp = TmpDecodingEntry.newEmpty();
//            for(Map.Entry<Long, int[]> entry : sortedArrays){
//                long key = entry.getKey();
//                tmp.setQuotient(key);
//                for(int number : entry.getValue()) {
//                    tmp.setResidue(number);
//                    numbers[index++] = mapping.get(tmp); //entry.getKey() * Integer.MAX_VALUE + number;
//                }
//            }
        }
//
//
//        private static class TmpDecodingEntry {
//            private long quotient;
//            private int residue;
//
//            private TmpDecodingEntry(long quotient, int residue) {
//                this.quotient = quotient;
//                this.residue = residue;
//            }
//
//            public static TmpDecodingEntry from(long quotient, int residue){
//                return new TmpDecodingEntry(quotient, residue);
//            }
//
//            public static TmpDecodingEntry newEmpty(){
//                return new TmpDecodingEntry(0L, 0);
//            }
//
//            public long getQuotient() {
//                return quotient;
//            }
//            public void setQuotient(long quotient) {
//                this.quotient = quotient;
//            }
//
//            public int getResidue() {
//                return residue;
//            }
//            public void setResidue(int residue) {
//                this.residue = residue;
//            }
//        }
//
//        private static class DecodingEntry {
//            private final long quotient;
//            private final int residue;
//
//            private DecodingEntry(long quotient, int residue) {
//                this.quotient = quotient;
//                this.residue = residue;
//            }
//
//            public static DecodingEntry from(long quotient, int residue){
//                return new DecodingEntry(quotient, residue);
//            }
//
//            public long getQuotient() {
//                return quotient;
//            }
//
//            public int getResidue() {
//                return residue;
//            }
//
//            public boolean isInTheSameSequenceWith(DecodingEntry other){
//                return this.quotient == other.quotient;
//            }
//        }

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

        }

        @Override
        public <T> void sort(T[] elements, Comparator<T> comparator) {

        }

        private static int normalize(int min, int value){
            return value + Math.abs(Math.min(min - 1 , 0));
        }
    }
}
