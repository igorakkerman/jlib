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

import java.util.NoSuchElementException;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIteratorState;
import org.jlib.container.sequence.StateSequenceIterator;

/**
 * {@link IndexSequenceIterator} traversing the elements in the proper order.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class StateIndexSequenceIterator<Element>
extends StateSequenceIterator<Element>
implements IndexSequenceIterator<Element> {

    /** IndexSequence to traverse */
    private final IndexSequence<Element> sequence;

    /** index of the next Item in the {@link IndexSequence} */
    private int nextElementIndex;

    private IndexSequenceIteratorState<Element> elementReturnedState;

    private IndexSequenceIteratorState<Element> noElementReturnedState;

    /**
     * Creates a new StateIndexSequenceIterator over the Elements of the
     * specified ReplaceIndexSequence.
     * 
     * @param sequence
     *        IndexSequence to traverse
     */
    protected StateIndexSequenceIterator(final IndexSequence<Element> sequence) {
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
     * @param startIndex
     *        integer specifying the start index of the traversal
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    protected StateIndexSequenceIterator(final IndexSequence<Element> sequence, final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        super();

        this.sequence = sequence;

        nextElementIndex = startIndex;
    }

    @Override
    public int getPreviousElementIndex()
    throws NoSuchElementException {
        if (!hasNext())
            throw new NoSuchElementException();

        return nextElementIndex - 1;
    }

    @Override
    public int getNextElementIndex() {
        return nextElementIndex;
    }

    /**
     * Registers the index of the next Element of this
     * {@link StateIndexSequenceIterator}.
     * 
     * @param nextElementIndex
     *        integer specifying the nextElementIndex
     */
    void setNextElementIndex(final int nextElementIndex) {
        this.nextElementIndex = nextElementIndex;
    }

    /**
     * Returns the sequence traversed by this {@link StateIndexSequenceIterator}
     * .
     * 
     * @return traversed {@link IndexSequence}
     */
    IndexSequence<Element> getSequence() {
        return sequence;
    }

    /**
     * TODO:
     * 
     * @param lastReturnedElementIndex
     * @return
     */
    public SequenceIteratorState<Element> getElementReturnedState(final int lastReturnedElementIndex) {
        elementReturnedState;
    }
}
