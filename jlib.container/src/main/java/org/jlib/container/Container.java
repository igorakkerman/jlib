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

package org.jlib.container;

import java.util.Collection;
import java.util.Iterator;

/**
 * Container of elements.
 * 
 * @param <Element>
 *        type of elements held in the {@link Container}
 *
 * @author Igor Akkerman
 */
//TODO: add operations passing ModificationListeners to the methods
//TODO: 
public interface Container<Element>
extends Iterable<Element> {

    /**
     * Returns the number of Elements in this Container.
     * 
     * @return integer specifying the number of Elements in this Container
     */
    public int getSize();

    /**
     * Verifies whether this Container contains no Elements.
     * 
     * @return {@code true} if this Container contains no Elements;
     *         {@code false} otherwise
     */
    public boolean isEmpty();

    /**
     * Verifies whether this Container contains the specified Object.
     * 
     * @param element
     *        Element to verify
     * @return {@code true} if this Container contains {@code object};
     *         {@code false} otherwise
     */
    public boolean contains(final Element element);

    /**
     * Verifies whether this Container contains all of the Elements in the
     * specified Container.
     * 
     * @param elements
     *        Container containing the Elements to verify
     * @return {@code true} if this Container contains all of the Elements
     *         contained by {@code otherContainer}; {@code false} otherwise
     */
    public boolean containsAll(final Container<? extends Element> elements);

    /**
     * Verifies whether this Container contains all of the Elements in the
     * specified Collection.
     * 
     * @param elements
     *        Collection containing the Elements to verify
     * @return {@code true} if this Container contains all of the Elements
     *         contained by {@code collection}; {@code false} otherwise
     */
    public boolean containsAll(final Collection<? extends Element> elements);

    /**
     * Verifies whether this Container contains all of the specified Elements.
     * 
     * @param elements
     *        comma separated sequence of Elements to verify
     * @return {@code true} if this Container contains all of the
     *         {@code objects}; {@code false} otherwise
     */
    public boolean containsAll(@SuppressWarnings({"unchecked", /* "varargs" */}) final Element... elements);

    /**
     * Returns a Collection containing all of the Elements of this Container in
     * the proper order as returned by this Container's Iterator.
     * 
     * @return {@link Collection} containing all of the Elements of this Container
     */
    public Collection<Element> toCollection();

    /**
     * Returns an array containing all of the Elements of this Container in the
     * proper order as returned by this Container's Iterator.
     * 
     * TODO: where can toArray() be overridden for optimization
     * 
     * @return array containing all of the Elements of this Container
     */
    public Element[] toArray();
    
    /**
     * Creates a new {@link Iterator} over this {@link Container}.
     *
     * @return newly created {@link Iterator}
     */
    public Iterator<Element> createIterator();
}
