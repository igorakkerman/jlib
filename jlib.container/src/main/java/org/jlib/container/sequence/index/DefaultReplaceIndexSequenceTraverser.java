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
import org.jlib.container.sequence.ConcatenatedSequence;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.NoSequenceItemToReplaceException;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.array.ArrayTraversible;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.reference.NoValueSetException;

/**
 * Default implementation of a {@link IndexSequenceTraverser} and
 * {@link ObservedReplaceIndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link ReplaceIndexSequence}
 * 
 * @author Igor Akkerman
 */
public class DefaultReplaceIndexSequenceTraverser<Item, Sequenze extends ObservedReplaceIndexSequence<Item>>
extends DefaultIndexSequenceTraverser<Item, Sequenze>
implements ObservedReplaceIndexSequenceTraverser<Item> {

    /** replace {@link ValueObserver} items */
    // FIXME: initialize with initially empty fillable Sequence
    private final AppendSequence<ValueObserver<Item>> traverserObservers = null;

    /**
     * Creates a new {@link DefaultReplaceIndexSequenceTraverser} over the Items
     * of the specified {@link ObservedReplaceIndexSequence} beginning at its
     * first index.
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

    /**
     * Registers the specified {@link ValueObserver} for the replace operations
     * of this {@link DefaultReplaceIndexSequenceTraverser}.
     * 
     * @param replaceObserver
     *        additional replace {@link ValueObserver}
     */
    public final void addReplaceObserver(final ValueObserver<Item> replaceObserver) {
        // FIXME: implement
    }

    @Override
    public final void replace(final Item newItem)
    throws NoSequenceItemToReplaceException, IllegalSequenceArgumentException, IllegalSequenceStateException {
        try {
            getSequence().replace(getLastAccessedItemIndex(), newItem);
        }
        catch (final NoValueSetException exception) {
            throw new NoSequenceItemToReplaceException(getSequence(), exception);
        }
    }

    @Override
    @SafeVarargs
    @SuppressWarnings("finally")
    public final void replace(final Item newItem, final ValueObserver<Item>... operationObservers)
    throws NoSequenceItemToReplaceException, ValueObserverException, IllegalSequenceArgumentException,
    IllegalSequenceStateException {

        final ConcatenatedSequence<ValueObserver<Item>> observers =
            new ConcatenatedSequence<ValueObserver<Item>>(traverserObservers, new ArrayTraversible<>(operationObservers));

        try {
            for (final ValueObserver<Item> observer : observers)
                observer.handleBefore(newItem, getSequence());

            replace(newItem);

            for (final ValueObserver<Item> observer : observers)
                observer.handleAfterSuccess(newItem, getSequence());
        }
        catch (NoSequenceItemToReplaceException | IllegalSequenceArgumentException | IllegalSequenceStateException exception) {
            try {
                for (final ValueObserver<Item> observer : observers)
                    observer.handleAfterFailure(newItem, getSequence());
            }
            finally {
                throw exception;
            }
        }
    }
}
