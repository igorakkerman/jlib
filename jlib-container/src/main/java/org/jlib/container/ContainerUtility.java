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

package org.jlib.container;

import org.jlib.container.collection.CollectionUtility;
import org.jlib.core.array.ArrayUtility;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.exception.observer.ValueObserverException;
import org.jlib.core.operator.HandledOperator;
import org.jlib.core.exception.operator.OperatorException;
import org.jlib.core.traverser.ObservedRemoveTraverser;
import org.jlib.core.traverser.RemoveTraverser;

import java.util.Collection;
import java.util.Set;

/**
 * Utility class providing methods operating on {@link Container} instances.
 *
 * @author Igor Akkerman
 */
public final class ContainerUtility {

    /** No visible constructor. */
    private ContainerUtility() {
    }

    /**
     * Removes all Items of the specified {@link Remove}.
     *
     * @param container
     *        {@link Remove} containing the Items
     *
     * @param <Item>
     *        type of the items held in the {@link Container}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public static <Item> void removeAll(final Remove<Item> container)
    throws InvalidContainerStateException {
        for (final RemoveTraverser<Item> traverser = container.createTraverser(); traverser.isNextItemAccessible(); ) {
            traverser.getNextItem();
            traverser.remove();
        }
    }

    /**
     * Removes all Items of the specified {@link Remove}.
     *
     * @param container
     *        {@link ObservedRemove} containing the Items
     *
     * @param <Item>
     *        type of the items held in the {@link Container}
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    @SafeVarargs
    public static <Item> void removeAll(final ObservedRemove<Item> container, final ValueObserver<Item>... observers)
    throws InvalidContainerStateException {
        for (final ObservedRemoveTraverser<Item> traverser = container.createTraverser(); traverser.isNextItemAccessible(); ) {
            traverser.getNextItem();
            traverser.remove(observers);
        }
    }

    /**
     * Removes the specified Item of this {@link Remove}.
     *
     * @param <Item>
     *        type of the items held in the {@link Container}
     *
     * @param container
     *        {@link ObservedRemove} containing the Item
     *
     * @param item
     *        Item to remove
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws NoSuchItemToRemoveException
     *         if this {@link Remove} does not contain {@code Item}
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
    @SuppressWarnings("unchecked")
    public static <Item> void remove(final ObservedRandomAccessRemove<Item> container, final Item item, final ValueObserver<Item>... observers)
    throws NoSuchItemToRemoveException, InvalidContainerArgumentException, InvalidContainerStateException,
           RuntimeException {

        ObserverUtility.operate(new HandledOperator() {

            @Override
            public void operate()
            throws OperatorException, RuntimeException {
                try {
                    container.remove(item);
                }
                catch (InvalidContainerArgumentException | InvalidContainerStateException exception) {
                    throw new OperatorException("remove: {0}", exception, item);
                }
            }
        },

                                item, observers);
    }

    /**
     * Removes all Items provided by the specified {@link Iterable} from the
     * specified {@link Remove}.
     *
     * @param <Item>
     *        type of the items held in the {@link Container}
     *
     * @param container
     *        {@link ObservedRemove} containing the Items
     *
     * @param items
     *        {@link Iterable} providing the Items to remove
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public static <Item> void remove(final RandomAccessRemove<Item> container, final Iterable<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        for (final Item item : items)
            container.remove(item);
    }

    /**
     * Removes all Items in the specified comma separated sequence from the
     * specified {@link Remove}.
     *
     * @param <Item>
     *        type of the items held in the {@link Container}
     *
     * @param container
     *        {@link Remove} containing the Items
     *
     * @param items
     *        {@link Iterable} providing the Items to remove
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
    public static <Item> void remove(final RandomAccessRemove<Item> container, final Item... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException, RuntimeException {
        remove(container, ArrayUtility.iterable(items));
    }

    /**
     * Removes all Items provided by the specified {@link Iterable} from the
     * specified {@link ObservedRemove}.
     *
     * @param <Item>
     *        type of the items held in the {@link Container}
     *
     * @param container
     *        {@link ObservedRemove} containing the Items
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
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SafeVarargs
    public static <Item> void remove(final ObservedRandomAccessRemove<Item> container, final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, RuntimeException {
        for (final Item item : items)
            container.remove(item, observers);
    }

    /**
     * Removes all Items in the specified comma separated sequence from the
     * specified {@link Remove}.
     *
     * @param <Item>
     *        type of the items held in the {@link Container}
     *
     * @param container
     *        {@link Remove} containing the Items
     *
     * @param observers
     *        array of {@link ValueObserver} instances attending the removal
     *
     * @param items
     *        {@link Iterable} providing the Items to remove
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
    public static <Item> void remove(final ObservedRandomAccessRemove<Item> container, final ValueObserver<Item>[] observers, final Item... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {
        remove(container, ArrayUtility.iterable(items), observers);
    }

    /**
     * Removes all Items from the specified {@link Remove}
     * <em>except</em> the Items provided by the specified {@link Iterable}.
     *
     * @param <Item>
     *        type of the items held in the {@link Container}
     *
     * @param container
     *        {@link Remove} containing the Items to remove
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

    public static <Item> void retain(final Remove<Item> container, final Iterable<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        final Set<Item> retainedItemsSet = CollectionUtility.toSet(items);

        final RemoveTraverser<Item> containerTraverser = container.createTraverser();
        while (containerTraverser.isNextItemAccessible())
            if (! retainedItemsSet.contains(containerTraverser.getNextItem()))
                containerTraverser.remove();
    }

    /**
     * Removes all Items from the specified {@link Remove}
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
     *        {@link Remove} containing the Items to remove
     *
     * @param items
     *        {@link Collection} containing the Items to retain
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    @SafeVarargs
    public static <Item, RetainedItem extends Item> void retain(final Remove<Item> container, final RetainedItem... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        // necessary as we need the contains() method fot the items sequence
        final Set<Item> retainedItemsSet = CollectionUtility.toSet(items);
        // do not inline, otherwise Eclipse removes the cast from Set<RetainedItem> to Set<Item> and Javac complains
        retain(container, retainedItemsSet);
    }

    /**
     * Removes all Items from the specified {@link Remove}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     *
     * @param <Item>
     *        type of the items held in the {@link Container}
     *
     * @param container
     *        {@link Remove} containing the Items to remove
     *
     * @param items
     *        {@link Collection} containing the Items to retain
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code item}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public static <Item> void retain(final Remove<Item> container, final Collection<? extends Item> items)
    throws InvalidContainerArgumentException, InvalidContainerStateException {
        final RemoveTraverser<Item> itemsTraverser = container.createTraverser();
        while (itemsTraverser.isNextItemAccessible())
            if (! items.contains(itemsTraverser.getNextItem()))
                itemsTraverser.remove();
    }

    /**
     * Removes all Items from the specified {@link ObservedRemove}
     * <em>except</em> the Items provided by the specified {@link Iterable}.
     *
     * @param <Item>
     *        type of the items held in the {@link Container}
     *
     * @param container
     *        {@link ObservedRemove} containing the Items to remove
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
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SafeVarargs
    public static <Item> void retain(final ObservedRemove<Item> container, final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {
        final Set<Item> retainedItemsSet = CollectionUtility.toSet(items);

        final ObservedRemoveTraverser<Item> containerTraverser = container.createTraverser();

        for (final ValueObserver<Item> observer : observers)
            containerTraverser.addRemoveObserver(observer);

        while (containerTraverser.isNextItemAccessible())
            if (! retainedItemsSet.contains(containerTraverser.getNextItem()))
                containerTraverser.remove(observers);
    }

    /**
     * Removes all Items from the specified {@link ObservedRemove}
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
     *        {@link ObservedRemove} containing the Items to remove
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @param items
     *        comma separated sequence of the Items to retain
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
    public static <Item, RetainedItem extends Item> void retain(final ObservedRemove<Item> container, final ValueObserver<Item>[] observers, final RetainedItem... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException, RuntimeException {
        // conversion to Set necessary as we need the contains() method for the tems sequence
        final Set<Item> retainedItemsSet = CollectionUtility.toSet(items);
        // do not inline, otherwise Eclipse removes the cast from Set<RetainedItem> to Set<Item> and Javac complains
        retain(container, retainedItemsSet, observers);
    }

    /**
     * Removes all Items from the specified {@link ObservedRemove}
     * <em>except</em> for the Items contained by the specified
     * {@link Collection} .
     *
     * @param <Item>
     *        type of the items held in the {@link Container}
     *
     * @param container
     *        {@link ObservedRemove} containing the Items to remove
     *
     * @param items
     *        {@link Collection} containing the Items to retain
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
    public static <Item> void retain(final ObservedRemove<Item> container, final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, RuntimeException {
        final ObservedRemoveTraverser<Item> itemsTraverser = container.createTraverser();

        for (final ValueObserver<Item> observer : observers)
            itemsTraverser.addRemoveObserver(observer);

        while (itemsTraverser.isNextItemAccessible())
            if (! items.contains(itemsTraverser.getNextItem()))
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
