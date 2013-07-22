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

package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.IndexSequence;
import org.jlib.container.sequence.index.LinearIndexStorageSequence;
import org.jlib.core.array.ArrayStorage;
import org.jlib.core.storage.LinearIndexStorage;

/**
 * {@link IndexSequence} baked by an array.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class ArraySequence<Item>
extends LinearIndexStorageSequence<Item> {

    /**
     * Creates a new uninitialized {@link ArraySequence} with the specified
     * first and last indices.
     *
     * @param firstIndex
     *        integer specifying the initial first index
     *
     * @param lastIndex
     *        integer specifying the initial last index
     *
     * @throws InvalidSequenceIndexRangeException
     *         if {@code lastIndex < firstIndex}
     */
    protected ArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link ArraySequence} with a first index of {@code 0} and
     * the specified number of {@link Item}s.
     *
     * @param itemsCount
     *        integer specifying the initial number of {@link Item}s
     *
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    public ArraySequence(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        super(itemsCount);
    }

    /**
     * Creates a new {@link ArraySequence} with a first index of {@code 0}
     * containing the specified {@link Item}s.
     *
     * @param items
     *        comma separated sequence of {@link Item}s to store
     */
    @SafeVarargs
    public ArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ArraySequence} with the specified first index
     * containing the specified {@link Item}s.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        comma separated sequence of {@link Item}s to store
     */
    @SafeVarargs
    public ArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ArraySequence} with a first index of {@code 0}
     * containing the specified {@link Item}s.
     *
     * @param items
     *        {@link Collection} of {@link Item}s to store
     */
    public ArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ArraySequence} with the specified first index
     * containing the specified {@link Item}s.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        {@link Collection} of {@link Item}s to store
     */
    public ArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ArraySequence} with a first index of {@code 0}
     * containing the specified {@link Item}s.
     *
     * @param items
     *        {@link Container} of {@link Item}s to store
     */
    public ArraySequence(final Container<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ArraySequence} with the specified first index
     * containing the specified {@link Item}s.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        {@link Container} of {@link Item}s to store
     */
    public ArraySequence(final int firstIndex, final Container<? extends Item> items) {
        super(firstIndex, items);
    }

    @Override
    protected LinearIndexStorage<Item> createStorage() {
        return new ArrayStorage<>();
    }
}
