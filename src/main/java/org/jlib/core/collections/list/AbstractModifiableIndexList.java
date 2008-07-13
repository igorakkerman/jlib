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

import java.util.Iterator;

/**
 * Skeletal implementation of a ModifiableIndexList using a random access data store.
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public abstract class AbstractModifiableIndexList<Element>
extends AbstractEditableIndexList<Element>
implements ModifiableIndexList<Element> {

    /**
     * Creates a new AbstractModifiableIndexList initialized as empty.
     */
    protected AbstractModifiableIndexList() {
        super();
    }

    /**
     * Creates a new AbstractModifiableIndexList initialized with the correct values for
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
    protected AbstractModifiableIndexList(int minIndex, int maxIndex)
    throws IllegalArgumentException {
        super(minIndex, maxIndex);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The returned Iterator supports the {@code remove()} operation.
     * </p>
     */
    @Override
    public Iterator<Element> iterator() {
        return modifiableIndexListIterator();
    }

    // @see org.jlib.core.collections.list.ModifiableIndexList#modifiableIndexListIterator()
    @Override
    public ModifiableIndexListIterator<Element> modifiableIndexListIterator() {
        return modifiableIndexListIterator(minIndex);
    }

    // @see org.jlib.core.collections.list.ModifiableIndexList#modifiableIndexListIterator(int)
    @Override
    public ModifiableIndexListIterator<Element> modifiableIndexListIterator(int startIndex) {
        return new DefaultModifiableIndexListIterator<Element>(this, startIndex);
    }
}
