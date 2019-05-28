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
package KeyedElement;

/**
 * @author Spyros Foniadakis
 */
public final class DoubleKeyedElement<T> implements Comparable<DoubleKeyedElement<T>>{

    private double key;
    private T value;

    public DoubleKeyedElement(final double key, final T value) {
        this.key = key;
        this.value = value;
    }

    public static <T> DoubleKeyedElement<T> from(final double key, final T value) {
        return new DoubleKeyedElement<>(key, value);
    }

    public double getKey() {
        return key;
    }

    public void setKey(final double key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public void increaseKeyBy(final double offset) {
        this.key += offset;
    }

    @Override
    public int compareTo(final DoubleKeyedElement<T> o) {
        return Double.compare(this.key, o.key);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof DoubleKeyedElement)) return false;
        DoubleKeyedElement<?> that = (DoubleKeyedElement<?>) o;
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
