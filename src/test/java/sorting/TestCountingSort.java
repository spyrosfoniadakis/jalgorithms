package sorting;

import org.junit.Test;

import java.util.Random;

public class TestCountingSort {

    @Test
    public void test_countingSort_intDesending(){
        int[] numbers = new int[]{1, 14, 8, 10, -6, 9, 21, 16, 12, 3, -20};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.DESCENDING, (a) -> CountingSort.sort(a, SortingDirection.DESCENDING),"test_countingSort_intDesending");
    }

    @Test
    public void test_countingSort_intAscending(){
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, -100};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, (a) -> CountingSort.sort(a, SortingDirection.ASCENDING),"test_countingSort_intAscending");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_countingSort_longAscending(){
        Random r = new Random();
        long[] numbers = new long[]{ Math.abs(r.nextLong()), Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong())};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, (a) -> CountingSort.sort(a, SortingDirection.DESCENDING),"test_countingSort_longDesending");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_countingSort_longDescending(){
        Random r = new Random();
        long[] numbers = new long[]{ Math.abs(r.nextLong()), Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong())};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.DESCENDING, (a) -> CountingSort.sort(a, SortingDirection.DESCENDING),"test_countingSort_longDesending");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_countingSort_floatAscending(){
        Random r = new Random();
        float[] numbers = new float[]{ Math.abs(r.nextFloat()), Math.abs(r.nextFloat()),Math.abs(r.nextFloat()),Math.abs(r.nextFloat()),Math.abs(r.nextFloat()),Math.abs(r.nextFloat()),Math.abs(r.nextFloat()),Math.abs(r.nextFloat()),Math.abs(r.nextFloat())};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, (a) -> CountingSort.sort(a, SortingDirection.DESCENDING),"test_countingSort_longDesending");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_countingSort_floatDescending(){
        Random r = new Random();
        float[] numbers = new float[]{ Math.abs(r.nextFloat()), Math.abs(r.nextFloat()),Math.abs(r.nextFloat()),Math.abs(r.nextFloat()),Math.abs(r.nextFloat()),Math.abs(r.nextFloat()),Math.abs(r.nextFloat()),Math.abs(r.nextFloat()),Math.abs(r.nextFloat())};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.DESCENDING, (a) -> CountingSort.sort(a, SortingDirection.DESCENDING),"test_countingSort_longDesending");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_countingSort_doubleAscending(){
        Random r = new Random();
        double[] numbers = new double[]{ Math.abs(r.nextDouble()), Math.abs(r.nextDouble()),Math.abs(r.nextDouble()),Math.abs(r.nextDouble()),Math.abs(r.nextDouble()),Math.abs(r.nextDouble()),Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong())};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.ASCENDING, (a) -> CountingSort.sort(a, SortingDirection.DESCENDING),"test_countingSort_longDesending");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_countingSort_doubleDescending(){
        Random r = new Random();
        double[] numbers = new double[]{ Math.abs(r.nextDouble()), Math.abs(r.nextDouble()),Math.abs(r.nextDouble()),Math.abs(r.nextDouble()),Math.abs(r.nextDouble()),Math.abs(r.nextDouble()),Math.abs(r.nextLong()),Math.abs(r.nextLong()),Math.abs(r.nextLong())};
        SortingUtils.executeSortTestOn(numbers, SortingDirection.DESCENDING, (a) -> CountingSort.sort(a, SortingDirection.DESCENDING),"test_countingSort_longDesending");
    }
}
