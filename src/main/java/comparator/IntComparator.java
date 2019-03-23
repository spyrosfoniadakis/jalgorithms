package comparator;

@FunctionalInterface
public interface IntComparator {
    int compare(int a, int b);

    default boolean shouldSwap(int a, int b){
        return this.compare(a, b) > 0;
    }
}