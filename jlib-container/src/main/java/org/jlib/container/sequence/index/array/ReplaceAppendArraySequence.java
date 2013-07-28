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

/**
 * {@link ReplaceArraySequence} to which Items can be added.
 *
 * @param <Item>
 *        type of items held in the {@link ReplaceAppendArraySequence}
 *
 * @author Igor Akkerman
 */
public class ReplaceAppendArraySequence<Item>
/*extends ReplaceArraySequence<Item>
implements ObservedAppendSequence<Item> */ {

//    /**
//     * Creates a new uninitialized {@link ReplaceAppendArraySequence} with the
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
//    protected ReplaceAppendArraySequence(final int firstIndex, final int lastIndex)
//    throws InvalidSequenceIndexException {
//        super(firstIndex, lastIndex);
//    }
//
//    /**
//     * Creates a new {@link ReplaceAppendArraySequence} with a first index of
//     * {@code 0} and the specified number of Items.
//     *
//     * @param itemsCount
//     *        integer specifying the initial number of Items
//     *
//     * @throws InvalidSequenceItemsCountException
//     *         if {@code itemsCount < 1}
//     */
//    protected ReplaceAppendArraySequence(final int itemsCount)
//    throws InvalidSequenceItemsCountException {
//        super(itemsCount);
//    }
//
//    /**
//     * Creates a new {@link ReplaceAppendArraySequence} with a first index of
//     * {@code 0} containing the specified Items.
//     *
//     * @param items
//     *        comma separated sequence of Items to store
//     */
//    @SafeVarargs
//    public ReplaceAppendArraySequence(final Item... items) {
//        super(items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceAppendArraySequence} with the specified first
//     * index containing the specified Items.
//     *
//     * @param firstIndex
//     *        integer specifying the first index
//     *
//     * @param items
//     *        comma separated sequence of Items to store
//     */
//    @SafeVarargs
//    public ReplaceAppendArraySequence(final int firstIndex, final Item... items) {
//        super(firstIndex, items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceAppendArraySequence} with a first index of
//     * {@code 0} containing the specified Items.
//     *
//     * @param items
//     *        {@link Collection} of Items to store
//     */
//    public ReplaceAppendArraySequence(final Collection<? extends Item> items) {
//        super(items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceAppendArraySequence} with the specified first
//     * index containing the specified Items.
//     *
//     * @param firstIndex
//     *        integer specifying the first index
//     *
//     * @param items
//     *        {@link Collection} of Items to store
//     */
//    public ReplaceAppendArraySequence(final int firstIndex, final Collection<? extends Item> items) {
//        super(firstIndex, items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceAppendArraySequence} with a first index of
//     * {@code 0} containing the specified Items.
//     *
//     * @param items
//     *        {@link TraversableContainer} of Items to store
//     */
//    public ReplaceAppendArraySequence(final TraversableContainer<? extends Item> items) {
//        super(items);
//    }
//
//    /**
//     * Creates a new {@link ReplaceAppendArraySequence} with the specified first
//     * index containing the specified Items.
//     *
//     * @param firstIndex
//     *        integer specifying the first index
//     *
//     * @param items
//     *        {@link TraversableContainer} of Items to store
//     */
//    public ReplaceAppendArraySequence(final int firstIndex, final TraversableContainer<? extends Item> items) {
//        super(firstIndex, items);
//    }
//
//    @Override
//    public void append(final Item item) {
//        // intentionally not using SequenceUtility for efficiency
//        append(singleton(item));
//    }
//
//    @Override
//    public void append(final TraversableContainer<? extends Item> items) {
//        // intentionally not using SequenceUtility for efficiency
//        append(items, items.getCount());
//    }
//
//    @Override
//    public void append(final Collection<? extends Item> items) {
//        // intentionally not using SequenceUtility for efficiency
//        append(items, items.size());
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public final void append(final Item... items) {
//        // intentionally not using SequenceUtility for efficiency
//        append(iterable(items), items.length);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public final void append(final Item item, final ValueObserver<Item>... observers)
//    throws InvalidContainerArgumentException {
//        append(singleton(item), 1, observers);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public final void append(final TraversableContainer<? extends Item> items, final ValueObserver<Item>... observers)
//    throws InvalidContainerArgumentException {
//        append(items, items.getCount(), observers);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public final void append(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
//    throws InvalidContainerArgumentException {
//        append(items, items.size(), observers);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public final void append(final ValueObserver<Item>[] observers, final Item... items)
//    throws InvalidContainerArgumentException {
//        append(iterable(items), items.length, observers);
//    }
//
//    /**
//     * Appends all Items contained by the specified {@link TraversableContainer} to this
//     * {@link ObservedAppendSequence}.
//     *
//     * @param items
//     *        {@link Iterable} providing the Items to add
//     *
//     * @param addedItemsCount
//     *        integer specifying the number of added Items; {@code items} must
//     *        provide at least these {@code addedItemsCount} Items
//     *
//     * @param observers
//     *        comma separated sequence of {@link ValueObserver} instances
//     *        attending the operation
//     *
//     * @throws RuntimeException
//     *         if a {@link ValueObserver} operation throws this
//     *         {@link RuntimeException}
//     */
//    @SafeVarargs
//    private final void append(final Iterable<? extends Item> items, final int addedItemsCount,
//                              final ValueObserver<Item>... observers) {
//        getCapacityStrategy().ensureTailCapacity(addedItemsCount);
//
//        int storageItemIndex = getStorageItemIndex(getLastIndex());
//
//        for (final Item item : items) {
//            final int currentStorageItemIndex = ++ storageItemIndex;
//            ObserverUtility.operate(new HandledOperator() {
//
//                @Override
//                public void operate() {
//                    getStorage().replaceItem(currentStorageItemIndex, item);
//                }
//            },
//
//                                    item, observers);
//        }
//
//        setLastIndex(getLastIndex() + addedItemsCount);
//        getStorage().incrementLastItemIndex(addedItemsCount);
//    }
}
