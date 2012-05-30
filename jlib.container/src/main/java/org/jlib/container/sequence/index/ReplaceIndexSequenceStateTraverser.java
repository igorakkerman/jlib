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

import org.jlib.container.sequence.NoItemToReplaceException;
import org.jlib.container.sequence.Sequence;

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
extends IndexSequenceStateTraverser<Item, ReplaceIndexSequence<Item>>
implements ReplaceIndexSequenceTraverser<Item> {

    /** beginning of the {@link ReplaceIndexSequence} */
    private final ReplaceIndexSequenceTraverserState<Item> headOfSequenceState;

    /** middle of the {@link ReplaceIndexSequence} */
    private final MiddleOfReplaceIndexSequenceTraverserState<Item, ReplaceIndexSequence<Item>> middleOfSequenceState;

    /** end of the {@link ReplaceIndexSequence} */
    private final ReplaceIndexSequenceTraverserState<Item> tailOfSequenceState;

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
     * Creates a new DefaultReplaceReplaceIndexSequenceTraverser over the Items
     * of the specified ReplaceIndexSequence starting the traversal at the
     * specified index.
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
        super(sequence);

        headOfSequenceState = new HeadOfReplaceIndexSequenceTraverserState<Item, ReplaceIndexSequence<Item>>(sequence) {

            @Override
            public ReplaceIndexSequenceTraverserState<Item> getNextState() {
                return middleOfSequenceState;
            }
        };

        tailOfSequenceState = new TailOfReplaceIndexSequenceTraverserState<Item, ReplaceIndexSequence<Item>>(sequence) {

            @Override
            public ReplaceIndexSequenceTraverserState<Item> getPreviousState() {
                middleOfSequenceState.setNextItemIndex(sequence.getLastIndex() - 1);

                return middleOfSequenceState;
            }
        };

        middleOfSequenceState =
            new MiddleOfReplaceIndexSequenceTraverserState<Item, ReplaceIndexSequence<Item>>(sequence) {

                @Override
                protected ReplaceIndexSequenceTraverserState<Item> getReturnedItemState() {
                    return getCurrentState(getNextItemIndex());
                }
            };

        currentState = getCurrentState(initialNextIndex);
    }

    @Override
    protected ReplaceIndexSequenceTraverserState<Item> getCurrentState(final int nextItemIndex) {
        return super.getCurrentState(nextItemIndex);
    }

    /**
     * Returns the {@link IndexSequenceTraverserState} at the head of the
     * {@link IndexSequence}.
     * 
     * @return head {@link IndexSequenceTraverserState}
     */
    @Override
    protected IndexSequenceTraverserState<Item> getHeadOfSequenceState() {
        return headOfSequenceState;
    }

    /**
     * Returns the {@link IndexSequenceTraverserState} at the tail of the
     * {@link IndexSequence}.
     * 
     * @return tail {@link IndexSequenceTraverserState}
     */
    @Override
    protected IndexSequenceTraverserState<Item> getTailOfSequenceState() {
        return tailOfSequenceState;
    }

    /**
     * Returns the {@link IndexSequenceTraverserState} in the middle of the
     * {@link IndexSequence} with the next Item at the specified index.
     * 
     * @param nextItemIndex
     *        integer specifying the index of the next Item
     * 
     * @return middle {@link IndexSequenceTraverserState}
     */
    @Override
    protected IndexSequenceTraverserState<Item> getMiddleOfSequenceState(final int nextItemIndex) {
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
    public void replace(final Item newItem)
    throws NoItemToReplaceException {}
}
