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
import org.jlib.container.sequence.EndOfSequenceIteratorState;
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

    /**
     * Initializer of an {@link IndexSequenceStateIterator} creating the
     * {@link SequenceIteratorState} instances. An own class is necessary as the
     * {@link SequenceIteratorState} instances reference themselves.
     * 
     * @param <Element>
     *        type of elements held in the {@link Sequence}
     * 
     * @author Igor Akkerman
     */
    private static class Initializer<Element> {

        /** traversed {@link IndexSequence} */
        private final IndexSequence<Element> sequence;

        /** beginning of the {@link IndexSequence} */
        private final SequenceIteratorState<Element> beginningOfSequenceState;

        /** middle of the {@link IndexSequence} */
        private final MiddleOfIndexSequenceIteratorState<Element> middleOfSequenceState;

        /** end of the {@link IndexSequence} */
        private final SequenceIteratorState<Element> endOfSequenceState;

        /**
         * Creates a new
         * {@link org.jlib.container.sequence.index.IndexSequenceStateIterator.Initializer}
         * for the specified {@link IndexSequence}.
         * 
         * @param sequence
         *        traversed {@link IndexSequence}
         */
        private Initializer(final IndexSequence<Element> sequence) {

            this.sequence = sequence;

            beginningOfSequenceState = new BeginningOfSequenceIteratorState<Element>() {

                @Override
                public Element next() {
                    return sequence.getFirst();
                }

                @Override
                public SequenceIteratorState<Element> getNextState() {
                    return middleOfSequenceState;
                }
            };

            endOfSequenceState = new EndOfSequenceIteratorState<Element>() {

                @Override
                public Element previous()
                throws NoSuchSequenceElementException {
                    return sequence.getLast();
                }

                @Override
                public SequenceIteratorState<Element> getPreviousState() {
                    middleOfSequenceState.setNextElementIndex(sequence.getLastIndex() - 1);

                    return middleOfSequenceState;
                }
            };

            middleOfSequenceState = new MiddleOfIndexSequenceIteratorState<Element>() {

                @Override
                protected SequenceIteratorState<Element> getReturnedElementState() {
                    return getCurrentState(getNextElementIndex());
                }

                @Override
                protected Element getSequenceElement(final int elementIndex) {
                    return sequence.get(elementIndex);
                }
            };
        }

        /**
         * Returns the new {@link SequenceIteratorState} after an Element has
         * been returned and the specified index of the next Element has been
         * set.
         * 
         * @param nextElementIndex
         *        integer specifying the index of the next Element;
         *        {@code sequence.getLastIndex + 1} represents the end of the
         *        {@link IndexSequence}
         * 
         * @return new {@link SequenceIteratorState}
         */
        private SequenceIteratorState<Element> getCurrentState(final int nextElementIndex) {
            if (nextElementIndex == sequence.getFirstIndex())
                return beginningOfSequenceState;

            if (nextElementIndex == sequence.getLastIndex() + 1)
                return endOfSequenceState;

            middleOfSequenceState.setNextElementIndex(nextElementIndex);

            return middleOfSequenceState;
        }
    }

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
        super(new Initializer<Element>(sequence).getCurrentState(initialNextIndex));
    }

    @Override
    public int getPreviousElementIndex() {
        // TODO: implement
        return 0;
    }

    @Override
    public int getNextElementIndex() {
        // TODO: implement
        return 0;
    }
}
