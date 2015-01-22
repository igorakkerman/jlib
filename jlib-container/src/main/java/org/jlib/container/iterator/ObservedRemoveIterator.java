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

import org.jlib.core.iterator.InvalidIterableStateException;
import org.jlib.operator.observer.ValueObserver;
import org.jlib.operator.observer.ValueObserverException;

/**
 * {@link RemoveIterator} allowing its remove operation to be attended by
 * {@link ValueObserver} instances.
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
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     *
     * @throws NoItemToRemoveException
     *         if not called immediately after traversing an Item
     *
     * @throws InvalidIterableStateException
     *         if an error is caused by a delegate used to remove the Item
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings({ "unchecked", "DuplicateThrows" })
    void remove(ValueObserver<Item>... observers)
    throws NoItemToRemoveException, InvalidIterableStateException, ValueObserverException, RuntimeException;

    /**
     * Registers the specified {@link ValueObserver} for the remove operations
     * of this {@link ObservedRemoveIterator}.
     *
     * @param removeObserver
     *        additional remove {@link ValueObserver}
     */
    void addRemoveObserver(ValueObserver<Item> removeObserver);
}
