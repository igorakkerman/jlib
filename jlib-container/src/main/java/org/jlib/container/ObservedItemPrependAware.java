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
import org.jlib.core.observer.ValueObserver;

/**
 * {@link ItemPrependAware} to which Items can be prepended.
 * 
 * @param <Item>
 *        type of the prepended Items
 * 
 * @author Igor Akkerman
 */
public interface ObservedItemPrependAware<Item>
extends ItemPrependAware<Item> {

    /**
     * Prepends the specified Item to this {@link ObservedItemPrependAware}.
     * 
     * @param item
     *        Item to prepend
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws IllegalJlibArgumentException
     *         if some property of {@code item} prevents it from being prepended
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public void prepend(final Item item, final ValueObserver<Item>... observers)
    throws IllegalJlibArgumentException, IllegalJlibStateException, RuntimeException;

    /**
     * Prepends all Items contained by the specified {@link Container} to this
     * {@link ObservedItemPrependAware}.
     * 
     * @param items
     *        {@link Container} containing the Items to prepend
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public void prepend(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalJlibArgumentException, IllegalJlibStateException, RuntimeException;

    /**
     * Prepends all Items contained by the specified {@link Collection} to this
     * {@link ObservedItemPrependAware}.
     * 
     * @param items
     *        {@link Collection} containing the Items to prepend
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public void prepend(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalJlibArgumentException, IllegalJlibStateException, RuntimeException;

    /**
     * Prepends all specified Items to this {@link ObservedItemPrependAware}.
     * 
     * @param observers
     *        array of {@link ValueObserver} instances attending the operation
     * 
     * @param items
     *        comma separated sequence of Items to prepend
     * 
     * @throws IllegalJlibArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public void prepend(ValueObserver<Item>[] observers, final Item... items)
    throws IllegalJlibArgumentException, IllegalJlibStateException, RuntimeException;
}
