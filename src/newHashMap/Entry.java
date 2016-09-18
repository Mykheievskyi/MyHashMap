package newHashMap;

/**
 * Created by dima on 18.09.16.
 */
public class Entry<V, K> {

    private Entry<V, K> next;
    private final K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.setValue(value);
    }

    public K getKey() {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setNext(Entry<V, K> next) {
        this.next = next;
    }

    public Entry<V, K> getNext() {
        return next;
    }
}
