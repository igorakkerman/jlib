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

import java.util.Collection;

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;

/**
 * {@link Remove} allowing its remove operations to be attended by
 * {@link ValueObserver} instances.
 *
 * @param <Item>
 *        type of items held in the {@link TraversableContainer}
 *
 * @author Igor Akkerman
 */
public interface ObservedRemoveByItem<Item>
extends ItemOperation<Item> {

    /**
     * Removes the specified Item from this
     * {@link ObservedRemoveByItem}.
     *
     * @param item
     *        Item to remove
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws ItemToRemoveNotContainedException
     *         if this {@link ObservedRemoveByItem} does not
     *         contain {@code Item}
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
    @SuppressWarnings({ "unchecked", "DuplicateThrows" })
    public void remove(Item item, ValueObserver<Item>... observers)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, InvalidTraversableStateException,
           ValueObserverException;

    /**
     * Removes all Items contained by the specified {@link TraversableContainer} from this
     * {@link ObservedRemoveByItem}.
     *
     * @param items
     *        {@link TraversableContainer} containing the Items to remove
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SuppressWarnings("unchecked")
    public void remove(TraversableContainer<? extends Item> items, ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException;

    /**
     * Removes all Items contained by the specified {@link Collection} from this
     * {@link ObservedRemoveByItem}.
     *
     * @param items
     *        {@link Collection} containing the Items to remove
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SuppressWarnings("unchecked")
    public void remove(Collection<? extends Item> items, ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException;

    /**
     * Removes all Items provided by the specified {@link Iterable} from this
     * {@link ObservedRemoveByItem}.
     *
     * @param items
     *        {@link Iterable} providing the Items to remove
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SuppressWarnings("unchecked")
    public void remove(Iterable<? extends Item> items, ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException;

    /**
     * Removes all specified Items from this
     * {@link ObservedRemoveByItem}.
     *
     * @param items
     *        comma separated sequence of Items to remove
     *
     * @param observers
     *        array of {@link ValueObserver} instances attending the removal
     *
     * @throws InvalidTraversableArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SuppressWarnings("unchecked")
    public void remove(ValueObserver<Item>[] observers, Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, ValueObserverException;
}
