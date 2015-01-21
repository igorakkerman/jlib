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
 * {@link ReplaceInsertArraySequence} to which Items can be added.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class ReplaceInsertRemoveArraySequence<Item>
/*extends ReplaceInsertRemoveFirstLastArraySequence<Item>
implements ObservedReplaceIndexSequence<Item> */ {
//
//    /**
//     * Creates a new uninitialized {@link ReplaceInsertRemoveArraySequence} with
//     * the specified first and last indices.
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
//    protected ReplaceInsertRemoveArraySequence(final int firstIndex, final int lastIndex)
//    throws InvalidSequenceIndexException {
//        super(firstIndex, lastIndex);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveArraySequence} with a first index
//     * of {@code 0} and the specified number of Items.
//     *
//     * @param itemsCount
//     *        integer specifying the initial number of Items
//     *
//     * @throws InvalidSequenceItemsCountException
//     *         if {@code itemsCount < 1}
//     */
//    protected ReplaceInsertRemoveArraySequence(final int itemsCount)
//    throws InvalidSequenceItemsCountException {
//        super(itemsCount);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveArraySequence} with a first index
//     * of {@code 0} containing the specified Items.
//     *
//     * @param items
//     *        comma separated sequence of Items to store
//     */
//    @SafeVarargs
//    public ReplaceInsertRemoveArraySequence(final Item... items) {
//        super(items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveArraySequence} with the specified
//     * first index containing the specified Items.
//     *
//     * @param firstIndex
//     *        integer specifying the first index
//     *
//     * @param items
//     *        comma separated sequence of Items to store
//     */
//    @SafeVarargs
//    public ReplaceInsertRemoveArraySequence(final int firstIndex, final Item... items) {
//        super(firstIndex, items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveArraySequence} with a first index
//     * of {@code 0} containing the specified Items.
//     *
//     * @param items
//     *        {@link Collection} of Items to store
//     */
//    public ReplaceInsertRemoveArraySequence(final Collection<? extends Item> items) {
//        super(items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveArraySequence} with the specified
//     * first index containing the specified Items.
//     *
//     * @param firstIndex
//     *        integer specifying the first index
//     *
//     * @param items
//     *        {@link Collection} of Items to store
//     */
//    public ReplaceInsertRemoveArraySequence(final int firstIndex, final Collection<? extends Item> items) {
//        super(firstIndex, items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveArraySequence} with a first index
//     * of {@code 0} containing the specified Items.
//     *
//     * @param items
//     *        {@link Object} of Items to store
//     */
//    public ReplaceInsertRemoveArraySequence(final IterableContainer<? extends Item> items) {
//        super(items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceInsertRemoveArraySequence} with the specified
//     * first index containing the specified Items.
//     *
//     * @param firstIndex
//     *        integer specifying the first index
//     *
//     * @param items
//     *        {@link Sequence} of Items to store
//     */
//    public ReplaceInsertRemoveArraySequence(final int firstIndex, final Sequence<? extends Item> items) {
//        super(firstIndex, items);
//    }
//
//    @Override
//    public void retain(final int index) {
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void retain(final int index, final ValueObserver<Item>... observers) {
//        IndexSequenceUtility.retain(this, index, observers);
//    }
//
//    @Override
//    public void remove(final IterableContainer<? extends Item> items)
//    throws InvalidContainerArgumentException, InvalidContainerStateException {
//        ContainerUtility.remove(this, items);
//    }
//
//    @Override
//    public void remove(final Collection<? extends Item> items)
//    throws InvalidContainerArgumentException, InvalidContainerStateException {
//        ContainerUtility.remove(this, items);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void remove(final Item... items)
//    throws InvalidContainerArgumentException, InvalidContainerStateException {
//        ContainerUtility.remove(this, items);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void remove(final IterableContainer<? extends Item> items, final ValueObserver<Item>... observers)
//    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {
//        ContainerUtility.remove(this, items, observers);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void remove(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
//    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {
//        ContainerUtility.remove(this, items, observers);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void remove(final ValueObserver<Item>[] observers, final Item... items)
//    throws InvalidContainerArgumentException, InvalidContainerStateException, ValueObserverException {
//        ContainerUtility.remove(this, observers, items);
//    }
//
//    @Override
//    public ObservedReplaceInsertRemoveIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
//    throws InvalidSequenceIndexException, InvalidSequenceIndexException {
//        return new SubReplaceInsertRemoveIndexSequence<>(this, fromIndex, toIndex);
//    }
//
//    @Override
//    public ObservedReplaceInsertRemoveIndexSequenceIterator<Item> iterator() {
//        return new DefaultReplaceInsertRemoveIndexSequenceIterator<>(this);
//    }
//
//    @Override
//    public ObservedReplaceInsertRemoveIndexSequenceIterator<Item> iterator(final int startIndex) {
//        return new DefaultReplaceInsertRemoveIndexSequenceIterator<>(this, startIndex);
//    }
}
