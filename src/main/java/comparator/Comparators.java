package comparator;

public final class Comparators {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", Comparators.class);
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
