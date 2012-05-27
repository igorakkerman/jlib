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
public interface RemoveContainer<Item>
extends Container<Item> {

    /**
     * Removes the specified Item of this {@link RemoveContainer}.
     * 
     * @param item
     *        Item to remove
     * @throws IllegalArgumentException
     *         if this {@link RemoveContainer} does not contain {@code Item}
     */
    public void remove(final Item item)
    throws IllegalArgumentException;

    /**
     * Removes all Items of this {@link RemoveContainer}.
     */
    public void removeAll();

    /**
     * Removes all Items contained by the specified {@link Container} from this
     * {@link RemoveContainer}.
     * 
     * @param items
     *        {@link Container} containing the Items to remove
     */
    public void removeAll(final Container<? extends Item> items);

    /**
     * Removes all Items contained by the specified {@link Collection} from this
     * {@link RemoveContainer}.
     * 
     * @param items
     *        {@link Collection} containing the Items to remove
     */
    public void removeAll(final Collection<? extends Item> items);

    /**
     * Removes all Items provided by the specified {@link Iterable} from this
     * {@link AddContainer}.
     * 
     * @param items
     *        {@link Iterable} providing the Items to remove
     */
    public void removeAll(final Iterable<? extends Item> items);

    /**
     * Removes all specified Items from this {@link RemoveContainer}.
     * 
     * @param items
     *        vararg list of Items to remove
     */
    public void removeAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items);

    /**
     * Removes all Items from this {@link RemoveContainer} <i>except</i> the
     * Items contained by the specified {@link Container}.
     * 
     * @param items
     *        {@link Container} containing the Items to retain
     */
    public void retainAll(final Container<? extends Item> items);

    /**
     * Removes all Items from this {@link RemoveContainer} <i>except</i> the
     * Items contained by the specified {@link Collection}.
     * 
     * @param items
     *        {@link Collection} containing the Items to retain
     */
    public void retainAll(final Collection<? extends Item> items);

    /**
     * Removes all Items from this {@link RemoveContainer} <i>except</i> the
     * specified Items.
     * 
     * @param items
     *        vararg list of Items to retain
     */
    public void retainAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items);

    /**
     * Creates a new {@link RemoveTraverser} over this {@link RemoveContainer}.
     * 
     * @return newly created {@link RemoveTraverser}
     */
    @Override
    public RemoveTraverser<Item> createTraverser();
}
