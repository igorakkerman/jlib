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
import org.jlib.container.sequence.NoItemToReplaceException;
import org.jlib.container.sequence.NoSuchSequenceItemException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverserState;

/**
 * {@link ReplaceIndexSequenceTraverser} traversing the items in the proper
 * order.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceIndexSequenceStateTraverser<Item>
extends AbstractSequenceStateTraverser<Item>
implements ReplaceIndexSequenceTraverser<Item> {

    /** traversed {@link ReplaceIndexSequence} */
    private final ReplaceIndexSequence<Item> sequence;

    /** beginning of the {@link ReplaceIndexSequence} */
    private final ReplaceIndexSequenceTraverserState<Item> beginningOfSequenceState;

    /** middle of the {@link ReplaceIndexSequence} */
    private final MiddleOfReplaceIndexSequenceTraverserState<Item> middleOfSequenceState;

    /** end of the {@link ReplaceIndexSequence} */
    private final ReplaceIndexSequenceTraverserState<Item> endOfSequenceState;

    /** current {@link ReplaceIndexSequenceTraverserState} */
    private ReplaceIndexSequenceTraverserState<Item> currentState;

    /**
     * Creates a new {@link ReplaceIndexSequenceStateTraverser} over the Items
     * of the specified {@link ReplaceIndexSequence} beginning at its first
     * index.
     * 
     * @param sequence
     *        ReplaceIndexSequence to traverse
     */
    protected ReplaceIndexSequenceStateTraverser(final ReplaceIndexSequence<Item> sequence) {
        this(sequence, sequence.getFirstIndex());
    }

    /**
     * Creates a new DefaultReplaceReplaceIndexSequenceTraverser over the
     * Items of the specified ReplaceIndexSequence starting the traversal at
     * the specified index.
     * 
     * @param sequence
     *        ReplaceReplaceIndexSequence to traverse
     * 
     * @param initialNextIndex
     *        integer specifying the index of the initial next Item
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    protected ReplaceIndexSequenceStateTraverser(final ReplaceIndexSequence<Item> sequence, final int initialNextIndex)
    throws SequenceIndexOutOfBoundsException {
        super();

        this.sequence = sequence;

        beginningOfSequenceState = new ItemRetrievedBeginningOfReplaceIndexSequenceTraverserState<Item>(sequence) {

            @Override
            public ReplaceIndexSequenceTraverserState<Item> getNextState() {
                return middleOfSequenceState;
            }
        };

        endOfSequenceState = new EndOfReplaceIndexSequenceTraverserState<Item>(sequence) {

            @Override
            public ReplaceIndexSequenceTraverserState<Item> getPreviousState() {
                middleOfSequenceState.setNextItemIndex(sequence.getLastIndex() - 1);

                return middleOfSequenceState;
            }
        };

        middleOfSequenceState = new MiddleOfReplaceIndexSequenceTraverserState<Item>(sequence) {

            @Override
            protected ReplaceIndexSequenceTraverserState<Item> getReturnedItemState() {
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
     *        {@link ReplaceIndexSequence}
     * 
     * @return new {@link ReplaceIndexSequenceTraverserState}
     */
    private ReplaceIndexSequenceTraverserState<Item> getCurrentState(final int nextItemIndex) {
        if (nextItemIndex == sequence.getFirstIndex())
            return beginningOfSequenceState;

        if (nextItemIndex == sequence.getLastIndex() + 1)
            return endOfSequenceState;

        middleOfSequenceState.setNextItemIndex(nextItemIndex);

        return middleOfSequenceState;
    }

    @Override
    public int getPreviousItemIndex()
    throws NoSuchSequenceItemException {
        return currentState.getPreviousItemIndex();
    }

    @Override
    public int getNextItemIndex() {
        return currentState.getNextItemIndex();
    }

    @Override
    protected ReplaceIndexSequenceTraverserState<Item> getCurrentState() {
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

    @Override
    public void replace(final Item item)
    throws NoItemToReplaceException {}

    @Override
    protected ReplaceIndexSequence<Item> getSequence() {
        return sequence;
    }

}
