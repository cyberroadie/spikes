package net.transformatorhuis.junit.examples;

import java.util.Date;
import java.util.HashMap;
import org.junit.Test;

/**
 *
 * @author cyberroadie
 */
public class GenericsWildcard {

    @Test
    public void testGeneric() {
        // java.sql.Date extends java.util.Date
        UpperBoundMap<Date, String> map = new UpperBoundMap<Date, String>();
    }


    public class UpperBoundMap<K extends java.util.Date, V> {

        private HashMap<? extends java.util.Date, V> map;

        private UpperBoundMap() {

        }

        // This is not possible because key is of an unknown type
//        public void put(K key, V value) {
//            map.put(key, value);
//        }

        public V get(K key) {
            return map.get(key);
        }
    }
}
