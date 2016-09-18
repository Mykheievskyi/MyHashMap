package newHashMap;


public class Entry {

    private Entry next;
    private final int key;
    private long value;

    public Entry(int key, long value) {
        this.key = key;
        this.setValue(value);
    }

    public int getKey() {
        return key;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    public Entry getNext() {
        return next;
    }
}
