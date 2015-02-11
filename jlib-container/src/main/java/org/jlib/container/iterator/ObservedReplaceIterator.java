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

import org.jlib.operator.observer.Observer;
import org.jlib.operator.observer.ObserverException;

/**
 * {@link ReplaceIterator} allowing its remove operation to be attended by
 * {@link Observer} instances.
 *
 * @param <Item>
 *        type of the traversed items
 *
 * @author Igor Akkerman
 */
public interface ObservedReplaceIterator<Item>
extends ReplaceIterator<Item> {

    /**
     * Replaces the last traversed Item with the specified value.
     *
     * @param newItem
     *        Item by which the former Item is replaced
     *
     * @param observers
     *        comma separated sequence of {@link Observer} instances
     *        attending the replacement
     *
     * @throws NoItemToReplaceException
     *         if not called immediately after traversing an Item
     *
     * @throws ObserverException
     *         if an error occurs during the {@link Observer} operation
     */
    @SuppressWarnings("unchecked")
    void replace(Item newItem, Observer<Item>... observers)
    throws NoItemToReplaceException, ObserverException;

    /**
     * Registers the specified {@link Observer} for the replace operations
     * of this {@link ObservedReplaceIterator}.
     *
     * @param replaceObserver
     *        additional replace {@link Observer}
     */
    void addReplaceObserver(Observer<Item> replaceObserver);
}
