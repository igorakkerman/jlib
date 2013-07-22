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

import org.jlib.container.ContainerUtility;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;
import org.jlib.core.observer.ValueObserver;

import java.util.Collection;

/**
 * {@link ReplaceInsertArraySequence} to which Items can be added.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class ReplaceInsertRemoveAllArraySequence<Item>
extends ReplaceInsertRemoveArraySequence<Item>
implements ObservedRemoveAllSequence<Item> {

    /**
     * Creates a new uninitialized {@link ReplaceInsertRemoveAllArraySequence}
     * with the specified first and last indices.
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
    protected ReplaceInsertRemoveAllArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with a first
     * index of {@code 0} and the specified number of Items.
     *
     * @param itemsCount
     *        integer specifying the initial number of Items
     *
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    protected ReplaceInsertRemoveAllArraySequence(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        super(itemsCount);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with a first
     * index of {@code 0} containing the specified Items.
     *
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertRemoveAllArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with the
     * specified first index containing the specified Items.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertRemoveAllArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with a first
     * index of {@code 0} containing the specified Items.
     *
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertRemoveAllArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with the
     * specified first index containing the specified Items.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertRemoveAllArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with a first
     * index of {@code 0} containing the specified Items.
     *
     * @param items
     *        {@link Sequence} of Items to store
     */
    public ReplaceInsertRemoveAllArraySequence(final Sequence<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with the
     * specified first index containing the specified Items.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        {@link Sequence} of Items to store
     */
    public ReplaceInsertRemoveAllArraySequence(final int firstIndex, final Sequence<? extends Item> items) {
        super(firstIndex, items);
    }

    @Override
    public void removeAll()
    throws InvalidTraversibleStateException {
        ContainerUtility.removeAll(this);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeAll(final ValueObserver<Item>... observers)
    throws InvalidTraversibleStateException {
        ContainerUtility.removeAll(this, observers);
    }
}
