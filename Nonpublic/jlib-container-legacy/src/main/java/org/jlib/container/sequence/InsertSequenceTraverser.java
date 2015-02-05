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

package org.jlib.container.operation.sequence;

import org.jlib.container.operation.InvalidContainerArgumentException;
import org.jlib.container.operation.InvalidContainerStateException;
import org.jlib.container.operation.sequence.index.IndexSequenceIterator;

/**
 * {@link SequenceIterator} over a {@link InsertSequence}.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface InsertSequenceIterator<Item>
extends SequenceIterator<Item> {

    /**
     * <p>
     * Inserts the specified Item into the sequence at the current position of
     * this {@link IndexSequenceIterator}.
     * </p>
     * <p>
     * The Item is inserted immediately before the next Item that would have
     * been returned by {@link #next()} and immediately after the
     * previous Item that would have been returned by {@link #getPreviousItem()}
     * .
     * </p>
     * <p>
     * A subsequent call to {@link #next()} would be unaffected, and a
     * subsequent call to {@link #getPreviousItem()} would return the new item.
     * </p>
     *
     * @param item
     *        Item to insert
     *
     * @throws InvalidContainerArgumentException
     *         if some property of {@code item} prevents it from being inserted
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public void insert(Item item)
    throws InvalidContainerArgumentException, InvalidContainerStateException;
}