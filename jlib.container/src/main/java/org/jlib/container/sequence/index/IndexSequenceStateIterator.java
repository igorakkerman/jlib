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
import org.jlib.container.sequence.BeginningOfSequenceIteratorState;
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

    private final SequenceIteratorState<Element> beginningOfSequenceState;

    private final SequenceIteratorState<Element> middleOfSequenceState;

    private final SequenceIteratorState<Element> endOfSequenceState;

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
     * @param startIndex
     *        integer specifying the start index of the traversal
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    protected IndexSequenceStateIterator(final IndexSequence<Element> sequence, final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        super(selectInitialState(sequence, startIndex));
    }

    private SequenceIteratorState<Element> selectInitialState(final IndexSequence<Element> sequence,
                                                              final int startIndex) {

        final SequenceIteratorState<Element> beginningOfSequenceState =
            new BeginningOfSequenceIteratorState<Element>() {

                @Override
                public Element next() {
                    return sequence.getFirst();
                }

                @Override
                public SequenceIteratorState<Element> getNextState() {
                    return middleOfSequenceState;
                }
            };

        final int currentIndex = cursor.getNextElementIndex();
        final IndexSequence<Element> sequence = cursor.getSequence();

        if (currentIndex == sequence.getFirstIndex())
            return beginningOfSequenceState;

        if (currentIndex == sequence.getLastIndex())
            return endOfSequenceState;

        return middleOfSequenceState;
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

}
