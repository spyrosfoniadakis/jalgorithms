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
package sorting;

import comparator.Comparators;
import comparator.DoubleComparator;
import comparator.FloatComparator;
import comparator.IntComparator;
import comparator.LongComparator;

/**
 * @author Spyros Foniadakis
 */
public enum SortingDirection {
    ASCENDING{
        @Override
        public SortingDirection getOpposite() {
            return DESCENDING;
        }

        @Override
        public IntComparator getIntComparator() {
            return Comparators.INT_ASCENDING_COMPARATOR;
        }

        @Override
        public LongComparator getLongComparator() {
            return Comparators.LONG_ASCENDING_COMPARATOR;
        }

        @Override
        public FloatComparator getFloatComparator() {
            return Comparators.FLOAT_ASCENDING_COMPARATOR;
        }

        @Override
        public DoubleComparator getDoubleComparator() {
            return Comparators.DOUBLE_ASCENDING_COMPARATOR;
        }
    },
    DESCENDING{
        @Override
        public SortingDirection getOpposite() {
            return ASCENDING;
        }

        @Override
        public IntComparator getIntComparator() {
            return Comparators.INT_DESCENDING_COMPARATOR;
        }

        @Override
        public LongComparator getLongComparator() {
            return Comparators.LONG_DESCENDING_COMPARATOR;
        }

        @Override
        public FloatComparator getFloatComparator() {
            return Comparators.FLOAT_DESCENDING_COMPARATOR;
        }

        @Override
        public DoubleComparator getDoubleComparator() {
            return Comparators.DOUBLE_DESCENDING_COMPARATOR;
        }
    };

    public abstract SortingDirection getOpposite();
    public abstract IntComparator getIntComparator();
    public abstract LongComparator getLongComparator();
    public abstract FloatComparator getFloatComparator();
    public abstract DoubleComparator getDoubleComparator();
}
