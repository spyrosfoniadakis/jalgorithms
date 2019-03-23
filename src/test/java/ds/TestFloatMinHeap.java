package ds;

import org.junit.Assert;
import org.junit.Test;
import utils.AssertUtils;
import utils.ReflectionUtils;

import java.util.Arrays;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestFloatMinHeap {

    public static final String HEAP_ELEMENTS_FIELD_NAME = "elements";

    @Test
    public void test_defaultFactoryMethod_createsAnArrayOfTenForZeroSizeHeap() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        FloatMinHeap heap = FloatMinHeap.newHeap();

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(10)) );
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        Object value = ReflectionUtils.getFieldValueOf(heap, FloatMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        float[] elements = (float[]) value;

        for(float element : elements){
            Assert.assertThat(element, is(equalTo(0f)));
        }
    }

    @Test
    public void test_factoryMethodWithInitialCapacity_createsAnArrayWithZeroSizeHeap() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        FloatMinHeap heap = FloatMinHeap.newHeap(20);

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(20)) );
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        Object value = ReflectionUtils.getFieldValueOf(heap, FloatMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        float[] elements = (float[]) value;

        for(float element : elements){
            Assert.assertThat(element, is(equalTo(0f)));
        }
    }

    @Test
    public void test_factoryMethodWithArray_createsAHeapWithTheSameElements() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        FloatMinHeap heap = FloatMinHeap.from(numbers);

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        float[] elements = (float[]) ReflectionUtils.getFieldValueOf(heap, FloatMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        AssertUtils.assertIsMinHeap(heap);

        AssertUtils.areIdentical(elements, numbers);
        System.out.println(String.format("After building heap: %s", Arrays.toString(elements)));
    }

    @Test
    public void test_extractReducesTheSizeBYOneEachTime() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        FloatMinHeap heap = FloatMinHeap.from(numbers);

        // when
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        // then
        int sizeBefore = heap.getSize();
        heap.extract();
        int sizeAfter = heap.getSize();

        Assert.assertThat(sizeBefore, is(equalTo(sizeAfter + 1)));

    }

    // TODO: Array.stream() does not support float
//    @Test
//    public void test_extractRemovesTheElement() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
//        // given
//        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
//        FloatMinHeap heap = FloatMinHeap.from(numbers);
//
//        // when
//        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
//        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );
//
//        float[] elementsBefore = (float[]) ReflectionUtils.getFieldValueOf(heap, FloatMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
//        float peeked = heap.peek();
//        Assert.assertThat(Arrays.stream(elementsBefore).anyMatch(e -> e == peeked), is(equalTo(true)));
//
//        float extracted = heap.extract();
//        float[] elementsAfter = (float[]) ReflectionUtils.getFieldValueOf(heap, FloatMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
//        Assert.assertThat(Arrays.stream(elementsAfter).anyMatch(e -> e == extracted), is(equalTo(false)));
//    }

    @Test
    public void test_theElementPeekedIsTheOneToExtract() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        FloatMinHeap heap = FloatMinHeap.from(numbers);

        // when
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        float peeked = heap.peek();
        float extracted = heap.extract();
        Assert.assertThat(peeked, is(equalTo(extracted)));
    }

    @Test
    public void test_parentElementIsSmallerThanTheChildElements() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        FloatMinHeap heap = FloatMinHeap.from(numbers);
        float[] elements = (float[]) ReflectionUtils.getFieldValueOf(heap, heap.getClass().getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);

        int parentIndex = 0;
        while(true){
            int leftIndex = heap.getLeftChildIndexOf(parentIndex);
            int rightIndex = heap.getRightChildIndexOf(parentIndex);
            System.out.println(String.format("candidate parent: {index: %d, value: %f}, left: {index: %d, value: %s}, right:{index: %d, value: %s}",
                    parentIndex, elements[parentIndex], leftIndex, (leftIndex != -1) ? elements[leftIndex] : "n/a", rightIndex, (rightIndex != -1) ? elements[rightIndex] : "n/a"));

            if(leftIndex == -1 && rightIndex == -1) {
                break;
            }
            if(leftIndex != -1) {
                Assert.assertThat(elements[parentIndex], is(lessThanOrEqualTo(elements[leftIndex])));
            }
            if(rightIndex != -1) {
                Assert.assertThat(elements[parentIndex], is(lessThanOrEqualTo(elements[rightIndex])));
            }

            parentIndex ++;
        }
    }
    
}
