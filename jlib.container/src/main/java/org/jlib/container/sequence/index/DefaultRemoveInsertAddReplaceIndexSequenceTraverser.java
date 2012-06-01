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

import org.jlib.container.sequence.NoSequenceItemToRemoveException;
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
public class DefaultRemoveInsertAddReplaceIndexSequenceTraverser<Item, Sequenze extends ReplaceAddInsertRemoveIndexSequence<Item>>
extends DefaultReplaceAddInsertIndexSequenceTraverser<Item, Sequenze>
implements RemoveInsertReplaceIndexSequenceTraverser<Item> {

    /**
     * Creates a new {@link DefaultRemoveInsertAddReplaceIndexSequenceTraverser}
     * over the Items of the specified
     * {@link ReplaceAddInsertRemoveIndexSequence} beginning at its first index.
     * 
     * @param sequence
     *        {@link ReplaceAddInsertRemoveIndexSequence} to traverse
     */
    public DefaultRemoveInsertAddReplaceIndexSequenceTraverser(final Sequenze sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link DefaultRemoveInsertAddReplaceIndexSequenceTraverser}
     * over the Items of the specified
     * {@link ReplaceAddInsertRemoveIndexSequence} beginning the traversal at
     * the specified index.
     * 
     * @param sequence
     *        {@link ReplaceAddInsertRemoveIndexSequence} to traverse
     * 
     * @param initialNextItemIndex
     *        integer specifying the index of the initial next Item
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    public DefaultRemoveInsertAddReplaceIndexSequenceTraverser(final Sequenze sequence, final int initialNextItemIndex)
    throws SequenceIndexOutOfBoundsException {
        super(sequence, initialNextItemIndex);
    }

    @Override
    public void remove()
    throws NoSequenceItemToRemoveException {
        try {
            getSequence().remove(getLastAccessedItemIndex());

            unsetLastAccessedItem();
        }
        catch (final NoValueSetException exception) {
            throw new NoSequenceItemToRemoveException(getSequence(), exception);
        }

    }
}
