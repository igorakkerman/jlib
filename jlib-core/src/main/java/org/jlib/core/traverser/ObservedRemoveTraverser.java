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

package org.jlib.core.traverser;

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;

/**
 * {@link RemoveTraverser} allowing its remove operation to be attended by
 * {@link ValueObserver} instances.
 *
 * @param <Item>
 *        type of the traversed items
 *
 * @author Igor Akkerman
 */
public interface ObservedRemoveTraverser<Item>
extends RemoveTraverser<Item> {

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
     * @throws InvalidTraversibleStateException
     *         if an error is caused by a delegate used to remove the Item
     *
     * @throws ValueObserverException
     *         if an error occurs during the {@link ValueObserver} operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>... observers)
    throws NoItemToRemoveException, InvalidTraversibleStateException, ValueObserverException, RuntimeException;

    /**
     * Registers the specified {@link ValueObserver} for the remove operations
     * of this {@link ObservedRemoveTraverser}.
     *
     * @param removeObserver
     *        additional remove {@link ValueObserver}
     */
    public void addRemoveObserver(final ValueObserver<Item> removeObserver);
}
