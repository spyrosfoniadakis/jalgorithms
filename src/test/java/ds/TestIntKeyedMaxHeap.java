package ds;

import keyedElement.IntKeyedElement;
import misc.Person;
import misc.PersonUtils;
import org.junit.Assert;
import org.junit.Test;
import utils.AssertUtils;
import utils.DateUtils;
import utils.ReflectionUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestIntKeyedMaxHeap {

    public static final String HEAP_ELEMENTS_FIELD_NAME = "elements";

    @Test
    public void test_defaultFactoryMethod_createsAnArrayOfTenForZeroSizeHeap() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        IntKeyedMaxHeap heap = IntKeyedMaxHeap.newHeap();

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(10)) );
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        Object value = ReflectionUtils.getFieldValueOf(heap, IntKeyedMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        IntKeyedElement[] elements = (IntKeyedElement[]) value;

        for(IntKeyedElement element : elements){
            Assert.assertThat(element, is(equalTo(null)));
        }
    }

    @Test
    public void test_factoryMethodWithInitialCapacity_createsAnArrayWithZeroSizeHeap() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        IntKeyedMaxHeap<String> heap = IntKeyedMaxHeap.newHeap(20);

        // when

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(20)) );
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        Object value = ReflectionUtils.getFieldValueOf(heap, IntKeyedMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        IntKeyedElement[] elements = (IntKeyedElement[]) value;

        for(IntKeyedElement element : elements){
            Assert.assertThat(element, is(equalTo(null)));
        }
    }

    @Test
    public void test_factoryMethodWithArray_createsAHeapWithTheSameElements() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // given
        Person[] people = PersonUtils.getPeople();
        IntKeyedElement<Person>[] elements = PersonUtils.createIntKeyedElementsArrayFrom(people);

        // when
        IntKeyedMaxHeap<Person> heap = IntKeyedMaxHeap.from(elements);


        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(people.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(people.length)) );

        IntKeyedElement<Person>[] data = (IntKeyedElement<Person>[]) ReflectionUtils.getFieldValueOf(heap, IntKeyedMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        AssertUtils.assertIsMaxHeap(heap);

        AssertUtils.areIdentical(elements, data);
        System.out.println(String.format("After asserting on the contents: %s", Arrays.toString(elements)));
    }

    @Test
    public void test_extractReducesTheSizeBYOneEachTime() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        Person[] people = PersonUtils.getPeople();
        IntKeyedElement<Person>[] elements = PersonUtils.createIntKeyedElementsArrayFrom(people);

        // when
        IntKeyedMaxHeap<Person> heap = IntKeyedMaxHeap.from(elements);

        // when
        Assert.assertThat(heap.getCapacity(), is(equalTo(elements.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(elements.length)) );

        // then
        int sizeBefore = heap.getSize();
        heap.extract();
        int sizeAfter = heap.getSize();

        Assert.assertThat(sizeBefore, is(equalTo(sizeAfter + 1)));
    }

    @Test
    public void test_extractRemovesTheElement() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        Person[] people = PersonUtils.getPeople();
        IntKeyedElement<Person>[] elements = PersonUtils.createIntKeyedElementsArrayFrom(people);

        // when
        IntKeyedMaxHeap<Person> heap = IntKeyedMaxHeap.from(elements);

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(elements.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(elements.length)) );

        IntKeyedElement<Person>[] elementsBefore = (IntKeyedElement<Person>[]) ReflectionUtils.getFieldValueOf(heap, IntKeyedMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        IntKeyedElement<Person> peeked = heap.peek();
        Assert.assertThat(Arrays.stream(elementsBefore).anyMatch(e -> e.equals(peeked)), is(equalTo(true)));

        IntKeyedElement<Person> extracted = heap.extract();
        IntKeyedElement<Person>[] elementsAfter = (IntKeyedElement<Person>[]) ReflectionUtils.getFieldValueOf(heap, IntKeyedMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        Assert.assertThat(Arrays.stream(elementsAfter).anyMatch(e -> Objects.nonNull(e) && e.equals(peeked)), is(equalTo(false)));
    }

    @Test
    public void test_theElementPeekedIsTheOneToExtract() {
        // given
        Person[] people = PersonUtils.getPeople();
        IntKeyedElement<Person>[] elements = PersonUtils.createIntKeyedElementsArrayFrom(people);

        // when
        IntKeyedMaxHeap<Person> heap = IntKeyedMaxHeap.from(elements);

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(elements.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(elements.length)) );

        IntKeyedElement<Person> peeked = heap.peek();
        IntKeyedElement<Person> extracted = heap.extract();
        Assert.assertThat(peeked, is(equalTo(extracted)));
    }

    @Test
    public void test_afterSubsequentExtractionTheHeapRemainsValid() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        Person[] people = PersonUtils.getPeople();
        IntKeyedElement<Person>[] elements = PersonUtils.createIntKeyedElementsArrayFrom(people);

        // when
        IntKeyedMaxHeap<Person> heap = IntKeyedMaxHeap.from(elements);

        // then
        Assert.assertThat(heap.getCapacity(), is(equalTo(elements.length)) );
        Assert.assertThat(heap.getSize(), is(equalTo(elements.length)) );

        while(!heap.isEmpty()){
            heap.extract();
            AssertUtils.assertIsMaxHeap(heap);
        }

        Assert.assertThat(heap.getSize(), is(equalTo(0)) );
    }

    @Test
    public void test_insertIncreasesTheSizeByOneEachTime() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        Person[] people = PersonUtils.getPeople();
        IntKeyedElement<Person>[] elements = PersonUtils.createIntKeyedElementsArrayFrom(people);
        Person p = Person.from("David", "Davidson", DateUtils.getDateFrom(1980, 7, 19));

        // when
        IntKeyedMaxHeap<Person> heap = IntKeyedMaxHeap.from(elements);

        // then
        int sizeBefore = heap.getSize();
        heap.insert(p, p.getAgeInMonths());
        int sizeAfter = heap.getSize();

        Assert.assertThat(sizeBefore, is(equalTo(sizeAfter - 1)));
    }

    @Test
    public void test_subsequentInsertionsIncreasesTheSizeByOneEachTime() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        IntKeyedMaxHeap<Person> heap = IntKeyedMaxHeap.newHeap();

        // when
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        // then
        Random random = new Random();
        for(int i=0;i<100;i++){
            int sizeBefore = heap.getSize();
            Person p = Person.from("David", "Davidson", DateUtils.getDateFrom(1900 + random.nextInt(100), random.nextInt(12), random.nextInt(28)));
            heap.insert(p, p.getAgeInMonths());
            int sizeAfter = heap.getSize();

            Assert.assertThat(sizeBefore, is(equalTo(sizeAfter - 1)));
        }
    }

    @Test
    public void test_afterSubsequentInsertionsTheHeapRemainsValid() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        IntKeyedMaxHeap<Person> heap = IntKeyedMaxHeap.newHeap();


        // when
        Assert.assertThat(heap.getSize(), is(equalTo(0)) );

        // then
        Random random = new Random();
        for(int i=0;i<100;i++){
            Person p = Person.from("David", "Davidson", DateUtils.getDateFrom(1900 + random.nextInt(100), random.nextInt(12), random.nextInt(28)));
            heap.insert(p, p.getAgeInMonths());
            AssertUtils.assertIsMaxHeap(heap);
        }
    }

    @Test
    public void test_insertAddsTheElement() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        Person[] people = PersonUtils.getPeople();
        IntKeyedElement<Person>[] elements = PersonUtils.createIntKeyedElementsArrayFrom(people);
        IntKeyedMaxHeap<Person> heap = IntKeyedMaxHeap.from(elements);


        // when
        IntKeyedElement<Person>[] elementsBefore = ( IntKeyedElement<Person>[]) ReflectionUtils.getFieldValueOf(heap, IntKeyedMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);
        Person toInsert = Person.from("David", "Davidson", DateUtils.getDateFrom(1980, 7, 19));;
        Assert.assertThat(Arrays.stream(elementsBefore).anyMatch(e -> e.equals(toInsert)), is(equalTo(false)));

        heap.insert(toInsert, toInsert.getAgeInMonths());
        IntKeyedElement<Person> inserted = IntKeyedElement.from(toInsert.getAgeInMonths(), toInsert);
        IntKeyedElement<Person>[] elementsAfter = ( IntKeyedElement<Person>[]) ReflectionUtils.getFieldValueOf(heap, IntKeyedMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);

        // then
        // TODO: Put limit to all such tests.
        Assert.assertThat(Arrays.stream(elementsAfter).limit(heap.size).anyMatch(e -> e.equals(inserted)), is(equalTo(true)));
    }

    @Test
    public void test_parentElementIsLargerThanTheChildElements() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // given
        // given
        Person[] people = PersonUtils.getPeople();
        IntKeyedElement<Person>[] inputElements = PersonUtils.createIntKeyedElementsArrayFrom(people);
        IntKeyedMaxHeap<Person> heap = IntKeyedMaxHeap.from(inputElements);
        IntKeyedElement<Person>[] elements = ( IntKeyedElement<Person>[]) ReflectionUtils.getFieldValueOf(heap, IntKeyedMaxHeap.class.getCanonicalName(), HEAP_ELEMENTS_FIELD_NAME);

        int parentIndex = 0;
        while(true){
            int leftIndex = heap.getLeftChildIndexOf(parentIndex);
            int rightIndex = heap.getRightChildIndexOf(parentIndex);
            System.out.println(String.format("candidate parent: {index: %d, value: %s}, left: {index: %d, value: %s}, right:{index: %d, value: %s}",
                    parentIndex, elements[parentIndex], leftIndex, (leftIndex != -1) ? elements[leftIndex] : "n/a", rightIndex, (rightIndex != -1) ? elements[rightIndex] : "n/a"));

            if(leftIndex == -1 && rightIndex == -1) {
                break;
            }
            if(leftIndex != -1) {
                Assert.assertThat(elements[parentIndex].getKey(), is(greaterThanOrEqualTo(elements[leftIndex].getKey())));
            }
            if(rightIndex != -1) {
                Assert.assertThat(elements[parentIndex].getKey(), is(greaterThanOrEqualTo(elements[rightIndex].getKey())));
            }

            parentIndex ++;
        }
    }

}
