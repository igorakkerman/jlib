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
 * {@link Object} to which Items can be appended.
 * 
 * @param <Item>
 *        type of the appendable items
 * 
 * @author Igor Akkerman
 */
public interface AppendAware<Item> {

    /**
     * Appends the specified Item to this {@link AppendAware}.
     * 
     * @param item
     *        Item to append
     * 
     * @throws IllegalJlibArgumentException
     *         if some property of {@code item} prevents it from being appended
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void append(final Item item)
    throws IllegalJlibArgumentException, IllegalJlibStateException;

    /**
     * Appends all Items contained by the specified {@link Container} to this
     * {@link AppendAware}.
     * 
     * @param items
     *        {@link Container} containing the Items to append
     * 
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being appended
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void append(final Container<? extends Item> items)
    throws IllegalJlibArgumentException, IllegalJlibStateException;

    /**
     * Appends all Items contained by the specified {@link Collection} to this
     * {@link AppendAware}.
     * 
     * @param items
     *        {@link Collection} containing the Items to append
     * 
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being appended
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void append(final Collection<? extends Item> items)
    throws IllegalJlibArgumentException, IllegalJlibStateException;

    /**
     * Appends all specified Items to this {@link AppendAware}.
     * 
     * @param items
     *        comma separated sequence of Items to append
     * 
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being appended
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    public void append(final Item... items)
    throws IllegalJlibArgumentException, IllegalJlibStateException;
}
