package myHashMap;


public class MyHashMap {

    private int DEFAULT_BUCKET_COUNT = 10;
    private int size = 0;
    private Entry[] buckets;

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


    public MyHashMap() {
        buckets = new Entry[DEFAULT_BUCKET_COUNT];
    }

    public MyHashMap(int capacity) {
        buckets = new Entry[capacity];
    }

    public long get(int key) {

        Entry entry = buckets[bucketIndexForKey(key)];
        while (entry != null && key != entry.getKey())
            entry = entry.getNext();
        return entry != null ? entry.getValue() : null;
    }

    public void put(int key, long value) {

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

            buckets[bucketIndex] = new Entry(key, value);
            size++;
        }
    }

    public int size()
    {
        return size;
    }

    public int bucketIndexForKey(int key) {

        int bucketIndex = key % buckets.length;
        return bucketIndex;
    }

}
