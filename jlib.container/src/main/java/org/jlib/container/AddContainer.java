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

/**
 * <p>
 * Container that supports addition and removal of Items.
 * </p>
 * <p>
 * Note: In jlib, {@code null} is not a value. Hence, {@link Container
 * Containers} may <em>not</em> contain {@code null} items.
 * </p>
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * 
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
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of an Item in {@code items} prevents it to be
     *         added
     */
    public void add(final Container<? extends Item> items)
    throws IllegalContainerArgumentException;

    /**
     * Adds all Items contained by the specified {@link Collection} to this
     * {@link AddContainer}.
     * 
     * @param items
     *        {@link Collection} containing the Items to add
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of an Item in {@code items} prevents it to be
     *         added
     */
    public void add(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException;

    /**
     * Adds all specified Items to this {@link AddContainer}.
     * 
     * @param items
     *        vararg list of Items to add
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of an Item in {@code items} prevents it to be
     *         added
     */
    public void add(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerArgumentException;

    /**
     * Asserts that this {@link AddContainer} contains the specified Item. If
     * the {@link AddContainer} does not contain the Item, it is added.
     * 
     * @param item
     *        Item to add
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of {@code item} prevents it to be added
     */
    public void assertContained(final Item item)
    throws IllegalContainerArgumentException;

    /**
     * Asserts that this {@link AddContainer} contains all Items contained by
     * the specified {@link Container} to this {@link AddContainer}.
     * 
     * @param items
     *        {@link Container} containing the Items to add
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of an Item in {@code items} prevents it to be
     *         added
     */
    public void assertContained(final Container<? extends Item> items)
    throws IllegalContainerArgumentException;

    /**
     * Asserts that this {@link AddContainer} contains all Items contained by
     * the specified {@link Collection} to this {@link AddContainer}.
     * 
     * @param items
     *        {@link Collection} containing the Items to add
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of {@code item} prevents it to be added
     */
    public void assertContained(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException;

    /**
     * Asserts that this {@link AddContainer} contains all specified Items to
     * this {@link AddContainer}.
     * 
     * @param items
     *        vararg list of Items to add
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of {@code item} prevents it to be added
     */
    public void assertContained(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerArgumentException;
}
