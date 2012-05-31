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

import org.jlib.container.sequence.NoItemToRemoveException;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.reference.NoValueSetException;

/**
 * Default implementation of a {@link RemoveInsertReplaceIndexSequenceTraverser}
 * .
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link ReplaceIndexSequence}
 * 
 * @author Igor Akkerman
 */
public class DefaultRemoveInsertReplaceIndexSequenceTraverser<Item, Sequenze extends RemoveInsertReplaceIndexSequence<Item>>
extends DefaultInsertReplaceIndexSequenceTraverser<Item, Sequenze>
implements RemoveInsertReplaceIndexSequenceTraverser<Item> {

    /**
     * Creates a new {@link DefaultRemoveInsertReplaceIndexSequenceTraverser}
     * over the Items of the specified {@link InsertReplaceIndexSequence}
     * beginning at its first index.
     * 
     * @param sequence
     *        {@link InsertReplaceIndexSequence} to traverse
     */
    public DefaultRemoveInsertReplaceIndexSequenceTraverser(final Sequenze sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link DefaultRemoveInsertReplaceIndexSequenceTraverser}
     * over the Items of the specified {@link InsertReplaceIndexSequence}
     * beginning the traversal at the specified index.
     * 
     * @param sequence
     *        {@link InsertReplaceIndexSequence} to traverse
     * 
     * @param initialNextItemIndex
     *        integer specifying the index of the initial next Item
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    public DefaultRemoveInsertReplaceIndexSequenceTraverser(final Sequenze sequence, final int initialNextItemIndex)
    throws SequenceIndexOutOfBoundsException {
        super(sequence, initialNextItemIndex);
    }

    @Override
    public void remove()
    throws NoItemToRemoveException {
        try {
            getSequence().remove(getLastAccessedItemIndex());
        }
        catch (final NoValueSetException exception) {
            throw new NoItemToRemoveException(getSequence(), exception);
        }

    }
}
