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

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIteratorState;
import org.jlib.container.sequence.SequenceStateIterator;
import org.jlib.container.sequence.replace.ReplaceIndexSequence;

/**
 * {@link IndexSequenceIterator} traversing the elements in the proper order.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class IndexSequenceStateIterator<Element>
extends SequenceStateIterator<Element>
implements IndexSequenceIterator<Element> {

    private IndexSequenceIteratorGlobalState<Element> globalState;

    /**
     * Creates a new StateIndexSequenceIterator over the Elements of the
     * specified ReplaceIndexSequence.
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
     * @param startIndex
     *        integer specifying the start index of the traversal
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    protected IndexSequenceStateIterator(final IndexSequence<Element> sequence, final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        super(createInitialState(sequence, startIndex));

        this.sequence = sequence;

        nextElementIndex = startIndex;
    }

    /**
     * 
     * 
     * @param sequence
     * @param startIndex
     * @return
     */
    private IndexSequenceIteratorState<Element> createInitialState(final IndexSequence<Element> sequence,
                                                                   final int startIndex) {
        globalState = new IndexSequenceIteratorGlobalState<>(sequence, startIndex);

        return new IndexSequenceIteratorState<>(globalState);
    }

    @Override
    public int getPreviousElementIndex()
    throws NoSuchSequenceElementException {
        if (!hasPrevious())
            throw new NoSuchSequenceElementException();

        return nextElementIndex - 1;
    }

    @Override
    public int getNextElementIndex() {
        if (!hasNext())
            throw new NoSuchSequenceElementException();

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
