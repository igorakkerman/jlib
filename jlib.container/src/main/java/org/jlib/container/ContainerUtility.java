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
import org.jlib.core.traverser.RemoveTraverser;

/**
 * Utility class providing methods operating on {@link Container Containers}.
 * 
 * @author Igor Akkerman
 */
public final class ContainerUtility {

    /** No visible constructor. */
    private ContainerUtility() {}

    /**
     * Adds the specified Item to the specified {@link AddContainer} that does
     * not yet contain the Item.
     * 
     * @param container
     *        {@link AddContainer} to which the Item is added
     * 
     * @param item
     *        added Item
     * 
     * @throws ItemAlreadyContainedException
     *         if {@code container} already contains {@code item}
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of {@code item} prevents it from being added to
     *         {@code container}
     */
    public static <Item> void add(final AddContainer<Item> container, final Item item)
    throws ItemAlreadyContainedException, IllegalContainerArgumentException {
        if (container.contains(item))
            throw new ItemAlreadyContainedException(container, item);

        container.assertContained(item);
    }

    /**
     * Adds all Items provided by the specified {@link Iterable} to the
     * specified {@link AddContainer}.
     * 
     * @param container
     *        {@link AddContainer} to which the Items are added
     * 
     * @param items
     *        {@link Iterable} providing the Items to add
     * 
     * @throws ItemAlreadyContainedException
     *         if {@code container} already contains one Item in {@code items}
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of one Item in {@code items} prevents it from
     *         being added to {@code container}
     */
    public static <Item, Items extends Iterable<? extends Item>> void add(final AddContainer<Item> container,
                                                                          final Items items) {
        for (final Item item : items)
            container.add(item);
    }

    /**
     * Adds all Items in the specified comma separated sequence to the specified
     * {@link AddContainer}.
     * 
     * @param container
     *        {@link AddContainer} to which the Items are added
     * 
     * @param items
     *        {@link Iterable} providing the Items to add
     * 
     * @throws ItemAlreadyContainedException
     *         if {@code container} already contains one Item in {@code items}
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of one Item in {@code items} prevents it from
     *         being added to {@code container}
     */
    @SafeVarargs
    public static <Item> void add(final AddContainer<Item> container, final Item... items) {
        add(container, ArrayUtility.iterable(items));
    }

    /**
     * Asserts that the specified {@link AddContainer} contains the specified
     * Items. If the {@link AddContainer} does not contain the Item, it is
     * added.
     * 
     * @param container
     *        {@link AddContainer} to which the Items are added
     * 
     * @param items
     *        {@link Iterable} providing the Items to add
     */
    public static <Item> void assertContained(final AddContainer<Item> container, final Iterable<? extends Item> items) {
        for (final Item newItem : items)
            container.assertContained(newItem);
    }

    /**
     * Asserts that the specified {@link AddContainer} contains the specified
     * Items. If the {@link AddContainer} does not contain the Item, it is
     * added.
     * 
     * @param container
     *        {@link AddContainer} to which the Items are added
     * 
     * @param items
     *        {@link Iterable} providing the Items to add
     */
    @SafeVarargs
    public static <Item> void assertContained(final AddContainer<Item> container, final Item... items) {
        assertContained(container, ArrayUtility.iterable(items));
    }

    /**
     * Removes all Items provided by the specified {@link Iterable} from the
     * specified {@link RemoveContainer}.
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items
     * 
     * @param items
     *        {@link Iterable} providing the Items to remove
     */
    public static <Item> void remove(final RemoveContainer<Item> container, final Iterable<? extends Item> items) {
        for (final Item item : items)
            container.remove(item);
    }

    /**
     * Removes all Items in the specified comma separated sequence from the
     * specified {@link RemoveContainer}.
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items
     * 
     * @param items
     *        {@link Iterable} providing the Items to remove
     */
    @SafeVarargs
    public static <Item> void remove(final RemoveContainer<Item> container, final Item... items) {
        remove(container, ArrayUtility.iterable(items));
    }

    /**
     * Removes all Items from the specified {@link AddContainer} <i>except</i>
     * the Items provided by the specified {@link Iterable}.
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items to remove
     * 
     * @param items
     *        {@link Iterable} providing the Items to retain
     */
    public static <Item> void retain(final RemoveContainer<Item> container, final Iterable<? extends Item> items) {
        final Set<Item> retainedItemsSet = CollectionUtility.toSet(items);

        final RemoveTraverser<Item> containerTraverser = container.createTraverser();
        while (containerTraverser.isNextItemAccessible())
            if (!retainedItemsSet.contains(containerTraverser.getNextItem()))
                containerTraverser.remove();
    }

    /**
     * Removes all Items from the specified {@link AddContainer} <i>except</i>
     * for the Items contained by the specified {@link Collection}.
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items to remove
     * 
     * @param items
     *        {@link Collection} containing the Items to retain
     */
    public static <Item> void retain(final RemoveContainer<Item> container, final Collection<? extends Item> items) {
        final RemoveTraverser<Item> itemsTraverser = container.createTraverser();
        while (itemsTraverser.isNextItemAccessible())
            if (!items.contains(itemsTraverser.getNextItem()))
                itemsTraverser.remove();
    }

    /**
     * Removes all Items from the specified {@link AddContainer} <i>except</i>
     * for the Items contained by the specified {@link Collection}.
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items to remove
     * 
     * @param items
     *        {@link Collection} containing the Items to retain
     */
    @SafeVarargs
    public static <Item, RetainedItem extends Item> void retain(final RemoveContainer<Item> container,
                                                                final RetainedItem... items) {
        // necessary as we need the contains() method fot the items sequence
        retain(container, CollectionUtility.toSet(items));
    }
}
