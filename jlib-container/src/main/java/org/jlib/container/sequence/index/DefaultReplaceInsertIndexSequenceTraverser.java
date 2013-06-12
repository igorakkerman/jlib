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
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.operator.HandledOperator;
import org.jlib.core.operator.OperatorException;

import static org.jlib.core.array.ArrayUtility.traversible;

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.IllegalSequenceTraverserStateException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.array.FillupArraySequence;

import static org.jlib.container.sequence.SequenceUtility.concatenated;

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
public class DefaultReplaceInsertIndexSequenceTraverser<Item, Sequenze extends ReplaceInsertIndexSequence<Item>>
extends DefaultReplaceIndexSequenceTraverser<Item, Sequenze>
implements ObservedReplaceInsertIndexSequenceTraverser<Item> {

    /** insert {@link ValueObserver} items */
    private final AppendSequence<ValueObserver<Item>> traverserInsertObservers = new FillupArraySequence<>();

    /**
     * Creates a new {@link DefaultReplaceInsertIndexSequenceTraverser} over the
     * Items of the specified {@link ObservedReplaceIndexSequence} and
     * {@link InsertIndexSequence} beginning at its first index.
     * 
     * @param sequence
     *        {@link ObservedReplaceIndexSequence} and
     *        {@link InsertIndexSequence} to traverse
     */
    public DefaultReplaceInsertIndexSequenceTraverser(final Sequenze sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link DefaultReplaceInsertIndexSequenceTraverser} over the
     * Items of the specified {@link ObservedReplaceIndexSequence} and
     * {@link InsertIndexSequence} beginning at the specified index.
     * 
     * @param sequence
     *        {@link ObservedReplaceIndexSequence} and
     *        {@link InsertIndexSequence} to traverse
     * 
     * @param initialNextItemIndex
     *        integer specifying the index of the initial next Item
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    public DefaultReplaceInsertIndexSequenceTraverser(final Sequenze sequence, final int initialNextItemIndex)
    throws SequenceIndexOutOfBoundsException {
        super(sequence, initialNextItemIndex);
    }

    @Override
    public void insert(final Item item) {
        getSequence().insert(getPotentialNextItemIndex(), item);
    }

    @Override
    @SafeVarargs
    public final void insert(final Item item, final ValueObserver<Item>... operationObservers)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException, RuntimeException {
        ObserverUtility.operate(new HandledOperator() {

            @Override
            public void operate()
            throws OperatorException, RuntimeException {
                try {
                    insert(item);
                }
                catch (IllegalSequenceArgumentException | IllegalSequenceTraverserStateException exception) {
                    throw new OperatorException("insert: {0}", exception, item);
                }
            }

        },

        item, concatenated(traverserInsertObservers, traversible(operationObservers)).toArray());
    }

    @Override
    public final void addInsertObserver(final ValueObserver<Item> insertObserver) {
        traverserInsertObservers.append(insertObserver);
    }
}