package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;

/**
 * {@link AbstractIndexSequence} that can be initialized.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractInitializeableIndexSequence<Item>
extends AbstractIndexSequence<Item> {

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence}.
     * 
     * @param firstIndex
     *        integer specifying the initial minimum index of this
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @param lastIndex
     *        integer specifying the maximum index of this
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code  lastIndex < firstIndex}
     */
    public AbstractInitializeableIndexSequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param item
     *        Item to store
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    protected void replace(final int index, final Item item)
    throws SequenceIndexOutOfBoundsException {
        IndexSequenceUtility.assertIndexValid(this, index);

        replaceStoredItem(index, item);
    }

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item
     * expecting the index to be valid.
     * 
     * @param index
     *        integer specifying the valid index
     * 
     * @param item
     *        Item to store
     */
    protected abstract void replaceStoredItem(final int index, final Item item);
}
