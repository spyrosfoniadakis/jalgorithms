package comparator;

@FunctionalInterface
public interface FloatComparator {
    int compare(float a, float b);

    default boolean shouldSwap(float a, float b){
        return this.compare(a, b) > 0;
    }
}