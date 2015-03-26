/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
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

package org.jlib.container.iterator;

import org.jlib.iterator.InvalidIterableStateException;
import org.jlib.iterator.NoItemToRemoveException;
import org.jlib.iterator.RemoveIterator;

import org.jlib.operator.observer.Observer;
import org.jlib.operator.observer.ObserverException;

/**
 * {@link RemoveIterator} allowing its remove operation to be attended by
 * {@link Observer} instances.
 *
 * @param <Item>
 *        type of the traversed items
 *
 * @author Igor Akkerman
 */
public interface ObservedRemoveIterator<Item>
extends RemoveIterator<Item> {

    /**
     * Removes the last traversed Item.
     *
     * @param observers
     *        comma separated sequence of {@link Observer} instances
     *        attending the operation
     *
     * @throws NoItemToRemoveException
     *         if not called immediately after traversing an Item
     *
     * @throws InvalidIterableStateException
     *         if an error is caused by a delegate used to remove the Item
     *
     * @throws ObserverException
     *         if an error occurs during the {@link Observer} operation
     *
     * @throws RuntimeException
     *         if a {@link Observer} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings({ "unchecked", "DuplicateThrows" })
    void remove(Observer<Item>... observers)
    throws NoItemToRemoveException, InvalidIterableStateException, ObserverException, RuntimeException;

    /**
     * Registers the specified {@link Observer} for the remove operations
     * of this {@link ObservedRemoveIterator}.
     *
     * @param removeObserver
     *        additional remove {@link Observer}
     */
    void addRemoveObserver(Observer<Item> removeObserver);
}
