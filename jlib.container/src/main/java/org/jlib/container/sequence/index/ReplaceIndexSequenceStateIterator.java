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
import org.jlib.container.sequence.NoElementToReplaceException;
import org.jlib.container.sequence.NoSuchSequenceElementException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIteratorState;

/**
 * {@link ReplaceIndexSequenceIterator} traversing the elements in the proper
 * order.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceIndexSequenceStateIterator<Element>
extends AbstractSequenceStateIterator<Element>
implements ReplaceIndexSequenceIterator<Element> {

    /** traversed {@link ReplaceIndexSequence} */
    private final ReplaceIndexSequence<Element> sequence;

    /** beginning of the {@link ReplaceIndexSequence} */
    private final ReplaceIndexSequenceIteratorState<Element> beginningOfSequenceState;

    /** middle of the {@link ReplaceIndexSequence} */
    private final MiddleOfReplaceIndexSequenceIteratorState<Element> middleOfSequenceState;

    /** end of the {@link ReplaceIndexSequence} */
    private final ReplaceIndexSequenceIteratorState<Element> endOfSequenceState;

    /** current {@link ReplaceIndexSequenceIteratorState} */
    private ReplaceIndexSequenceIteratorState<Element> currentState;

    /**
     * Creates a new {@link ReplaceIndexSequenceStateIterator} over the Elements
     * of the specified {@link ReplaceIndexSequence} beginning at its first
     * index.
     * 
     * @param sequence
     *        ReplaceIndexSequence to traverse
     */
    protected ReplaceIndexSequenceStateIterator(final ReplaceIndexSequence<Element> sequence) {
        this(sequence, sequence.getFirstIndex());
    }

    /**
     * Creates a new DefaultReplaceReplaceIndexSequenceIterator over the
     * Elements of the specified ReplaceIndexSequence starting the traversal at
     * the specified index.
     * 
     * @param sequence
     *        ReplaceReplaceIndexSequence to traverse
     * 
     * @param initialNextIndex
     *        integer specifying the index of the initial next Element
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    protected ReplaceIndexSequenceStateIterator(final ReplaceIndexSequence<Element> sequence, final int initialNextIndex)
    throws SequenceIndexOutOfBoundsException {
        super();

        this.sequence = sequence;

        beginningOfSequenceState = new ElementRetrievedBeginningOfReplaceIndexSequenceIteratorState<Element>(sequence) {

            @Override
            public ReplaceIndexSequenceIteratorState<Element> getNextState() {
                return middleOfSequenceState;
            }
        };

        endOfSequenceState = new EndOfReplaceIndexSequenceIteratorState<Element>(sequence) {

            @Override
            public ReplaceIndexSequenceIteratorState<Element> getPreviousState() {
                middleOfSequenceState.setNextElementIndex(sequence.getLastIndex() - 1);

                return middleOfSequenceState;
            }
        };

        middleOfSequenceState = new MiddleOfReplaceIndexSequenceIteratorState<Element>(sequence) {

            @Override
            protected ReplaceIndexSequenceIteratorState<Element> getReturnedElementState() {
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
     *        {@link ReplaceIndexSequence}
     * 
     * @return new {@link ReplaceIndexSequenceIteratorState}
     */
    private ReplaceIndexSequenceIteratorState<Element> getCurrentState(final int nextElementIndex) {
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
    protected ReplaceIndexSequenceIteratorState<Element> getCurrentState() {
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
    public void replace(final Element element)
    throws NoElementToReplaceException {}

    @Override
    protected ReplaceIndexSequence<Element> getSequence() {
        return sequence;
    }

}
