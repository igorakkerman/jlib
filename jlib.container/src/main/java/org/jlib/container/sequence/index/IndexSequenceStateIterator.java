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

import org.jlib.container.sequence.AbstractSequenceStateIterator;
import org.jlib.container.sequence.NoSuchSequenceElementException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIteratorState;

/**
 * {@link IndexSequenceIterator} traversing the elements in the proper order.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class IndexSequenceStateIterator<Element>
extends AbstractSequenceStateIterator<Element>
implements IndexSequenceIterator<Element> {

    /** traversed {@link IndexSequence} */
    private final IndexSequence<Element> sequence;

    /** beginning of the {@link IndexSequence} */
    private final IndexSequenceIteratorState<Element> beginningOfSequenceState;

    /** middle of the {@link IndexSequence} */
    private final MiddleOfIndexSequenceIteratorState<Element> middleOfSequenceState;

    /** end of the {@link IndexSequence} */
    private final IndexSequenceIteratorState<Element> endOfSequenceState;

    /** current {@link IndexSequenceIteratorState} */
    private IndexSequenceIteratorState<Element> currentState;

    /**
     * Creates a new {@link IndexSequenceStateIterator} over the Elements of the
     * specified {@link IndexSequence} beginning at its first index.
     * 
     * @param sequence
     *        IndexSequence to traverse
     */
    protected IndexSequenceStateIterator(final IndexSequence<Element> sequence) {
        this(sequence, sequence.getFirstIndex());
    }

    /**
     * Creates a new DefaultReplaceIndexSequenceIterator over the Elements of
     * the specified IndexSequence starting the traversal at the specified
     * index.
     * 
     * @param sequence
     *        ReplaceIndexSequence to traverse
     * 
     * @param initialNextIndex
     *        integer specifying the index of the initial next Element
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    protected IndexSequenceStateIterator(final IndexSequence<Element> sequence, final int initialNextIndex)
    throws SequenceIndexOutOfBoundsException {
        super();

        this.sequence = sequence;

        beginningOfSequenceState = new BeginningOfIndexSequenceIteratorState<Element>(sequence) {

            @Override
            public IndexSequenceIteratorState<Element> getNextState() {
                return middleOfSequenceState;
            }
        };

        endOfSequenceState = new EndOfIndexSequenceIteratorState<Element>(sequence) {

            @Override
            public IndexSequenceIteratorState<Element> getPreviousState() {
                middleOfSequenceState.setNextElementIndex(sequence.getLastIndex() - 1);

                return middleOfSequenceState;
            }
        };

        middleOfSequenceState = new MiddleOfIndexSequenceIteratorState<Element>(sequence) {

            @Override
            protected IndexSequenceIteratorState<Element> getReturnedElementState() {
                return getCurrentState(getNextElementIndex());
            }
        };

        currentState = getCurrentState(initialNextIndex);
    }

    /**
     * Returns the new {@link SequenceIteratorState} after an Element has been
     * returned and the specified index of the next Element has been set.
     * 
     * @param nextElementIndex
     *        integer specifying the index of the next Element;
     *        {@code sequence.getLastIndex + 1} represents the end of the
     *        {@link IndexSequence}
     * 
     * @return new {@link IndexSequenceIteratorState}
     */
    private IndexSequenceIteratorState<Element> getCurrentState(final int nextElementIndex) {
        if (nextElementIndex == sequence.getFirstIndex())
            return beginningOfSequenceState;

        if (nextElementIndex == sequence.getLastIndex() + 1)
            return endOfSequenceState;

        middleOfSequenceState.setNextElementIndex(nextElementIndex);

        return middleOfSequenceState;
    }

    @Override
    public int getPreviousElementIndex()
    throws NoSuchSequenceElementException {
        return currentState.getPreviousElementIndex();
    }

    @Override
    public int getNextElementIndex() {
        return currentState.getNextElementIndex();
    }

    @Override
    protected IndexSequenceIteratorState<Element> getCurrentState() {
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
