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
package keyedElement;

import evaluator.LongEvaluator;

/**
 * @author Spyros Foniadakis
 */
public final class LongKeyedElement<T> implements Comparable<LongKeyedElement<T>>{

    private long key;
    private T value;

    public LongKeyedElement(final long key, final T value) {
        this.key = key;
        this.value = value;
    }

    public LongKeyedElement(final LongEvaluator<T> keyEvaluator, final T value){
        this(keyEvaluator.evaluate(), value);
    }

    public static <T> LongKeyedElement<T> from(final long key, final T value) {
        return new LongKeyedElement<>(key, value);
    }

    public static <T> LongKeyedElement<T> from(final LongEvaluator<T> keyEvaluator, final T value) {
        return new LongKeyedElement<>(keyEvaluator, value);
    }

    public static <T extends LongEvaluator<T>> LongKeyedElement<T> from(final T value) {
        return new LongKeyedElement<>(value.evaluate(), value);
    }

    public long getKey() {
        return key;
    }

    public void setKey(final long key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public void increaseKeyBy(final long offset) {
        this.key += offset;
    }

    @Override
    public int compareTo(final LongKeyedElement<T> o) {
        return Long.compare(this.key, o.key);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LongKeyedElement)) return false;
        LongKeyedElement<?> that = (LongKeyedElement<?>) o;
        return key == that.key &&
                value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int value = 17;
        value += this.key * 19;
        value += this.value.hashCode() * 19;
        return value;
    }
}
