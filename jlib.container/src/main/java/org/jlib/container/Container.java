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
 * Container of items.
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * 
 * @author Igor Akkerman
 */
//TODO: add operations passing ModificationListeners to the methods
//TODO: Container don't have Items, they have Items. Sets have Items!
public interface Container<Item>
extends Traversible<Item>, Iterable<Item> {

    /**
     * Returns the number of Items in this Container.
     * 
     * @return integer specifying the number of Items in this Container
     */
    public int getSize();

    /**
     * Verifies whether this Container contains no Items.
     * 
     * @return {@code true} if this Container contains no Items; {@code false}
     *         otherwise
     */
    public boolean isEmpty();

    /**
     * Verifies whether this Container contains the specified Object.
     * 
     * @param item
     *        Item to verify
     * @return {@code true} if this Container contains {@code object};
     *         {@code false} otherwise
     */
    public boolean contains(final Item item);

    /**
     * Verifies whether this Container contains all of the Items in the
     * specified Container.
     * 
     * @param items
     *        Container containing the Items to verify
     * @return {@code true} if this Container contains all of the Items
     *         contained by {@code otherContainer}; {@code false} otherwise
     */
    public boolean containsAll(final Container<? extends Item> items);

    /**
     * Verifies whether this Container contains all of the Items in the
     * specified Collection.
     * 
     * @param items
     *        Collection containing the Items to verify
     * @return {@code true} if this Container contains all of the Items
     *         contained by {@code collection}; {@code false} otherwise
     */
    public boolean containsAll(final Collection<? extends Item> items);

    /**
     * Verifies whether this Container contains all of the specified Items.
     * 
     * @param items
     *        comma separated sequence of Items to verify
     * @return {@code true} if this Container contains all of the
     *         {@code objects}; {@code false} otherwise
     */
    public boolean containsAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items);

    /**
     * Returns a Collection containing all of the Items of this Container in the
     * proper order as returned by this Container's Traverser.
     * 
     * @return {@link Collection} containing all of the Items of this Container
     */
    public Collection<Item> toCollection();

    /**
     * Returns an array containing all of the Items of this Container in the
     * proper order as returned by this Container's Traverser.
     * 
     * TODO: where can toArray() be overridden for optimization
     * 
     * @return array containing all of the Items of this Container
     */
    public Item[] toArray();
}
