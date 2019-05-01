package ds;

import org.junit.Assert;
import org.junit.Test;
import utils.AssertUtils;
import utils.ReflectionUtils;

import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestIntMaxHeap {

    public static final String HEAP_ELEMENTS_FIELD_NAME = "elements";

    @Test
    public void test_defaultFactoryMethod_createsAnArrayOfTenForZeroSizeHeap() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        IntMaxHeap heap = IntMaxHeap.newHeap();

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(10)) );
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        Object value = ReflectionUtils.getFieldValueOf(heap, IntMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        int[] elements = (int[]) value;

        for(int element : elements){
            Assert.assertThat(element, is(equalTo(0)));
        }
    }

    @Test
    public void test_factoryMethodWithInitialCapacity_createsAnArrayWithZeroSizeHeap() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        IntMaxHeap heap = IntMaxHeap.newHeap(20);

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(20)) );
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        Object value = ReflectionUtils.getFieldValueOf(heap, IntMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        int[] elements = (int[]) value;

        for(int element : elements){
            Assert.assertThat(element, is(equalTo(0)));
        }
    }

    @Test
    public void test_factoryMethodWithArray_createsAHeapWithTheSameElements() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMaxHeap heap = IntMaxHeap.from(numbers);

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        int[] elements = (int[]) ReflectionUtils.getFieldValueOf(heap, IntMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        AssertUtils.assertIsMaxHeap(heap);

        AssertUtils.areIdentical(elements, numbers);
        System.out.println(String.format("After asserting on the contents: %s", Arrays.toString(elements)));
    }

    @Test
    public void test_extractReducesTheSizeBYOneEachTime() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMaxHeap heap = IntMaxHeap.from(numbers);

        // when
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        // then
        int sizeBefore = heap.getSize();
        heap.extract();
        int sizeAfter = heap.getSize();

        Assert.assertThat(sizeBefore, is(equalTo(sizeAfter + 1)));

    }

    @Test
    public void test_extractRemovesTheElement() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMaxHeap heap = IntMaxHeap.from(numbers);

        // when
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        int[] elementsBefore = (int[]) ReflectionUtils.getFieldValueOf(heap, IntMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        int peeked = heap.peek();
        Assert.assertThat(Arrays.stream(elementsBefore).anyMatch(e -> e == peeked), is(equalTo(true)));

        int extracted = heap.extract();
        int[] elementsAfter = (int[]) ReflectionUtils.getFieldValueOf(heap, IntMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        Assert.assertThat(Arrays.stream(elementsAfter).anyMatch(e -> e == extracted), is(equalTo(false)));
    }

    @Test
    public void test_theElementPeekedIsTheOneToExtract() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMaxHeap heap = IntMaxHeap.from(numbers);

        // when
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        int peeked = heap.peek();
        int extracted = heap.extract();
        Assert.assertThat(peeked, is(equalTo(extracted)));
    }

    @Test
    public void test_afterSubsequentExtractionTheHeapRemainsValid() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMaxHeap heap = IntMaxHeap.from(numbers);

        // when
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        while(!heap.isEmpty()){
            heap.extract();
            AssertUtils.assertIsMaxHeap(heap);
        }

        Assert.assertThat(heap.getSize(), is(equalTo(0)) );
    }

    @Test
    public void test_insertIncreasesTheSizeByOneEachTime() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMaxHeap heap = IntMaxHeap.from(numbers);

        // when
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        // then
        int sizeBefore = heap.getSize();
        heap.insert(30);
        int sizeAfter = heap.getSize();

        Assert.assertThat(sizeBefore, is(equalTo(sizeAfter - 1)));
    }

    @Test
    public void test_subsequentInsertionsIncreasesTheSizeByOneEachTime() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        IntMaxHeap heap = IntMaxHeap.newHeap();

        // when
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        // then
        Random random = new Random();
        for(int i=0;i<100;i++){
            int sizeBefore = heap.getSize();
            heap.insert(random.nextInt());
            int sizeAfter = heap.getSize();

            Assert.assertThat(sizeBefore, is(equalTo(sizeAfter - 1)));
        }
    }

    @Test
    public void test_afterSubsequentInsertionsTheHeapRemainsValid() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        IntMaxHeap heap = IntMaxHeap.newHeap();

        // when
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        // then
        Random random = new Random();
        for(int i=0;i<100;i++){
            heap.insert(random.nextInt());
            AssertUtils.assertIsMaxHeap(heap);
        }
    }

    @Test
    public void test_insertAddsTheElement() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMaxHeap heap = IntMaxHeap.from(numbers);

        // when
        int[] elementsBefore = (int[]) ReflectionUtils.getFieldValueOf(heap, IntMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        int toInsert = 30;
        Assert.assertThat(Arrays.stream(elementsBefore).anyMatch(e -> e == toInsert), is(equalTo(false)));

        heap.insert(30);
        int[] elementsAfter = (int[]) ReflectionUtils.getFieldValueOf(heap, IntMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);

        // then
        Assert.assertThat(Arrays.stream(elementsAfter).anyMatch(e -> e == toInsert), is(equalTo(true)));
    }

    @Test
    public void test_parentElementIsLargerThanTheChildElements() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMaxHeap heap = IntMaxHeap.from(numbers);
        int[] elements = (int[]) ReflectionUtils.getFieldValueOf(heap, IntMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);

        int parentIndex = 0;
        while(true){
            int leftIndex = heap.getLeftChildIndexOf(parentIndex);
            int rightIndex = heap.getRightChildIndexOf(parentIndex);
            System.out.println(String.format("candidate parent: {index: %d, value: %d}, left: {index: %d, value: %s}, right:{index: %d, value: %s}",
                    parentIndex, elements[parentIndex], leftIndex, (leftIndex != -1) ? elements[leftIndex] : "n/a", rightIndex, (rightIndex != -1) ? elements[rightIndex] : "n/a"));

            if(leftIndex == -1 && rightIndex == -1) {
                break;
            }
            if(leftIndex != -1) {
                Assert.assertThat(elements[parentIndex], is(greaterThanOrEqualTo(elements[leftIndex])));
            }
            if(rightIndex != -1) {
                Assert.assertThat(elements[parentIndex], is(greaterThanOrEqualTo(elements[rightIndex])));
            }

            parentIndex ++;
        }
    }
}
