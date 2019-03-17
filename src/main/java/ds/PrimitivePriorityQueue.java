package ds;

// TODO: Consider deleting the file if the PrimitiveHeap interface becomes package-private

/**
 * It is an interface defined only for logical consistency and guidance. A priority queue implementation
 * is based on the Heap class and interface hierarchies, so this interface serves none significant purpose
 * other than for the users who would like to implement their own PrioritiyQueue implementation; it would
 * be confusing to extend directly from Heap-related classes or interfaces. So this interface and any
 * PriorityQueue-related interface or class serves as an alias for the Heap-related definition it inherits from.
 */
public interface PrimitivePriorityQueue extends PrimitiveHeap {

}
