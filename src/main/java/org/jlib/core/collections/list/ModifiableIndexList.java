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

import java.util.Collection;

/**
 * EditableIndexList that allows Elements to be added and removed.
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public interface ModifiableIndexList<Element>
extends EditableIndexList<Element>, ModifiableList<Element> {

    /**
     * Returns a ModifiableIndexListIterator traversing the Elements of this
     * List in proper sequence. Initially, the Iterator points to the beginning
     * of this List, that is, the Element returned by the first call to
     * {@code nextIndex()} is the Element stored at {@code getMinIndex()}.
     *
     * @return ModifiableIndexListIterator over this IndexList initially
     *         pointing to the beginning of this List
     */
    public ModifiableIndexListIterator<Element> modifiableIndexListIterator();

    /**
     * Returns a ModifiableIndexListIterator traversing the Elements of this
     * List in proper sequence. That is, the Element returned by the first call
     * to {@code nextIndex()} is the Element stored at the specified start
     * index.
     *
     * @param startIndex
     *        integer specifying the index of the first Element returned by the
     *        Iterator
     * @return ModifiableIndexListIterator over this List initially pointing to
     *         the beginning of this List
     * @throws ListIndexOutOfBoundsException
     *         if {@code startIndex < minIndex() || startIndex > maxIndex()}
     */
    public ModifiableIndexListIterator<Element> modifiableIndexListIterator(int startIndex)
    throws ListIndexOutOfBoundsException;

    /**
     * Inserts the specified Element at the specified index in this IndexList.
     *
     * @param index
     *        integer specifying the index
     * @param element
     *        Element to add
     */
    public void add(int index, Element element);

    /**
     * Inserts all Elements of the specified Collection at the specified index
     * of this IndexList. The Elements are inserted in the order they are
     * returned by the Collection's Iterator.
     *
     * @param index
     *        integer specifying the index
     * @param collection
     *        Collection holding the Elements to add
     * @return {@code true} if this IndexList changed as a result of this call,
     *         that is, if {@code collection} is not empty; {@code false}
     *         otherwise
     */
    public boolean addAll(int index, Collection<? extends Element> collection);

    /**
     * Removes from this IndexList the Element stored at the specified index.
     *
     * @param index
     *        integer specifying the index
     * @return the removed Element
     */
    public Element remove(int index);
}
