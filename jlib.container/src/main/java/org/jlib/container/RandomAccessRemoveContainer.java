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
 * {@link RemoveContainer} allowing its Items to be removed by random access to
 * each specified Item.
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * 
 * @author Igor Akkerman
 */
public interface RandomAccessRemoveContainer<Item>
extends RemoveContainer<Item> {

    /**
     * Removes the specified Item from this {@link RandomAccessRemoveContainer}.
     * 
     * @param item
     *        Item to remove
     * 
     * @throws NoSuchItemToRemoveException
     *         if this {@link RandomAccessRemoveContainer} does not contain
     *         {@code Item}
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public void remove(final Item item)
    throws NoSuchItemToRemoveException, IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Removes all Items contained by the specified {@link Container} from this
     * {@link RandomAccessRemoveContainer}.
     * 
     * @param items
     *        {@link Container} containing the Items to remove
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public void remove(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Removes all Items contained by the specified {@link Collection} from this
     * {@link RandomAccessRemoveContainer}.
     * 
     * @param items
     *        {@link Collection} containing the Items to remove
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public void remove(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Removes all Items provided by the specified {@link Iterable} from this
     * {@link RandomAccessRemoveContainer}.
     * 
     * @param items
     *        {@link Iterable} providing the Items to remove
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public void remove(final Iterable<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Removes all specified Items from this {@link RandomAccessRemoveContainer}
     * .
     * 
     * @param items
     *        comma separated sequence of Items to remove
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    public void remove(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException;
}
