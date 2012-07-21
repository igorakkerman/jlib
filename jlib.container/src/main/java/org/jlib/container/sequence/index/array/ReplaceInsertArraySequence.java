package org.jlib.container.sequence.index.array;

import java.util.Collection;

import static org.jlib.core.array.ArrayUtility.iterable;

import org.jlib.container.Container;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.DefaultReplaceInsertIndexSequenceTraverser;
import org.jlib.container.sequence.index.InsertIndexSequence;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;
import org.jlib.container.sequence.index.ObservedReplaceInsertIndexSequence;
import org.jlib.container.sequence.index.ObservedReplaceInsertIndexSequenceTraverser;
import org.jlib.container.sequence.index.SequenceIndexOutOfBoundsException;
import org.jlib.container.sequence.index.SubReplaceInsertIndexSequence;

import static org.jlib.container.sequence.SequenceUtility.singleton;

/**
 * {@link ReplaceAppendArraySequence} into which Items can be inserted.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceInsertArraySequence<Item>
extends ReplacePrependAppendArraySequence<Item>
implements ObservedReplaceInsertIndexSequence<Item> {

    /**
     * Creates a new uninitialized {@link ReplaceInsertArraySequence} with the
     * specified first and last indices.
     * 
     * @param firstIndex
     *        integer specifying the initial first index
     * 
     * @param lastIndex
     *        integer specifying the initial last index
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code lastIndex < firstIndex}
     */
    protected ReplaceInsertArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with a first index of
     * {@code 0} and the specified number of Items.
     * 
     * @param itemsCount
     *        integer specifying the initial number of Items
     * 
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    protected ReplaceInsertArraySequence(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        super(itemsCount);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with a first index of
     * {@code 0} containing the specified Items.
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with the specified first
     * index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with a first index of
     * {@code 0} containing the specified Items.
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with the specified first
     * index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with a first index of
     * {@code 0} containing the specified Items.
     * 
     * @param items
     *        {@link Container} of Items to store
     */
    public ReplaceInsertArraySequence(final Container<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertArraySequence} with the specified first
     * index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Container} of Items to store
     */
    public ReplaceInsertArraySequence(final int firstIndex, final Container<? extends Item> items) {
        super(firstIndex, items);
    }

    @Override
    public void insert(final int index, final Item item) {
        insert(index, singleton(item));
    }

    @Override
    public void insert(final int index, final Container<? extends Item> items) {
        insert(index, items, items.getItemsCount());
    }

    @Override
    public void insert(final int index, final Collection<? extends Item> items) {
        insert(index, items, items.size());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insert(final int index, final Item... items) {
        insert(index, iterable(items), items.length);
    }

    /**
     * Inserts the specified Items at the specified index of this
     * {@link InsertIndexSequence}.
     * 
     * @param index
     *        integer specifying the index
     * 
     * @param items
     *        {@link Collection} holding the Items to insert
     * 
     * @param insertedItemsCount
     *        integer specifying the number of inserted Items
     */
    private void insert(final int index, final Iterable<? extends Item> items, final int insertedItemsCount) {
        final int newSize = getItemsCount() + insertedItemsCount;
        final int delegateArrayInsertIndex = getStorageIndex(index);

        assertCapacityWithHole(newSize, delegateArrayInsertIndex, insertedItemsCount);

        int delegateArrayIndex = delegateArrayInsertIndex;
        for (final Item item : items)
            replaceDelegateArrayItem(delegateArrayIndex ++, item);

        setLastIndex(getLastIndex() + insertedItemsCount);
    }

    @Override
    public ObservedReplaceInsertIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        return new SubReplaceInsertIndexSequence<Item, ReplaceInsertArraySequence<Item>>(this, fromIndex, toIndex);
    }

    @Override
    public ObservedReplaceInsertIndexSequenceTraverser<Item> createTraverser() {
        return createTraverser(getFirstIndex());
    }

    @Override
    public ObservedReplaceInsertIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultReplaceInsertIndexSequenceTraverser<>(this, startIndex);
    }
}
