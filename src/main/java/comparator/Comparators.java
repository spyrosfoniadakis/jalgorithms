/*
 * Copyright 2019 Spyridon Foniadakis
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
 *
 */
package comparator;

public final class Comparators {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", Comparators.class.getCanonicalName());
    private Comparators(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    public static final IntComparator INT_ASCENDING_COMPARATOR = (a, b) -> a > b ? 1 : a < b ? -1 : 0;
    public static final IntComparator INT_DESCENDING_COMPARATOR = (a, b) -> a > b ? -1 : a < b ? 1 : 0;

    public static final LongComparator LONG_ASCENDING_COMPARATOR = (a, b) -> a > b ? 1 : a < b ? -1 : 0;
    public static final LongComparator LONG_DESCENDING_COMPARATOR = (a, b) -> a > b ? -1 : a < b ? 1 : 0;

    public static final FloatComparator FLOAT_ASCENDING_COMPARATOR = (a, b) -> a > b ? 1 : a < b ? -1 : 0;
    public static final FloatComparator FLOAT_DESCENDING_COMPARATOR = (a, b) -> a > b ? -1 : a < b ? 1 : 0;

    public static final DoubleComparator DOUBLE_ASCENDING_COMPARATOR = (a, b) -> a > b ? 1 : a < b ? -1 : 0;
    public static final DoubleComparator DOUBLE_DESCENDING_COMPARATOR = (a, b) -> a > b ? -1 : a < b ? 1 : 0;

}
