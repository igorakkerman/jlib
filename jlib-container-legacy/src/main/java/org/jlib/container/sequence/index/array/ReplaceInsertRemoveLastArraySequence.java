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

package org.jlib.container.operation.sequence.index.array;

import org.jlib.container.operation.sequence.Sequence;

/**
 * {@link ReplaceAppendArraySequence} into which Items can be inserted.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class ReplaceInsertRemoveLastArraySequence<Item>
/*extends ReplaceInsertArraySequence<Item>
implements ObservedReplaceInsertIndexSequence<Item>,
           ObservedRemoveLastSequence<Item> */{

//    /**
//     * Creates a new uninitialized {@link ReplaceInsertRemoveLastArraySequence}
//     * with the specified first and last indices.
//     *
//     * @param firstIndex
//     *        integer specifying the initial first index
//     *
//     * @param lastIndex
//     *        integer specifying the initial last index
//     *
//     * @throws InvalidSequenceIndexException
//     *         if {@code lastIndex < firstIndex}
//     */
//    protected ReplaceInsertRemoveLastArraySequence(final int firstIndex, final int lastIndex)
//    throws InvalidSequenceIndexException {
//        super(firstIndex, lastIndex);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveLastArraySequence} with a first
//     * index of {@code 0} and the specified number of Items.
//     *
//     * @param itemsCount
//     *        integer specifying the initial number of Items
//     *
//     * @throws InvalidSequenceItemsCountException
//     *         if {@code itemsCount < 1}
//     */
//    protected ReplaceInsertRemoveLastArraySequence(final int itemsCount)
//    throws InvalidSequenceItemsCountException {
//        super(itemsCount);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveLastArraySequence} with a first
//     * index of {@code 0} containing the specified Items.
//     *
//     * @param items
//     *        comma separated sequence of Items to store
//     */
//    @SafeVarargs
//    public ReplaceInsertRemoveLastArraySequence(final Item... items) {
//        super(items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveLastArraySequence} with the
//     * specified first index containing the specified Items.
//     *
//     * @param firstIndex
//     *        integer specifying the first index
//     *
//     * @param items
//     *        comma separated sequence of Items to store
//     */
//    @SafeVarargs
//    public ReplaceInsertRemoveLastArraySequence(final int firstIndex, final Item... items) {
//        super(firstIndex, items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveLastArraySequence} with a first
//     * index of {@code 0} containing the specified Items.
//     *
//     * @param items
//     *        {@link Collection} of Items to store
//     */
//    public ReplaceInsertRemoveLastArraySequence(final Collection<? extends Item> items) {
//        super(items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveLastArraySequence} with the
//     * specified first index containing the specified Items.
//     *
//     * @param firstIndex
//     *        integer specifying the first index
//     *
//     * @param items
//     *        {@link Collection} of Items to store
//     */
//    public ReplaceInsertRemoveLastArraySequence(final int firstIndex, final Collection<? extends Item> items) {
//        super(firstIndex, items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveLastArraySequence} with a first
//     * index of {@code 0} containing the specified Items.
//     *
//     * @param items
//     *        {@link IterableContainer} of Items to store
//     */
//    public ReplaceInsertRemoveLastArraySequence(final IterableContainer<? extends Item> items) {
//        super(items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveLastArraySequence} with the
//     * specified first index containing the specified Items.
//     *
//     * @param firstIndex
//     *        integer specifying the first index
//     *
//     * @param items
//     *        {@link IterableContainer} of Items to store
//     */
//    public ReplaceInsertRemoveLastArraySequence(final int firstIndex, final IterableContainer<? extends Item> items) {
//        super(firstIndex, items);
//    }
//
//    @Override
//    public void removeLastItem()
//    throws SoleItemNotRemoveableException {
//        final int lastIndex = getLastIndex();
//
//        if (lastIndex == getFirstIndex())
//            throw new SoleItemNotRemoveableException(this);
//
//        setLastIndex(lastIndex - 1);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void removeLastItem(final ValueObserver<Item>... observers) {
//        ObserverUtility.operate(new HandledOperator() {
//
//            @Override
//            public void operate()
//            throws OperatorException {
//                try {
//                    removeLastItem();
//                }
//                catch (final SoleItemNotRemoveableException exception) {
//                    throw new OperatorException(message("removeLastItem()"), exception);
//                }
//            }
//        }, getStoredItem(getLastIndex()), observers);
//    }
}
