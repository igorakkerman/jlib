package org.jlib.container.sequence.index.array;

import org.jlib.container.sequence.Sequence;

/**
 * Full-featured {@link ArraySequence} providing the most of capabilities.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class CompleteArraySequence<Item>
extends ReplaceAppendRemoveTailArraySequence<Item> {

    /**
     * Creates a new {@link CompleteArraySequence}.
     * 
     * @param firstIndex
     *        first index of this {@link CompleteArraySequence}
     * 
     * @param lastIndex
     *        last index of this {@link CompleteArraySequence}
     */
    protected CompleteArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }
}
