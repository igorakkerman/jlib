package org.jlib.container.sequence.index;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.sequence.IllegalSequenceSizeException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceUtility;
import org.jlib.container.sequence.index.array.InvalidStoredItemsCountException;
import org.jlib.core.array.ArrayUtility;
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
     * Creates a new uninitialized {@link AbstractInitializeableIndexSequence}
     * with the specified first and last indices.
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
     *         if {@code lastIndex < firstIndex}
     */
    protected AbstractInitializeableIndexSequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * specified Items. That is, the index of the first Item of the specified
     * sequence in this Sequence is 0. The fixed size of the
     * {@link AbstractInitializeableIndexSequence} is the size of the specified
     * sequence.
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    protected AbstractInitializeableIndexSequence(final Item... items) {
        this(0, items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * specified Items having a specified first index. That is, the index of the
     * first Item of the specified sequence in the
     * {@link AbstractInitializeableIndexSequence} can be specified. The fixed
     * size of the {@link AbstractInitializeableIndexSequence} is the size of
     * the specified sequence.
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @param items
     *        comma separated sequence of Items to store s
     */
    @SafeVarargs
    protected AbstractInitializeableIndexSequence(final int firstIndex, final Item... items) {
        this(firstIndex, firstIndex + items.length - 1);

        storeItems(items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} with a first
     * index of {@code 0} and the specified size.
     * 
     * @param size
     *        integer specifying the size of the new
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @throws IllegalSequenceSizeException
     *         if {@code size < 1}
     */
    protected AbstractInitializeableIndexSequence(final int size)
    throws IllegalSequenceSizeException {
        this(0, SequenceUtility.getValidatedSequenceSize(size) - 1);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Container. The index of the first Item of the
     * specified Container in the {@link AbstractInitializeableIndexSequence} is
     * 0. The fixed size of the {@link AbstractInitializeableIndexSequence} is
     * the size of the specified Container.
     * 
     * @param items
     *        Container of which the Items are copied to the
     *        {@link AbstractInitializeableIndexSequence}
     */

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Java Container. The index of the first Item of the
     * specified Container in the {@link AbstractInitializeableIndexSequence} is
     * 0. The fixed size of the {@link AbstractInitializeableIndexSequence} is
     * the size of the specified Container.
     * 
     * @param items
     *        Collection of which the Items are copied to the
     *        {@link AbstractInitializeableIndexSequence}
     */

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Container having a specified first index. That is,
     * the index of the first Item of the specified collection in the
     * {@link AbstractInitializeableIndexSequence} can be specified. The fixed
     * size of the {@link AbstractInitializeableIndexSequence} is the size of
     * the specified Container.
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link AbstractInitializeableIndexSequence}. The first Item of
     *        {@code collection} is stored at this index of the newly created
     *        {@link AbstractInitializeableIndexSequence}.
     * 
     * @param items
     *        Container of which the Items are copied to the
     *        {@link AbstractInitializeableIndexSequence}
     */

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Container having a specified first index. That is,
     * the index of the first Item of the specified collection in the
     * {@link AbstractInitializeableIndexSequence} can be specified. The fixed
     * size of the {@link AbstractInitializeableIndexSequence} is the size of
     * the specified Container.
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link AbstractInitializeableIndexSequence}. The first Item of
     *        {@code collection} is stored at this index of the newly created
     *        {@link AbstractInitializeableIndexSequence}.
     * 
     * @param items
     *        {@link Collection} containing the Items for the
     *        {@link AbstractInitializeableIndexSequence}
     */

    /**
     * Stores the specified Items in this
     * {@link AbstractInitializeableIndexSequence}.
     * 
     * @param items
     *        {@link Container} of Items to store
     * 
     * @throws InvalidStoredItemsCountException
     *         if {@code items.getItemsCount() != getItemsCount()}
     */
    protected void storeItems(final Container<Item> items) {
        if (items.getItemsCount() != getItemsCount())
            throw new InvalidStoredItemsCountException(this, items.getItemsCount(),
                                                       "{0}: items.getItemsCount() == {1} != {2} == getItemsCount()",
                                                       getItemsCount());
        storeItems(items);
    }

    /**
     * Stores the specified Items in this
     * {@link AbstractInitializeableIndexSequence}.
     * 
     * @param items
     *        {@link Collection} of Items to store
     * 
     * @throws InvalidStoredItemsCountException
     *         if {@code items.size() != getItemsCount()}
     */
    protected void storeItems(final Collection<Item> items) {
        if (items.size() != getItemsCount())
            throw new InvalidStoredItemsCountException(this, items.size(),
                                                       "{0}: items.size() == {1} != {2} == getItemsCount()",
                                                       getItemsCount());
        storeItems(items);
    }

    /**
     * Stores the specified Items in this
     * {@link AbstractInitializeableIndexSequence}.
     * 
     * @param items
     *        comma separated sequence of Items to store
     * 
     * @throws InvalidStoredItemsCountException
     *         if {@code items.length != getItemsCount()}
     */
    @SuppressWarnings("unchecked")
    protected void storeItems(final Item... items) {
        if (items.length != getItemsCount())
            throw new InvalidStoredItemsCountException(this, items.length,
                                                       "{0}: items.length == {1} != {2} == getItemsCount()",
                                                       getItemsCount());
        storeItems(ArrayUtility.iterable(items));
    }

    /**
     * Stores the specified Items in this
     * {@link AbstractInitializeableIndexSequence}.
     * 
     * @param items
     *        {@link Iterable} providing Items to store
     */
    protected void storeItems(final Iterable<Item> items) {
        int index = getFirstIndex();

        for (final Item item : items)
            replaceStoredItem(index ++, item);
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
