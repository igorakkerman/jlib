package org.jlib.core.collection;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ForwardingMap;
import org.junit.Test;

public class CachingMapTest {

    @Test
    public void performance() {
        final Map<String, String> hashMap = new HashMap<>();
        hashMap.put("ja", "nein");
        hashMap.put("gut", "schlecht");
        hashMap.put("München", "Berlin");

        final Map<String, String> forwardingMap = new ForwardingMap<String, String>() {

            @Override
            protected Map<String, String> delegate() {
                return hashMap;
            }
        };

        final Map<String, String> cacheMap = new CachingMap<>(hashMap);

        for (int i = 0; i < 20; i++) {
            System.out.println("HashMap:       " + measure(hashMap));
            System.out.println("DelegatingMap: " + measure(forwardingMap));
            System.out.println("CacheMap:      " + measure(cacheMap));
        }
    }

    private long measure(final Map<String, String> map) {
        final int MAX = 100;
        final String MUC = "ja";

        long start = System.nanoTime();

        for (int i = 0; i < MAX; i++)
            if (map.containsKey(MUC))
                map.get(MUC);

        long end = System.nanoTime();

        return end - start;
    }
}
