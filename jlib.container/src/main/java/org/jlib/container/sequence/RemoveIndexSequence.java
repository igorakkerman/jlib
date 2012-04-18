/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence;

/**
 * {@link ReplaceIndexSequence} that allows Elements to be added and removed.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveIndexSequence<Element>
extends RemoveSequence<Element>, IndexSequence<Element> {

    /**
     * Returns a {@link RemoveIndexSequenceIterator} traversing the Elements of
     * this Sequence in proper sequence. Initially, the Iterator points to the
     * beginning of this Sequence, that is, the Element returned by the first
     * call to {@link AddIndexSequenceIterator#next()} is the Element stored at
     * {@link #getFirstIndex()}.
     * 
     * @return AddIndexSequenceIterator over this IndexSequence initially
     *         pointing to the beginning of this Sequence
     */
    @Override
    public RemoveIndexSequenceIterator<Element> createIterator();

    /**
     * Returns a RemoveIndexSequenceIterator traversing the Elements of this
     * Sequence in proper sequence. That is, the Element returned by the first
     * call to {@link AddIndexSequenceIterator#next()} is the Element stored at
     * the specified start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Element returned by the
     *        Iterator
     * 
     * @return AddIndexSequenceIterator over this Sequence initially pointing to
     *         the beginning of this Sequence
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    @Override
    public RemoveIndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException;

    /**
     * Removes from this IndexSequence the Element stored at the specified
     * index.
     * 
     * @param index
     *        integer specifying the index
     */
    public void remove(final int index);
}
