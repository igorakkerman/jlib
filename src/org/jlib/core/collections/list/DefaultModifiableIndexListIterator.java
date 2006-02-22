/*
 * jlib - The Free Java Library
 *
 *    http://www.jlib.org
 *
 * File:    DefaultModifiableIndexListIterator.java
 * Project: jlib.core
 *
 * Copyright (c) 2006 Igor Akkerman
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
 *        type of the elements held in the IndexList
 * @author Igor Akkerman
 */
public class DefaultModifiableIndexListIterator<Element>
extends DefaultEditableIndexListIterator<Element>
implements ModifiableIndexListIterator<Element> {

    /** EditableIndexList traversed by this Iterator */
    private ModifiableIndexList<Element> list;

    /** ready for modifying operation (add/remove) */
    private boolean modificationReady;

    /** no default constructor */
    private DefaultModifiableIndexListIterator() {
        super(new Array<Element>());
    }

    /**
     * Creates a new DefaultModifiableIndexListIterator for the specified
     * ModifiableIndexList.
     *
     * @param list
     *        ModifiableIndexList to traverse
     */
    public DefaultModifiableIndexListIterator(ModifiableIndexList<Element> list) {
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
    public DefaultModifiableIndexListIterator(ModifiableIndexList<Element> list, int startIndex)
    throws IndexOutOfBoundsException {
        super(list, startIndex);
        this.list = list;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalStateException
     *         if {@code next()} or {@code prev()} have not been called initially or after
     *         the last call to {@code add} or {@code remove()}
     */
    public void add(Element element)
    throws IllegalStateException {
        if (!modificationReady)
            throw new IllegalStateException();

        list.add(nextElementIndex ++, element);

        modificationReady = false;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalStateException
     *         if {@code next()} or {@code prev()} have not been called initially or after
     *         the last call to {@code add} or {@code remove()}
     */
    @Override
    public void remove() {
        if (!modificationReady)
            throw new IllegalStateException();

        list.remove(getLastRetreivedElementIndex());

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