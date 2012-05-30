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

import org.jlib.container.sequence.AbstractSequenceStateTraverser;
import org.jlib.container.sequence.NoPreviousSequenceItemException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverserState;

/**
 * {@link IndexSequenceTraverser} traversing the items in the proper order.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class IndexSequenceStateTraverser<Item, Sequenze extends IndexSequence<Item>>
extends AbstractSequenceStateTraverser<Item, Sequenze>
implements IndexSequenceTraverser<Item> {

    /** beginning of the {@link IndexSequence} */
    private final IndexSequenceTraverserState<Item> headOfSequenceState;

    /** middle of the {@link IndexSequence} */
    private final MiddleOfIndexSequenceTraverserState<Item, Sequenze> middleOfSequenceState;

    /** end of the {@link IndexSequence} */
    private final IndexSequenceTraverserState<Item> tailOfSequenceState;

    /** current {@link IndexSequenceTraverserState} */
    private IndexSequenceTraverserState<Item> currentState;

    /**
     * Creates a new {@link IndexSequenceStateTraverser} over the Items of the
     * specified {@link IndexSequence} beginning at its first index.
     * 
     * @param sequence
     *        IndexSequence to traverse
     */
    protected IndexSequenceStateTraverser(final Sequenze sequence) {
        this(sequence, sequence.getFirstIndex());
    }

    /**
     * Creates a new DefaultReplaceIndexSequenceTraverser over the Items of the
     * specified IndexSequence starting the traversal at the specified index.
     * 
     * @param sequence
     *        ReplaceIndexSequence to traverse
     * 
     * @param initialNextIndex
     *        integer specifying the index of the initial next Item
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    protected IndexSequenceStateTraverser(final Sequenze sequence, final int initialNextIndex)
    throws SequenceIndexOutOfBoundsException {
        super(sequence);

        headOfSequenceState = new HeadOfIndexSequenceTraverserState<Item, Sequenze>(sequence) {

            @Override
            public IndexSequenceTraverserState<Item> getNextState() {
                return middleOfSequenceState;
            }
        };

        tailOfSequenceState = new TailOfIndexSequenceTraverserState<Item, Sequenze>(sequence) {

            @Override
            public IndexSequenceTraverserState<Item> getPreviousState() {
                middleOfSequenceState.setNextItemIndex(sequence.getLastIndex() - 1);

                return middleOfSequenceState;
            }
        };

        middleOfSequenceState = new MiddleOfIndexSequenceTraverserState<Item, Sequenze>(sequence) {

            @Override
            protected IndexSequenceTraverserState<Item> getReturnedItemState() {
                return getCurrentState(getNextItemIndex());
            }
        };

        currentState = getCurrentState(initialNextIndex);
    }

    /**
     * Returns the new {@link SequenceTraverserState} after an Item has been
     * returned and the specified index of the next Item has been set.
     * 
     * @param nextItemIndex
     *        integer specifying the index of the next Item;
     *        {@code sequence.getLastIndex + 1} represents the end of the
     *        {@link IndexSequence}
     * 
     * @return new {@link IndexSequenceTraverserState}
     */
    protected IndexSequenceTraverserState<Item> getCurrentState(final int nextItemIndex) {
        if (nextItemIndex == getSequence().getFirstIndex())
            return getHeadOfSequenceState();

        if (nextItemIndex == getSequence().getLastIndex() + 1)
            return getTailOfSequenceState();

        middleOfSequenceState.setNextItemIndex(nextItemIndex);

        return middleOfSequenceState;
    }

    /**
     * Returns the {@link IndexSequenceTraverserState} at the head of the
     * {@link IndexSequence}.
     * 
     * @return head {@link IndexSequenceTraverserState}
     */
    protected IndexSequenceTraverserState<Item> getHeadOfSequenceState() {
        return headOfSequenceState;
    }

    /**
     * Returns the {@link IndexSequenceTraverserState} at the tail of the
     * {@link IndexSequence}.
     * 
     * @return tail {@link IndexSequenceTraverserState}
     */
    private IndexSequenceTraverserState<Item> getTailOfSequenceState() {
        return tailOfSequenceState;
    }

    @Override
    public int getPreviousItemIndex()
    throws NoPreviousSequenceItemException {
        return currentState.getPreviousItemIndex();
    }

    @Override
    public int getNextItemIndex() {
        return currentState.getNextItemIndex();
    }

    @Override
    protected IndexSequenceTraverserState<Item> getCurrentState() {
        return currentState;
    }

    @Override
    protected void setCurrentStateToPrevious() {
        currentState = currentState.getPreviousState();
    }

    @Override
    protected void setCurrentStateToNext() {
        currentState = currentState.getNextState();
    }
}
