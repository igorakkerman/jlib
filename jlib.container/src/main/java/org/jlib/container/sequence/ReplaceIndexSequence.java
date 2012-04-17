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
 * IndexSequence that allows its Elements to be modified.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface ReplaceIndexSequence<Element>
extends ReplaceSequence<Element>, IndexSequence<Element> {

    /**
     * Replaces the Element at the specified index in this
     * IndexSequence by the specified Elements.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param element
     *        Element to store
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getMinimumIndex() || index > getMaximumIndex()}
     */
    // TODO: add set method with ReplaceElementListener
    public void replace(final int index, final Element element)
    throws SequenceIndexOutOfBoundsException;

    /**
     * Returns an ReplaceIndexSequenceIterator traversing the Elements of this
     * IndexSequence in proper sequence. Initially, the Iterator points to the
     * beginning of this IndexSequence, that is, the Element returned by the
     * first call to {@link ReplaceIndexSequenceIterator#next()} is the Element
     * stored at {@link #getMinimumIndex()}.
     * 
     * @return ReplaceIndexSequenceIterator over this IndexSequence initially
     *         pointing to the beginning of this IndexSequence
     */
    @Override
    public ReplaceIndexSequenceIterator<Element> createIterator();

    /**
     * Returns an ReplaceIndexSequenceIterator traversing the Elements of this
     * IndexSequence in proper sequence. That is, the Element returned by the
     * first call to {@link ReplaceIndexSequenceIterator#next()} is the Element
     * stored at the specified start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Element returned by the
     *        Iterator
     * 
     * @return ReplaceIndexSequenceIterator over this IndexSequence initially
     *         pointing to the beginning of this IndexSequence
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getMinimumIndex() || startIndex > getMaximumIndex()}
     */
    @Override
    public ReplaceIndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException;
}
