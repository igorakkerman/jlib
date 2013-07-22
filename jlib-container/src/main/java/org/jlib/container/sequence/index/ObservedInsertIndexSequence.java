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

package org.jlib.container.sequence.index;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.sequence.InsertSequence;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.traverser.InvalidTraversibleStateException;

/**
 * {@link IndexSequence} and {@link InsertSequence}.
 *
 * @param <Item>
 *        type of items held in the {@link ObservedInsertIndexSequence}
 *
 * @author Igor Akkerman
 */
public interface ObservedInsertIndexSequence<Item>
extends InsertIndexSequence<Item> {

    /**
     * Inserts the Item at the specified index in this
     * {@link ObservedInsertIndexSequence} by the specified Items.
     *
     * @param index
     *        integer specifying the index
     *
     * @param item
     *        item to store
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     *
     * @throws InvalidSequenceIndexException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     *
     * @throws InvalidTraversibleArgumentException
     *         if some property of {@code item} prevents the operation from
     *         being performed
     *
     * @throws InvalidTraversibleStateException
     *         if an error occurs performing the operation
     */
    @SuppressWarnings("unchecked")
    public void insert(int index, Item item, ValueObserver<Item>... observers)
    throws InvalidSequenceIndexException, InvalidTraversibleArgumentException, InvalidTraversibleStateException;

    /**
     * Inserts the specified Items at the specified index of this
     * {@link ObservedInsertIndexSequence}.
     *
     * @param index
     *        integer specifying the index
     *
     * @param items
     *        {@link Container} holding the Items to insert
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     */
    @SuppressWarnings("unchecked")
    public void insert(int index, Container<? extends Item> items, ValueObserver<Item>... observers);

    /**
     * Inserts the specified Items at the specified index of this
     * {@link ObservedInsertIndexSequence}.
     *
     * @param index
     *        integer specifying the index
     *
     * @param items
     *        {@link Collection} holding the Items to insert
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     */
    @SuppressWarnings("unchecked")
    public void insert(int index, Collection<? extends Item> items, ValueObserver<Item>... observers);

    /**
     * Inserts the specified Items at the specified index of this
     * {@link ObservedInsertIndexSequence}.
     *
     * @param index
     *        integer specifying the index
     *
     * @param observers
     *        array of {@link ValueObserver} instances attending the operation
     *
     * @param items
     *        comma separated sequence holding the Items to insert
     */
    @SuppressWarnings("unchecked")
    public void insert(int index, ValueObserver<Item>[] observers, Item... items);
}
