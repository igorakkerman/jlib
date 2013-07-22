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
import org.jlib.container.SoleItemNotRemoveableException;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.ObservedRemoveFirstSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.operator.HandledOperator;
import org.jlib.core.operator.OperatorException;

/**
 * {@link ReplaceAppendArraySequence} from which Items can be removed at its
 * ends, that is, its head and tail.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class ReplaceInsertRemoveFirstLastArraySequence<Item>
extends ReplaceInsertRemoveLastArraySequence<Item>
implements ObservedRemoveFirstSequence<Item> {

    /**
     * Creates a new uninitialized
     * {@link ReplaceInsertRemoveFirstLastArraySequence} with the specified
     * first and last indices.
     *
     * @param firstIndex
     *        integer specifying the initial first index
     *
     * @param lastIndex
     *        integer specifying the initial last index
     *
     * @throws InvalidSequenceIndexException
     *         if {@code lastIndex < firstIndex}
     */
    protected ReplaceInsertRemoveFirstLastArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with a
     * first index of {@code 0} and the specified number of Items.
     *
     * @param itemsCount
     *        integer specifying the initial number of Items
     *
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    protected ReplaceInsertRemoveFirstLastArraySequence(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        super(itemsCount);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with a
     * first index of {@code 0} containing the specified Items.
     *
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertRemoveFirstLastArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with the
     * specified first index containing the specified Items.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertRemoveFirstLastArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with a
     * first index of {@code 0} containing the specified Items.
     *
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertRemoveFirstLastArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with the
     * specified first index containing the specified Items.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertRemoveFirstLastArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with a
     * first index of {@code 0} containing the specified Items.
     *
     * @param items
     *        {@link Container} of Items to store
     */
    public ReplaceInsertRemoveFirstLastArraySequence(final Container<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveFirstLastArraySequence} with the
     * specified first index containing the specified Items.
     *
     * @param firstIndex
     *        integer specifying the first index
     *
     * @param items
     *        {@link Container} of Items to store
     */
    public ReplaceInsertRemoveFirstLastArraySequence(final int firstIndex, final Container<? extends Item> items) {
        super(firstIndex, items);
    }

    @Override
    public void removeFirstItem() {
        final int firstIndex = getFirstIndex();

        if (firstIndex == getLastIndex())
            throw new SoleItemNotRemoveableException(this);

        setFirstIndex(firstIndex + 1);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeFirstItem(final ValueObserver<Item>... observers) {
        ObserverUtility.operate(new HandledOperator() {

            @Override
            public void operate()
            throws OperatorException {
                try {
                    removeFirstItem();
                }
                catch (final SoleItemNotRemoveableException exception) {
                    throw new OperatorException("removeFirstItem {0}", exception);
                }
            }
        },

                                getStoredItem(getFirstIndex()), observers);
    }
}
