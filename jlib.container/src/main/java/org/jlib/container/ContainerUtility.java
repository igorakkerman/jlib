/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container;

import java.util.Collection;
import java.util.Set;

import org.jlib.container.collection.CollectionUtility;
import org.jlib.core.array.ArrayUtility;
import org.jlib.core.observer.ItemObserver;
import org.jlib.core.observer.ItemObserverException;
import org.jlib.core.traverser.ObservedRemoveTraverser;
import org.jlib.core.traverser.RemoveTraverser;

/**
 * Utility class providing methods operating on {@link Container} instances.
 * 
 * @author Igor Akkerman
 */
public final class ContainerUtility {

    /** No visible constructor. */
    private ContainerUtility() {}

    /**
     * Removes the specified Item of this {@link RemoveContainer}.
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param container
     *        {@link ObservedRemoveContainer} containing the Item
     * 
     * @param item
     *        Item to remove
     * 
     * @param observers
     *        comma separated sequence of {@link ItemObserver} instances
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
     * @throws ItemObserverException
     *         if an error occurs during the {@link ItemObserver} operation
     */
    public static <Item> void remove(final ObservedRemoveContainer<Item> container,
                                     final Item item,
                                     @SuppressWarnings({ "unchecked", /* "varargs" */}) final ItemObserver<Item>... observers)
    throws NoSuchItemToRemoveException, IllegalContainerArgumentException, IllegalContainerStateException,
    ItemObserverException {
        try {
            for (final ItemObserver<Item> observer : observers)
                observer.handleBefore(item, container);

            container.remove(item);

            for (final ItemObserver<Item> observer : observers)
                observer.handleAfterSuccess(item, container);
        }
        catch (IllegalContainerArgumentException | IllegalContainerStateException exception) {
            for (final ItemObserver<Item> observer : observers)
                observer.handleAfterFailure(item, container, exception);

            throw exception;
        }
    }

    /**
     * Removes all Items provided by the specified {@link Iterable} from the
     * specified {@link RemoveContainer}.
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param container
     *        {@link ObservedRemoveContainer} containing the Items
     * 
     * @param items
     *        {@link Iterable} providing the Items to remove
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public static <Item> void remove(final RemoveContainer<Item> container, final Iterable<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        for (final Item item : items)
            container.remove(item);
    }

    /**
     * Removes all Items in the specified comma separated sequence from the
     * specified {@link RemoveContainer}.
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items
     * 
     * @param items
     *        {@link Iterable} providing the Items to remove
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     * 
     * @throws ItemObserverException
     *         if an error occurs during the {@link ItemObserver} operation
     */
    @SafeVarargs
    public static <Item> void remove(final RemoveContainer<Item> container, final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ItemObserverException {
        remove(container, ArrayUtility.iterable(items));
    }

    /**
     * Removes all Items provided by the specified {@link Iterable} from the
     * specified {@link ObservedRemoveContainer}.
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param container
     *        {@link ObservedRemoveContainer} containing the Items
     * 
     * @param items
     *        {@link Iterable} providing the Items to remove
     * 
     * @param observers
     *        comma separated sequence of {@link ItemObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     * 
     * @throws ItemObserverException
     *         if an error occurs during the {@link ItemObserver} operation
     */
    @SafeVarargs
    public static <Item> void remove(final ObservedRemoveContainer<Item> container,
                                     final Iterable<? extends Item> items, final ItemObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ItemObserverException {
        for (final Item item : items)
            container.remove(item, observers);
    }

    /**
     * Removes all Items in the specified comma separated sequence from the
     * specified {@link RemoveContainer}.
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items
     * 
     * @param observers
     *        array of {@link ItemObserver} instances attending the removal
     * 
     * @param items
     *        {@link Iterable} providing the Items to remove
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     * 
     * @throws ItemObserverException
     *         if an error occurs during the {@link ItemObserver} operation
     */

    @SafeVarargs
    public static <Item> void remove(final ItemObserver<Item>[] observers,
                                     final ObservedRemoveContainer<Item> container, final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ItemObserverException {
        remove(container, ArrayUtility.iterable(items), observers);
    }

    /**
     * Removes all Items from the specified {@link RemoveContainer}
     * <em>except</em> the Items provided by the specified {@link Iterable}.
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items to remove
     * 
     * @param items
     *        {@link Iterable} providing the Items to retain
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */

    public static <Item> void retain(final RemoveContainer<Item> container, final Iterable<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        final Set<Item> retainedItemsSet = CollectionUtility.toSet(items);

        final RemoveTraverser<Item> containerTraverser = container.createRemoveTraverser();
        while (containerTraverser.isNextItemAccessible())
            if (!retainedItemsSet.contains(containerTraverser.getNextItem()))
                containerTraverser.remove();
    }

    /**
     * Removes all Items from the specified {@link RemoveContainer}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param <RetainedItem>
     *        type of the items retained in the {@link Container}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items to remove
     * 
     * @param items
     *        {@link Collection} containing the Items to retain
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    @SafeVarargs
    public static <Item, RetainedItem extends Item> void retain(final RemoveContainer<Item> container,
                                                                final RetainedItem... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        // necessary as we need the contains() method fot the items sequence
        retain(container, CollectionUtility.toSet(items));
    }

    /**
     * Removes all Items from the specified {@link RemoveContainer}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items to remove
     * 
     * @param items
     *        {@link Collection} containing the Items to retain
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public static <Item> void retain(final RemoveContainer<Item> container, final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        final RemoveTraverser<Item> itemsTraverser = container.createRemoveTraverser();
        while (itemsTraverser.isNextItemAccessible())
            if (!items.contains(itemsTraverser.getNextItem()))
                itemsTraverser.remove();
    }

    /**
     * Removes all Items from the specified {@link RemoveContainer}
     * <em>except</em> the Items provided by the specified {@link Iterable}.
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items to remove
     * 
     * @param items
     *        {@link Iterable} providing the Items to retain
     * 
     * @param observers
     *        comma separated sequence of {@link ItemObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     * 
     * @throws ItemObserverException
     *         if an error occurs during the {@link ItemObserver} operation
     */
    @SafeVarargs
    public static <Item> void retain(final ObservedRemoveContainer<Item> container,
                                     final Iterable<? extends Item> items, final ItemObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ItemObserverException {
        final Set<Item> retainedItemsSet = CollectionUtility.toSet(items);

        final ObservedRemoveTraverser<Item> containerTraverser = container.createObservedTraverser(observers);
        while (containerTraverser.isNextItemAccessible())
            if (!retainedItemsSet.contains(containerTraverser.getNextItem()))
                containerTraverser.remove(observers);
    }

    /**
     * Removes all Items from the specified {@link RemoveContainer}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param <RetainedItem>
     *        type of the items retained in the {@link Container}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items to remove
     * 
     * @param observers
     *        comma separated sequence of {@link ItemObserver} instances
     *        attending the removal
     * 
     * @param items
     *        comma separated sequence of the Items to retain
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     * 
     * @throws ItemObserverException
     *         if an error occurs during the {@link ItemObserver} operation
     */

    @SafeVarargs
    public static <Item, RetainedItem extends Item> void retain(final RemoveContainer<Item> container,
                                                                final ItemObserver<Item>[] observers,
                                                                final RetainedItem... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ItemObserverException {
        // necessary as we need the contains() method for the tems sequence
        retain(container, CollectionUtility.toSet(items));
    }

    /**
     * Removes all Items from the specified {@link RemoveContainer}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items to remove
     * 
     * @param items
     *        {@link Collection} containing the Items to retain
     * 
     * @param observers
     *        comma separated sequence of {@link ItemObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     * 
     * @throws ItemObserverException
     *         if an error occurs during the {@link ItemObserver} operation
     */

    @SafeVarargs
    public static <Item> void retain(final RemoveContainer<Item> container, final Collection<? extends Item> items,
                                     final ItemObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ItemObserverException {
        final RemoveTraverser<Item> itemsTraverser = container.createRemoveTraverser();
        while (itemsTraverser.isNextItemAccessible())
            if (!items.contains(itemsTraverser.getNextItem()))
                itemsTraverser.remove();
    }
}
