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
 * Skeletal implementation of an EditableIndexList.
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public abstract class AbstractEditableIndexList<Element>
extends AbstractIndexList<Element>
implements EditableIndexList<Element> {

    /**
     * Creates a new AbstractEditableIndexList initialized as empty.
     */
    protected AbstractEditableIndexList() {
        super();
    }

    /**
     * Creates a new AbstractEditableIndexList initialized with the correct values for
     * minimum and maximum indices. Classes extending this class must initialize the
     * Element store.
     *
     * @param minIndex
     *        integer specifying the minimum index of this List
     * @param maxIndex
     *        integer specifying the maximum index of this List
     * @throws IllegalArgumentException
     *         if {@code  minIndex < 0 || minIndex > maxIndex}
     */
    protected AbstractEditableIndexList(int minIndex, int maxIndex)
    throws IllegalArgumentException {
        super(minIndex, maxIndex);
    }

    // @see org.jlib.core.collections.list.EditableList#editableListIterator()
    public EditableListIterator<Element> editableListIterator() {
        return editableIndexListIterator();
    }

    // @see org.jlib.core.collections.list.EditableList#editableListIterator()
    public EditableIndexListIterator<Element> editableIndexListIterator() {
        return editableIndexListIterator(minIndex);
    }

    // @see org.jlib.core.collections.list.EditableList#editableListIterator()
    public EditableIndexListIterator<Element> editableIndexListIterator(int startIndex) {
        return new DefaultEditableIndexListIterator<Element>(this, startIndex);
    }
}
