package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;
import org.jlib.core.observer.ValueObserver;

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
     * @param newItem
     *        Item to store
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    protected void replace(final int index, final Item newItem)
    throws SequenceIndexOutOfBoundsException {
        IndexSequenceUtility.assertIndexValid(this, index);

        replaceStoredItem(index, newItem);
    }

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param newItem
     *        Item to store
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    @SuppressWarnings("unchecked")
    protected void replace(final int index, final Item newItem, final ValueObserver<Item>... observers)
    throws SequenceIndexOutOfBoundsException {
        IndexSequenceUtility.assertIndexValid(this, index);

        replaceStoredItem(index, newItem, observers);
    }

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item
     * expecting the index to be valid.
     * 
     * @param index
     *        integer specifying the valid index
     * 
     * @param newItem
     *        Item to store
     */
    protected abstract void replaceStoredItem(final int index, final Item newItem);

    /**
     * Replaces the Item stored at the specified index in this
     * {@link AbstractInitializeableIndexSequence} by the specified Item
     * expecting the index to be valid.
     * 
     * @param index
     *        integer specifying the valid index
     * 
     * @param newItem
     *        Item to store
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} in {@code observers} throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    protected abstract void replaceStoredItem(final int index, final Item newItem, ValueObserver<Item>... observers)
    throws RuntimeException;
}
