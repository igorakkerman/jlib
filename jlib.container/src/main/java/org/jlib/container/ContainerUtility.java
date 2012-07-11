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
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.Operator;
import org.jlib.core.observer.OperatorException;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
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
     * Removes all Items of the specified {@link RemoveContainer}.
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public static <Item> void removeAll(final RemoveContainer<Item> container)
    throws IllegalContainerStateException {
        for (final Item item : container)
            container.remove(item);
    }

    /**
     * Removes all Items of the specified {@link RemoveContainer}.
     * 
     * @param container
     *        {@link ObservedRemoveContainer} containing the Items
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    @SafeVarargs
    public static <Item> void removeAll(final ObservedRemoveContainer<Item> container,
                                        final ValueObserver<Item>... observers)
    throws IllegalContainerStateException {
        for (final Item item : container)
            container.remove(item, observers);
    }

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
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public static <Item> void remove(final ObservedRemoveContainer<Item> container, final Item item,
                                     final ValueObserver<Item>... observers)
    throws NoSuchItemToRemoveException, IllegalContainerArgumentException, IllegalContainerStateException,
    RuntimeException {

        ObserverUtility.operate(new Operator() {

            @Override
            public void operate()
            throws OperatorException, RuntimeException {
                try {
                    container.remove(item);
                }
                catch (IllegalContainerArgumentException | IllegalContainerStateException exception) {
                    throw new OperatorException("remove: {0}", exception, item);
                }
            }
        },

        item, observers);
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
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SafeVarargs
    public static <Item> void remove(final RemoveContainer<Item> container, final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, RuntimeException {
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
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SafeVarargs
    public static <Item> void remove(final ObservedRemoveContainer<Item> container,
                                     final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, RuntimeException {
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
     *        array of {@link ValueObserver} instances attending the removal
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
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */

    @SafeVarargs
    public static <Item> void remove(final ValueObserver<Item>[] observers,
                                     final ObservedRemoveContainer<Item> container, final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
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

        final RemoveTraverser<Item> containerTraverser = container.createTraverser();
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
        final Set<Item> retainedItemsSet = CollectionUtility.toSet(items);
        // do not inline, otherwise Eclipse removes the cast from Set<RetainedItem> to Set<Item> and Javac complains
        retain(container, retainedItemsSet);
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
        final RemoveTraverser<Item> itemsTraverser = container.createTraverser();
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
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
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
    @SafeVarargs
    public static <Item> void retain(final ObservedRemoveContainer<Item> container,
                                     final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        final Set<Item> retainedItemsSet = CollectionUtility.toSet(items);

        final ObservedRemoveTraverser<Item> containerTraverser = container.createTraverser(observers);
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
     *        comma separated sequence of {@link ValueObserver} instances
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
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */

    @SafeVarargs
    public static <Item, RetainedItem extends Item> void retain(final RemoveContainer<Item> container,
                                                                final ValueObserver<Item>[] observers,
                                                                final RetainedItem... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, RuntimeException {
        // conversion to Set necessary as we need the contains() method for the tems sequence
        final Set<Item> retainedItemsSet = CollectionUtility.toSet(items);
        // do not inline, otherwise Eclipse removes the cast from Set<RetainedItem> to Set<Item> and Javac complains
        retain(container, retainedItemsSet);
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
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     * 
     * @throws IllegalContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */

    @SafeVarargs
    public static <Item> void retain(final RemoveContainer<Item> container, final Collection<? extends Item> items,
                                     final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, RuntimeException {
        final RemoveTraverser<Item> itemsTraverser = container.createTraverser();
        while (itemsTraverser.isNextItemAccessible())
            if (!items.contains(itemsTraverser.getNextItem()))
                itemsTraverser.remove();
    }

    /**
     * Returns the sum of number of Items in all of the specified
     * {@link Container} instances.
     * 
     * @param containers
     *        array of {@link Iterable} instances providing the Items
     * 
     * @return integer specifying the total number of Items
     */
    public static int getItemsCount(final Container<?>[] containers) {
        int itemsCount = 0;

        for (final Container<?> container : containers)
            itemsCount += container.getItemsCount();

        return itemsCount;
    }
}
