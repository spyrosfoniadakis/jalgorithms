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

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Spyros Foniadakis
 */
public class TestIntMinHeap {

    public static final String HEAP_ELEMENTS_FIELD_NAME = "elements";

    @Test
    public void test_defaultFactoryMethod_createsAnArrayOfTenForZeroSizeHeap() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        IntMinHeap heap = IntMinHeap.newHeap();

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(10)) );
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        Object value = ReflectionUtils.getFieldValueOf(heap, IntMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        int[] elements = (int[]) value;

        for(int element : elements){
            Assert.assertThat(element, is(equalTo(0)));
        }
    }

    @Test
    public void test_factoryMethodWithInitialCapacity_createsAnArrayWithZeroSizeHeap() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        IntMinHeap heap = IntMinHeap.newHeap(20);

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(20)) );
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        Object value = ReflectionUtils.getFieldValueOf(heap, IntMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        int[] elements = (int[]) value;

        for(int element : elements){
            Assert.assertThat(element, is(equalTo(0)));
        }
    }

    @Test
    public void test_factoryMethodWithArray_createsAHeapWithTheSameElements() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMinHeap heap = IntMinHeap.from(numbers);

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        int[] elements = (int[]) ReflectionUtils.getFieldValueOf(heap, IntMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        AssertUtils.assertIsMinHeap(heap);

        AssertUtils.areIdentical(elements, numbers);
        System.out.println(String.format("After building heap: %s", Arrays.toString(elements)));
    }

    @Test
    public void test_extractReducesTheSizeBYOneEachTime() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMinHeap heap = IntMinHeap.from(numbers);

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
        IntMinHeap heap = IntMinHeap.from(numbers);

        // when
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        int[] elementsBefore = (int[]) ReflectionUtils.getFieldValueOf(heap, IntMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        int peeked = heap.peek();
        Assert.assertThat(Arrays.stream(elementsBefore).anyMatch(e -> e == peeked), is(equalTo(true)));

        int extracted = heap.extract();
        int[] elementsAfter = (int[]) ReflectionUtils.getFieldValueOf(heap, IntMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        Assert.assertThat(Arrays.stream(elementsAfter).anyMatch(e -> e == extracted), is(equalTo(false)));
    }

    @Test
    public void test_theElementPeekedIsTheOneToExtract() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMinHeap heap = IntMinHeap.from(numbers);

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
        IntMinHeap heap = IntMinHeap.from(numbers);

        // when
        Assert.assertThat(heap.getCapacity(), is(equalTo(numbers.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(numbers.length)) );

        while(!heap.isEmpty()){
            heap.extract();
            AssertUtils.assertIsMinHeap(heap);
        }

        Assert.assertThat(heap.getSize(), is(equalTo(0)) );
    }

    @Test
    public void test_insertIncreasesTheSizeByOneEachTime() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMinHeap heap = IntMinHeap.from(numbers);

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
        IntMinHeap heap = IntMinHeap.newHeap();

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
        IntMinHeap heap = IntMinHeap.newHeap();

        // when
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        // then
        Random random = new Random();
        for(int i=0;i<100;i++){
            heap.insert(random.nextInt());
            AssertUtils.assertIsMinHeap(heap);
        }
    }

    @Test
    public void test_insertAddsTheElement() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMinHeap heap = IntMinHeap.from(numbers);

        // when
        int[] elementsBefore = (int[]) ReflectionUtils.getFieldValueOf(heap, IntMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        int toInsert = 30;
        Assert.assertThat(Arrays.stream(elementsBefore).anyMatch(e -> e == toInsert), is(equalTo(false)));

        heap.insert(30);
        int[] elementsAfter = (int[]) ReflectionUtils.getFieldValueOf(heap, IntMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);

        // then
        Assert.assertThat(Arrays.stream(elementsAfter).anyMatch(e -> e == toInsert), is(equalTo(true)));
    }

    @Test
    public void test_parentElementIsSmallerThanTheChildElements() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        int[] numbers = new int[]{1, 14, 8, 10, 6, 9, 21, 16, 12, 3, 0};
        IntMinHeap heap = IntMinHeap.from(numbers);
        int[] elements = (int[]) ReflectionUtils.getFieldValueOf(heap, IntMinHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);

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
                Assert.assertThat(elements[parentIndex], is(lessThanOrEqualTo(elements[leftIndex])));
            }
            if(rightIndex != -1) {
                Assert.assertThat(elements[parentIndex], is(lessThanOrEqualTo(elements[rightIndex])));
            }

            parentIndex ++;
        }
    }
}
