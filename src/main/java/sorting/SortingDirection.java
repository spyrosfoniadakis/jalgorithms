package sorting;

import comparator.Comparators;
import comparator.DoubleComparator;
import comparator.FloatComparator;
import comparator.IntComparator;
import comparator.LongComparator;

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
