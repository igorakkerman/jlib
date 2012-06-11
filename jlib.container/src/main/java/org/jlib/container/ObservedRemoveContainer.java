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
import org.jlib.core.traverser.RemoveTraverser;

/**
 * <p>
 * {@link RemoveContainer} allowing its remove operations to be attended by
 * {@link ValueObserver} instances.
 * </p>
 * <p>
 * Note: In jlib, {@code null} is not a value. Hence, {@link Container
 * Containers} may <em>not</em> contain null items
 * </p>
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * 
 * @author Igor Akkerman
 */
public interface ObservedRemoveContainer<Item>
extends RemoveContainer<Item> {

    /**
     * Removes the specified Item of this {@link RemoveContainer}.
     * 
     * @param item
     *        Item to remove
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     * 
     * @throws NoSuchItemToRemoveException
     *         if this {@link RemoveContainer} does not contain {@code Item}
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     * 
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    public void remove(final Item item,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) final ValueObserver<Item>... observers)
    throws NoSuchItemToRemoveException, IllegalContainerArgumentException, IllegalContainerStateException,
    ValueObserverException;

    /**
     * Removes all Items contained by the specified {@link Container} from this
     * {@link ObservedRemoveContainer}.
     * 
     * @param items
     *        {@link Container} containing the Items to remove
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
    public void remove(final Container<? extends Item> items,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException;

    /**
     * Removes all Items contained by the specified {@link Collection} from this
     * {@link ObservedRemoveContainer}.
     * 
     * @param items
     *        {@link Collection} containing the Items to remove
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
    public void remove(final Collection<? extends Item> items,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException;

    /**
     * Removes all Items provided by the specified {@link Iterable} from this
     * {@link ObservedRemoveContainer}.
     * 
     * @param items
     *        {@link Iterable} providing the Items to remove
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
    public void remove(final Iterable<? extends Item> items,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException;

    /**
     * Removes all specified Items from this {@link ObservedRemoveContainer}.
     * 
     * @param items
     *        comma separated sequence of Items to remove
     * 
     * @param observers
     *        array of {@link ValueObserver} instances attending the removal
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
    public void remove(ValueObserver<Item>[] observers,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException;

    /**
     * Removes all Items from this {@link ObservedRemoveContainer}
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
    public void retain(final Container<? extends Item> items,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException;

    /**
     * Removes all Items from this {@link ObservedRemoveContainer}
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
    public void retain(final Collection<? extends Item> items,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException;

    /**
     * Removes all Items from this {@link ObservedRemoveContainer}
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
    public void retain(ValueObserver<Item>[] observers,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException;

    /**
     * Creates a new {@link ObservedRemoveTraverser} over this
     * {@link ObservedRemoveContainer} with the specified {@link ValueObserver}
     * instances.
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending Item removals
     * 
     * @return newly created {@link RemoveTraverser}
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    public ObservedRemoveTraverser<Item> createTraverser(@SuppressWarnings({ "unchecked", /* "varargs" */}) ValueObserver<Item>... observers);
}
