package comparator;

@FunctionalInterface
public interface DoubleComparator {

    int compare(double a, double b);

    default boolean shouldSwap(double a, double b){
        return this.compare(a, b) > 0;
    }
}