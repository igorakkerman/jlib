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

import org.jlib.core.traverser.RemoveTraverser;

/**
 * <p>
 * {@link RemoveContainer} allowing its remove operations to be attended by
 * {@link RemoveObserver} instances.
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
extends Container<Item> {

    /**
     * Removes all Items from this {@link ObservedRemoveContainer}
     * <em>except</em> the Items contained by the specified {@link Container}.
     * 
     * @param items
     *        {@link Container} containing the Items to retain
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public void retain(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Removes all Items from this {@link ObservedRemoveContainer}
     * <em>except</em> the Items contained by the specified {@link Collection}.
     * 
     * @param items
     *        {@link Collection} containing the Items to retain
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public void retain(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Removes all Items from this {@link ObservedRemoveContainer}
     * <em>except</em> the specified Items.
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
     */
    public void retain(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Removes all Items contained by the specified {@link Container} from this
     * {@link ObservedRemoveContainer}.
     * 
     * @param items
     *        {@link Container} containing the Items to remove
     * 
     * @param removeObservers
     *        comma separated sequence of {@link RemoveObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    // @formatter:off
    public void removeMe(final Container<? extends Item> items,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) 
                       final RemoveObserver<Item, ObservedRemoveContainer<Item>>... removeObservers)
    throws IllegalContainerArgumentException, IllegalContainerStateException;
    // @formatter:on

    /**
     * Removes all Items contained by the specified {@link Collection} from this
     * {@link ObservedRemoveContainer}.
     * 
     * @param items
     *        {@link Collection} containing the Items to remove
     * 
     * @param removeObservers
     *        comma separated sequence of {@link RemoveObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public void remove(final Collection<? extends Item> items,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) RemoveObserver<Item, ? extends Container<Item>>... removeObservers)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Removes all Items provided by the specified {@link Iterable} from this
     * {@link ObservedRemoveContainer}.
     * 
     * @param items
     *        {@link Iterable} providing the Items to remove
     * 
     * @param removeObservers
     *        comma separated sequence of {@link RemoveObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    // @formatter:off
    public void remove(final Iterable<? extends Item> items,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) RemoveObserver<Item, Conteener>... removeObservers)
    throws IllegalContainerArgumentException, IllegalContainerStateException;
    // @formatter:on

    /**
     * Removes all specified Items from this {@link ObservedRemoveContainer}.
     * 
     * @param items
     *        comma separated sequence of Items to remove
     * 
     * @param removeObservers
     *        array of {@link RemoveObserver} instances attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public void remove(RemoveObserver<Item, ? extends Container<Item>>[] removeObservers,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Removes all Items from this {@link ObservedRemoveContainer}
     * <em>except</em> the Items contained by the specified {@link Container}.
     * 
     * @param items
     *        {@link Container} containing the Items to retain
     * 
     * @param removeObservers
     *        comma separated sequence of {@link RemoveObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public void retain(final Container<? extends Item> items,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) RemoveObserver<Item, ? extends Container<Item>>... removeObservers)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Removes all Items from this {@link ObservedRemoveContainer}
     * <em>except</em> the Items contained by the specified {@link Collection}.
     * 
     * @param items
     *        {@link Collection} containing the Items to retain
     * 
     * @param removeObservers
     *        comma separated sequence of {@link RemoveObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public void retain(final Collection<? extends Item> items,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) RemoveObserver<Item, ? extends Container<Item>>... removeObservers)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Removes all Items from this {@link ObservedRemoveContainer}
     * <em>except</em> the specified Items.
     * 
     * @param removeObservers
     *        array of {@link RemoveObserver} instances attending the removal
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
     */
    public void retain(RemoveObserver<Item, ? extends Container<Item>>[] removeObservers,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException;

    /**
     * Creates a new {@link RemoveTraverser} over this
     * {@link ObservedRemoveContainer}.
     * 
     * @return newly created {@link RemoveTraverser}
     */
    @Override
    public RemoveTraverser<Item> createTraverser();
}
