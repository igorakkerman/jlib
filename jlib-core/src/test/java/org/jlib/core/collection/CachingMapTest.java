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
        hashMap.put("Münchenhausen", "Berlin");

        final Map<String, String> forwardingMap = new ForwardingMap<String, String>() {

            @Override
            protected Map<String, String> delegate() {
                return hashMap;
            }
        };

        final Map<String, String> cacheMap = new CachingMap<>(hashMap);

        for (int i = 0; i < 20; i++) {
            System.out.println("HashMap:       " + measure(hashMap));
            System.out.println("ForwardingMap: " + measure(forwardingMap));
            System.out.println("CacheMap:      " + measure(cacheMap));
            System.out.println();
        }
    }

    //    @Test
    public void performanceDirect() {

        final int MAX = 1000000;
        final String MUC = "Münchenhausen";

        final Map<String, String> map = new HashMap<>();
        map.put("ja", "nein");
        map.put("gut", "schlecht");
        map.put(MUC, "Berlin");

        for (int j = 0; j < 20; j++) {

            long start = System.nanoTime();

            for (int i = 0; i < MAX; i++)
                map.containsKey(MUC);

            long end = System.nanoTime();

            System.out.println(end - start);

            start = System.nanoTime();

            for (int i = 0; i < MAX; i++)
                map.get(MUC);

            end = System.nanoTime();

            System.out.println(end - start);
            System.out.println();
        }
    }

    @Test
    public void performanceCachedGetOnly() {

        final int MAX = 1000000;
        final String MUC = "Münchenhausen";

        final Map<String, String> map = new CachingMap<>(new HashMap<String, String>());
        map.put("ja", "nein");
        map.put("gut", "schlecht");
        final String BERLIN = "Berlin";
        map.put(MUC, BERLIN);

        map.containsKey(MUC);

        for (int j = 0; j < 20; j++) {

            System.gc();
            final long start = System.nanoTime();

            for (int i = 0; i < MAX; i++)
                if (map.get(MUC) != BERLIN)
                    System.out.println("x");

            final long end = System.nanoTime();

            System.out.println("" + (end - start) + " [" + end + " - " + start + "]");
        }
    }

    private long measure(final Map<String, String> map) {
        final int MAX = 1000000;
        final String MUC = "Münchenhausen";

        long start = System.nanoTime();

        for (int i = 0; i < MAX; i++) {
            System.gc();
            if (map.containsKey(MUC))
                map.get(MUC);
        }

        long end = System.nanoTime();

        return end - start;
    }
}
