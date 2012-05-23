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

import org.jlib.container.sequence.NoElementToReplaceException;
import org.jlib.container.sequence.ReplaceSequenceIteratorState;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIteratorState;

/**
 * Iterator over an ReplaceIndexSequence using a random access data store.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * @author Igor Akkerman
 */
public class DefaultReplaceIndexSequenceIterator<Element>
extends StateIndexSequenceIterator<Element>
implements ReplaceIndexSequenceIterator<Element> {

    /**
     * ReplaceIndexSequence traversed by this
     * {@link DefaultReplaceIndexSequenceIterator}
     */
    private final ReplaceIndexSequence<Element> sequence;

    private final ReplaceSequenceIteratorState UNRETRIEVED = new ReplaceSequenceIteratorState<Element>() {

        @Override
        public SequenceIteratorState<Element> getPreviousState() {
            return RETRIEVED;
        }

        @Override
        public SequenceIteratorState<Element> getNextState() {
            return RETRIEVED;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Element next() {
            return null;
        }

        @Override
        public void remove() {}

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Element previous()
        throws NoSuchElementException {
            return null;
        }

        @Override
        public void replace(final Element element)
        throws IllegalStateException {}

        @Override
        public ReplaceSequenceIteratorState<Element> getReplaceState() {
            return null;
        }
    };

    private final ReplaceSequenceIteratorState RETRIEVED = new ReplaceSequenceIteratorState<Element>() {

        @Override
        public SequenceIteratorState<Element> getPreviousState() {
            return null;
        }

        @Override
        public SequenceIteratorState<Element> getNextState() {
            return null;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Element next() {
            return null;
        }

        @Override
        public void remove() {}

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Element previous()
        throws NoSuchElementException {
            return null;
        }

        @Override
        public void replace(final Element element)
        throws IllegalStateException {}

        @Override
        public ReplaceSequenceIteratorState<Element> getReplaceState() {
            return null;
        }
    };

    /**
     * Creates a new {@link DefaultReplaceIndexSequenceIterator} over the
     * Elements of the specified ReplaceIndexSequence.
     * 
     * @param sequence
     *        ReplaceIndexSequence to traverse
     */
    public DefaultReplaceIndexSequenceIterator(final ReplaceIndexSequence<Element> replaceIndexSequence) {
        this(replaceIndexSequence, replaceIndexSequence.getFirstIndex());
    }

    /**
     * Creates a new {@link DefaultReplaceIndexSequenceIterator} over the
     * Elements of the specified IndexSequence starting the traversal at the
     * specified index.
     * 
     * @param sequence
     *        ReplaceIndexSequence to traverse
     * 
     * @param startIndex
     *        integer specifying the start index of the traversal
     * 
     * @throws IndexOutOfBoundsException
     *         if
     *         {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    public DefaultReplaceIndexSequenceIterator(final ReplaceIndexSequence<Element> replaceIndexSequence,
                                               final int startIndex)
    throws IndexOutOfBoundsException {
        super(replaceIndexSequence, startIndex);

        this.sequence = replaceIndexSequence;
        modificationReady = false;
    }

    @Override
    public void replace(final Element element) {
        if (!modificationReady)
            throw new NoElementToReplaceException(sequence);

        sequence.replace(getLastRetreivedElementIndex(), element);
    }

    @Override
    public Element next()
    throws NoSuchElementException {
        final Element nextElement = super.next();

        modificationReady = true;

        return nextElement;
    }
}
