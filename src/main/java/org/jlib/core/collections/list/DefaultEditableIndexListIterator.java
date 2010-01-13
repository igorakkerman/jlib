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

/**
 * Iterator over an EditableIndexList using a random access data store.
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public class DefaultEditableIndexListIterator<Element>
extends DefaultIndexListIterator<Element>
implements EditableIndexListIterator<Element> {

    /** EditableIndexList traversed by this Iterator */
    private EditableIndexList<Element> list;

    /**
     * Creates a new DefaultEditableIndexListIterator over the Elements of the specified
     * EditableIndexList.
     *
     * @param list
     *        EditableIndexList to traverse
     */
    protected DefaultEditableIndexListIterator(EditableIndexList<Element> list) {
        this(list, list.minIndex());
    }

    /**
     * Creates a new DefaultEditableIndexListIterator over the Elements of the specified IndexList
     * starting the traversal at the specified index.
     *
     * @param list
     *        EditableIndexList to traverse
     * @param startIndex
     *        integer specifying the start index of the traversal
     * @throws IndexOutOfBoundsException
     *         if {@code startIndex < matrix.minIndex() || matrix.maxIndex > startIndex}
     */
    protected DefaultEditableIndexListIterator(EditableIndexList<Element> list, int startIndex)
    throws IndexOutOfBoundsException {
        super(list, startIndex);
        this.list = list;
    }

    // @see org.jlib.core.collections.list.EditableListIterator#set(java.lang.Object)
    @Override
    public void set(Element element) {
        list.set(lastRetreivedElementIndex(), element);
    }
}
