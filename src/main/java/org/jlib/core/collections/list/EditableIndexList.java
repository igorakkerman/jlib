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

package org.jlib.core.collections.list;

/**
 * IndexList that allows its Elements to be modified.
 * 
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public interface EditableIndexList<Element>
extends EditableList<Element>, IndexList<Element> {

    /**
     * Stores the specified Element at the specified index in this IndexList.
     * 
     * @param index
     *        integer specifying the index
     * @param element
     *        Element to store
     * @return Element formerly stored at {@code index}
     * @throws ListIndexOutOfBoundsException
     *         if {@code index < getMinIndex() || index > getMaxIndex()}
     */
    public Element set(int index, Element element)
    throws ListIndexOutOfBoundsException;

    /**
     * Returns an EditableIndexListIterator traversing the Elements of this
     * IndexList in proper sequence. Initially, the Iterator points to the
     * beginning of this IndexList, that is, the Element returned by the first
     * call to {@link EditableIndexListIterator#next()} is the Element stored at
     * {@link #minIndex()}.
     * 
     * @return EditableIndexListIterator over this IndexList initially pointing
     *         to the beginning of this IndexList
     */
    public EditableIndexListIterator<Element> editableIndexListIterator();

    /**
     * Returns an EditableIndexListIterator traversing the Elements of this
     * IndexList in proper sequence. That is, the Element returned by the first
     * call to {@link EditableIndexListIterator#next()} is the Element stored at
     * the specified start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Element returned by the
     *        Iterator
     * @return EditableIndexListIterator over this IndexList initially pointing
     *         to the beginning of this IndexList
     * @throws ListIndexOutOfBoundsException
     *         if {@code startIndex < minIndex() || startIndex > maxIndex()}
     */
    public EditableIndexListIterator<Element> editableIndexListIterator(int startIndex)
    throws ListIndexOutOfBoundsException;
}
