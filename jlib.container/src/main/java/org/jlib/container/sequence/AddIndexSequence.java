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

import org.jlib.container.Container;

/**
 * {@link ReplaceIndexSequence} that allows Elements to be added and removed.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface AddIndexSequence<Element>
extends AddSequence<Element>, IndexSequence<Element> {

    /**
     * Returns a AddIndexSequenceIterator traversing the Elements of this
     * Sequence in proper sequence. Initially, the Iterator points to the
     * beginning of this Sequence, that is, the Element returned by the first
     * call to {@link AddIndexSequenceIterator#next()} is the Element stored at
     * {@link #getFirstIndex()}.
     * 
     * @return AddIndexSequenceIterator over this IndexSequence initially
     *         pointing to the beginning of this Sequence
     */
    @Override
    public AddIndexSequenceIterator<Element> createIterator();

    /**
     * Returns a AddIndexSequenceIterator traversing the Elements of this
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
    public AddIndexSequenceIterator<Element> createIterator(int startIndex)
    throws SequenceIndexOutOfBoundsException;

    /**
     * Inserts the specified Element at the specified index in this
     * IndexSequence.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param element
     *        Element to add
     */
    public void add(int index, Element element);

    /**
     * Inserts all Elements of the specified Container at the specified index of
     * this IndexSequence. The Elements are inserted in the order they are
     * returned by the Container's Iterator.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param elements
     *        Container holding the Elements to add
     */
    public void addAll(int index, Container<? extends Element> elements);
}
