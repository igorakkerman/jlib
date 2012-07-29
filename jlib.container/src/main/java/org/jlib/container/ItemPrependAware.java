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

import org.jlib.core.IllegalJlibArgumentException;
import org.jlib.core.IllegalJlibStateException;

/**
 * {@link Object} to which Items can be prepended.
 * 
 * @param <Item>
 *        type of the prependable items
 * 
 * @author Igor Akkerman
 */
public interface ItemPrependAware<Item> {

    /**
     * Prepends the specified Item to this {@link ItemPrependAware}.
     * 
     * @param item
     *        Item to prepend
     * 
     * @throws IllegalJlibArgumentException
     *         if some property of {@code item} prevents it from being prepended
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void prepend(final Item item)
    throws IllegalJlibArgumentException, IllegalJlibStateException;

    /**
     * Prepends all Items contained by the specified {@link Container} to this
     * {@link ItemPrependAware}.
     * 
     * @param items
     *        {@link Container} containing the Items to prepend
     * 
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void prepend(final Container<? extends Item> items)
    throws IllegalJlibArgumentException, IllegalJlibStateException;

    /**
     * Prepends all Items contained by the specified {@link Collection} to this
     * {@link ItemPrependAware}.
     * 
     * @param items
     *        {@link Collection} containing the Items to prepend
     * 
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void prepend(final Collection<? extends Item> items)
    throws IllegalJlibArgumentException, IllegalJlibStateException;

    /**
     * Prepends all specified Items to this {@link ItemPrependAware}.
     * 
     * @param items
     *        comma separated sequence of Items to prepend
     * 
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    public void prepend(final Item... items)
    throws IllegalJlibArgumentException, IllegalJlibStateException;
}
