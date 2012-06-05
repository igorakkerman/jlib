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
     */
    @SafeVarargs
    public static <Item> void remove(final RemoveContainer<Item> container, final Item... items) {
        remove(container, ArrayUtility.iterable(items));
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
     */
    @SafeVarargs
    public static <Item, RetainedItem extends Item> void retain(final RemoveContainer<Item> container,
                                                                final RetainedItem... items) {
        // necessary as we need the contains() method fot the items sequence
        retain(container, CollectionUtility.toSet(items));
    }

    /**
     * Removes all Items provided by the specified {@link Iterable} from the
     * specified {@link RemoveContainer}.
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param <Conteener>
     *        type of the {@link RemoveContainer}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items
     * 
     * @param items
     *        {@link Iterable} providing the Items to remove
     * 
     * @param removeObservers
     *        comma separated sequence of {@link RemoveObserver} instances
     *        attending the removal
     */
    // @formatter:off
//    public static <Item, Conteener extends RemoveContainer<Item>> 
//                  void remove(final Conteener container, final Iterable<? extends Item> items,
//                  final RemoveObserver<Item, Conteener>... removeObservers) {
//    // @formatter:on
//        for (final Item item : items)
//            container.remove(item);
//    }
    // @formatter:off
    @SafeVarargs
    public static <Item, Conteener extends RemoveContainer<Item>> 
                  void removeIt(final Conteener container, final Iterable<? extends Item> items,
                              final RemoveObserver<Item, Conteener>... removeObservers) {
        for (final Item item : items) {
            for (final RemoveObserver<Item, Conteener> removeObserver : removeObservers)
                removeObserver.handleBeforeRemove(container, item);
            container.remove(item);
        }
    }
        
    /**
     * Removes all Items in the specified comma separated sequence from the
     * specified {@link RemoveContainer}.
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param <Conteener>
     *        type of the {@link RemoveContainer}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items
     * 
     * @param removeObservers
     *        array of {@link RemoveObserver} instances attending the removal
     * 
     * @param items
     *        {@link Iterable} providing the Items to remove
     */
    // @formatter:off
    @SafeVarargs
    public static <Item, Conteener extends RemoveContainer<Item>> 
                  void remove(final RemoveObserver<Item, Conteener>[] removeObservers, final RemoveContainer<Item> container, 
                              final Item... items) {
        remove(container, ArrayUtility.iterable(items));
    }

    /**
     * Removes all Items from the specified {@link RemoveContainer}
     * <em>except</em> the Items provided by the specified {@link Iterable}.
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param <Conteener>
     *        type of the {@link RemoveContainer}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items to remove
     * 
     * @param items
     *        {@link Iterable} providing the Items to retain
     *        
     * @param removeObservers
     *        comma separated sequence of {@link RemoveObserver} instances
     *        attending the removal
     */
    // @formatter:off
    @SafeVarargs
    public static <Item, Conteener extends RemoveContainer<Item>> 
                  void retain(final RemoveContainer<Item> container, final Iterable<? extends Item> items,
                              final RemoveObserver<Item, Conteener>... removeObservers) {
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
     * @param <Conteener>
     *        type of the {@link RemoveContainer}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items to remove
     * 
     * @param items
     *        {@link Collection} containing the Items to retain
     *        
     * @param removeObservers
     *        comma separated sequence of {@link RemoveObserver} instances
     *        attending the removal
     */
    // @formatter:off
    @SafeVarargs
    public static <Item, Conteener extends RemoveContainer<Item>> 
                  void retain(final RemoveContainer<Item> container, final Collection<? extends Item> items,
                              final RemoveObserver<Item, Conteener>... removeObservers) {
        final RemoveTraverser<Item> itemsTraverser = container.createTraverser();
        while (itemsTraverser.isNextItemAccessible())
            if (!items.contains(itemsTraverser.getNextItem()))
                itemsTraverser.remove();
    }

    /**
     * Removes all Items from the specified {@link RemoveContainer}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param <Conteener>
     *        type of the {@link RemoveContainer}
     * 
     * @param <RetainedItem>
     *        type of the items retained in the {@link Container}
     * 
     * @param container
     *        {@link RemoveContainer} containing the Items to remove
     * 
     * @param removeObservers
     *        comma separated sequence of {@link RemoveObserver} instances
     *        attending the removal
     *        
     * @param items
     *        comma separated sequence of the Items to retain
     */
    // @formatter:off
    @SafeVarargs
    public static <Item, Conteener extends RemoveContainer<Item>, RetainedItem extends Item> 
                  void retain(final RemoveContainer<Item> container, final RemoveObserver<Item, Conteener>[] removeObservers,
                              final RetainedItem... items) {
        // necessary as we need the contains() method for the tems sequence
        retain(container, CollectionUtility.toSet(items));
    }
}
