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
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;

/**
 * {@link RetainItemsByTraversable} allowing its removeItem operations to be attended by
 * {@link ValueObserver} instances.
 *
 * @param <Item>
 *        type of items held in the {@link TraversableContainer}
 *
 * @author Igor Akkerman
 */
public interface ObservedRemoveItemByItem<Item>
extends ItemOperationStrategy<Item> {

    /**
     * Removes the specified Item from this
     * {@link ObservedRemoveItemByItem}.
     *
     * @param item
     *        Item to removeItem
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws ItemToRemoveNotContainedException
     *         if this {@link ObservedRemoveItemByItem} does not
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
    public void removeItem(Item item, ValueObserver<Item>... observers)
    throws ItemToRemoveNotContainedException, InvalidTraversableArgumentException, InvalidTraversableStateException,
           ValueObserverException;
}
