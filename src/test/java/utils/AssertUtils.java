package utils;

import ds.IntMaxHeap;
import org.junit.Assert;
import sorting.SortingDirection;

import java.util.Arrays;
import java.util.function.BiFunction;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AssertUtils {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", AssertUtils.class.getSimpleName());

    private AssertUtils(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    public static void assertIsSorted(float[] numbers) {
        assertIsSorted(numbers, SortingDirection.ASCENDING);
    }

    public static void assertIsSorted(long[] numbers) {
        assertIsSorted(numbers, SortingDirection.ASCENDING);
    }

    public static void assertIsSorted(double[] numbers) {
        assertIsSorted(numbers, SortingDirection.ASCENDING);
    }

    public static void assertIsMaxHeap(IntMaxHeap heap) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Object value = ReflectionUtils.getFieldValueOf(heap, "ds.IntMaxHeap", "elements");
        int[] elements = (int[]) value;
        int[] extracted = new int[elements.length];
        int index = 0;
        while (heap.getSize() > 0){
            extracted[index++]= heap.extract();
        }
        assertIsSorted(extracted, SortingDirection.DESCENDING);
    }

    public enum SortingDirection{
        ASCENDING{
//            @Override
//            public BiFunction<Integer, Integer, Boolean> shouldSwap() {
//                return (a, b) -> a > b ;
//            }

            @Override
            public <T extends Comparable<T>> BiFunction<T, T, Boolean> shouldSwap() {
                return (a, b) -> a.compareTo(b) > 0 ;
            }

        },
        DESCENDING{
//            @Override
//            public BiFunction<Integer, Integer, Boolean> shouldSwap() {
//                return (a, b) -> a < b ;
//            }

            @Override
            public <T extends Comparable<T>> BiFunction<T, T, Boolean> shouldSwap() {
                return (a, b) -> a.compareTo(b) < 0 ;
            }
        };

        public abstract <T extends Comparable<T>> BiFunction<T, T, Boolean> shouldSwap();

    }

    public static void assertIsSorted(int[] numbers) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
            Assert.assertThat(numbers[prev++], is(lessThanOrEqualTo(numbers[current++])));
        }
    }

    public static void assertIsSorted(int[] numbers, SortingDirection direction) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
//            Assert.assertThat(numbers[prev++], is(lessThanOrEqualTo(numbers[current++])));
            Assert.assertThat(!direction.<Integer>shouldSwap().apply(numbers[prev++], numbers[current++]), is(equalTo(true)));
        }
    }

    public static void assertIsSorted(long[] numbers, SortingDirection direction) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
//            Assert.assertThat(numbers[prev++], is(lessThanOrEqualTo(numbers[current++])));
            Assert.assertThat(!direction.<Long>shouldSwap().apply(numbers[prev++], numbers[current++]), is(equalTo(true)));
        }
    }

    public static void assertIsSorted(float[] numbers, SortingDirection direction) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
//            Assert.assertThat(numbers[prev++], is(lessThanOrEqualTo(numbers[current++])));
            Assert.assertThat(!direction.<Float>shouldSwap().apply(numbers[prev++], numbers[current++]), is(equalTo(true)));
        }
    }

    public static void assertIsSorted(double[] numbers, SortingDirection direction) {
        int prev = 0;
        int current = 1;
        while(current < numbers.length){
//            Assert.assertThat(numbers[prev++], is(lessThanOrEqualTo(numbers[current++])));
            Assert.assertThat(!direction.<Double>shouldSwap().apply(numbers[prev++], numbers[current++]), is(equalTo(true)));
        }
    }

    public static void areIdentical(double[] original, double[] target) {
        double[] copyOriginal = Arrays.copyOfRange(original, 0, original.length);
        double[] copyTarget = Arrays.copyOfRange(target, 0, target.length);
        Arrays.sort(copyOriginal);
        Arrays.sort(copyTarget);
        Assert.assertArrayEquals(copyOriginal, copyTarget, 0);
    }

    public static void areIdentical(int[] original, int[] target) {
        int[] copyOriginal = Arrays.copyOfRange(original, 0, original.length);
        int[] copyTarget = Arrays.copyOfRange(target, 0, target.length);
        Arrays.sort(copyOriginal);
        Arrays.sort(copyTarget);
        Assert.assertArrayEquals(copyOriginal, copyTarget);
    }

    public static void areIdentical(long[] original, long[] target) {
        long[] copyOriginal = Arrays.copyOfRange(original, 0, original.length);
        long[] copyTarget = Arrays.copyOfRange(target, 0, target.length);
        Arrays.sort(copyOriginal);
        Arrays.sort(copyTarget);
        Assert.assertArrayEquals(copyOriginal, copyTarget);
    }

    public static void areIdentical(float[] original, float[] target) {
        float[] copyOriginal = Arrays.copyOfRange(original, 0, original.length);
        float[] copyTarget = Arrays.copyOfRange(target, 0, target.length);
        Arrays.sort(copyOriginal);
        Arrays.sort(copyTarget);
        Assert.assertArrayEquals(copyOriginal, copyTarget, 0);
    }
}
