package tests;

import newHashMap.MyHashMap;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * Created by dima on 18.09.16.
 */
public class MyHashMapTest
{

        @Test
        public void readWriteSimpleValue() {
            MyHashMap map = new MyHashMap();
            map.put(1, (long) 10);
            map.put(2, (long) 20);
            map.put(1, (long) 0);

            assertEquals(0, map.get(1));
            assertEquals(20, map.get(2));
        }

        @Test
        public void overWriteValue() {
            MyHashMap map = new MyHashMap();
            map.put(42, (long) 212314123);
            assertEquals(212314123, map.get(42));
            map.put(42, (long) 0);
            assertEquals(0, map.get(42));
        }

        @Test
        public void checkSize() {
            MyHashMap map = new MyHashMap();
            map.put(13, (long) 324121230);
            assertEquals(1, map.size());
            map.put(13, (long) 2312);
            assertEquals(1, map.size());
        }

        @Test
        public void checkingMaxSize() {
            MyHashMap map = new MyHashMap();
            map.put(1, (long) 1);
            map.put(2, (long) 2);
            map.put(3, (long) 3);
            map.put(4, (long) 4);
            map.put(5, (long) 5);
            map.put(6, (long) 6);
            map.put(7, (long) 7);
            map.put(8, (long) 8);
            map.put(9, (long) 9);
            map.put(10, (long) 10);

            assertEquals(10, map.size());

            map.put(11, (long) 2);
            System.out.println(map.size());
        }

}
