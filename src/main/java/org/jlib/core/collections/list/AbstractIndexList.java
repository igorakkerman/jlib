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

import java.util.ArrayList;

/**
 * Skeletal implementation of the IndexList interface.
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public abstract class AbstractIndexList<Element>
extends AbstractList<Element>
implements IndexList<Element> {

    /** current minimum index of this list */
    protected int minIndex;

    /** current maximum index of this list */
    protected int maxIndex;

    /**
     * Creates a new AbstractIndexList initialized as empty.
     */
    protected AbstractIndexList() {
        super();
        minIndex = -1;
        maxIndex = -2;
        // now the size can be computed by maxIndex - minIndex + 1 == 0
    }

    /**
     * Creates a new AbstractIndexList initialized with the correct values for minimum and maximum
     * indices. Classes extending this class must initialize the Element store.
     *
     * @param minIndex
     *        integer specifying the minimum index of this List
     * @param maxIndex
     *        integer specifying the maximum index of this List
     * @throws IllegalArgumentException
     *         if {@code  minIndex < 0 || minIndex > maxIndex}
     */
    protected AbstractIndexList(int minIndex, int maxIndex) {
        super();
        if (minIndex < 0 || minIndex > maxIndex)
            throw new IllegalArgumentException();

        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    // @see org.jlib.core.collections.list.IndexList#minIndex()
    public int minIndex() {
        return minIndex;
    }

    // @see org.jlib.core.collections.list.IndexList#maxIndex()
    public int maxIndex() {
        return maxIndex;
    }

    // @see org.jlib.core.collections.Collection#size()
    @Override
    public int size() {
        return maxIndex - minIndex + 1;
    }

    // @see org.jlib.core.collections.list.IndexList#indexOf(java.lang.Object)
    public int indexOf(Element element) {
        Element listElement;
        for (int index = minIndex; index <= maxIndex; index ++) {
            listElement = get(index);
            if (listElement == element || listElement != null && listElement.equals(element))
                return index;
        }
        return -1;
    }

    // @see org.jlib.core.collections.list.IndexList#lastIndexOf(java.lang.Object)
    public int lastIndexOf(Element element) {
        Element listElement;
        for (int index = maxIndex; index >= minIndex; index --) {
            listElement = get(index);
            if (listElement == element || listElement != null && listElement.equals(element))
                return index;
        }
        return -1;
    }

    // @see org.jlib.core.collections.list.IndexList#indexListIterator()
    public IndexListIterator<Element> indexListIterator() {
        return indexListIterator(minIndex);
    }

    // @see org.jlib.core.collections.list.IndexList#indexListIterator(int)
    public IndexListIterator<Element> indexListIterator(int startIndex)
    throws ListIndexOutOfBoundsException {
        return new DefaultIndexListIterator<Element>(this, startIndex);
    }

    // @see org.jlib.core.collections.list.List#listIterator()
    public ListIterator<Element> listIterator() {
        return indexListIterator();
    }

    // @see org.jlib.core.collections.list.IndexList#subJavaList(int, int)
    public java.util.List<Element> subJavaList(int fromIndex, int toIndex)
    throws IllegalArgumentException, ListIndexOutOfBoundsException {
        if (fromIndex > toIndex)
            throw new IllegalArgumentException();

        java.util.List<Element> list = new ArrayList<Element>(size());
        for (int index = fromIndex; index <= toIndex; index ++)
            list.add(get(index));

        return list;
    }

    // @see org.jlib.core.collections.list.IndexList#subIndexList(int, int)
    public IndexList<Element> subList(int fromIndex, int toIndex)
    throws IllegalArgumentException, ListIndexOutOfBoundsException {
        if (fromIndex > toIndex)
            throw new IllegalArgumentException();

        EditableIndexList<Element> list = new Array<Element>(fromIndex, toIndex);
        for (int index = fromIndex; index <= toIndex; index ++)
            list.set(index, get(index));

        return list;
    }

    // @see java.lang.Object#toString()
    @Override
    public String toString() {
        IndexListIterator<Element> iterator = indexListIterator();
        boolean hasNext = iterator.hasNext();

        StringBuffer stringBuffer = new StringBuffer(8 * size());

        stringBuffer.append('[');
        while (hasNext) {
            stringBuffer.append(iterator.nextIndex());
            stringBuffer.append('=');
            stringBuffer.append(iterator.next());
            hasNext = iterator.hasNext();
            if (hasNext)
                stringBuffer.append(", ");
        }
        stringBuffer.append(']');

        return stringBuffer.toString();
    }
}
