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

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.container.traverser.ObservedRemoveTraverser;

import java.util.Collection;

/**
 * Ability to remove Items; the remove operations can be attended by {@link ValueObserver}
 * instances.
 *
 * @param <Item>
 *        type of items held in the {@link Container}
 *
 * @author Igor Akkerman
 */
public interface ObservedRemove<Item> {

    /**
     * Removes all Items from this {@link Container} <em>except</em> the Items contained by
     * the specified {@link Container}.
     *
     * @param items
     *        {@link Container} containing the Items to retain
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SuppressWarnings("unchecked")
    public void retain(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException;

    /**
     * Removes all Items from this {@link ObservedRandomAccessRemove}
     * <em>except</em> the Items contained by the specified {@link Collection}.
     *
     * @param items
     *        {@link Collection} containing the Items to retain
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException;

    /**
     * Removes all Items from this {@link ObservedRandomAccessRemove}
     * <em>except</em> the specified Items.
     *
     * @param observers
     *        array of {@link ValueObserver} instances attending the removal
     *
     * @param items
     *        comma separated sequence of Items to retain
     *
     * @throws InvalidContainerArgumentException
     *         if the operation cannot be completed due to some property of one
     *         Item in {@code items}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     */
    @SuppressWarnings("unchecked")
    public void retain(ValueObserver<Item>[] observers, final Item... items)
    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException;

    /**
     * Returns an {@link ObservedRemoveTraverser} traversing the Items of this {@link ObservedRemove}
     *
     * @return {@link ObservedRemoveTraverser} traversing the Items of this {@link ObservedRemove}
     */
    public ObservedRemoveTraverser<Item> createTraverser();
}
