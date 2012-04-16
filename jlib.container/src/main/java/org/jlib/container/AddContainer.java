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
public interface AddContainer<Element>
extends Container<Element> {

    /**
     * Adds the specified Element to this {@link AddContainer}.
     * 
     * @param element
     *        Element to add
     * @throws IllegalArgumentException
     *         if {@code element} cannot be added, for instance, if this
     *         {@link AddContainer} does not allow the multiple addition
     *         of an Element and already contains {@code element}
     */
    public void add(final Element element);

    /**
     * Adds all Elements contained by the specified {@link Container} to this
     * {@link AddContainer}.
     * 
     * @param elements
     *        {@link Container} containing the Elements to add
     */
    public void addAll(final Container<? extends Element> elements);

    /**
     * Adds all Elements contained by the specified {@link Collection} to this
     * {@link AddContainer}.
     * 
     * @param elements
     *        {@link Collection} containing the Elements to add
     */
    public void addAll(final Collection<? extends Element> elements);

    /**
     * Adds all specified Elements to this {@link AddContainer}.
     * 
     * @param elements
     *        vararg list of Elements to add
     */
    public void addAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Element... elements);
}
