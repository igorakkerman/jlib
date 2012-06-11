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

import org.jlib.core.traverser.Traversible;

/**
 * Container of items.
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * 
 * @author Igor Akkerman
 */
public interface Container<Item>
extends Traversible<Item>, Iterable<Item> {

    /**
     * Returns the number of Items in this {@link Container}.
     * 
     * @return integer specifying the number of Items in this {@link Container}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public int getItemsCount()
    throws IllegalContainerStateException;

    /**
     * Verifies whether this {@link Container} contains no Items.
     * 
     * @return {@code true} if this {@link Container} contains no Items;
     *         {@code false} otherwise
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public boolean isEmpty()
    throws IllegalContainerStateException;

    /**
     * Verifies whether this {@link Container} contains the specified Object.
     * 
     * @param item
     *        Item to verify
     * 
     * @return {@code true} if this {@link Container} contains {@code object};
     *         {@code false} otherwise
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public boolean contains(final Item item)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Verifies whether this {@link Container} contains all of the Items in the
     * specified Container.
     * 
     * @param items
     *        Container containing the Items to verify
     * 
     * @return {@code true} if this {@link Container} contains all of the Items
     *         contained by {@code otherContainer}; {@code false} otherwise
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public boolean containsAll(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Verifies whether this {@link Container} contains all of the Items in the
     * specified Collection.
     * 
     * @param items
     *        {@link Collection} containing the Items to verify
     * 
     * @return {@code true} if this {@link Container} contains all of the Items
     *         contained by {@code collection}; {@code false} otherwise
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public boolean containsAll(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Verifies whether this {@link Container} contains all of the specified
     * Items.
     * 
     * @param items
     *        comma separated sequence of Items to verify
     * 
     * @return {@code true} if this {@link Container} contains all of the
     *         {@code objects}; {@code false} otherwise
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public boolean containsAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Returns a Collection containing all of the Items of this
     * {@link Container} in the proper order as returned by this
     * {@link Container}'s Traverser.
     * 
     * @return {@link Collection} containing all of the Items of this
     *         {@link Container}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public Collection<Item> toCollection()
    throws IllegalContainerStateException;

    /**
     * Returns an array containing all of the Items of this {@link Container} in
     * the proper order as returned by this {@link Container}'s Traverser.
     * 
     * @return array containing all of the Items of this {@link Container}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public Item[] toArray()
    throws IllegalContainerStateException;
}