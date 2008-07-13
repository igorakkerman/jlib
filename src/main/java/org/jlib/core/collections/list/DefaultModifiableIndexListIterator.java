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
 * EditableIndexListIterator over a ModifiableIndexList.
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public class DefaultModifiableIndexListIterator<Element>
extends DefaultEditableIndexListIterator<Element>
implements ModifiableIndexListIterator<Element> {

    /** EditableIndexList traversed by this Iterator */
    private ModifiableIndexList<Element> list;

    /** ready for modifying operation (add/remove) */
    private boolean modificationReady;

    /**
     * Creates a new DefaultModifiableIndexListIterator for the specified
     * ModifiableIndexList.
     *
     * @param list
     *        ModifiableIndexList to traverse
     */
    protected DefaultModifiableIndexListIterator(ModifiableIndexList<Element> list) {
        super(list);
        this.list = list;
    }

    /**
     * Creates a new DefaultModifiableIndexListIterator for the specified
     * ModifiableIndexList.
     *
     * @param list
     *        ModifiableIndexList to traverse
     * @param startIndex
     *        integer specifying the start index of the traversal
     * @throws IndexOutOfBoundsException
     *         if {@code startIndex < matrix.minIndex() || matrix.maxIndex > startIndex}
     */
    protected DefaultModifiableIndexListIterator(ModifiableIndexList<Element> list, int startIndex)
    throws IndexOutOfBoundsException {
        super(list, startIndex);
        this.list = list;
    }

    // @see org.jlib.core.collections.list.ModifiableListIterator#add(java.lang.Object)
    public void add(Element element)
    throws IllegalStateException {
        if (!modificationReady)
            throw new IllegalStateException();

        list.add(nextElementIndex ++, element);

        modificationReady = false;
    }

    // @see org.jlib.core.collections.list.ModifiableListIterator#remove()
    public void remove() {
        if (!modificationReady)
            throw new IllegalStateException();

        list.remove(lastRetreivedElementIndex());

        modificationReady = false;
    }

    // @see
    // org.jlib.core.collections.list.DefaultEditableIndexListIterator#next()
    @Override
    public Element next() {
        // this order in case of an exception
        Element nextElement = super.next();
        modificationReady = true;
        return nextElement;
    }

    // @see
    // org.jlib.core.collections.list.DefaultEditableIndexListIterator#previous()
    @Override
    public Element previous() {
        // this order in case of an exception
        Element previousElement = super.previous();
        modificationReady = true;
        return previousElement;
    }
}
