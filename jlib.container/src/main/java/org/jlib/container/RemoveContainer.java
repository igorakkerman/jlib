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

// TODO: add operations passing ModificationListeners to the methods

/**
 * <p>
 * Container that supports addition and removal of Elements.
 * </p>
 * <p>
 * Note: In jlib, {@code null} is not a value. Hence, {@link Container
 * Containers} may <em>not</em> contain null elements
 * </p>
 * 
 * @param <Element>
 *        type of elements held in the {@link Container}
 * @author Igor Akkerman
 */
public interface RemoveContainer<Element>
extends Container<Element> {

    /**
     * Removes the specified Element of this {@link RemoveContainer}.
     * 
     * @param element
     *        Element to remove
     * @throws IllegalArgumentException
     *         if this {@link RemoveContainer} does not contain
     *         {@code Element}
     */
    public void remove(final Element element)
    throws IllegalArgumentException;

    /**
     * Removes all Elements of this {@link RemoveContainer}.
     */
    public void removeAll();

    /**
     * Removes all Elements contained by the specified {@link Container} from
     * this {@link RemoveContainer}.
     * 
     * @param elements
     *        {@link Container} containing the Elements to remove
     */
    public void removeAll(final Container<? extends Element> elements);

    /**
     * Removes all Elements contained by the specified {@link Collection} from
     * this {@link RemoveContainer}.
     * 
     * @param elements
     *        {@link Collection} containing the Elements to remove
     */
    public void removeAll(final Collection<? extends Element> elements);

    /**
     * Removes all specified Elements from this {@link RemoveContainer}.
     * 
     * @param elements
     *        vararg list of Elements to remove
     */
    public void removeAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Element... elements);

    /**
     * Removes all Elements from this {@link RemoveContainer} <i>except</i>
     * the Elements contained by the specified {@link Container}.
     * 
     * @param elements
     *        {@link Container} containing the Elements to retain
     */
    public void retainAll(final Container<? extends Element> elements);

    /**
     * Removes all Elements from this {@link RemoveContainer} <i>except</i>
     * the Elements contained by the specified {@link Collection}.
     * 
     * @param elements
     *        {@link Collection} containing the Elements to retain
     */
    public void retainAll(final Collection<? extends Element> elements);

    /**
     * Removes all Elements from this {@link RemoveContainer} <i>except</i>
     * the specified Elements.
     * 
     * @param elements
     *        vararg list of Elements to retain
     */
    public void retainAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Element... elements);

    /**
     * Creates a new {@link RemoveContainerIterator} over this
     * {@link RemoveContainer}.
     * 
     * @return newly created {@link RemoveContainerIterator}
     */
    @Override
    public RemoveContainerIterator<Element> createIterator();
}
