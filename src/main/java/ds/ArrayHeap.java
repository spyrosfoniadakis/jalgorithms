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

/**
 * @author Spyros Foniadakis
 */
public class ArrayHeap<T> extends AbstractIndexedHeap {

    @FunctionalInterface
    public interface ElementComparator<T extends ToIntEvaluator<T>>{
        int compare(T t1, T t2);
    }

    @FunctionalInterface
    public interface ToIntEvaluator<T>{
        int evaluate();
    }

    @FunctionalInterface
    public interface ToLongEvaluator<T>{
        long evaluate();
    }

    @FunctionalInterface
    public interface ToFloatEvaluator<T>{
        float evaluate();
    }

    @FunctionalInterface
    public interface ToDoubleEvaluator<T>{
        double evaluate();
    }



    private ArrayHeap(final ToIntEvaluator<T> evaluator){

    }
    private ArrayHeap(final ToDoubleEvaluator<T> evaluator){

    }
    private ArrayHeap(final ToLongEvaluator<T> evaluator){

    }
    private ArrayHeap(final ToFloatEvaluator<T> evaluator){

    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public void heapify() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
