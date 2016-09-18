package myHashMap;


public class MyHashMap {

    private final static int TABLE_SIZE = 10;
    private int size = 0;

    HashEntry[] table;

    public class HashEntry {
        private int key;
        private long value;

        HashEntry(int key, long value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public long getValue() {
            return value;
        }
    }

    public MyHashMap() {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public long get(int key) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        if (table[hash] == null)
            return -1;
        else
            return table[hash].getValue();
    }

    public void put(int key, long value) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }
        if (table[hash] == null)
        {
            size++;
        }
        table[hash] = new HashEntry(key, value);
    }

    public int size()
    {
        return size;
    }
}
