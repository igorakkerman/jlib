package org.jlib.core.collections.list;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * JUnit test for {@link Array} class.
 * 
 * @author Igor Akkerman
 */
public class ArrayTest {

    /**
     * Asserts that an {@link Array} created by
     * {@link Array#newIntegerArray(Integer...)} with no arguments is empty.
     */
    @Test
    public final void newIntegerArrayIsEmpty() {
        List<Integer> list = Array.newIntegerArray();
        // TODO: replace with self written Empty matcher
        assertTrue(list.isEmpty());
    }
}
