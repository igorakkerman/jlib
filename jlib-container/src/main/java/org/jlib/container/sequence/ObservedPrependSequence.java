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

package org.jlib.container.sequence;

import java.util.Collection;

import org.jlib.container.GetContainer;

import org.jlib.core.observer.ValueObserver;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;

/**
 * {@link PrependSequence} to which Items can be prepended.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface ObservedPrependSequence<Item>
extends PrependSequence<Item> {

    /**
     * @throws InvalidTraversableArgumentException
     *         if some property of {@code item} prevents it from being
     *         prepended, for instance, if it is already contained
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    public void prepend(Item item, ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, RuntimeException;

    /**
     * Prepends all Items contained by the specified {@link GetContainer} to this
     * {@link ObservedPrependSequence}.
     *
     * @param items
     *        {@link GetContainer} containing the Items to prepend
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public void prepend(GetContainer<? extends Item> items, ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, RuntimeException;

    /**
     * Prepends all Items contained by the specified {@link Collection} to this
     * {@link ObservedPrependSequence}.
     *
     * @param items
     *        {@link Collection} containing the Items to prepend
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public void prepend(Collection<? extends Item> items, ValueObserver<Item>... observers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, RuntimeException;

    /**
     * Prepends all specified Items to this {@link ObservedPrependSequence}.
     *
     * @param observers
     *        array of {@link ValueObserver} instances attending the operation
     *
     * @param items
     *        comma separated sequence of Items to prepend
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public void prepend(ValueObserver<Item>[] observers, Item... items)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, RuntimeException;
}
