package comparator;

@FunctionalInterface
public interface LongComparator{
    int compare(long a, long b);

    default boolean shouldSwap(long a, long b){
        return this.compare(a, b) > 0;
    }
}