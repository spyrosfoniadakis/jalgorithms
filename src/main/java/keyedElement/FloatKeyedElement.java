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

import evaluator.FloatEvaluator;

/**
 * @author Spyros Foniadakis
 */
public final class FloatKeyedElement<T> implements Comparable<FloatKeyedElement<T>>{

    private float key;
    private T value;

    public FloatKeyedElement(final float key, final T value) {
        this.key = key;
        this.value = value;
    }

    public FloatKeyedElement(final FloatEvaluator<T> keyEvaluator, final T value){
        this(keyEvaluator.evaluate(), value);
    }

    public static <T> FloatKeyedElement<T> from(final float key, final T value) {
        return new FloatKeyedElement<>(key, value);
    }

    public static <T> FloatKeyedElement<T> from(final FloatEvaluator<T> keyEvaluator, final T value) {
        return new FloatKeyedElement<>(keyEvaluator, value);
    }

    public static <T extends FloatEvaluator<T>> FloatKeyedElement<T> from(final T value) {
        return new FloatKeyedElement<>(value.evaluate(), value);
    }

    public float getKey() {
        return key;
    }

    public void setKey(final float key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public void increaseKeyBy(final float offset) {
        this.key += offset;
    }

    @Override
    public int compareTo(final FloatKeyedElement<T> o) {
        return Float.compare(this.key, o.key);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof FloatKeyedElement)) return false;
        FloatKeyedElement<?> that = (FloatKeyedElement<?>) o;
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
