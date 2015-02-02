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
 * {@link ArraySequence} allowing its Items to be replaced.
 *
 * @param <Item>
 *        type of the items of the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class ReplaceArraySequence<Item>
/*extends ArraySequence<Item>
implements ObservedReplaceIndexSequence<Item> */{

//    /**
//     * Creates a new uninitialized {@link ReplaceArraySequence} with the
//     * specified first and last indices.
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
//    protected ReplaceArraySequence(final int firstIndex, final int lastIndex)
//    throws InvalidSequenceIndexException {
//        super(firstIndex, lastIndex);
//    }
//
//    /**
//     * Creates a new {@link ReplaceArraySequence} with a first index of
//     * {@code 0} and the specified number of Items.
//     *
//     * @param itemsCount
//     *        integer specifying the initial number of Items
//     *
//     * @throws InvalidSequenceItemsCountException
//     *         if {@code itemsCount < 1}
//     */
//    protected ReplaceArraySequence(final int itemsCount)
//    throws InvalidSequenceItemsCountException {
//        super(itemsCount);
//    }
//
//    /**
//     * Creates a new {@link ReplaceArraySequence} with a first index of
//     * {@code 0} containing the specified Items.
//     *
//     * @param items
//     *        comma separated sequence of Items to store
//     */
//    @SafeVarargs
//    public ReplaceArraySequence(final Item... items) {
//        super(items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceArraySequence} with the specified first index
//     * containing the specified Items.
//     *
//     * @param firstIndex
//     *        integer specifying the first index
//     *
//     * @param items
//     *        comma separated sequence of Items to store
//     */
//    @SafeVarargs
//    public ReplaceArraySequence(final int firstIndex, final Item... items) {
//        super(firstIndex, items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceArraySequence} with a first index of
//     * {@code 0} containing the specified Items.
//     *
//     * @param items
//     *        {@link Collection} of Items to store
//     */
//    public ReplaceArraySequence(final Collection<? extends Item> items) {
//        super(items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceArraySequence} with the specified first index
//     * containing the specified Items.
//     *
//     * @param firstIndex
//     *        integer specifying the first index
//     *
//     * @param items
//     *        {@link Collection} of Items to store
//     */
//    public ReplaceArraySequence(final int firstIndex, final Collection<? extends Item> items) {
//        super(firstIndex, items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceArraySequence} with a first index of
//     * {@code 0} containing the specified Items.
//     *
//     * @param items
//     *        {@link Object} of Items to store
//     */
//    public ReplaceArraySequence(final IterableContainer<? extends Item> items) {
//        super(items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceArraySequence} with the specified first index
//     * containing the specified Items.
//     *
//     * @param firstIndex
//     *        integer specifying the first index
//     *
//     * @param items
//     *        {@link Object} of Items to store
//     */
//    public ReplaceArraySequence(final int firstIndex, final IterableContainer<? extends Item> items) {
//        super(firstIndex, items);
//    }
//
//    @Override
//    // raising visibility from protected to public
//    public void replace(final int index, final Item newItem)
//    throws InvalidSequenceIndexException {
//        super.replace(index, newItem);
//    }
//
//    @Override
//    @SafeVarargs
//    // raising visibility from protected to public
//    public final void replace(final int index, final Item newItem, final ValueObserver<Item>... observers)
//    throws InvalidSequenceIndexException {
//        super.replace(index, newItem, observers);
//    }
//
//    @Override
//    public ObservedReplaceIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
//    throws InvalidSequenceIndexException, InvalidSequenceIndexException {
//        return new SubReplaceIndexSequence<>(this, fromIndex, toIndex);
//    }
//
//    @Override
//    public ObservedReplaceIndexSequenceIterator<Item> iterator()
//    throws InvalidSequenceIndexException {
//        return new DefaultReplaceIndexSequenceIterator<>(this);
//    }
//
//    @Override
//    public ObservedReplaceIndexSequenceIterator<Item> iterator(final int startIndex)
//    throws InvalidSequenceIndexException {
//        return new DefaultReplaceIndexSequenceIterator<>(this, startIndex);
//    }
}
