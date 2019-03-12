package ds;

public interface HeapElement<K extends Comparable<K>, V> {

    K getKey();
    V getValue();

}
