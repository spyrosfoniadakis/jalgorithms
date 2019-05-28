package ds;

import KeyedElement.DoubleKeyedElement;
import KeyedElement.FloatKeyedElement;
import KeyedElement.IntKeyedElement;
import KeyedElement.LongKeyedElement;

public final class Heaps {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", Heaps.class.getSimpleName());

    private Heaps(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    // int heaps
    // int max heaps
    public static final IntMaxHeap newIntMaxHeap(){
        return IntMaxHeap.newHeap();
    }

    public static final IntMaxHeap newIntMaxHeapWith(final int capacity){
        return IntMaxHeap.newHeap(capacity);
    }

    public static final IntMaxHeap newIntMaxHeapFrom(final int[] elements){
        return IntMaxHeap.from(elements);
    }

    public static final IntMaxHeap newIntMaxHeapFrom(final int[] elements, final int size){
        return IntMaxHeap.from(elements, size);
    }

    // int min heaps
    public static final IntMinHeap newIntMinHeap(){
        return IntMinHeap.newHeap();
    }

    public static final IntMinHeap newIntMinHeapWith(final int capacity){
        return IntMinHeap.newHeap(capacity);
    }

    public static final IntMinHeap newIntMinHeapFrom(final int[] elements){
        return IntMinHeap.from(elements);
    }

    public static final IntMinHeap newIntMinHeapFrom(final int[] elements, final int size){
        return IntMinHeap.from(elements, size);
    }

    // long heaps
    // long max heaps
    public static final LongMaxHeap newLongMaxHeap(){
        return LongMaxHeap.newHeap();
    }

    public static final LongMaxHeap newLongMaxHeapWith(final int capacity){
        return LongMaxHeap.newHeap(capacity);
    }

    public static final LongMaxHeap newIntMaxHeapFrom(final long[] elements){
        return LongMaxHeap.from(elements);
    }

    public static final LongMaxHeap newIntMaxHeapFrom(final long[] elements, final int size){
        return LongMaxHeap.from(elements, size);
    }

    // long min heaps
    public static final LongMinHeap newLongMinHeap(){
        return LongMinHeap.newHeap();
    }

    public static final LongMinHeap newLongMinHeapWith(final int capacity){
        return LongMinHeap.newHeap(capacity);
    }

    public static final LongMinHeap newLongMinHeapFrom(final long[] elements){
        return LongMinHeap.from(elements);
    }

    public static final LongMinHeap newLongMinHeapFrom(final long[] elements, final int size){
        return LongMinHeap.from(elements, size);
    }

    // float heaps
    // float max heaps
    public static final FloatMaxHeap newFloatMaxHeap(){
        return FloatMaxHeap.newHeap();
    }

    public static final FloatMaxHeap newFloatMaxHeapWith(final int capacity){
        return FloatMaxHeap.newHeap(capacity);
    }

    public static final FloatMaxHeap newFloatMaxHeapFrom(final float[] elements){
        return FloatMaxHeap.from(elements);
    }

    public static final FloatMaxHeap newFloatMaxHeapFrom(final float[] elements, final int size){
        return FloatMaxHeap.from(elements, size);
    }

    // float min heaps
    public static final FloatMinHeap newFloatMinHeap(){
        return FloatMinHeap.newHeap();
    }

    public static final FloatMinHeap newFloatMinHeapWith(final int capacity){
        return FloatMinHeap.newHeap(capacity);
    }

    public static final FloatMinHeap newFloatMinHeapFrom(final float[] elements){
        return FloatMinHeap.from(elements);
    }

    public static final FloatMinHeap newFloatMinHeapFrom(final float[] elements, final int size){
        return FloatMinHeap.from(elements, size);
    }

    // double heaps
    // double max heaps
    public static final DoubleMaxHeap newDoubleMaxHeap(){
        return DoubleMaxHeap.newHeap();
    }

    public static final DoubleMaxHeap newDoubleMaxHeapWith(final int capacity){
        return DoubleMaxHeap.newHeap(capacity);
    }

    public static final DoubleMaxHeap newDoubleMaxHeapFrom(final double[] elements){
        return DoubleMaxHeap.from(elements);
    }

    public static final DoubleMaxHeap newDoubleMaxHeapFrom(final double[] elements, final int size){
        return DoubleMaxHeap.from(elements, size);
    }

    // double min heaps
    public static final DoubleMinHeap newDoubleMinHeap(){
        return DoubleMinHeap.newHeap();
    }

    public static final DoubleMinHeap newDoubleMinHeapWith(final int capacity){
        return DoubleMinHeap.newHeap(capacity);
    }

    public static final DoubleMinHeap newDoubleMinHeapFrom(final double[] elements){
        return DoubleMinHeap.from(elements);
    }

    public static final DoubleMinHeap newDoubleMinHeapFrom(final double[] elements, final int size){
        return DoubleMinHeap.from(elements, size);
    }

    // int keyed heaps
    // int keyed max heaps
    public static final <T> IntKeyedMaxHeap<T> newIntKeyedMaxHeap(){
        return IntKeyedMaxHeap.<T>newHeap();
    }

    public static final <T> IntKeyedMaxHeap newIntKeyedMaxHeapWith(final int capacity){
        return IntKeyedMaxHeap.<T>newHeap(capacity);
    }

    public static final <T> IntKeyedMaxHeap newIntKeyedMaxHeapFrom(final IntKeyedElement<T>[] elements){
        return IntKeyedMaxHeap.<T>from(elements);
    }

    public static final <T> IntKeyedMaxHeap newIntKeyedMaxHeapFrom(final IntKeyedElement<T>[] elements, final int size){
        return IntKeyedMaxHeap.<T>from(elements, size);
    }

    // int keyed min heaps
    public static final <T> IntKeyedMinHeap<T> newIntKeyedMinHeap(){
        return IntKeyedMinHeap.<T>newHeap();
    }

    public static final <T> IntKeyedMinHeap newIntKeyedMinHeapWith(final int capacity){
        return IntKeyedMinHeap.<T>newHeap(capacity);
    }

    public static final <T> IntKeyedMinHeap newIntKeyedMinHeapFrom(final IntKeyedElement<T>[] elements){
        return IntKeyedMinHeap.<T>from(elements);
    }

    public static final <T> IntKeyedMinHeap newIntKeyedMinHeapFrom(final IntKeyedElement<T>[] elements, final int size){
        return IntKeyedMinHeap.<T>from(elements, size);
    }

    // long keyed heaps
    // long keyed max heaps
    public static final <T> LongKeyedMaxHeap<T> newLongKeyedMaxHeap(){
        return LongKeyedMaxHeap.<T>newHeap();
    }

    public static final <T> LongKeyedMaxHeap newLongKeyedMaxHeapWith(final int capacity){
        return LongKeyedMaxHeap.<T>newHeap(capacity);
    }

    public static final <T> LongKeyedMaxHeap newLongKeyedMaxHeapFrom(final LongKeyedElement<T>[] elements){
        return LongKeyedMaxHeap.<T>from(elements);
    }

    public static final <T> LongKeyedMaxHeap newLongKeyedMaxHeapFrom(final LongKeyedElement<T>[] elements, final int size){
        return LongKeyedMaxHeap.<T>from(elements, size);
    }

    // long keyed min heaps
    public static final <T> LongKeyedMinHeap<T> newLongKeyedMinHeap(){
        return LongKeyedMinHeap.<T>newHeap();
    }

    public static final <T> LongKeyedMinHeap newLongKeyedMinHeapWith(final int capacity){
        return LongKeyedMinHeap.<T>newHeap(capacity);
    }

    public static final <T> LongKeyedMinHeap newLongKeyedMinHeapFrom(final LongKeyedElement<T>[] elements){
        return LongKeyedMinHeap.<T>from(elements);
    }

    public static final <T> LongKeyedMinHeap newIntKeyedMinHeapFrom(final LongKeyedElement<T>[] elements, final int size){
        return LongKeyedMinHeap.<T>from(elements, size);
    }

    // float keyed heaps
    // float keyed max heaps
    public static final <T> FloatKeyedMaxHeap<T> newFloatKeyedMaxHeap(){
        return FloatKeyedMaxHeap.<T>newHeap();
    }

    public static final <T> FloatKeyedMaxHeap newFloatKeyedMaxHeapWith(final int capacity){
        return FloatKeyedMaxHeap.<T>newHeap(capacity);
    }

    public static final <T> FloatKeyedMaxHeap newFloatKeyedMaxHeapFrom(final FloatKeyedElement<T>[] elements){
        return FloatKeyedMaxHeap.<T>from(elements);
    }

    public static final <T> FloatKeyedMaxHeap newFloatKeyedMaxHeapFrom(final FloatKeyedElement<T>[] elements, final int size){
        return FloatKeyedMaxHeap.<T>from(elements, size);
    }

    // float keyed min heaps
    public static final <T> FloatKeyedMinHeap<T> newFloatKeyedMinHeap(){
        return FloatKeyedMinHeap.<T>newHeap();
    }

    public static final <T> FloatKeyedMinHeap newFloatKeyedMinHeapWith(final int capacity){
        return FloatKeyedMinHeap.<T>newHeap(capacity);
    }

    public static final <T> FloatKeyedMinHeap newFloatKeyedMinHeapFrom(final FloatKeyedElement<T>[] elements){
        return FloatKeyedMinHeap.<T>from(elements);
    }

    public static final <T> FloatKeyedMinHeap newIntKeyedMinHeapFrom(final FloatKeyedElement<T>[] elements, final int size){
        return FloatKeyedMinHeap.<T>from(elements, size);
    }

    // double keyed heaps
    // double keyed max heaps
    public static final <T> DoubleKeyedMaxHeap<T> newDoubleKeyedMaxHeap(){
        return DoubleKeyedMaxHeap.<T>newHeap();
    }

    public static final <T> DoubleKeyedMaxHeap newDoubleKeyedMaxHeapWith(final int capacity){
        return DoubleKeyedMaxHeap.<T>newHeap(capacity);
    }

    public static final <T> DoubleKeyedMaxHeap newDoubleKeyedMaxHeapFrom(final DoubleKeyedElement<T>[] elements){
        return DoubleKeyedMaxHeap.<T>from(elements);
    }

    public static final <T> DoubleKeyedMaxHeap newDoubleKeyedMaxHeapFrom(final DoubleKeyedElement<T>[] elements, final int size){
        return DoubleKeyedMaxHeap.<T>from(elements, size);
    }

    // double keyed min heaps
    public static final <T> DoubleKeyedMinHeap<T> newDoubleKeyedMinHeap(){
        return DoubleKeyedMinHeap.<T>newHeap();
    }

    public static final <T> DoubleKeyedMinHeap newDoubleKeyedMinHeapWith(final int capacity){
        return DoubleKeyedMinHeap.<T>newHeap(capacity);
    }

    public static final <T> DoubleKeyedMinHeap newDoubleKeyedMinHeapFrom(final DoubleKeyedElement<T>[] elements){
        return DoubleKeyedMinHeap.<T>from(elements);
    }

    public static final <T> DoubleKeyedMinHeap newIntKeyedMinHeapFrom(final DoubleKeyedElement<T>[] elements, final int size){
        return DoubleKeyedMinHeap.<T>from(elements, size);
    }
}
