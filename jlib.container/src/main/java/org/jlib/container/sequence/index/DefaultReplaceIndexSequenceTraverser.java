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

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.NoSequenceItemToReplaceException;
import org.jlib.container.sequence.ObservedReplaceSequenceTraverser;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.array.ReplaceAppendArraySequence;
import org.jlib.core.observer.ItemObserver;
import org.jlib.core.observer.ItemObserverException;
import org.jlib.core.reference.NoValueSetException;

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
public class DefaultReplaceIndexSequenceTraverser<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends DefaultIndexSequenceTraverser<Item, Sequenze>
implements ReplaceIndexSequenceTraverser<Item>, ObservedReplaceSequenceTraverser<Item> {

    private final AppendSequence<ItemObserver<Item>> replaceObservers =
        IndexSequenceUtility.createSequence(ReplaceAppendArraySequence.getCreator());

    /**
     * Creates a new {@link DefaultReplaceIndexSequenceTraverser} over the Items
     * of the specified {@link ReplaceIndexSequence} beginning at its first
     * index.
     * 
     * @param sequence
     *        {@link ReplaceIndexSequence} to traverse
     */
    public DefaultReplaceIndexSequenceTraverser(final Sequenze sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link DefaultReplaceIndexSequenceTraverser} over the Items
     * of the specified {@link ReplaceIndexSequence} beginning the traversal at
     * the specified index.
     * 
     * @param sequence
     *        {@link ReplaceIndexSequence} to traverse
     * 
     * @param initialNextItemIndex
     *        integer specifying the index of the initial next Item
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of {@code newItem} prevents the operation from
     *         being performed
     * 
     * @throws IllegalSequenceStateException
     *         if an error occurs performing the operation
     */
    public DefaultReplaceIndexSequenceTraverser(final Sequenze sequence, final int initialNextItemIndex)
    throws SequenceIndexOutOfBoundsException, IllegalSequenceArgumentException, IllegalSequenceStateException {
        super(sequence, initialNextItemIndex);
    }

    @Override
    public void replace(final Item newItem)
    throws NoSequenceItemToReplaceException, IllegalSequenceArgumentException, IllegalSequenceStateException {
        try {
            getSequence().replace(getLastAccessedItemIndex(), newItem);
        }
        catch (final NoValueSetException exception) {
            throw new NoSequenceItemToReplaceException(getSequence(), exception);
        }
    }

    @Override
    public void replace(final Item newItem,
                        @SuppressWarnings({ "unchecked", /* "varargs" */}) final ItemObserver<Item>... observers)
    throws NoSequenceItemToReplaceException, ItemObserverException, IllegalSequenceArgumentException,
    IllegalSequenceStateException {
        try {
            for (final ItemObserver<Item> observer : observers)
                observer.handleBefore(newItem, getSequence());

            replace(newItem);

            for (final ItemObserver<Item> observer : observers)
                observer.handleAfterSuccess(newItem, getSequence());
        }
        catch (NoSequenceItemToReplaceException | IllegalSequenceArgumentException | IllegalSequenceStateException exception) {
            for (final ItemObserver<Item> observer : observers)
                observer.handleAfterFailure(newItem, getSequence());
        }
    }
}
