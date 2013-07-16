package org.jlib.core.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ContainsKeyCacheMapTest {

    @Test
    public void performance(String... commandLineArguments) {
        final Map<String, String> hashMap = new HashMap<>();
        hashMap.put("ja", "nein");
        hashMap.put("gut", "schlecht");
        hashMap.put("München", "Berlin");

        final Map<String, String> delegateMap = new DelegateMap<>(hashMap);
        final Map<String, String> cacheMap = new ContainsKeyCacheMap<>(hashMap);

        for (int i = 0; i < 20; i++) {
            System.out.println("HashMap:     " + measure(hashMap));
            System.out.println("DelegateMap: " + measure(delegateMap));
            System.out.println("CacheMap:    " + measure(cacheMap));
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
