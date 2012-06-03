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
 * Container that supports addition and removal of Items.
 * </p>
 * <p>
 * Note: In jlib, {@code null} is not a value. Hence, {@link Container
 * Containers} may <em>not</em> contain null items
 * </p>
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * @author Igor Akkerman
 */
public interface AddContainer<Item>
extends Container<Item> {

    /**
     * Adds the specified Item to this {@link AddContainer}.
     * 
     * @param item
     *        Item to add
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of {@code item} prevents it to be added
     */
    public void add(final Item item)
    throws IllegalContainerArgumentException;

    /**
     * Adds all Items contained by the specified {@link Container} to this
     * {@link AddContainer}.
     * 
     * @param items
     *        {@link Container} containing the Items to add
     * 
     * @throws IllegalContainerArgumentException
     *         if {@code items}
     */
    public void addAll(final Container<? extends Item> items);

    /**
     * Adds all Items contained by the specified {@link Collection} to this
     * {@link AddContainer}.
     * 
     * @param items
     *        {@link Collection} containing the Items to add
     */
    public void addAll(final Collection<? extends Item> items);

    /**
     * Adds all specified Items to this {@link AddContainer}.
     * 
     * @param items
     *        vararg list of Items to add
     */
    public void addAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items);
}
