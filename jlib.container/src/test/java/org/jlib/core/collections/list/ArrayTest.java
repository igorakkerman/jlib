package org.jlib.collections.sequence;

import org.jlib.container.sequence.array.ArraySequence;

/**
 * JUnit test for {@link ArraySequence} class.
 * 
 * @author Igor Akkerman
 */
public class ArrayTest {

    /**
     * Asserts that an {@link ArraySequence} created by
     * {@link ArraySequence#createIntegerArray(Integer...)} with no arguments is empty.
     */
    @Test
    public final void createIntegerArrayIsEmpty() {
        Sequence<Integer> sequence = ArraySequence.createIntegerArray();
        // TODO: replace with self written Empty matcher
        assertTrue(sequence.isEmpty());
    }
}
