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

package org.jlib.core.collections.list;

import java.util.NoSuchElementException;

/**
 * IndexListIterator traversing the Elements in the proper order.
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public class DefaultIndexListIterator<Element>
implements IndexListIterator<Element> {

    /** IndexList to traverse */
    private IndexList<Element> list;

    /** index of the next Element in the IndexList */
    protected int nextElementIndex;

    /** index of last retrieved Element */
    private int lastRetreivedElementIndex;

    /**
     * Creates a new DefaultIndexListIterator over the Elements of the specified
     * EditableIndexList.
     *
     * @param list
     *        IndexList to traverse
     */
    protected DefaultIndexListIterator(IndexList<Element> list) {
        this(list, list.minIndex());
    }

    /**
     * Creates a new DefaultEditableIndexListIterator over the Elements of the specified
     * IndexList starting the traversal at the specified index.
     *
     * @param list
     *        EditableIndexList to traverse
     * @param startIndex
     *        integer specifying the start index of the traversal
     * @throws ListIndexOutOfBoundsException
     *         if {@code startIndex < minIndex() || startIndex > maxIndex()}
     */
    protected DefaultIndexListIterator(IndexList<Element> list, int startIndex)
    throws ListIndexOutOfBoundsException {
        super();
        this.list = list;
        nextElementIndex = startIndex;
        lastRetreivedElementIndex = -1;
    }

    // @see org.jlib.core.collections.list.ListIterator#hasNext()
    @Override
    public boolean hasNext() {
        return nextIndex() <= list.maxIndex();
    }

    // @see org.jlib.core.collections.list.ListIterator#next()
    @Override
    public Element next()
    throws NoSuchElementException {
        if (!hasNext())
            throw new NoSuchElementException();

        lastRetreivedElementIndex = nextElementIndex;

        return list.get(nextElementIndex ++);
    }

    // @see org.jlib.core.collections.list.ListIterator#hasPrevious()
    @Override
    public boolean hasPrevious() {
        return previousIndex() >= list.minIndex();
    }

    // @see org.jlib.core.collections.list.ListIterator#previous()
    @Override
    public Element previous()
    throws NoSuchElementException {
        if (!hasPrevious())
            throw new NoSuchElementException();

        lastRetreivedElementIndex = -- nextElementIndex;

        return list.get(nextElementIndex);
    }

    // @see org.jlib.core.collections.list.IndexListIterator#previousIndex()
    @Override
    public int previousIndex() {
        return nextElementIndex - 1;
    }

    // @see org.jlib.core.collections.list.IndexListIterator#nextIndex()
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
        return lastRetreivedElementIndex;
    }
}
