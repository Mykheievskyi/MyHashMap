package myHashMap;


public class MyHashMap {

    private int DEFAULT_BUCKET_COUNT = 10;
    private int size = 0;

    private Entry[] buckets;

    public MyHashMap() {
        buckets = new Entry[DEFAULT_BUCKET_COUNT];
    }

    public MyHashMap(int capacity) {
        buckets = new Entry[capacity];
    }

    public long get(int key) {
        throwIfKeyNull(key);
        Entry entry = buckets[bucketIndexForKey(key)];
        while (entry != null && key != entry.getKey())
            entry = entry.getNext();
        return entry != null ? entry.getValue() : null;
    }

    public void put(int key, long value) {
        throwIfKeyNull(key);

        int bucketIndex = bucketIndexForKey(key);
        Entry entry = buckets[bucketIndex];

        if (null != entry) {
            boolean done = false;
            while (!done) {
                if (key == entry.getKey()) {
                    entry.setValue(value);
                    done = true;
                } else if (entry.getNext() == null) {
                    entry.setNext(new Entry(key, value));
                    done = true;
                }
                entry = entry.getNext();
            }
        } else {
            // nothing there at all; just shove the new entry in
            buckets[bucketIndex] = new Entry(key, value);
            size++;
        }
    }

    public int size()
    {
        return size;
    }

    public int bucketIndexForKey(int key) {
        //We consider the value of the key hashCode
        int bucketIndex = key % buckets.length;
        return bucketIndex;
    }

    private void throwIfKeyNull(int key) {
        if (key == 0) {
            throw new IllegalArgumentException("key may not be null");
        }
    }
}
