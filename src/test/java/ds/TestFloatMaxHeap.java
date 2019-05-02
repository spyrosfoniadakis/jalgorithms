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

/**
 * @author Spyros Foniadakis
 */
public class TestFloatMaxHeap {

    public static final String HEAP_ELEMENTS_FIELD_NAME = "elements";

    @Test
    public void test_defaultFactoryMethod_createsAnArrayOfTenForZeroSizeHeap() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        FloatMaxHeap heap = FloatMaxHeap.newHeap();

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(10)) );
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        Object value = ReflectionUtils.getFieldValueOf(heap, FloatMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        float[] elements = (float[]) value;

        for(float element : elements){
            Assert.assertThat(element, is(equalTo(0f)));
        }
    }

    @Test
    public void test_factoryMethodWithInitialCapacity_createsAnArrayWithZeroSizeHeap() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        FloatMaxHeap heap = FloatMaxHeap.newHeap(20);

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(20)) );
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        Object value = ReflectionUtils.getFieldValueOf(heap, FloatMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        float[] elements = (float[]) value;

        for(float element : elements){
            Assert.assertThat(element, is(equalTo(0f)));
        }
    }

    @Test
    public void test_factoryMethodWithArray_createsAHeapWithTheSameElements() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        FloatMaxHeap heap = FloatMaxHeap.from(numbers);

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        float[] elements = (float[]) ReflectionUtils.getFieldValueOf(heap, FloatMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        AssertUtils.assertIsMaxHeap(heap);

        AssertUtils.areIdentical(elements, numbers);
        System.out.println(String.format("After building heap: %s", Arrays.toString(elements)));
    }

    @Test
    public void test_extractReducesTheSizeByOneEachTime() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        FloatMaxHeap heap = FloatMaxHeap.from(numbers);

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
    @Test
    public void test_extractRemovesTheElement() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
//        // given
//        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
//        FloatMaxHeap heap = FloatMaxHeap.from(numbers);
//
//        // when
//        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
//        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );
//
//        float[] elementsBefore = (float[]) ReflectionUtils.getFieldValueOf(heap, FloatMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
//        float peeked = heap.peek();
//        Assert.assertThat(Arrays.stream(elementsBefore).anyMatch(e -> e == peeked), is(equalTo(true)));
//
//        float extracted = heap.extract();
//        float[] elementsAfter = (float[]) ReflectionUtils.getFieldValueOf(heap, FloatMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
//        Assert.assertThat(Arrays.stream(elementsAfter).anyMatch(e -> e == extracted), is(equalTo(false)));
    }

    @Test
    public void test_theElementPeekedIsTheOneToExtract() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        FloatMaxHeap heap = FloatMaxHeap.from(numbers);

        // when
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        float peeked = heap.peek();
        float extracted = heap.extract();
        Assert.assertThat(peeked, is(equalTo(extracted)));
    }

    @Test
    public void test_afterSubsequentExtractionTheHeapRemainsValid() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        FloatMaxHeap heap = FloatMaxHeap.from(numbers);

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
        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        FloatMaxHeap heap = FloatMaxHeap.from(numbers);

        // when
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        // then
        int sizeBefore = heap.getSize();
        heap.insert(30f);
        int sizeAfter = heap.getSize();

        Assert.assertThat(sizeBefore, is(equalTo(sizeAfter - 1)));
    }

    @Test
    public void test_subsequentInsertionsIncreasesTheSizeByOneEachTime() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        FloatMaxHeap heap = FloatMaxHeap.newHeap();

        // when
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        // then
        Random random = new Random();
        for(int i=0;i<100;i++){
            int sizeBefore = heap.getSize();
            heap.insert(random.nextFloat());
            int sizeAfter = heap.getSize();

            Assert.assertThat(sizeBefore, is(equalTo(sizeAfter - 1)));
        }
    }

    @Test
    public void test_afterSubsequentInsertionsTheHeapRemainsValid() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        FloatMaxHeap heap = FloatMaxHeap.newHeap();

        // when
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        // then
        Random random = new Random();
        for(int i=0;i<100;i++){
            heap.insert(random.nextFloat());
            AssertUtils.assertIsMaxHeap(heap);
        }
    }

    @Test
    public void test_parentElementIsLargerThanTheChildElements() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        float[] numbers = new float[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        FloatMaxHeap heap = FloatMaxHeap.from(numbers);
        float[] elements = (float[]) ReflectionUtils.getFieldValueOf(heap, FloatMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);

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
                Assert.assertThat(elements[parentIndex], is(greaterThanOrEqualTo(elements[leftIndex])));
            }
            if(rightIndex != -1) {
                Assert.assertThat(elements[parentIndex], is(greaterThanOrEqualTo(elements[rightIndex])));
            }

            parentIndex ++;
        }
    }

}
