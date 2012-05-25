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

package org.jlib.container.sequence.index;

import org.jlib.container.sequence.RemoveSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequence} that allows Elements to be removed.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveIndexSequence<Element>
extends RemoveSequence<Element>, IndexSequence<Element> {

    /**
     * Removes from this IndexSequence the Element stored at the specified
     * index.
     * 
     * @param index
     *        integer specifying the index
     */
    public void remove(final int index);

    /**
     * Returns a {@link RemoveIndexSequenceIterator} traversing the Elements of
     * this Sequence in proper sequence. Initially, the Iterator points to the
     * beginning of this Sequence, that is, the Element returned by the first
     * call to {@link InsertIndexSequenceIterator#next()} is the Element stored
     * at {@link #getFirstIndex()}.
     * 
     * @return InsertIndexSequenceIterator over this IndexSequence initially
     *         pointing to the beginning of this Sequence
     */
    @Override
    public RemoveIndexSequenceIterator<Element> createIterator();

    /**
     * Returns a RemoveIndexSequenceIterator traversing the Elements of this
     * Sequence in proper sequence. That is, the Element returned by the first
     * call to {@link InsertIndexSequenceIterator#next()} is the Element stored
     * at the specified start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Element returned by the
     *        Iterator
     * 
     * @return InsertIndexSequenceIterator over this Sequence initially pointing
     *         to the beginning of this Sequence
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    @Override
    public RemoveIndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
