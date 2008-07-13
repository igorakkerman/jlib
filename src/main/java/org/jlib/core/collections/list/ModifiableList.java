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
 * EditableList that allows Elements to be added and removed.
 * 
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public interface ModifiableList<Element>
extends EditableList<Element> {

    /**
     * Appends the specified Element to the end of this List.
     * 
     * @param element
     *        Element to add
     * @return always {@code true}
     */
    public boolean add(Element element);

    /**
     * Returns a ModifiableListIterator traversing the Elements of this List in
     * proper order.
     * 
     * @return ModifiableListIterator traversing the Elements of this List in
     *         proper order
     */
    public ModifiableListIterator<Element> modifiableListIterator();

    /**
     * Appends all Elements of the specified Collection to the end of this List.
     * The Elements are appended in the order they are returned by the
     * Collection's Iterator.
     * 
     * @param collection
     *        Collection holding the Elements to add
     * @return {@code true} if this List changed as a result of this call, that
     *         is, if {@code collection} is not empty; {@code false} otherwise
     */
    public boolean addAll(Collection<? extends Element> collection);

    /**
     * Removes from this List the specified Element at its first occurrence.
     * More formally, the first {@code listElement} is removed such as
     * {@code listElement != null ? listElement.equals(element) : element == null}.
     * 
     * @param element
     *        Element to remove
     * @return {@code true} if this List changed as a result of this call, that
     *         is, if this List contains {@code element}; {@code false}
     *         otherwise
     */
    public boolean remove(Object element);

    /**
     * Removes from this List all Elements of the specified Collection. More
     * formally, for each {@code collectionElement} the first
     * {@code listElement} is removed such as
     * {@code listElement != null ? listElement.equals(collectionElement) : collectionElement == null}.
     * 
     * @param collection
     *        Collection holding the Elements to remove
     * @return {@code true} if this List changed as a result of this call, that
     *         is, if {@code collection} is not empty and at least one Element
     *         of {@code collection} equals to an Element of this List;
     *         {@code false} otherwise
     */
    public boolean removeAll(Collection<?> collection);

    /**
     * Retains in this List only the Elements contained by the specified
     * Collection. That is, all Elements that are not contained by the specified
     * Collection are removed from this List. More formally, each
     * {@code listElement} is removed if for no {@code collectionElement}
     * {@code listElement != null ? listElement.equals(collectionElement) : collectionElement == null}.
     * 
     * @param collection
     *        Collection holding the Elements to retain
     * @return {@code true} if this List changed as a result of this call, that
     *         is, if {@code collection} is not empty and at least one Element
     *         of {@code collection} is not equal to an Element of this List;
     *         {@code false} otherwise
     */
    public boolean retainAll(Collection<?> collection);

    /**
     * Removes all Elements from this List.
     */
    public void clear();
}
