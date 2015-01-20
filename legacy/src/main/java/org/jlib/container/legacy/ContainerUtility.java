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

package org.jlib.container.operation.legacy;

import java.util.Collection;
import java.util.Set;

import org.jlib.core.array.ArrayUtility;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.operator.HandledOperator;
import org.jlib.core.operator.OperatorException;
import org.jlib.core.iterator.NoItemToRemoveException;
import org.jlib.core.iterator.NoNextItemException;
import org.jlib.core.iterator.ObservedRemoveIterator;
import org.jlib.core.iterator.RemoveIterable;
import org.jlib.core.iterator.RemoveIterator;

import org.jlib.container.operation.InvalidContainerArgumentException;
import org.jlib.container.operation.InvalidContainerStateException;
import org.jlib.container.operation.ItemToRemoveNotContainedException;
import org.jlib.container.operation.ObservedRemoveMany;

import static java.util.Arrays.asList;
import static org.jlib.container.operation.collection.CollectionUtility.toSet;
import static org.jlib.core.language.MessageUtility.message;

/**
 * Utility class providing methods operating on {@link IterableContainer} instances.
 *
 * @author Igor Akkerman
 */
public final class ContainerUtility {

    /**
     * Removes the specified Item of this {@link RetainItemsByIterable}.
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param container
     *        {@link ObservedRetainItemsByIterable} containing the Item
     *
     * @param item
     *        {@link Item} to retain
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws ItemToRemoveNotContainedException
     *         if this {@link RetainItemsByIterable} does not contain {@code Item}
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
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
    throws ItemToRemoveNotContainedException, InvalidContainerArgumentException, InvalidContainerStateException,
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
                catch (InvalidContainerArgumentException | InvalidContainerStateException exception) {
                    throw new OperatorException(message("retain: {0}", item), exception);
                }
            }
        }, item, observers);
    }

    /**
     * Removes all Items provided by the specified {@link Iterable} from the
     * specified {@link RetainItemsByIterable}.
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param container
     *        {@link ObservedRetainItemsByIterable} containing the Items
     *
     * @param items
     *        {@link Iterable} providing the Items to retain
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public static <Item> void remove(final RemoveItemByItem<Item> container, final Iterable<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        for (final Item item : items)
            container.removeItem(item);
    }

    /**
     * Removes all Items in the specified comma separated sequence from the
     * specified {@link RetainItemsByIterable}.
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param container
     *        {@link RetainItemsByIterable} containing the Items
     *
     * @param items
     *        {@link Iterable} providing the Items to retain
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SafeVarargs
    @SuppressWarnings("DuplicateThrows")
    public static <Item> void remove(final RemoveItemByItem<Item> container, final Item... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException, RuntimeException {
        remove(container, ArrayUtility.iterable(items));
    }

    /**
     * Removes all Items provided by the specified {@link Iterable} from the
     * specified {@link ObservedRetainItemsByIterable}.
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param container
     *        {@link ObservedRetainItemsByIterable} containing the Items
     *
     * @param items
     *        {@link Iterable} providing the Items to retain
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SafeVarargs
    @SuppressWarnings("DuplicateThrows")
    public static <Item> void remove(final ObservedRemoveMany<Item> container, final Iterable<? extends Item> items,
                                     final ValueObserver<Item>... observers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, RuntimeException {
        for (final Item item : items)
            container.remove(item, observers);
    }

    /**
     * Removes all Items in the specified comma separated sequence from the
     * specified {@link RetainItemsByIterable}.
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param container
     *        {@link RetainItemsByIterable} containing the Items
     *
     * @param observers
     *        array of {@link ValueObserver} instances attending the removal
     *
     * @param items
     *        {@link Iterable} providing the Items to retain
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */

    @SafeVarargs
    public static <Item> void remove(final ObservedRemoveMany<Item> container, final ValueObserver<Item>[] observers,
                                     final Item... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {
        remove(container, ArrayUtility.iterable(items), observers);
    }

    /**
     * Removes all Items from the specified {@link RemoveIterable} <em>except</em> the Items provided by the
     * specified {@link Iterable}.
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param iterable
     *        {@link RetainItemsByIterable} containing the Items to retain
     *
     * @param items
     *        {@link Iterable} providing the Items to remove
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of one {@link Item} in {@code items}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public static <Item> void retain(final RemoveIterable<Item> iterable, final Iterable<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        final Set<Item> retainedItemsSet = toSet(items);

        final RemoveIterator<Item> containerIterator = iterable.iterator();
        while (containerIterator.hasNext())
            if (! retainedItemsSet.contains(containerIterator.next()))
                containerIterator.remove();
    }

    /**
     * Removes all Items from the specified {@link RetainItemsByIterable}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param <RetainedItem>
     *        type of the items retained in the {@link IterableContainer}
     *
     * @param container
     *        {@link RetainItemsByIterable} containing the Items to retain
     *
     * @param items
     *        {@link Collection} containing the Items to remove
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    @SafeVarargs
    public static <Item, RetainedItem extends Item> void retain(final RetainItemsByIterable<Item> container,
                                                                final RetainedItem... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
//        remove(operation, toSet(items));
    }

    /**
     * Removes all Items from the specified {@link RetainItemsByIterable}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param container
     *        {@link RetainItemsByIterable} containing the Items to retain
     *
     * @param items
     *        {@link Collection} containing the Items to remove
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public static <Item> void retain(final RetainItemsByIterable<Item> container,
                                     final Collection<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        final RemoveIterator<Item> itemsIterator = null; // operation.iterator();
        while (itemsIterator.hasNext())
            if (! items.contains(itemsIterator.next()))
                itemsIterator.remove();
    }

    /**
     * Removes all Items from the specified {@link ObservedRetainItemsByIterable}
     * <em>except</em> the Items provided by the specified {@link Iterable}.
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param container
     *        {@link ObservedRetainItemsByIterable} containing the Items to retain
     *
     * @param items
     *        {@link Iterable} providing the Items to remove
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SafeVarargs
    public static <Item> void retain(final ObservedRetainItemsByIterable<Item> container,
                                     final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {

        final Set<Item> retainedItemsSet = toSet(items);

        final ObservedRemoveIterator<Item> containerIterator = null; // operation.iterator();

        for (final ValueObserver<Item> observer : observers)
            containerIterator.addRemoveObserver(observer);

        while (containerIterator.hasNext())
            if (! retainedItemsSet.contains(containerIterator.next()))
                containerIterator.remove(observers);
    }

    /**
     * Removes all Items from the specified {@link ObservedRetainItemsByIterable}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param <RetainedItem>
     *        type of the items retained in the {@link IterableContainer}
     *
     * @param container
     *        {@link ObservedRetainItemsByIterable} containing the Items to retain
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @param items
     *        comma separated sequence of the Items to remove
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */

    @SafeVarargs
    @SuppressWarnings("DuplicateThrows")
    public static <Item, RetainedItem extends Item> void retain(final ObservedRetainItemsByIterable<Item> container,
                                                                final ValueObserver<Item>[] observers,
                                                                final RetainedItem... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException, RuntimeException {
        retain(container, asList(items), observers);
    }

    /**
     * Removes all Items from the specified {@link ObservedRetainItemsByIterable}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param container
     *        {@link ObservedRetainItemsByIterable} containing the Items to retain
     *
     * @param items
     *        {@link Collection} containing the Items to remove
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    // TODO: check declared exceptions
    @SafeVarargs
    @SuppressWarnings({ "DuplicateThrows", "ProhibitedExceptionDeclared", "OverlyBroadThrowsClause" })
    public static <Item> void retain(final ObservedRetainItemsByIterable<Item> container,
                                     final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws NoItemToRemoveException, InvalidContainerArgumentException, InvalidContainerStateException,
           RuntimeException {

        final ObservedRemoveIterator<Item> itemsIterator = null; // operation.iterator();

        for (final ValueObserver<Item> observer : observers)
            itemsIterator.addRemoveObserver(observer);

        while (itemsIterator.hasNext())
            if (! items.contains(itemsIterator.next()))
                itemsIterator.remove();
    }

    /**
     * Removes all Items of the specified {@link RetainItemsByIterable}.
     *
     * @param iterable
     *        {@link RetainItemsByIterable} containing the Items
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public static <Item> void removeAll(final RemoveIterable<Item> iterable)
    throws InvalidContainerStateException, NoItemToRemoveException, NoNextItemException {
        for (final RemoveIterator<Item> iterator = iterable.iterator(); iterator.hasNext(); ) {
            iterator.next();
            iterator.remove();
        }
    }

    /**
     * Removes all Items of the specified {@link RetainItemsByIterable}.
     *
     * @param container
     *        {@link ObservedRetainItemsByIterable} containing the Items
     *
     * @param <Item>
     *        type of the items held in the {@link IterableContainer}
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    @SafeVarargs
    public static <Item> void removeAll(final ObservedRetainItemsByIterable<Item> container,
                                        final ValueObserver<Item>... observers)
    throws InvalidContainerStateException {
        for (final ObservedRemoveIterator<Item> iterator = null; // operation.iterator();
             iterator.hasNext(); ) {
            iterator.next();
            iterator.remove(observers);
        }
    }

    /**
     * Returns the sum of number of Items in all of the specified
     * {@link IterableContainer} instances.
     *
     * @param containers
     *        array of {@link Iterable} instances providing the Items
     *
     * @return integer specifying the total number of Items
     */
    public static int getItemsCount(final IterableContainer<?>[] containers) {
        int itemsCount = 0;

        for (final IterableContainer<?> container : containers)
            itemsCount += container.getItemsCount();

        return itemsCount;
    }

    /** No visible constructor. */
    private ContainerUtility() {
        .;
    }

    private void next() {

    }

    private void next() {

    }
}
