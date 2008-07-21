
package org.jlib.core.collections.list;

import static org.junit.Assert.*;

import org.junit.Test;


public class ArrayTest {

    @Test
    public final void testNewIntegerArrayEmpty() {
        List<Integer> list = Array.newIntegerArray();
        assertTrue(list.isEmpty());
    }

}
