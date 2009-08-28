package net.transformatorhuis.junit.examples;

import java.sql.Date;
import java.util.HashMap;
import org.junit.Test;

/**
 *
 * @author cyberroadie
 */
public class GenericsUpperBound {

    @Test
    public void testGeneric() {
        // java.sql.Date extends java.util.Date 
        UpperBoundMap<java.sql.Date, String> map = new UpperBoundMap<Date, String>();
    }


    public class UpperBoundMap<K extends java.util.Date, V> {

        private HashMap<K, V> map;

        private UpperBoundMap() {

        }

        public void put(K key, V value) {
            map.put(key, value);
        }

        public V get(K key) {
            return map.get(key);
        }
    }

}
