
package org.jlib.core.collections.list;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ArrayTest {

    @Test
    public final void testNewIntegerArrayEmpty() {
        List<Integer> list = Array.newIntegerArray();
        assertTrue(list.isEmpty());
    }

}
