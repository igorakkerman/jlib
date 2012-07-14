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

import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.Operator;
import org.jlib.core.observer.OperatorException;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.valueholder.ValueNotAccessibleException;

import static org.jlib.core.array.ArrayUtility.traversible;

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceTraverserStateException;
import org.jlib.container.sequence.NoSequenceItemToRemoveException;
import org.jlib.container.sequence.ObservedReplaceRemoveSequenceTraverser;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.array.FillupArraySequence;

import static org.jlib.container.sequence.SequenceUtility.concatenated;

/**
 * Default implementation of a {@link RemoveIndexSequenceTraverser},
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link ReplaceInsertIndexSequence} and
 *        {@link RemoveIndexSequence}
 * 
 * @author Igor Akkerman
 */
public class DefaultReplaceInsertRemoveIndexSequenceTraverser<Item, Sequenze extends ReplaceInsertRemoveIndexSequence<Item>>
extends DefaultReplaceInsertIndexSequenceTraverser<Item, Sequenze>
implements RemoveIndexSequenceTraverser<Item>, ObservedReplaceRemoveSequenceTraverser<Item> {

    /** remove {@link ValueObserver} items */
    private final AppendSequence<ValueObserver<Item>> traverserRemoveObservers = new FillupArraySequence<>();

    /**
     * Creates a new {@link DefaultReplaceInsertRemoveIndexSequenceTraverser}
     * over the Items of the specified
     * {@link ReplaceAppendInsertRemoveIndexSequence} beginning at its first
     * index.
     * 
     * @param sequence
     *        {@link ReplaceAppendInsertRemoveIndexSequence} to traverse
     */
    public DefaultReplaceInsertRemoveIndexSequenceTraverser(final Sequenze sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link DefaultReplaceInsertRemoveIndexSequenceTraverser}
     * over the Items of the specified
     * {@link ReplaceAppendInsertRemoveIndexSequence} beginning the traversal at
     * the specified index.
     * 
     * @param sequence
     *        {@link ReplaceAppendInsertRemoveIndexSequence} to traverse
     * 
     * @param initialNextItemIndex
     *        integer specifying the index of the initial next Item
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    public DefaultReplaceInsertRemoveIndexSequenceTraverser(final Sequenze sequence, final int initialNextItemIndex)
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
        catch (final ValueNotAccessibleException exception) {
            throw new NoSequenceItemToRemoveException(getSequence(), exception);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>... operationObservers)
    throws NoSequenceItemToRemoveException, ValueObserverException, RuntimeException {
        ObserverUtility.operate(new Operator() {

            @Override
            public void operate()
            throws OperatorException, RuntimeException {
                try {
                    remove();
                }
                catch (IllegalSequenceArgumentException | IllegalSequenceTraverserStateException exception) {
                    throw new OperatorException("remove: {0}", exception);
                }
            }

        },

        concatenated(traverserRemoveObservers, traversible(operationObservers)).toArray());
    }

    @Override
    public final void addRemoveObserver(final ValueObserver<Item> removeObserver) {
        traverserRemoveObservers.append(removeObserver);
    }
}
