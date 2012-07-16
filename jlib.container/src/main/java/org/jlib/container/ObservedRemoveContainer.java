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

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.ObservedRemoveTraverser;

/**
 * {@link RemoveContainer} allowing its remove operations to be attended by
 * {@link ValueObserver} instances.
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * 
 * @author Igor Akkerman
 */
public interface ObservedRemoveContainer<Item>
extends RemoveContainer<Item> {

    /**
     * Removes all Items from this {@link ObservedRandomAccessRemoveContainer}
     * <em>except</em> the Items contained by the specified {@link Container}.
     * 
     * @param items
     *        {@link Container} containing the Items to retain
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     * 
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SuppressWarnings("unchecked")
    public void retain(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException;

    /**
     * Removes all Items from this {@link ObservedRandomAccessRemoveContainer}
     * <em>except</em> the Items contained by the specified {@link Collection}.
     * 
     * @param items
     *        {@link Collection} containing the Items to retain
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     * 
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException;

    /**
     * Removes all Items from this {@link ObservedRandomAccessRemoveContainer}
     * <em>except</em> the specified Items.
     * 
     * @param observers
     *        array of {@link ValueObserver} instances attending the removal
     * 
     * @param items
     *        comma separated sequence of Items to retain
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     * 
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SuppressWarnings("unchecked")
    public void retain(ValueObserver<Item>[] observers, final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException;

    /**
     * @eturn {@link ObservedRemoveTraverser} traversing the Items of this
     *        {@link ObservedRemoveContainer}
     */
    @Override
    public ObservedRemoveTraverser<Item> createTraverser();
}
