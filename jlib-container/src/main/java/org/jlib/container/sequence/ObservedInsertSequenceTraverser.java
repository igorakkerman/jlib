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

import org.jlib.container.sequence.index.IndexSequenceTraverser;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;

/**
 * {@link IndexSequenceTraverser} allowing observed insertion of Items.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface ObservedInsertSequenceTraverser<Item>
extends InsertSequenceTraverser<Item> {

    /**
     * <p>
     * Inserts the specified Item into the sequence at the current position of
     * this {@link IndexSequenceTraverser}.
     * </p>
     * <p>
     * The Item is inserted immediately before the next Item that would have
     * been returned by {@link #getNextItem()} and immediately after the
     * previous Item that would have been returned by {@link #getPreviousItem()}
     * .
     * </p>
     * <p>
     * A subsequent call to {@link #getNextItem()} would be unaffected, and a
     * subsequent call to {@link #getPreviousItem()} would return the new item.
     * </p>
     *
     * @param operationObservers
     *        comma separated sequence of {@link ValueObserver} items attending
     *        the operation
     *
     * @param item
     *        Item to insert
     *
     * @throws InvalidTraversableArgumentException
     *         if some property of {@code item} prevents it from being inserted
     *
     * @throws InvalidTraversableStateException
     *         if an error occurs during the operation
     *
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public void insert(Item item, ValueObserver<Item>... operationObservers)
    throws InvalidTraversableArgumentException, InvalidTraversableStateException, RuntimeException;

    /**
     * Registers the specified {@link ValueObserver} for the insert operations
     * of this {@link ObservedRemoveSequenceTraverser}.
     *
     * @param insertObserver
     *        additional insert {@link ValueObserver}
     */
    public void addInsertObserver(ValueObserver<Item> insertObserver);
}
