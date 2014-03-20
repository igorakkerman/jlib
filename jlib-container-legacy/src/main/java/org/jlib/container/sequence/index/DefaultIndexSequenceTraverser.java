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

package org.jlib.container.operation.sequence.index;

import org.jlib.core.value.InitializedModifiable;
import org.jlib.core.value.Modifiable;
import org.jlib.core.value.Uninitialized;
import org.jlib.core.value.ValueNotAccessibleException;

import org.jlib.container.operation.sequence.AbstractSequenceIterator;
import org.jlib.container.operation.sequence.NoNextSequenceItemException;
import org.jlib.container.operation.sequence.NoPreviousSequenceItemException;
import org.jlib.container.operation.sequence.Sequence;

/**
 * Default implementation of an {@link IndexSequenceIterator}.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @param <Sequenze>
 *        type of the traversed {@link IndexSequence}
 *
 * @author Igor Akkerman
 */
public class DefaultIndexSequenceIterator<Item, Sequenze extends IndexSequence<Item>>
extends AbstractSequenceIterator<Item, Sequenze>
implements IndexSequenceIterator<Item> {

    /** index of the potential next traversed Item */
    private int potentialNextItemIndex;

    /** {@link Modifiable} for the index of the last accessed Item */
    private Modifiable<Integer> lastAccessedItemIndexHolder;

    /**
     * Creates a new {@link DefaultIndexSequenceIterator} over the Items of the
     * specified {@link IndexSequence} beginning at its first index.
     *
     * @param sequence
     *        {@link IndexSequence} to traverse
     */
    public DefaultIndexSequenceIterator(final Sequenze sequence) {
        super(sequence);

        potentialNextItemIndex = sequence.getFirstIndex();
    }

    /**
     * Creates a new {@link DefaultIndexSequenceIterator} over the Items of the
     * specified {@link IndexSequence} beginning the traversal at the specified
     * index.
     *
     * @param sequence
     *        {@link IndexSequence} to traverse
     *
     * @param initialNextItemIndex
     *        integer specifying the index of the initial next Item
     *
     * @throws InvalidSequenceIndexException
     *         if
     *         {@code initialNextItemIndex < sequence.getFirstIndex() || initialNextItemIndex > sequence.getLastIndex()}
     */
    public DefaultIndexSequenceIterator(final Sequenze sequence, final int initialNextItemIndex) {
        super(sequence);

        IndexSequenceUtility.ensureIndexValid(sequence, initialNextItemIndex);

        potentialNextItemIndex = initialNextItemIndex;

        unsetLastAccessedItem();
    }

    /**
     * Unregisters the last accessed Item.
     */
    protected void unsetLastAccessedItem() {
        lastAccessedItemIndexHolder = new Uninitialized<Integer>() {

            @Override
            public void setValue(final Integer index) {
                lastAccessedItemIndexHolder = new InitializedModifiable<>(index);
            }
        };
    }

    @Override
    public boolean hasPreviousItem() {
        return potentialNextItemIndex - 1 >= getSequence().getFirstIndex();
    }

    @Override
    public boolean hasNext() {
        return potentialNextItemIndex <= getSequence().getLastIndex();
    }

    @Override
    public final Item getPreviousItem()
    throws NoPreviousSequenceItemException {
        try {
            final Item sequenceItem = getSequenceItem(potentialNextItemIndex - 1);

            potentialNextItemIndex--;  // allow decrementation only if no exception is thrown

            return sequenceItem;
        }
        catch (final InvalidSequenceIndexException exception) {
            throw new NoPreviousSequenceItemException(getSequence(), exception);
        }
    }

    @Override
    public Item getNextItem()
    throws NoNextSequenceItemException {
        try {
            final Item sequenceItem = getSequenceItem(potentialNextItemIndex);

            potentialNextItemIndex++; // allow incrementation only if no exception is thrown

            return sequenceItem;
        }
        catch (final InvalidSequenceIndexException exception) {
            throw new NoNextSequenceItemException(getSequence(), exception);
        }
    }

    /**
     * Returns the Item stored at the specified index in the {@link Sequence}
     *
     * @param itemIndex
     *        integer specifying the index of the Item
     *
     * @return Item stored at {@code itemIndex}
     *
     * @throws InvalidSequenceIndexException
     *         if {@code itemIndex} is out of the index bounds
     */
    private Item getSequenceItem(final int itemIndex)
    throws InvalidSequenceIndexException {
        final Item item = getSequence().get(itemIndex);

        setLastAccessedItemIndex(itemIndex);

        return item;
    }

    @Override
    public int getPreviousItemIndex()
    throws NoPreviousSequenceItemException {

        final int previousItemIndex = potentialNextItemIndex - 1;

        if (previousItemIndex < getSequence().getFirstIndex())
            throw new NoPreviousSequenceItemException(getSequence());

        return previousItemIndex;
    }

    @Override
    public int getNextItemIndex() {
        if (! hasNext())
            throw new NoPreviousSequenceItemException(getSequence());

        return potentialNextItemIndex;
    }

    /**
     * Returns the index of the potential next Item, even if the index is higher
     * than {@link IndexSequence#getLastIndex()}.
     *
     * @return integer specifying the index of the potential next Item
     */
    protected int getPotentialNextItemIndex() {
        return potentialNextItemIndex;
    }

    /**
     * Returns the index of the last Item accessed by this
     * {@link DefaultIndexSequenceIterator}.
     *
     * @return integer specifying the index of the last accessed Item
     *
     * @throws ValueNotAccessibleException
     *         if no Item has been accessed
     */
    protected int getLastAccessedItemIndex()
    throws ValueNotAccessibleException {
        return lastAccessedItemIndexHolder.getValue();
    }

    /**
     * Registers the index of the last Item accessed by this
     * {@link DefaultIndexSequenceIterator}.
     *
     * @param lastAccessedItemIndex
     *        integer specifying the index
     */
    protected void setLastAccessedItemIndex(final int lastAccessedItemIndex) {
        lastAccessedItemIndexHolder.setValue(lastAccessedItemIndex);
    }
}
