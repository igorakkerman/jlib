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

import static org.jlib.core.language.ExceptionMessageUtility.message;

import static org.jlib.container.sequence.index.IndexSequenceUtility.ensureIndexValid;

import org.jlib.container.Container;
import org.jlib.container.sequence.AbstractNonEmptySequence;

/**
 * Skeletal implementation of an {@link IndexSequence}.
 *
 * @param <Item>
 *        type of the items of the sequence
 *
 * @author Igor Akkerman
 */
public abstract class AbstractIndexSequence<Item>
extends AbstractNonEmptySequence<Item>
implements IndexSequence<Item> {

    /** current minimum index of this sequence */
    private int firstIndex;

    /** current maximum index of this sequence */
    private int lastIndex;

    /**
     * Creates a new AbstractNonEmptyIndexSequence with the specified minimum
     * and maximum indices. Classes extending this class must ensureCapacityAndShiftItems the
     * Item store.
     *
     * @param firstIndex
     *        integer specifying the initial minimum index of this ArraySequence
     *
     * @param lastIndex
     *        integer specifying the maximum index of this ArraySequence
     *
     * @throws InvalidSequenceIndexException
     *         if {@code lastIndex < firstIndex}
     */
    protected AbstractIndexSequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexException {
        super();

        if (lastIndex < firstIndex)
            throw new InvalidSequenceIndexException(this, message("lastIndex = {0} < {1} = firstIndex", lastIndex,
                                                                  firstIndex));

        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }

    @Override
    public final Item get(final int index)
    throws InvalidSequenceIndexException {
        ensureIndexValid(this, index);

        return getStoredItem(index);
    }

    /**
     * Returns the Item stored at the specified index expecting the index to be
     * valid.
     *
     * @param index
     *        integer specifying the valid index
     *
     * @return Item stored at {@code index}
     */
    protected abstract Item getStoredItem(int index);

    @Override
    public final Item getFirstItem() {
        return getStoredItem(firstIndex);
    }

    @Override
    public final Item getLastItem() {
        return getStoredItem(lastIndex);
    }

    @Override
    public final int getItemIndex(final Item item)
    throws NoSuchSequenceItemException {
        for (int index = firstIndex; index <= lastIndex; index++)
            if (getStoredItem(index).equals(item))
                return index;

        throw new NoSuchSequenceItemException(this, item);
    }

    @Override
    public final int getLastItemIndex(final Item item)
    throws NoSuchSequenceItemException {
        for (int index = lastIndex; index >= firstIndex; index--)
            if (getStoredItem(index).equals(item))
                return index;

        throw new NoSuchSequenceItemException(this, item);
    }

    @Override
    public IndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws InvalidSequenceIndexException {
        return new SubIndexSequence<>(this, fromIndex, toIndex);
    }

    @Override
    public final int getFirstIndex() {
        return firstIndex;
    }

    @Override
    public final int getLastIndex() {
        return lastIndex;
    }

    @Override
    public int getItemsCount() {
        return lastIndex - firstIndex + 1;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder(8 * getItemsCount());

        final IndexSequenceTraverser<Item> itemsTraverser = createTraverser();

        stringBuilder.append('[');

        getNextItemString(stringBuilder, itemsTraverser);

        while (itemsTraverser.hasNextItem()) {
            stringBuilder.append(", ");
            getNextItemString(stringBuilder, itemsTraverser);
        }

        stringBuilder.append(']');

        return stringBuilder.toString();
    }

    @Override
    protected boolean hasMatchingProperties(final Container<Item> otherContainer) {
        if (! super.hasMatchingProperties(otherContainer))
            return false;

        final IndexSequence<Item> otherSequence = (IndexSequence<Item>) otherContainer;

        return otherSequence.getFirstIndex() == firstIndex && otherSequence.getLastIndex() == lastIndex;
    }

    /**
     * Appends a {@link String} representation of the next Item returned by the
     * specified {@link IndexSequenceTraverser} to the specified
     * {@link StringBuilder}.
     *
     * @param stringBuilder
     *        {@link StringBuilder} to which the Item representation is appended
     *
     * @param itemsTraverser
     *        {@link IndexSequenceTraverser} providing the Item
     */
    private void getNextItemString(final StringBuilder stringBuilder,
                                   final IndexSequenceTraverser<Item> itemsTraverser) {
        stringBuilder.append(itemsTraverser.getNextItemIndex());
        stringBuilder.append(": ");
        stringBuilder.append(itemsTraverser.getNextItem());
    }

    /**
     * Registers the first index of this {@link AbstractIndexSequence}.
     *
     * @param firstIndex
     *        integer specifying the first index
     */
    protected void setFirstIndex(final int firstIndex) {
        this.firstIndex = firstIndex;
    }

    /**
     * Registers the last index of this {@link AbstractIndexSequence}.
     *
     * @param lastIndex
     *        integer specifying the last index
     */
    protected void setLastIndex(final int lastIndex) {
        this.lastIndex = lastIndex;
    }

    @Override
    public IndexSequenceTraverser<Item> createTraverser() {
        return createTraverser(firstIndex);
    }

    @Override
    public IndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws InvalidSequenceIndexException {
        return new DefaultIndexSequenceTraverser<>(this, startIndex);
    }
}
