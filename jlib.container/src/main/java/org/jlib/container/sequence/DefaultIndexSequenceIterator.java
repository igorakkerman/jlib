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

package org.jlib.container.sequence;

import java.util.NoSuchElementException;

/**
 * {@link IndexSequenceIterator} traversing the elements in the proper order.
 *
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * @author Igor Akkerman
 */
public class DefaultIndexSequenceIterator<Element>
implements IndexSequenceIterator<Element> {

    /** IndexSequence to traverse */
    private IndexSequence<Element> sequence;

    /** index of the next Element in the IndexSequence */
    protected int nextElementIndex;

    /** index of last retrieved Element */
    private int lastRetrievedElementIndex;

    /**
     * Creates a new DefaultIndexSequenceIterator over the Elements of the specified
     * ReplaceIndexSequence.
     *
     * @param sequence
     *        IndexSequence to traverse
     */
    protected DefaultIndexSequenceIterator(final IndexSequence<Element> sequence) {
        this(sequence, sequence.getFirstIndex());
    }

    /**
     * Creates a new DefaultReplaceIndexSequenceIterator over the Elements of the specified
     * IndexSequence starting the traversal at the specified index.
     *
     * @param sequence
     *        ReplaceIndexSequence to traverse
     * @param startIndex
     *        integer specifying the start index of the traversal
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code startIndex < sequence.getFirstIndex() || startIndex > sequence.getLastIndex()}
     */
    protected DefaultIndexSequenceIterator(final IndexSequence<Element> sequence, int startIndex)
    throws SequenceIndexOutOfBoundsException {
        super();
        this.sequence = sequence;
        nextElementIndex = startIndex;
        lastRetrievedElementIndex = -1;
    }

    @Override
    public boolean hasNext() {
        return nextIndex() <= sequence.getLastIndex();
    }

    @Override
    public Element next()
    throws NoSuchElementException {
        if (!hasNext())
            throw new NoSuchElementException();

        lastRetrievedElementIndex = nextElementIndex;

        return sequence.get(nextElementIndex ++);
    }

    @Override
    public boolean hasPrevious() {
        return previousIndex() >= sequence.getFirstIndex();
    }

    @Override
    public Element previous()
    throws NoSuchElementException {
        if (!hasPrevious())
            throw new NoSuchElementException();

        lastRetrievedElementIndex = -- nextElementIndex;

        return sequence.get(nextElementIndex);
    }

    @Override
    public int previousIndex() {
        return nextElementIndex - 1;
    }

    @Override
    public int nextIndex() {
        return nextElementIndex;
    }

    /**
     * Returns the index of the last retreived Element.
     *
     * @return integer specifying the index
     */
    protected int lastRetreivedElementIndex() {
        return lastRetrievedElementIndex;
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
