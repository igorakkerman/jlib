/*
 * jlib - The Free Java Library
 *
 *    http://www.jlib.org
 *
 * Copyright (c) 2006-2008 Igor Akkerman
 *
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;

/**
 * Default implementation of a {@link ReplaceIndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link ReplaceIndexSequence}
 * 
 * @author Igor Akkerman
 */
public class DefaultReplaceAddInsertIndexSequenceTraverser<Item, Sequenze extends InsertAppendReplaceIndexSequence<Item>>
extends DefaultReplaceIndexSequenceTraverser<Item, Sequenze>
implements ReplaceInsertIndexSequenceTraverser<Item> {

    /**
     * Creates a new {@link DefaultReplaceAddInsertIndexSequenceTraverser} over
     * the Items of the specified {@link InsertAppendReplaceIndexSequence}
     * beginning at its first index.
     * 
     * @param sequence
     *        {@link InsertAppendReplaceIndexSequence} to traverse
     */
    public DefaultReplaceAddInsertIndexSequenceTraverser(final Sequenze sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link DefaultReplaceAddInsertIndexSequenceTraverser} over
     * the Items of the specified {@link InsertAppendReplaceIndexSequence}
     * beginning the traversal at the specified index.
     * 
     * @param sequence
     *        {@link InsertAppendReplaceIndexSequence} to traverse
     * 
     * @param initialNextItemIndex
     *        integer specifying the index of the initial next Item
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    public DefaultReplaceAddInsertIndexSequenceTraverser(final Sequenze sequence, final int initialNextItemIndex)
    throws SequenceIndexOutOfBoundsException {
        super(sequence, initialNextItemIndex);
    }

    @Override
    public void insert(final Item newItem) {
        getSequence().insert(getPotentialNextItemIndex(), newItem);
    }
}
