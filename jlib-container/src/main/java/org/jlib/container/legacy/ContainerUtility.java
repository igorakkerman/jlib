/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.container.legacy;

import java.util.Collection;
import java.util.Set;

import org.jlib.core.array.ArrayUtility;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.operator.HandledOperator;
import org.jlib.core.operator.OperatorException;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.NoItemToRemoveException;
import org.jlib.core.traverser.NoNextItemException;
import org.jlib.core.traverser.ObservedRemoveTraverser;
import org.jlib.core.traverser.RemoveTraversable;
import org.jlib.core.traverser.RemoveTraverser;

import org.jlib.container.ObservedRemoveItemByItem;
import org.jlib.container.ObservedRetainItemsByTraversable;
import org.jlib.container.RemoveItemByItem;
import org.jlib.container.RetainItemsByTraversable;
import org.jlib.container.ItemToRemoveNotContainedException;

import static java.util.Arrays.asList;
import static org.jlib.container.collection.CollectionUtility.toSet;
import static org.jlib.core.language.ExceptionMessageUtility.message;

/**
 * Utility class providing methods operating on {@link TraversableContainer} instances.
 *
 * @author Igor Akkerman
 */
public final class ContainerUtility {

    /** No visible constructor. */
    private ContainerUtility() {
    }

    /**
     * Removes the specified Item of this {@link RetainItemsByTraversable}.
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @param container
     *        {@link ObservedRetainItemsByTraversable} containing the Item
     *
     * @param item
     *        {@link Item} to retainItems
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws ItemToRemoveNotContainedException
     *         if this {@link RetainItemsByTraversable} does not contain {@code Item}
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SafeVarargs
    // TODO: check declared exceptions
    @SuppressWarnings({ "DuplicateThrows", "ProhibitedExceptionDeclared" })
    public static <Item> void remove(final RemoveItemByItem<Item> container, final Item item,
                                     final ValueObserver<Item>... observers)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, InvalidTraversableStateException,
           RuntimeException {

        ObserverUtility.operate(new HandledOperator() {

            @Override
            @SuppressWarnings("OverlyBroadCatchBlock")
            public void operate()
            throws OperatorException, RuntimeException {
                try {
                    container.removeItem(item);
                }
                // TODO: check caught exceptions
                catch (InvalidTraversableArgumentException | InvalidTraversableStateException exception) {
                    throw new OperatorException(message("retainItems: {0}", item), exception);
                }
            }
        }, item, observers);
    }

    /**
     * Removes all Items provided by the specified {@link Iterable} from the
     * specified {@link RetainItemsByTraversable}.
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @param container
     *        {@link ObservedRetainItemsByTraversable} containing the Items
     *
     * @param items
     *        {@link Iterable} providing the Items to retainItems
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public static <Item> void remove(final RemoveItemByItem<Item> container,
                                     final Iterable<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        for (final Item item : items)
            container.removeItem(item);
    }

    /**
     * Removes all Items in the specified comma separated sequence from the
     * specified {@link RetainItemsByTraversable}.
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @param container
     *        {@link RetainItemsByTraversable} containing the Items
     *
     * @param items
     *        {@link Iterable} providing the Items to retainItems
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SafeVarargs
    @SuppressWarnings("DuplicateThrows")
    public static <Item> void remove(final RemoveItemByItem<Item> container, final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, RuntimeException {
        remove(container, ArrayUtility.iterable(items));
    }

    /**
     * Removes all Items provided by the specified {@link Iterable} from the
     * specified {@link ObservedRetainItemsByTraversable}.
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @param container
     *        {@link ObservedRetainItemsByTraversable} containing the Items
     *
     * @param items
     *        {@link Iterable} providing the Items to retainItems
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SafeVarargs
    @SuppressWarnings("DuplicateThrows")
    public static <Item> void remove(final ObservedRemoveItemByItem<Item> container,
                                     final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, RuntimeException {
        for (final Item item : items)
            container.remove(item, observers);
    }

    /**
     * Removes all Items in the specified comma separated sequence from the
     * specified {@link RetainItemsByTraversable}.
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @param container
     *        {@link RetainItemsByTraversable} containing the Items
     *
     * @param observers
     *        array of {@link ValueObserver} instances attending the removal
     *
     * @param items
     *        {@link Iterable} providing the Items to retainItems
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */

    @SafeVarargs
    public static <Item> void remove(final ObservedRemoveItemByItem<Item> container,
                                     final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {
        remove(container, ArrayUtility.iterable(items), observers);
    }

    /**
     * Removes all Items from the specified {@link RemoveTraversable} <em>except</em> the Items provided by the
     * specified {@link Iterable}.
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @param traversable
     *        {@link RetainItemsByTraversable} containing the Items to retainItems
     *
     * @param items
     *        {@link Iterable} providing the Items to removeItems
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of one {@link Item} in {@code items}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public static <Item> void retain(final RemoveTraversable<Item> traversable, final Iterable<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        final Set<Item> retainedItemsSet = toSet(items);

        final RemoveTraverser<Item> containerTraverser = traversable.createTraverser();
        while (containerTraverser.hasNextItem())
            if (! retainedItemsSet.contains(containerTraverser.getNextItem()))
                containerTraverser.remove();
    }

    /**
     * Removes all Items from the specified {@link RetainItemsByTraversable}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @param <RetainedItem>
     *        type of the items retained in the {@link TraversableContainer}
     *
     * @param container
     *        {@link RetainItemsByTraversable} containing the Items to retainItems
     *
     * @param items
     *        {@link Collection} containing the Items to removeItems
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    @SafeVarargs
    public static <Item, RetainedItem extends Item> void retain(final RetainItemsByTraversable<Item> container,
                                                                final RetainedItem... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
//        removeItems(container, toSet(items));
    }

    /**
     * Removes all Items from the specified {@link RetainItemsByTraversable}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @param container
     *        {@link RetainItemsByTraversable} containing the Items to retainItems
     *
     * @param items
     *        {@link Collection} containing the Items to removeItems
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public static <Item> void retain(final RetainItemsByTraversable<Item> container, final Collection<? extends Item> items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
        final RemoveTraverser<Item> itemsTraverser = null; // container.createTraverser();
        while (itemsTraverser.hasNextItem())
            if (! items.contains(itemsTraverser.getNextItem()))
                itemsTraverser.remove();
    }

    /**
     * Removes all Items from the specified {@link ObservedRetainItemsByTraversable}
     * <em>except</em> the Items provided by the specified {@link Iterable}.
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @param container
     *        {@link ObservedRetainItemsByTraversable} containing the Items to retainItems
     *
     * @param items
     *        {@link Iterable} providing the Items to removeItems
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SafeVarargs
    public static <Item> void retain(final ObservedRetainItemsByTraversable<Item> container,
                                     final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException {

        final Set<Item> retainedItemsSet = toSet(items);

        final ObservedRemoveTraverser<Item> containerTraverser = null; // container.createTraverser();

        for (final ValueObserver<Item> observer : observers)
            containerTraverser.addRemoveObserver(observer);

        while (containerTraverser.hasNextItem())
            if (! retainedItemsSet.contains(containerTraverser.getNextItem()))
                containerTraverser.remove(observers);
    }

    /**
     * Removes all Items from the specified {@link ObservedRetainItemsByTraversable}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @param <RetainedItem>
     *        type of the items retained in the {@link TraversableContainer}
     *
     * @param container
     *        {@link ObservedRetainItemsByTraversable} containing the Items to retainItems
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @param items
     *        comma separated sequence of the Items to removeItems
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */

    @SafeVarargs
    @SuppressWarnings("DuplicateThrows")
    public static <Item, RetainedItem extends Item> void retain(final ObservedRetainItemsByTraversable<Item> container,
                                                                final ValueObserver<Item>[] observers,
                                                                final RetainedItem... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, RuntimeException {
        retain(container, asList(items), observers);
    }

    /**
     * Removes all Items from the specified {@link ObservedRetainItemsByTraversable}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @param container
     *        {@link ObservedRetainItemsByTraversable} containing the Items to retainItems
     *
     * @param items
     *        {@link Collection} containing the Items to removeItems
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    // TODO: check declared exceptions
    @SafeVarargs
    @SuppressWarnings({ "DuplicateThrows", "ProhibitedExceptionDeclared", "OverlyBroadThrowsClause" })
    public static <Item> void retain(final ObservedRetainItemsByTraversable<Item> container,
                                     final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws NoItemToRemoveException, InvalidTraversableArgumentException, InvalidTraversableStateException,
           RuntimeException {

        final ObservedRemoveTraverser<Item> itemsTraverser = null; // container.createTraverser();

        for (final ValueObserver<Item> observer : observers)
            itemsTraverser.addRemoveObserver(observer);

        while (itemsTraverser.hasNextItem())
            if (! items.contains(itemsTraverser.getNextItem()))
                itemsTraverser.remove();
    }

    /**
     * Removes all Items of the specified {@link RetainItemsByTraversable}.
     *
     * @param traversable
     *        {@link RetainItemsByTraversable} containing the Items
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    public static <Item> void removeAll(final RemoveTraversable<Item> traversable)
    throws InvalidTraversableStateException, NoItemToRemoveException, NoNextItemException {
        for (final RemoveTraverser<Item> traverser = traversable.createTraverser(); traverser.hasNextItem(); ) {
            traverser.getNextItem();
            traverser.remove();
        }
    }

    /**
     * Removes all Items of the specified {@link RetainItemsByTraversable}.
     *
     * @param container
     *        {@link ObservedRetainItemsByTraversable} containing the Items
     *
     * @param <Item>
     *        type of the items held in the {@link TraversableContainer}
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    @SafeVarargs
    public static <Item> void removeAll(final ObservedRetainItemsByTraversable<Item> container,
                                        final ValueObserver<Item>... observers)
    throws InvalidTraversableStateException {
        for (final ObservedRemoveTraverser<Item> traverser = null; // container.createTraverser();
             traverser.hasNextItem(); ) {
            traverser.getNextItem();
            traverser.remove(observers);
        }
    }

    /**
     * Returns the sum of number of Items in all of the specified
     * {@link TraversableContainer} instances.
     *
     * @param containers
     *        array of {@link Iterable} instances providing the Items
     *
     * @return integer specifying the total number of Items
     */
    public static int getItemsCount(final TraversableContainer<?>[] containers) {
        int itemsCount = 0;

        for (final TraversableContainer<?> container : containers)
            itemsCount += container.getItemsCount();

        return itemsCount;
    }
}
